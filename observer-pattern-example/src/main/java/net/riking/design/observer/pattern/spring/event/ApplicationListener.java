

package net.riking.design.observer.pattern.spring.event;

import java.util.EventListener;

/**
 * Interface to be implemented by application event listeners.
 *
 * 基于标准 {@code java.util.EventListener} 接口，用于观察者设计模式。
 *
 * @Description 处理应用程序事件的监听器接口。
 * @Author: kongLiuYi
 * @Date: 2020/2/16 17:24
 * @param <E> the specific {@code ApplicationEvent} subclass to listen to
 * @see net.riking.design.observer.pattern.spring.event.ApplicationEvent
 * @see net.riking.design.observer.pattern.spring.event.ApplicationEventMulticaster
 */
@FunctionalInterface
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

	/**
	 * Handle an application event.
	 * @param event the event to respond to
	 */
	void onApplicationEvent(E event);

}
