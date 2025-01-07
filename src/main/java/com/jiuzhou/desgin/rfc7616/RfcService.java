package com.jiuzhou.desgin.rfc7616;

/**
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2024/2/21 14:52
 */
public interface RfcService {
    /**
     * 获取加密请求头
     * @return
     */
    String digestAuth(String url);
    /**
     * 获取接口信息
     */
    String testApi(String url,String digest);
}
