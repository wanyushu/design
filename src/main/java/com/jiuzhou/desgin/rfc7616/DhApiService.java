package com.jiuzhou.desgin.rfc7616;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * 大华 http接口
 * @author yushu
 * @email 921784721@qq.com
 * @date 2024/2/22 8:47
 */
public interface DhApiService {

    /**
     * 获取设备序列号
     */
    String getSerialNo(String addr);

}
