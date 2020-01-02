package net.riking.design.decorator.pattern.coffee;
/**
 * 具体装饰（ConcreteDecorator）角色：摩卡
 */
public class Mocha extends Decorator {
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
