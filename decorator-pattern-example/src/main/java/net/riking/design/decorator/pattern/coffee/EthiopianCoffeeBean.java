package net.riking.design.decorator.pattern.coffee;

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
