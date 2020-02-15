package net.riking.design.decorator.pattern.coffee;

/**
 * @Description 具体装饰（ConcreteDecorator）角色：摩卡
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class Mocha extends AbstractDecoratorCoffee {

	private String description = "摩卡！";

	public Mocha(Beverages beverages){
	  super(beverages);
	}

	@Override
	public String getDescription(){
		return super.getDescription()+"\n加入"+description;
	}

	@Override
	public double getPrice(){
		//49表示摩卡的价格
		return super.getPrice()+49;
	}
}
