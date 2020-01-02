package net.riking.design.observer.mode.event;



//铃声事件：用于封装事件源及一些与事件相关的参数
public class RingEvent extends SoundEvent
{   
    private static final long serialVersionUID=1L;
    private boolean sound;    //true表示上课铃声,false表示下课铃声
    public RingEvent(Object source,boolean sound)
    {
        super(source);
        this.sound=sound;
        System.out.println(sound?"上课铃响!":"下课铃响!");
    }
    public boolean getSound()
    {
        return this.sound;
    }
}