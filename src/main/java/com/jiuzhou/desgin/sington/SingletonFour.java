package com.jiuzhou.desgin.sington;

/**
 * 饿汉式——变种
 * 其实和之前的一样，仅仅是将单例的创建挪到了静态块。
 */
public class SingletonFour {
    public static SingletonFour singleton;
    static {
        singleton = new SingletonFour();
    }
    private SingletonFour () { }
    public static SingletonFour getSingleton() {
        return singleton;
    }
}
