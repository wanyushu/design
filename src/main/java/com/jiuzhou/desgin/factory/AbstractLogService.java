package com.jiuzhou.desgin.factory;

/**
 * 抽象实现类  该类在工厂模式中不充当角色 非必要 只是在实际应用场景
 * 当中，我们通常在该类中抽象出通用的方法
 */
public abstract class AbstractLogService {

    protected  void saveLog(){
        System.out.println("我是保存日志的公共方法");
    }
}
