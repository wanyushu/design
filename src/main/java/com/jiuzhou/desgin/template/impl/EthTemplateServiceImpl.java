package com.jiuzhou.desgin.template.impl;

import com.jiuzhou.desgin.template.AbstractTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * eth模板实现类
 */
@Slf4j
@Service
public class EthTemplateServiceImpl extends AbstractTemplateService {

    @Override
    public void transfer() {
        log.info("我是usdt转账实现类");
    }

    @Override
    public BigDecimal getMoney() {
        log.info("我是btc查询余额实现类");
        return super.getMoney();
    }

    @Override
    public Long height() {
        return super.height();
    }

}
