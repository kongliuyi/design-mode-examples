

package net.riking.design.observer.pattern.spring.event;

import java.util.EventObject;

/**
 * @Description 抽象 Application 事件
 * @Author: kongLiuYi
 * @Date: 2020/2/16 17:24
 * @see net.riking.design.observer.pattern.spring.event.ApplicationListener
 */
public abstract class ApplicationEvent extends EventObject {

	/** use serialVersionUID from Spring 1.2 for interoperability. */
	private static final long serialVersionUID = 7099057708183571937L;

	/** System time when the event happened. */
	private final long timestamp;


	/**
	 * Create a new {@code ApplicationEvent}.
	 * @param source the object on which the event initially occurred or with
	 * which the event is associated (never {@code null})
	 */
	public ApplicationEvent(Object source) {
		super(source);
		this.timestamp = System.currentTimeMillis();
	}


	/**
	 * Return the system time in milliseconds when the event occurred.
	 */
	public final long getTimestamp() {
		return this.timestamp;
	}

}
