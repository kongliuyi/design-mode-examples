package net.riking.design.observer.pattern.rmbrate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 具体目标：人民币汇率
 * @Author: kongLiuYi
 * @Date: 2020/2/15 23:31
 */
public class RmbRate implements Rate {

    private List<Company> companys=new ArrayList<>();

    /**
     * 增加观察者
     * @param company 公司
     */
    @Override
    public void add(Company company) {
        companys.add(company);
    }

    /**
     * 移除观察者
     * @param company 公司
     */
    @Override
    public void remove(Company company) {
        companys.remove(company);
    }

    /**
     * 遍历观察者以便观察对汇率变动做出响应
     * @param number 具体值
     */
    @Override
    public void change(int number) {
        for (Company company : this.companys) {
            company.response(number);
        }
    }
}