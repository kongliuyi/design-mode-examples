package net.riking.design.decorator.pattern.coffee;
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
