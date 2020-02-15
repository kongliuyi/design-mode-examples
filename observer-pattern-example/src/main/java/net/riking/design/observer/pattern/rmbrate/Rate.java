package net.riking.design.observer.pattern.rmbrate;


/**
 * @Description 抽象目标：汇率
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public interface Rate {

    /**
     * 增加观察者
     * @param company 公司
     */
    void add(Company company);

    /**
     * 移除观察者
     * @param company 公司
     */
    void remove(Company company);

    /**
     *  汇率变动
     * @param number 具体值
     */
    void change(int number);
}