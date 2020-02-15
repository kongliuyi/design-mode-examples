package net.riking.design.observer.pattern.event;

import java.util.EventObject;

/**
 * @Description 抽象事件
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public abstract class AbstractSoundEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public AbstractSoundEvent(Object source) {
        super(source);
    }
}
