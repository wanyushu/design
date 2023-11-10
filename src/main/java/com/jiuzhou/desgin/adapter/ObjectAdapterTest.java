package com.jiuzhou.desgin.adapter;

public class ObjectAdapterTest {
    /**
     * 民用电都是 220V 交流电，但手机锂电池使用的是 5V 直流电。因此，
     * 我们给手机充电时就需要使用电源适配器来进行转换。下面用代码来
     * 还原这个生活场景，创建 AC220 类，表示 220V 交流电：
     * @param args
     */
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outputDC5V();
    }
}
