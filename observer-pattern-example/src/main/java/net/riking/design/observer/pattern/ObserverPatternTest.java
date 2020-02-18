package net.riking.design.observer.pattern;

import net.riking.design.observer.pattern.event.*;
import net.riking.design.observer.pattern.rmbrate.*;
import net.riking.design.observer.pattern.spring.event.*;
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

    @Test
    public void  springEvent(){
        // 构造一个广播器
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        // 添加监听器
        eventMulticaster.addApplicationListener(new TopApplicationListener());
        eventMulticaster.addApplicationListener(new BottomApplicationListener());
        // 广播器广播事件
        eventMulticaster.multicastEvent(new ApplicationStartingEvent("Starting"));
        eventMulticaster.multicastEvent(new ApplicationPreparedEvent("Prepared"));

    }


    @Test
    public void  springEvent2(){
        // 构造一个广播器
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        // 添加监听器
        eventMulticaster.addApplicationListener(new TopApplicationListener());
        eventMulticaster.addApplicationListener(new BottomApplicationListener());
        // 构造一个应用从开启到运行时期的过程
        EventPublishingRunListener runListener = new EventPublishingRunListener(eventMulticaster, "application");
        System.out.println("应用开始时期");
        runListener.starting();
        System.out.println("应用加载时期");
        runListener.contextLoaded();
        System.out.println("应用运行时期");
        runListener.running();
    }


}
