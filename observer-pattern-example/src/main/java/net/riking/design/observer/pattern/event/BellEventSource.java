package net.riking.design.observer.pattern.event;

import java.util.*;

/**
 * @Description 具体主题：事件源，铃
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class BellEventSource implements  EventSource {

    /**  监听器容器  */
    private List<PersonListener> listener;

    public BellEventSource()
    { 
        listener=new ArrayList<>();
    }

    @Override
    public void addPersonListener(PersonListener personEventListener) {
        listener.add(personEventListener);
    }

    /**
     * 给事件源绑定监听器
     * 当事件发生时,通知绑定在该事件源上的所有监听器做出反应（调用事件处理方法）
     * @param soundEvent 事件
     */
    @Override
    public void publishEvent(AbstractSoundEvent soundEvent) {
        // 通知注册在该事件源上的所有监听器
        notifies(soundEvent);
    }

    /**
     * 事件触发器：敲钟，当铃声 sound 的值发生变化时，触发事件。
     * @param soundEvent 铃声事件
     */
    private void notifies(AbstractSoundEvent soundEvent) {
        for (PersonListener personListener : listener) {
            personListener.onEvent(soundEvent);
        }
    }
}