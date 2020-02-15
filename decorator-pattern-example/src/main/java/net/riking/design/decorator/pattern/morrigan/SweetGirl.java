package net.riking.design.decorator.pattern.morrigan;

import javax.swing.*;

/**
 * @Description 具体构件角色：可爱少女
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class SweetGirl extends DecoratorMorrigan {

    public SweetGirl(Morrigan m) {
        super(m);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"可爱少女";
    }

    @Override
    public void display() {
        setChanger();
        super.display();

    }

    public void setChanger() {
        ((OriginalGirl) super.m).setJl(new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("static").getPath()+"/Morrigan2.jpg")));
    }
}