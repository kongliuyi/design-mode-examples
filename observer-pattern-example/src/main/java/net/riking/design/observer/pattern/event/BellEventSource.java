package net.riking.design.observer.pattern.event;

import java.util.*;

//具体主题：事件源，铃
public class BellEventSource implements  EventSource
{    
    private List<PersonListener> listener; //监听器容器
    public BellEventSource()
    { 
        listener=new ArrayList<>();
    }

    @Override
    public void addPersonListener(PersonListener personEventListener) {
        listener.add(personEventListener);
    }


    //给事件源绑定监听器
    //当事件发生时,通知绑定在该事件源上的所有监听器做出反应（调用事件处理方法）
    @Override
    public void publishEvent(SoundEvent soundEvent) {
        notifies(soundEvent);//通知注册在该事件源上的所有监听器
    }


    //事件触发器：敲钟，当铃声sound的值发生变化时，触发事件。
    private void notifies(SoundEvent soundEvent) {
        PersonListener ren=null;
        Iterator<PersonListener> iterator=listener.iterator();
        while(iterator.hasNext())
        {
            ren=iterator.next();
            ren.onEvent(soundEvent);
        }
    }


}