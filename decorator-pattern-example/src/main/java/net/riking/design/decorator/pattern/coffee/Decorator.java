package net.riking.design.decorator.pattern.coffee;

/**
 *  抽象装饰（Decorator）：装饰类
 */
public abstract class Decorator implements Beverages {
	private Beverages beverages ;

	public Decorator(Beverages beverages) {
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
