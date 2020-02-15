package net.riking.design.decorator.pattern.coffee;

/**
 * @Description 具体装饰（ConcreteDecorator）角色：牛奶
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class Milk extends AbstractDecoratorCoffee {

	private String description = "牛奶！";

	public Milk(Beverages beverages){
		super(beverages);
	}

	@Override
	public String getDescription(){
		return super.getDescription()+"\n加入"+description;
	}

	@Override
	public double getPrice(){
		// 20表示牛奶的价格
		return super.getPrice()+20;
	}
}
