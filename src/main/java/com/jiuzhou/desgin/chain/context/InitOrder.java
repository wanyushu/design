package com.jiuzhou.desgin.chain.context;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface InitOrder {
    int LOWEST_PRECEDENCE = 2147483647;
    int HIGHEST_PRECEDENCE = -2147483648;

    int value() default 2147483647;
}