# 装饰者模式案例（decorator-pattern-examples）

  在现实生活中，常常需要对现有产品增加新的功能或美化其外观，如房子装修、相片加相框等。在软件开发过程中，有时想用一些现存的组件。这些组件可能只是完成了一些核心功能。但在不改变其结构的情况下，可以动态地扩展其功能。所有这些都可以釆用装饰模式来实现。
  
### 装饰模式的定义与特点

装饰（Decorator）模式的定义：指在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式，它属于对象结构型模式。

装饰（Decorator）模式的主要优点有：

    采用装饰模式扩展对象的功能比采用继承方式更加灵活。
    可以设计出多个不同的具体装饰类，创造出多个不同行为的组合。


### 其主要缺点是：装饰模式增加了许多子类，如果过度使用会使程序变得很复杂。

装饰模式的结构与实现

通常情况下，扩展一个类的功能会使用继承方式来实现。但继承具有静态特征，耦合度高，并且随着扩展功能的增多，子类会很膨胀。如果使用组合关系来创建一个包装对象（即装饰对象）来包裹真实对象，并在保持真实对象的类结构不变的前提下，为其提供额外的功能，这就是装饰模式的目标。下面来分析其基本结构和实现方法。

1. 模式的结构

装饰模式主要包含以下角色。


     抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
     具体构件（Concrete    Component）角色：实现抽象构件，通过装饰角色为其添加一些职责。
     抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
     具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。


2. 针对的问题

        动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator模式相比生成子类更为灵活。不改变接口的前提下，增强所考虑的类的性能。

何时使用：

    1）需要扩展一个类的功能，或给一个类增加附加责任。

    2）需要动态的给一个对象增加功能，这些功能可以再动态地撤销。

    3）需要增加一些基本功能的排列组合而产生的非常大量的功能，从而使继承变得    不现实。

## 【例1】用装饰模式实现游戏角色“莫莉卡·安斯兰”的变身。

程序代码如下： 

 - 抽象构件角色：莫莉卡
```java
//抽象构件角色：莫莉卡
public interface  Morrigan
{
     String getDescription();

     void display();
}
```
- 具体构件角色：原身少女
```java
import javax.swing.*;
import java.awt.*;

//具体构件角色：原身少女
public class OriginalGirl extends JFrame implements Morrigan
{
    private static final long serialVersionUID = 1L;

    private JLabel jl= new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("static").getPath()+"/Morrigan0.jpg"));

    public OriginalGirl()
    {
        super("《恶魔战士》中的莫莉卡·安斯兰");
    }


    public String getDescription() {
        return "原身莫莉卡·安斯兰";
    }

    public void display()
    {   
        this.setLayout(new FlowLayout());
        this.add(jl);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);
    }

    public void setJl(JLabel jl) {
        this.jl = jl;
    }
}
```
 - 抽象装饰角色：变身
```java
//抽象装饰角色：变身
public abstract  class DecoratorMorrigan implements Morrigan
{
    Morrigan m;   
    public DecoratorMorrigan(Morrigan m)
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
```
 - 具体装饰角色：蝙蝠女妖
```java
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
```
 - 具体装饰角色：着装少女
```java
import javax.swing.*;

//具体装饰角色：着装少女
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
```
- 测试结果
```java
    public static void main(String[] args) {
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
    /**
     输出打印
     原身莫莉卡·安斯兰 
     原身莫莉卡·安斯兰变身蝙蝠女妖 
     原身莫莉卡·安斯兰变身可爱少女 */
```
## 【例2】用装饰模式实现咖啡口味搭配。
   咖啡是一种饮料，咖啡的本质是咖啡豆+水磨出来的。咖啡店现在要卖各种口味的咖啡，如果不使用装饰模式，那么在销售系统中，各种不一样的咖啡都要产生一个类，如果有4中咖啡豆，5种口味，那么将要产生至少20个类（不包括混合口味），非常麻烦。使用了装饰模式，只需要11个类即可生产任意口味咖啡（包括混合口味）。

程序代码如下： 
- 抽象构件角色：饮料
```java
/**
 * 抽象构件（Component）：饮料
 */
public interface Beverages {
	//返回商品描述
	 String getDescription();
	//返回价格
	 double getPrice();
}

```
- 具体构件角色：埃塞俄比亚咖啡豆
```java
/**
 * 具体构件（Concrete Component）角色：埃塞俄比亚咖啡豆
 */
public class EthiopianCoffeeBean implements Beverages {
	private String description = "选取埃塞俄比亚咖啡豆";
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public double getPrice() {
		return 50;
	}
 
}
```
- 具体构件角色：肯尼亚咖啡豆
```java
/**
 * 具体构件（Concrete Component）角色：肯尼亚咖啡豆
 */
public class KenyanCoffeeBean implements Beverages {
	private String description = "选取肯尼亚咖啡豆";
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public double getPrice() {
		return 45;
	}
 
}
```
- 具体构件角色：苏门答腊咖啡豆
```java
/**
 * 具体构件（Concrete Component）角色：苏门答腊咖啡豆
 */
public class SumatraCoffeeBean implements Beverages {
	private String description = "选取苏门答腊咖啡豆";
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public double getPrice() {
		return 60;
	}
 
}
```
 - 抽象装饰角色
```java
/**
 *  抽象装饰（Decorator）：装饰类
 */
public abstract class DecoratorCoffee implements Beverages {
	private Beverages beverages ;

	public DecoratorCoffee(Beverages beverages) {
		this.beverages = beverages;
	}

	@Override
	public String getDescription() {
		return beverages.getDescription();
	}
	@Override
	public double getPrice() {
		return beverages.getPrice();
	}

}
```
 - 具体装饰角色：牛奶
```java
/**
 * 具体装饰（ConcreteDecorator）角色：牛奶
 */
public class Milk extends DecoratorCoffee{
	private String description = "牛奶！";
	public Milk(Beverages beverages){
		super(beverages);
	}
	public String getDescription(){
		return super.getDescription()+"\n加入"+description;
	}
	public double getPrice(){
		return super.getPrice()+20;	//20表示牛奶的价格
	}
}
```
 - 具体装饰角色：摩卡
```java
/**
 * 具体装饰（ConcreteDecorator）角色：摩卡
 */
public class Mocha extends DecoratorCoffee {
	private String description = "摩卡！";

	public Mocha(Beverages beverages){
	super(beverages);
	}
	public String getDescription(){
		return super.getDescription()+"\n加入"+description;
	}
	public double getPrice(){
		return super.getPrice()+49;	//30表示摩卡的价格
	}
}
```
 - 具体装饰角色：糖
```java
/**
 * 具体装饰（ConcreteDecorator）角色：糖
 */
public class Sugar extends DecoratorCoffee{
	private String description = "糖！";
	public Sugar(Beverages beverages){
		super(beverages);
	}
	public String getDescription(){
		return super.getDescription()+"\n加入"+description;
	}
	public double getPrice(){
		return super.getPrice()+5;	//5表示糖的价格
	}
}
```
- 测试类以及结果
```java
    @Test
    public  void  coffee(){
        Beverages beverages= new EthiopianCoffeeBean();
        beverages = new Milk(beverages);
        beverages =new Sugar(beverages);
        System.out.println(beverages.getDescription());
        System.out.println("总价格:"+beverages.getPrice());

    }
    /**
    输出打印
    选取埃塞俄比亚咖啡豆
    加入牛奶！
    加入糖！
    总价格:75.0  */
```

参考例子

[*莫莉卡·安斯兰](http://c.biancheng.net/view/1366.html)

[*咖啡案例](https://blog.csdn.net/zhshulin/article/details/38665187)

[*更多参考案例](https://blog.csdn.net/liujun03/article/details/80738546)
     
