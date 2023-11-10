package com.jiuzhou.desgin.chain.impl;

import com.jiuzhou.desgin.chain.ChainService;
import com.jiuzhou.desgin.chain.context.InitOrder;
import com.jiuzhou.desgin.chain.context.WomanContext;
import org.springframework.stereotype.Service;

/**
 * 涂抹口红 实现类
 */
@InitOrder(8)
@Service
public class LipstickChainServiceImpl implements ChainService {

    @Override
    public WomanContext handle(WomanContext womanContext) {
        womanContext.setLipstick(true);
        return womanContext;
    }
}
