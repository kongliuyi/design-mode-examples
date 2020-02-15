package net.riking.design.observer.pattern.event;

/**
 * @Description 铃声事件：用于封装事件源及一些与事件相关的参数
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class RingEvent extends AbstractSoundEvent {

    /** true 表示上课铃声,false 表示下课铃声 */
    private boolean sound;

    public RingEvent(Object source, boolean sound)
    {
        super(source);
        this.sound=sound;
        System.out.println(sound?"上课铃响!":"下课铃响!");
    }

    boolean getSound()
    {
        return this.sound;
    }

}