package net.riking.design.observer.pattern;

import net.riking.design.observer.pattern.event.*;
import net.riking.design.observer.pattern.rmbrate.*;
import org.junit.Test;
/**
 * @Description 观察者模式测试类
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class ObserverPatternTest {

    /**
     *
     */
    @Test
    public void rmbRatChange(){
        // 可以认为是 RMB 汇率操作者
        Rate rate=new RmbRate();
        // 进口公司
        Company watcher1=new ImportCompany();
        // 出口公司
        Company watcher2=new ExportCompany();
        // 加入观察者
        rate.add(watcher1);
        rate.add(watcher2);
        // 汇率变动，观察者即公司做出的响应
        rate.change(10);
        rate.change(-9);
    }

    /**
     *
     */
    @Test
    public void  bellEvent(){
        //铃（事件源）
        EventSource bell=new BellEventSource();
        //注册监听器（老师）
        bell.addPersonListener(new TeacherListener());
        //注册监听器（学生）
        bell.addPersonListener(new StudentListener());
        //打上课铃声
        bell.publishEvent(new RingEvent(bell, true));
        //打下课铃声
        bell.publishEvent(new RingEvent(bell, false));
    }


}
