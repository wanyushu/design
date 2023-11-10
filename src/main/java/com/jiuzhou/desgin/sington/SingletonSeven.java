package com.jiuzhou.desgin.sington;


/**
 * 双重校验锁式
 *这种实现方式是经常出现在面试题中的，而且经常会要求手写。
 1. volatile的使用，为了防止暴露一个未初始化的不完整单例实例；
 2. 双重判空校验，第一个判断避免了频繁的加锁，第二个判断可以拦住多余的创建实例的线程；
 3. 加锁，保证了线程安全（只有一个实例）
 */
public class SingletonSeven {
    private static volatile SingletonSeven singleton;
    private SingletonSeven() {}
    public static SingletonSeven getSingleton(){
        if (singleton == null) {
            synchronized (SingletonSeven.class) {
                if (singleton == null)
                    return new SingletonSeven();
            }
        }
        return singleton;
    }
}
