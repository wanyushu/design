package com.jiuzhou.desgin.chain.impl;

import com.jiuzhou.desgin.chain.ChainService;
import com.jiuzhou.desgin.chain.context.InitOrder;
import com.jiuzhou.desgin.chain.context.WomanContext;
import org.springframework.stereotype.Service;

/**
 * 首饰 实现类
 */
@InitOrder(2)
@Service
public class JewelryChainServiceImpl implements ChainService {
    @Override
    public WomanContext handle(WomanContext womanContext) {
        womanContext.setJewelry(true);
        return womanContext;
    }
}
