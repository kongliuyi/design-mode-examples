

package net.riking.design.observer.pattern.spring.event;

import com.sun.istack.internal.Nullable;


/**
 * @Description 扩展 {@link ApplicationListener} 接口，支持事件和源类型判断。
 * @Author: kongLiuYi
 * @Date: 2020/2/16 17:24
 */
public interface SmartApplicationListener extends ApplicationListener<ApplicationEvent> {


	/**
	 * 确定此监听器是否支持给定的源类型。
	 * @param eventType 事件类型
	 * @return  是否支持
	 */
	boolean supportsEventType(@Nullable Class<? extends ApplicationEvent> eventType);


	/**
	 * 确定此监听器是否支持给定的源类型。
	 * @param sourceType 源类型
	 * @return 默认 true 支持
	 */
	default boolean supportsSourceType(Class<?> sourceType) {
		return true;
	}



}
