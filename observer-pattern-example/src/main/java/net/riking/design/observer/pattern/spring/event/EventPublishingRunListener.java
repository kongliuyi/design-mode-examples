
package net.riking.design.observer.pattern.spring.event;


/**
 * @Description 事件发布运行时期监听器
 * @Author: kongLiuYi
 * @Date: 2020/2/16 17:24
 */
public class EventPublishingRunListener implements SpringApplicationRunListener {

    private final Object applicationSource;

	private final ApplicationEventMulticaster initialMulticaster;

    /**
     * @param eventMulticaster
     */
	public EventPublishingRunListener(ApplicationEventMulticaster eventMulticaster , Object applicationSource) {
		this.initialMulticaster = eventMulticaster;
		this.applicationSource = applicationSource;
	}


	@Override
	public void starting() {
		this.initialMulticaster.multicastEvent(new ApplicationStartingEvent(this.applicationSource));
	}



	@Override
	public void contextLoaded() {
		this.initialMulticaster.multicastEvent(new ApplicationPreparedEvent(this.applicationSource));
	}


	@Override
	public void running() {
        this.initialMulticaster.multicastEvent(new ApplicationReadyEvent(this.applicationSource));
	}



}
