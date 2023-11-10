package com.jiuzhou.desgin.chain.impl;

import com.jiuzhou.desgin.chain.ChainService;
import com.jiuzhou.desgin.chain.context.InitOrder;
import com.jiuzhou.desgin.chain.context.WomanContext;
import org.springframework.stereotype.Service;

/**
 * 理发师 实现类
 */
@InitOrder(1)
@Service
public class HairChainServiceImpl implements ChainService {

    @Override
    public WomanContext handle(WomanContext womanContext) {
        womanContext.setHair(true);
        return womanContext;
    }
}
