package com.jiuzhou.desgin.factory.impl;

import com.jiuzhou.desgin.factory.AbstractLogService;
import com.jiuzhou.desgin.factory.FactoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BtcFactoryServiceImpl extends AbstractLogService implements FactoryService {

    @Override
    public String getCoinName() {
        return "BTC";
    }

    @Override
    public void execute() {
        log.info("我是工厂方法BTC执行类");
        super.saveLog();
    }



}
