package com.jiuzhou.desgin.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 【问题】群组表
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2024/6/18 16:52
 */
@Getter
@AllArgsConstructor
public enum TestEnum implements TestInterface{

    ONE(1),TWO(2);

    private Integer type;
}
