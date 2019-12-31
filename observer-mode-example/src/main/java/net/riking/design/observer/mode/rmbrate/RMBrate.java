package net.riking.design.observer.mode.rmbrate;

//具体目标：人民币汇率
class RMBrate extends Rate 
{
    public void change(int number)
    {       
        for(Company obs:companys)
        {
            ((Company)obs).response(number);
        }       
    }
}