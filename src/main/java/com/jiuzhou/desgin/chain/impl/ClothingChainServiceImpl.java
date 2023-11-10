package com.jiuzhou.desgin.chain.impl;

import com.jiuzhou.desgin.chain.ChainService;
import com.jiuzhou.desgin.chain.context.InitOrder;
import com.jiuzhou.desgin.chain.context.WomanContext;
import org.springframework.stereotype.Service;

/**
 * 服装 实现类
 */
@InitOrder(4)
@Service
public class ClothingChainServiceImpl implements ChainService {

    @Override
    public WomanContext handle(WomanContext womanContext) {
        womanContext.setClothing(true);
        return womanContext;
    }
}
