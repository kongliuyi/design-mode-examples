package net.riking.design.decorator.pattern;


import net.riking.design.decorator.pattern.coffee.Beverages;
import net.riking.design.decorator.pattern.coffee.EthiopianCoffeeBean;
import net.riking.design.decorator.pattern.coffee.Milk;
import net.riking.design.decorator.pattern.coffee.Sugar;
import net.riking.design.decorator.pattern.morrigan.BatGirl;
import net.riking.design.decorator.pattern.morrigan.Morrigan;
import net.riking.design.decorator.pattern.morrigan.OriginalGirl;

import net.riking.design.decorator.pattern.morrigan.SweetGirl;
import org.junit.Test;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class DecoratorPatternTest {

    public static void main(String[] args) {
        morrigan();
    }


    private static void  morrigan(){
        Morrigan m0=new OriginalGirl();
        System.out.println(m0.getDescription());
        m0.display();
        Morrigan m1=new BatGirl(m0);
        System.out.println(m1.getDescription());
        m1.display();
        Morrigan m2=new SweetGirl(m0);
        System.out.println(m2.getDescription());
        m2.display();
    }

    @Test
    public  void  coffee(){
        Beverages beverages= new EthiopianCoffeeBean();
        beverages = new Milk(beverages);
        beverages =new Sugar(beverages);
        System.out.println(beverages.getDescription());
        System.out.println("总价格:"+beverages.getPrice());

    }

    @Test
    public  void  reader() throws IOException {
        BufferedReader in=new BufferedReader(new FileReader("filename.txt"));
        in.readLine();
    }


}
