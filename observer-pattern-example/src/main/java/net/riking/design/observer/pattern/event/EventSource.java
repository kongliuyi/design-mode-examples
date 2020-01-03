package net.riking.design.observer.pattern.event;

//抽象主题：事件源
public interface EventSource {

     void addPersonListener(PersonListener personEventListener);

    void publishEvent(SoundEvent soundEvent);
}