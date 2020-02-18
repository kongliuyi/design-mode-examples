

package net.riking.design.observer.pattern.spring.event;



import com.sun.istack.internal.Nullable;
import org.junit.Assert;

/**
 * @Description  通过事件和事件源的声明类型来删选监听器的适配器.
 * @Author: kongLiuYi
 * @Date: 2020/2/16 17:24
 */
public class GenericApplicationListenerAdapter implements  SmartApplicationListener {

	private final ApplicationListener<ApplicationEvent> delegate;


	/**
	 * Create a new GenericApplicationListener for the given delegate.
	 * @param delegate the delegate listener to be invoked
	 */
	@SuppressWarnings("unchecked")
	public GenericApplicationListenerAdapter(ApplicationListener<?> delegate) {
        Assert.assertNotNull("Delegate listener must not be null", delegate);
		this.delegate = (ApplicationListener<ApplicationEvent>) delegate;

	}


	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		this.delegate.onApplicationEvent(event);
	}



	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
            return (eventType != null && ((SmartApplicationListener) this.delegate).supportsEventType(eventType));
	}

	@Override
	public boolean supportsSourceType(@Nullable Class<?> sourceType) {
		return !(this.delegate instanceof SmartApplicationListener) ||
				((SmartApplicationListener) this.delegate).supportsSourceType(sourceType);
	}



}