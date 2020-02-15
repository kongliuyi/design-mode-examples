package net.riking.design.decorator.pattern.coffee;

/**
 * @Description 抽象构件（Component）：饮料
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public interface Beverages {

	/** 返回商品描述 */
	 String getDescription();

	/**
	 * 获取价格
	 * @return 总价格
	 */
	double getPrice();
}