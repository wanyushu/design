package com.jiuzhou.desgin.template;


import java.math.BigDecimal;

/**
 * 写一个抽象类 因抽象类可以空实现
 * 抽象类不会在成为bean只是在spring初始化过程中会进行子类及父类合并操作
 */
public abstract class AbstractTemplateService implements TemplateService {

    @Override
    public void transfer() {

    }

    @Override
    public Long height() {
        return null;
    }

    @Override
    public BigDecimal getMoney() {
        return null;
    }

    @Override
    public String getHash() {
        return null;
    }
}
