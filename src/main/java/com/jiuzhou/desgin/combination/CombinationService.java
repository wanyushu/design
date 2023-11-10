package com.jiuzhou.desgin.combination;


/**
 * 组合模式 + 模板模式跑步抽象实现
 */
public interface CombinationService {

     void addHand(CombinationService combinationService);//添加手

     void removeHand(CombinationService combinationService);//获取手

     CombinationService getHand(int c);//获取容器

     void operation();//业务方法执行

}
