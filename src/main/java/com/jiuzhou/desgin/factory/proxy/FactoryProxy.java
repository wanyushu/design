package com.jiuzhou.desgin.factory.proxy;

import com.jiuzhou.desgin.factory.FactoryService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FactoryProxy {

    private Map<String, FactoryService> factoryServiceMap = new HashMap<>();
    /**
     * spring在初始化的过程中有一个策略就推断构造 它直接通过构造器去找对应的bean实例
     * @param factoryServices
     */
    public FactoryProxy(List<FactoryService> factoryServices) {
        factoryServices.forEach((factoryService -> {
            factoryServiceMap.put(factoryService.getCoinName(),factoryService);
        }));
    }

    /**
     * 外部通过该方法调用
     * @param coinName
     */
    public void execute(String coinName){
        FactoryService factoryService = factoryServiceMap.get(coinName);
        factoryService.execute();
    }


}
