package com.jiuzhou.desgin.observer.impl;

import com.jiuzhou.desgin.observer.ObserverHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * btc观察者设计策略
 */
@Slf4j
@Service("usdtOberverService")
public class UsdtOberverServiceImpl implements ObserverHandler {

    @Override
    public void handle() {
        log.info("我是usdt观察者demo实现类");
    }
}
