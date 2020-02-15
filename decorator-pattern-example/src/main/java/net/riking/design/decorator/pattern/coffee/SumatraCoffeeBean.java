package net.riking.design.decorator.pattern.coffee;

/**
 * @Description 具体构件（Concrete Component）角色：苏门答腊咖啡豆
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class SumatraCoffeeBean implements Beverages {

	private String description = "选取苏门答腊咖啡豆";

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getPrice() {
		return 60;
	}
 
}
