package net.riking.design.observer.pattern.event;

/**
 * @Description 具体观察者：老师针对铃声事件监听器
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class TeacherListener implements PersonListener<RingEvent> {

    @Override
    public void onEvent(RingEvent event) {
        if(event.getSound()) {
            System.out.println("老师上课了...");
        }
        else {
            System.out.println("老师下课了...");
        }
    }
}