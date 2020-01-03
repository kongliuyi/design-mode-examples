package net.riking.design.observer.pattern.event;

import java.util.EventListener;
import java.util.EventObject;

//抽象观察者：事件监听器
public interface PersonListener<E extends EventObject>  extends EventListener
{
    //事件处理方法，听到铃声
     void onEvent(E event);
}