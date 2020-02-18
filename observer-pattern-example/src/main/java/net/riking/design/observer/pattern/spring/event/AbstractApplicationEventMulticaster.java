

package net.riking.design.observer.pattern.spring.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.sun.istack.internal.Nullable;

/**
 * {@link ApplicationEventMulticaster}接口的抽象实现，
 *
 * @Description 提供基本的监听器注册功能。
 * @Author: kongLiuYi
 * @Date: 2020/2/16 17:21
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster {

	private final ListenerRetriever defaultRetriever = new ListenerRetriever(false);

	final Map<String, ListenerRetriever> retrieverCache = new ConcurrentHashMap<>(64);

	private Object retrievalMutex = this.defaultRetriever;


	@Override
	public void addApplicationListener(ApplicationListener<?> listener) {
		synchronized (this.retrievalMutex) {
			if (listener instanceof ApplicationListener) {
				this.defaultRetriever.applicationListeners.remove(listener);
			}
			this.defaultRetriever.applicationListeners.add(listener);
			this.retrieverCache.clear();
		}
	}


	@Override
	public void removeApplicationListener(ApplicationListener<?> listener) {
		synchronized (this.retrievalMutex) {
			this.defaultRetriever.applicationListeners.remove(listener);
			this.retrieverCache.clear();
		}
	}


	@Override
	public void removeAllListeners() {
		synchronized (this.retrievalMutex) {
			this.defaultRetriever.applicationListeners.clear();
			this.retrieverCache.clear();
		}
	}


	/**
	 * Return a Collection containing all ApplicationListeners.
	 * @return a Collection of ApplicationListeners
	 * @see net.riking.design.observer.pattern.spring.event.ApplicationListener
	 */
	protected Collection<ApplicationListener<?>> getApplicationListeners() {
		synchronized (this.retrievalMutex) {
			return this.defaultRetriever.getApplicationListeners();
		}
	}

	/**
	 * Return a Collection of ApplicationListeners matching the given
	 * event type. Non-matching listeners get excluded early.
	 * @param event the event to be propagated. Allows for excluding
	 * non-matching listeners early, based on cached matching information.
	 * @param eventType the event type
	 * @return a Collection of ApplicationListeners
	 * @see net.riking.design.observer.pattern.spring.event.ApplicationListener
	 */
	protected Collection<ApplicationListener<?>> getApplicationListeners(
			ApplicationEvent event, Class<? extends ApplicationEvent> eventType) {

		Object source = event.getSource();
		Class<?> sourceType = (source != null ? source.getClass() : null);

         String cacheKey = eventType.toString() + sourceType;
		// Quick check for existing entry on ConcurrentHashMap...
		ListenerRetriever retriever = this.retrieverCache.get(cacheKey);
		if (retriever != null) {
			return retriever.getApplicationListeners();
		}
		// Fully synchronized building and caching of a ListenerRetriever
		synchronized (this.retrievalMutex) {
			retriever = this.retrieverCache.get(cacheKey);
			if (retriever != null) {
				return retriever.getApplicationListeners();
			}
			retriever = new ListenerRetriever(true);
			Collection<ApplicationListener<?>> listeners =
					retrieveApplicationListeners(eventType, sourceType, retriever);
			this.retrieverCache.put(cacheKey, retriever);
			return listeners;
		}

	}

	/**
	 * Actually retrieve the application listeners for the given event and source type.
	 * @param eventType the event type
	 * @param sourceType the event source type
	 * @param retriever the ListenerRetriever, if supposed to populate one (for caching purposes)
	 * @return the pre-filtered list of application listeners for the given event and source type
	 */
	private Collection<ApplicationListener<?>> retrieveApplicationListeners(
			Class<? extends ApplicationEvent> eventType, @Nullable Class<?> sourceType, @Nullable ListenerRetriever retriever) {

			List<ApplicationListener<?>> allListeners = new ArrayList<>();
			Set<ApplicationListener<?>> listeners;
			synchronized (this.retrievalMutex) {
				listeners = new LinkedHashSet<>(this.defaultRetriever.applicationListeners);
			}

			// Add programmatically registered listeners, including ones coming
			// from ApplicationListenerDetector (singleton beans and inner beans).
			for (ApplicationListener<?> listener : listeners) {
				if (supportsEvent(listener, eventType, sourceType)) {
					if (retriever != null) {
						retriever.applicationListeners.add(listener);
					}
					allListeners.add(listener);
				}
			}

			if (retriever != null ) {
				retriever.applicationListeners.clear();
				retriever.applicationListeners.addAll(allListeners);
			}
			return allListeners;
	}


	/**
	 * 确定给定监听器是否支持给定事件。
	 * @param listener the target listener to check
	 * @param eventType the event type to check against
	 * @param sourceType the source type to check against
	 * @return whether the given listener should be included in the candidates
	 * for the given event type
	 */
	protected boolean supportsEvent(
			ApplicationListener<?> listener, Class<? extends ApplicationEvent> eventType, @Nullable Class<?> sourceType) {
		SmartApplicationListener smartListener = new GenericApplicationListenerAdapter(listener);
		return (smartListener.supportsEventType(eventType) && smartListener.supportsSourceType(sourceType));
	}




	/**
	 * Helper class that encapsulates a specific set of target listeners,
	 * allowing for efficient retrieval of pre-filtered listeners.
	 * <p>An instance of this helper gets cached per event type and source type.
	 */
	private class ListenerRetriever {

		public final Set<ApplicationListener<?>> applicationListeners = new LinkedHashSet<>();

        // 监听器过滤器,这里是没作用
		private final boolean preFiltered;

		public ListenerRetriever(boolean preFiltered) {
			this.preFiltered = preFiltered;
		}

		public Collection<ApplicationListener<?>> getApplicationListeners() {
			List<ApplicationListener<?>> allListeners = new ArrayList<>(this.applicationListeners.size());
			allListeners.addAll(this.applicationListeners);
			return allListeners;
		}
	}

}
