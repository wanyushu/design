package com.jiuzhou.controller;


import com.jiuzhou.utils.ApplicationContextUtil;
import com.jiuzhou.desgin.chain.ChainHandler;
import com.jiuzhou.desgin.chain.context.WomanContext;
import com.jiuzhou.desgin.combination.CombinationHandler;
import com.jiuzhou.desgin.decorate.DecorateService;
import com.jiuzhou.desgin.factory.proxy.FactoryProxy;
import com.jiuzhou.desgin.observer.ObserverHandler;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 加rest是标准的restful风格的一种方式 次注解相当于 controller + responseBody
 *
 */
@RestController
@RequestMapping("consumerHandler")
public class ConsumerHandlerController {

    @Autowired
    private ChainHandler chainHandler;

    @Autowired
    private CombinationHandler combinationHandler;


    @Autowired
    private FactoryProxy factoryProxy;

    @Qualifier("iDecorateService")
    @Autowired
    private DecorateService decorateService;

    /**
     * 该方法是模拟 消息队列类回调处理
     * spring 的很多扩展点即该思想处理
     */
    @RequestMapping("consumer")
    public Object consumer(String beanName){
        if(StringUtils.isEmpty(beanName)){
            beanName = "btcOberverService";
        }
        /**
         * ApplicationContextUtil 封装好的bean工厂 可以获取到所有的bean实例对象
         */
        Object bean = ApplicationContextUtil.getBean(beanName);
        /**
         * 该方法表示如果获取的这个bean非空 且实现了该方法则执行该方法
         */
        if(null!=bean&&bean instanceof ObserverHandler){
            ((ObserverHandler)bean).handle();
        }
        return "success";
    }

    /**
     *
     * 责任链测试
     */
    @RequestMapping("chain")
    public Object chain(){
        WomanContext context = new WomanContext();

        return chainHandler.execute(context);
    }


    /**
     *
     * 组合模式测试
     */
    @RequestMapping("combine")
    public Object combine(){
        return combinationHandler.execute();
    }

    /**
     * 装饰者模式
     */
    @RequestMapping("decorate")
    public Object decorate(){
        return decorateService.login();
    }


    /**
     * 策略模式调用
     */
    @RequestMapping("factory")
    public Object factory(String coinName){
        factoryProxy.execute(coinName);
        return "OK";
    }
}
