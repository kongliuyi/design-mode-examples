package net.riking.design.decorator.pattern.coffee;

/**
 * @Description 具体构件（Concrete Component）角色：埃塞俄比亚咖啡豆
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
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
