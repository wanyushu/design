package com.jiuzhou;

import com.jiuzhou.desgin.spi.CacheLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * java设计模式经典案例 结合spring应用场景
 * 个人论坛 http://www.softworld.vip
 * 更多开源项目 http://www.github.com/wanyushu
 */
@SpringBootApplication
public class RobotApplication implements  CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RobotApplication.class,args);
    }

    /**
     * 组合模式 && spring种的spi机制 通常用于初始化一些缓存操作
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        ServiceLoader<CacheLoader> load = ServiceLoader.load(CacheLoader.class);
        Iterator<CacheLoader> iterator = load.iterator();
        while (iterator.hasNext()){
            CacheLoader next = iterator.next();
            next.operation();
        }

    }
}
