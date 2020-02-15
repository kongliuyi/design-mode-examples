package net.riking.design.decorator.pattern.morrigan;

/**
 * @Description 抽象装饰角色：变身
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public abstract  class DecoratorMorrigan implements Morrigan {

    Morrigan m;

    public DecoratorMorrigan(Morrigan m) {
        this.m=m;
    }

    @Override
    public String getDescription() {
        return m.getDescription()+"变身";
    }

    @Override
    public void display() {
        m.display();
    }
}