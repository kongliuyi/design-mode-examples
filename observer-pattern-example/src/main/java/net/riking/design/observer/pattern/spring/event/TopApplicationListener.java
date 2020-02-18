package net.riking.design.observer.pattern.spring.event;

/**
 * @Description 应用前中期监听器
 * @Author: kongLiuYi
 * @Date: 2020/2/16 17:21
 */
public class TopApplicationListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationStartingEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationStartingEvent) {
            System.out.println("TopApplicationListener 监听器处理 ApplicationStartingEvent 事件");
        }
        if (event instanceof ApplicationPreparedEvent) {
            System.out.println("TopApplicationListener 监听器处理 ApplicationPreparedEvent 事件");
        }

    }
}
