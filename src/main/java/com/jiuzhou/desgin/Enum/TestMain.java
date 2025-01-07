package com.jiuzhou.desgin.Enum;

/**
 * 【问题】群组表
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2024/6/18 16:54
 */
public class TestMain {

    public static void main(String[] args) {

        if(TestEnum.TWO instanceof TestInterface){
            System.out.println(1111);
        }else {
            System.out.println(222);
        }
    }
}
