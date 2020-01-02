package net.riking.design.decorator.pattern.coffee;
/**
 * 具体构件（Concrete Component）角色：肯尼亚咖啡豆
 */
public class KenyanCoffeeBean implements Beverages {
	private String description = "选取肯尼亚咖啡豆";
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public double getPrice() {
		return 45;
	}
 
}
