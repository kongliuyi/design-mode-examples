package net.riking.design.decorator.pattern.coffee;

/**
 * 具体装饰（ConcreteDecorator）角色：牛奶
 */
public class Milk extends Decorator{
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
