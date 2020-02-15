package net.riking.design.observer.pattern.event;

import java.util.EventListener;
import java.util.EventObject;
/**
 * @Description 抽象观察者：事件监听器
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public interface PersonListener<E extends EventObject>  extends EventListener {

    /**
     *  事件处理方法，听到铃声
     * @param event 事件
     */
     void onEvent(E event);
}