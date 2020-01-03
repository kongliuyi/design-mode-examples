package net.riking.design.observer.pattern.rmbrate;

import java.util.ArrayList;
import java.util.List;

//抽象目标：汇率
public abstract class Rate
{
    protected List<Company> companys=new ArrayList<Company>();
    //增加观察者方法
    public void add(Company company)
    {
        companys.add(company);
    }    
    //删除观察者方法
    public void remove(Company company)
    {
        companys.remove(company);
    }   
    public abstract void change(int number);
}