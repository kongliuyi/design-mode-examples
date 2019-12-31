package net.riking.design.decorator.pattern.morrigan;

//抽象装饰角色：变身
public abstract  class Transfiguration implements Morrigan
{
    Morrigan m;   
    public Transfiguration(Morrigan m)
    {
        this.m=m;
    }

    public String getDescription() {
        return m.getDescription()+"变身";
    }

    public void display()
    {
        m.display();
    }
}