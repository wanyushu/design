package com.jiuzhou.desgin.template.impl;

import com.jiuzhou.desgin.template.AbstractTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * usdt模板实现类  该类实现如 没有查询交易高度的方法可不写
 */
@Slf4j
@Service
public class UsdtTemplateServiceImpl extends AbstractTemplateService {

    @Override
    public void transfer() {
        log.info("我是usdt转账实现类");
    }

    @Override
    public BigDecimal getMoney() {
        log.info("我是btc查询余额实现类");
        return super.getMoney();
    }
}
