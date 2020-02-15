package net.riking.design.decorator.pattern.morrigan;

import javax.swing.*;

/**
 * @Description 具体装饰角色：蝙蝠女妖
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class BatGirl extends DecoratorMorrigan {

    public BatGirl(Morrigan m) {
        super(m);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"蝙蝠女妖";
    }

    @Override
    public void display() {
        setChanger();
        super.display();
    }

    public void setChanger() {
        ((OriginalGirl) super.m).setJl(new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("static").getPath()+"/Morrigan1.jpg")));
    }
}