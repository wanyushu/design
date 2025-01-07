package com.jiuzhou.desgin.rfc7616.impl;

import com.jiuzhou.desgin.Enum.DhApiEnum;
import com.jiuzhou.desgin.rfc7616.DhApiService;
import com.jiuzhou.desgin.rfc7616.RfcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 大华api实现类
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2024/2/22 8:58
 */
@Service
public class DhApiServiceImpl implements DhApiService {
    private Logger logger = LoggerFactory.getLogger(DhApiServiceImpl.class);

    @Autowired
    private RfcService rfcService;

    /**
     * get请求 没有参数
     * @param addr
     * @param uri
     * @return
     */
    protected String getApi(String addr,String uri){
        final String url = addr+ uri;
        return rfcService.testApi(url, rfcService.digestAuth(url));
    }


    @Override
    public String getSerialNo(String addr) {

        return getApi(addr, DhApiEnum.GET_SERIAL_NO.getUri());
    }

}
