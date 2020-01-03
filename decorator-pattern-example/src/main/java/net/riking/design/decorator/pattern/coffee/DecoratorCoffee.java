package net.riking.design.decorator.pattern.coffee;

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
