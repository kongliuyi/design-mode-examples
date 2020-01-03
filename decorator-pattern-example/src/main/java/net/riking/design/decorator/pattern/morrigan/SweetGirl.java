package net.riking.design.decorator.pattern.morrigan;

import javax.swing.*;

//具体装饰角色：可爱少女
public class SweetGirl extends DecoratorMorrigan
{
    public SweetGirl(Morrigan m)
    {
        super(m);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"可爱少女";
    }

    public void display()
    {
        setChanger();
        super.display();

    }
    public void setChanger()
    {
        ((OriginalGirl) super.m).setJl(new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("static").getPath()+"/Morrigan2.jpg")));
    }
}