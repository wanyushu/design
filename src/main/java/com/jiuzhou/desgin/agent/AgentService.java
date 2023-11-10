package com.jiuzhou.desgin.agent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;


@Slf4j
@Component
public class AgentService implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //处理bean启动之前做业务处理
        if(beanName.equals("btcOberverService")){
            log.info("我是实例化bean之前处理类");
        }
        return bean;
    }

    /**
     * jdk代理
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if ("btcOberverService".equals(beanName)) {
            log.info("我是实例化bean之后处理类");
            Object proxy = Proxy.newProxyInstance(AgentService.class.getClassLoader(), bean.getClass().getInterfaces(), (proxy1, method, args) -> method.invoke(bean, args));
            return proxy;
        }
        return bean;
    }
}
