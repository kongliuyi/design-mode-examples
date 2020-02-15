package net.riking.design.observer.pattern.event;


/**
 * @Description 抽象主题：事件源
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public interface EventSource {

    /**
     * 添加事件监听器
     * @param personEventListener 事件监听器
     */
     void addPersonListener(PersonListener personEventListener);

    /**
     * 发布事件
     * @param soundEvent 事件
     */
    void publishEvent(AbstractSoundEvent soundEvent);
}
