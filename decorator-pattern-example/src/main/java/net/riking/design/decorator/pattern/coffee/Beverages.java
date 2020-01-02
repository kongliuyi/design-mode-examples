package net.riking.design.decorator.pattern.coffee;

/**
 * 抽象构件（Component）：饮料
 */
public interface Beverages {
	//返回商品描述
	 String getDescription();
	//返回价格
	 double getPrice();
}