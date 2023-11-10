package com.jiuzhou.desgin.decorate.impl;

import com.jiuzhou.desgin.decorate.DecorateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("decorateService")
public class DecorateServiceImpl implements DecorateService {

    @Override
    public String login() {
        log.info("我是装饰者模式 原始阶段实现类");
        return "成功";
    }
}
