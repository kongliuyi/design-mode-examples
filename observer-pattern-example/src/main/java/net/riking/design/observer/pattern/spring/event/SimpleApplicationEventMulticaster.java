

package net.riking.design.observer.pattern.spring.event;

import java.util.concurrent.Executor;

import com.sun.istack.internal.Nullable;


/**
 * Simple implementation of the {@link ApplicationEventMulticaster} interface.
 * @Description 将所有事件广播给所有已注册的监听器，由其自行决定听众感兴趣的事件。
 * @Author: kongLiuYi
 * @Date: 2020/2/16 17:24
 * @see #setTaskExecutor
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

	@Nullable
	private Executor taskExecutor;


	/**
	 * Create a new SimpleApplicationEventMulticaster.
	 */
	public SimpleApplicationEventMulticaster() {
	}



	/**
	 *  设置自定义执行器 调用每个监听器。
	 *
	 * @param taskExecutor  这里我没有做例子，感兴趣可以去看源码
	 */
	public void setTaskExecutor(@Nullable Executor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	/**
	 * Return the current task executor for this multicaster.
	 */
	@Nullable
	protected Executor getTaskExecutor() {
		return this.taskExecutor;
	}


	@Override
	public void multicastEvent(ApplicationEvent event) {
		multicastEvent(event, event.getClass());
	}

	@Override
	public void multicastEvent(final ApplicationEvent event, @Nullable Class<? extends ApplicationEvent> eventType) {
		Executor executor = getTaskExecutor();
		for (ApplicationListener<?> listener : getApplicationListeners(event, eventType)) {
			if (executor != null) {
				executor.execute(() -> invokeListener(listener, event));
			}
			else {
				invokeListener(listener, event);
			}
		}
	}


	/**
	 * Invoke the given listener with the given event.
	 * @param listener the ApplicationListener to invoke
	 * @param event the current event to propagate
	 * @since 4.1
	 */
	protected void invokeListener(ApplicationListener<?> listener, ApplicationEvent event) {
			doInvokeListener(listener, event);
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void doInvokeListener(ApplicationListener listener, ApplicationEvent event) {
		try {
			listener.onApplicationEvent(event);
		}
		catch (ClassCastException ex) {
            System.out.println("Non-matching event type for listener: " + listener);
		}
	}


}
