package net.riking.design.observer.pattern;

import net.riking.design.observer.pattern.event.*;
import org.junit.Test;

public class ObserverModeTest {

    @Test
    public void  bellEvent(){
        EventSource bell=new BellEventSource();    //铃（事件源）
        bell.addPersonListener(new TeacherListener()); //注册监听器（老师）
        bell.addPersonListener(new StudentListener());    //注册监听器（学生）
        bell.publishEvent(new RingEvent(bell, true));//打上课铃声
        System.out.println("------------");
        bell.publishEvent(new RingEvent(bell, false));//打下课铃声
    }


}
