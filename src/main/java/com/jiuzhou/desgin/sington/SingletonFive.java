package com.jiuzhou.desgin.sington;

/**
 * 静态内部类式
 * 静态内部类保证了懒加载，单例实例优先提供又保证了线程安全性，较实用。
 */
public class SingletonFive {
    private static class SingletonHolder {
        private static SingletonFive singleton = new SingletonFive();
    }
    private SingletonFive () {}
    public static final SingletonFive getSingleton(){
        return SingletonHolder.singleton;
    }
}
