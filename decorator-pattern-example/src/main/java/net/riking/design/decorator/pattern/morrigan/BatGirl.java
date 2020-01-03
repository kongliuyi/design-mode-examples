package net.riking.design.decorator.pattern.morrigan;

import javax.swing.*;

//具体装饰角色：蝙蝠女妖
public class BatGirl extends DecoratorMorrigan
{
    public BatGirl(Morrigan m)
    {
        super(m);
    }
    @Override
    public String getDescription() {
        return super.getDescription()+"蝙蝠女妖";
    }

    public void display()
    {
        setChanger();
        super.display();

    }
    public void setChanger()
    {
        ((OriginalGirl) super.m).setJl(new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("static").getPath()+"/Morrigan1.jpg")));
    }
}