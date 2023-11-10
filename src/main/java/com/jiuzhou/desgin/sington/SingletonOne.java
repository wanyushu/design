package com.jiuzhou.desgin.sington;

/**
 * 懒汉式--线程不安全
 * 懒汉式实现了懒加载，但是线程不安全，基本不会使用。
 */
public class SingletonOne {
    public static SingletonOne singleton;
    private SingletonOne() {}
    public static SingletonOne getSingleton() {
        if (singleton == null)
            return new SingletonOne();
        return singleton;
    }
}
