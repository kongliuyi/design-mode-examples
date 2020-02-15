package net.riking.design.decorator.pattern.coffee;

/**
 * @Description 抽象装饰（Decorator）：装饰类
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public abstract class AbstractDecoratorCoffee implements Beverages {

	private Beverages beverages ;

	public AbstractDecoratorCoffee(Beverages beverages) {
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
