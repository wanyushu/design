package com.jiuzhou.desgin.sington;

/**
 * 饿汉式
 * 由于实例优先提供，不存在线程安全问题，但是没有实现懒加载。
 */
public class SingletonThree {
    public static SingletonThree singleton = new SingletonThree();
    private SingletonThree () { }
    public static SingletonThree getSingleton() {
        return singleton;
    }
}
