package com.jiuzhou.desgin.combination;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class CombinationHandler {

    //此种用法表示在spring容器中指定去key为 leftService的bean
    @Autowired
    @Qualifier("footService")
    private CombinationService footService;


    @Autowired
    @Qualifier("leftService")
    private CombinationService leftService;

    @Autowired
    @Qualifier("rightService")
    private CombinationService rightService;

    @Autowired
    @Qualifier("mouthService")
    private CombinationService mouthService;

    /**
     * 执行手脚并用 方可跑的更快
     */
    public Object execute(){
        /**
         * 以下代码备注是考虑 不用 spring的情况下直接new 出对象来 这个时候需要一个个的添加
         * 如果需要规范顺序,需要在每个service中写个方法 规范顺序 此处可以参考责任链模式
         */
//        footService.addHand(leftService);
//        footService.addHand(rightService);
//        footService.addHand(mouthService);
//        footService.removeHand(rightService);//不要右边
//        footService.getHand(1).operation();//获取动作
        footService.operation();
//        Singtion instance = Singtion.getInstance();
        return "起来了";
    }


}
