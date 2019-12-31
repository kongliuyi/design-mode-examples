package net.riking.design.decorator.pattern.morrigan;

public class MorriganAensland
{
    public static void main(String[] args)
    {
        Morrigan m0=new OriginalGirl();
        System.out.println(m0.getDescription());
        m0.display();
/*        Morrigan m1=new BatGirl(m0);
        System.out.println(m1.getDescription());
        m1.display();
        Morrigan m2=new SweetGirl(m0);
        System.out.println(m2.getDescription());
        m2.display();*/
    }
}