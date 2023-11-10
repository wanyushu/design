package com.jiuzhou.desgin.spi.impl;

import com.jiuzhou.desgin.spi.CacheLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class MouthCacheLoader implements CacheLoader {

    @Override
    public void operation() {
        log.info("嘴巴唱起来");
    }
}
