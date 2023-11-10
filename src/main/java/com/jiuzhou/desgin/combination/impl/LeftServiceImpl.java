package com.jiuzhou.desgin.combination.impl;

import com.jiuzhou.desgin.combination.AbstractCombinationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("leftService")
public class LeftServiceImpl extends AbstractCombinationService {

    @Override
    public void operation() {
        log.info("左手动起来");
    }
}
