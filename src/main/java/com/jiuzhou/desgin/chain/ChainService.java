package com.jiuzhou.desgin.chain;

import com.jiuzhou.desgin.chain.context.WomanContext;

/**
 * 责任链模式案例接口 此案例可应用于审批类流程
 */
public interface ChainService {


    WomanContext handle(WomanContext womanContext);
}
