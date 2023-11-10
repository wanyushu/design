package com.jiuzhou.desgin.observer.impl;

import com.jiuzhou.desgin.observer.ObserverHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * btc观察者设计策略
 */
@Slf4j
@Service("btcOberverService")
public class BtcOberverServiceImpl implements ObserverHandler {

    @Override
    public void handle() {
        log.info("我是btc观察者demo实现类");
    }
}
