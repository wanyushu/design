package com.jiuzhou.desgin.template;

import java.math.BigDecimal;

/**
 * 模板模式案例接口
 * 应用场景 如虚拟货币对接过程中 BTC ETH USDT 都转账 查询当前交易高度
 */
public interface TemplateService {
    /**
     * 转账
     */
    void transfer();
    /**
     * 查询交易高度
     */
    Long  height();

    /**
     * 查询余额
     */
    BigDecimal getMoney();

    /**
     * 获取交易地址
     */
    String getHash();
}
