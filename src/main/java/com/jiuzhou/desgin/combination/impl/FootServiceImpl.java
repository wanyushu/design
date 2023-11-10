package com.jiuzhou.desgin.combination.impl;

import com.jiuzhou.desgin.combination.AbstractCombinationService;
import com.jiuzhou.desgin.combination.CombinationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("footService")
public class FootServiceImpl extends AbstractCombinationService {

    /**
     * 将所有的实现类一次性注入 通过spring的推断构造
     */
    private List<CombinationService> combinationServices;

    public FootServiceImpl(List<CombinationService> combinationServices) {
        this.combinationServices = combinationServices;
    }

    @Override
    public void addHand(CombinationService combinationService) {
        combinationServices.add(combinationService);
    }

    @Override
    public void removeHand(CombinationService combinationService) {
        combinationServices.remove(combinationService);
    }

    @Override
    public CombinationService getHand(int c) {
        return combinationServices.get(c);
    }

    @Override
    public void operation() {
        log.info("脚动起来");
        combinationServices.forEach((combinationService)->{
            combinationService.operation();
        });
    }


}
