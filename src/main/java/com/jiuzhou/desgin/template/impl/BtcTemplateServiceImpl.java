package com.jiuzhou.desgin.template.impl;

import com.jiuzhou.desgin.template.AbstractTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * btc模板实现类  该类实现方法可以都进行实现 也可以不实现 因抽象类已做处理
 * 在spring中 该bean的key为 btcTemplateService
 */
@Slf4j
@Service
public class BtcTemplateServiceImpl extends AbstractTemplateService {


    @Override
    public void transfer() {
        log.info("我是btc转账实现类");
    }

    @Override
    public Long height() {
        log.info("我是btc查询交易高度实现类");
        return super.height();
    }

    @Override
    public BigDecimal getMoney() {
        log.info("我是btc查询余额实现类");
        return super.getMoney();
    }

    @Override
    public String getHash() {
        log.info("我是btc获取交易地址");
        return UUID.randomUUID()+"";
    }
}
