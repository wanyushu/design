package com.jiuzhou.desgin.sington;

/**
 * 懒汉式——线程安全
 * 在第一种的基础上加了个synchronized，保证线程安全，同时实现了懒加载，只是效率不高。
 */
public class SingletonTwo {
    public static SingletonTwo singleton;
    private SingletonTwo() {}
    public static synchronized SingletonTwo getSingleton() {
        if (singleton == null)
            return new SingletonTwo();
        return singleton;
    }
}
