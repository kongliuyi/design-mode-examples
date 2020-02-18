package net.riking.design.observer.pattern.spring.event;

/**
 * @Description
 * @Author: kongLiuYi
 * @Date: 2020/2/16 17:24
 */
public class ApplicationStartingEvent extends ApplicationEvent {


    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ApplicationStartingEvent(Object source) {
        super(source);
    }
}
