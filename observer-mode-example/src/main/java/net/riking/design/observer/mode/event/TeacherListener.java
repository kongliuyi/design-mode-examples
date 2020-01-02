package net.riking.design.observer.mode.event;

//具体观察者：老师针对铃声事件监听器
public class TeacherListener implements PersonListener<RingEvent>
{
    @Override
    public void onEvent(RingEvent event) {
        if(event.getSound())
        {
            System.out.println("老师上课了...");
        }
        else
        {
            System.out.println("老师下课了...");
        }
    }
}