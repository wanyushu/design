package com.jiuzhou.desgin.combination;

public abstract class AbstractCombinationService implements CombinationService{

    @Override
    public void addHand(CombinationService combinationService) {

    }

    @Override
    public void removeHand(CombinationService combinationService) {

    }

    @Override
    public CombinationService getHand(int c) {
        return null;
    }

    @Override
    public abstract void operation();
}
