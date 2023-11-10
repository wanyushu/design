package com.jiuzhou.desgin.decorate.impl;

import com.jiuzhou.desgin.decorate.DecorateService;
import com.jiuzhou.desgin.decorate.IDecorateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 装饰者曾强方法
 */
@Slf4j
@Service("iDecorateService")
public class IDecorateServiceImpl implements IDecorateService {

    private DecorateService decorateService;

    public IDecorateServiceImpl(DecorateService decorateService) {
        this.decorateService = decorateService;
    }

    @Override
    public String login() {
        //编写增加的功能
        log.info("我是增加功能的业务方法");
        String login = decorateService.login();
        log.info("我是增加功能的业务方法增强后方法实现");
        return login;
    }
}
