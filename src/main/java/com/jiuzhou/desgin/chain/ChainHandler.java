package com.jiuzhou.desgin.chain;

import com.jiuzhou.desgin.chain.context.InitOrder;
import com.jiuzhou.desgin.chain.context.WomanContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChainHandler {
    /**
     * 基于集合模式
     */
    private List<ChainService>  chainServiceList = new ArrayList<>();

    @Autowired
    private void allChain(List<ChainService> chainServices){
        chainServiceList.addAll(chainServices);
        //解析每一个order的值 进行排序
        chainServiceList.sort((o1, o2) -> resolveOrder(o2)-resolveOrder(o1));
    }

    public WomanContext execute(WomanContext context){
        chainServiceList.forEach((chainService -> {
            chainService.handle(context);
        }));
        return context;
    }

    private static int resolveOrder(ChainService chainService) {
        return !chainService.getClass().isAnnotationPresent(InitOrder.class) ? InitOrder.LOWEST_PRECEDENCE : ((InitOrder)chainService.getClass().getAnnotation(InitOrder.class)).value();
    }

}
