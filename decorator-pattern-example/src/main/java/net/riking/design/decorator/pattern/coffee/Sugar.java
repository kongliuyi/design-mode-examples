package net.riking.design.decorator.pattern.coffee;

/**
 * @Description 具体装饰（ConcreteDecorator）角色：糖
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class Sugar extends AbstractDecoratorCoffee {

	private String description = "糖！";

	public Sugar(Beverages beverages){
		super(beverages);
	}

	@Override
	public String getDescription(){
		return super.getDescription()+"\n加入"+description;
	}

	@Override
	public double getPrice(){
		//5表示糖的价格
		return super.getPrice()+5;
	}
}
