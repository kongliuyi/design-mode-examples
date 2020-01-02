package net.riking.design.observer.mode.event;

import java.util.EventObject;

/**
 * 抽象事件
 */
public abstract class SoundEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public SoundEvent(Object source) {
        super(source);
    }
}
