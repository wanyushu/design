package com.jiuzhou.desgin.agent1;


public class ProxyTest {
//    public static void main(String[] args) {
//        IService serviceA = new ServiceA();
//        IService serviceB = new ServiceB();
//        serviceA.m1();
//        serviceA.m2();
//        serviceA.m3();
//
//        serviceB.m1();
//        serviceB.m2();
//        serviceB.m3();
//    }

   public static void main(String[] args) {
        IService serviceA = new ServiceProxy(new ServiceA());//@1
        IService serviceB = new ServiceProxy(new ServiceB()); //@2
        serviceA.m1();
        serviceA.m2();
        serviceA.m3();

        serviceB.m1();
        serviceB.m2();
        serviceB.m3();
    }
}
