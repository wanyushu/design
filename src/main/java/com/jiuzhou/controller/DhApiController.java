package com.jiuzhou.controller;
import com.jiuzhou.desgin.rfc7616.DhApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2024/2/28 9:23
 */

@RestController
@RequestMapping("/apiUrl")
public class DhApiController {
    private static String addr =  "http://192.168.60.249";

    @Autowired
    private DhApiService dhApiService;

    @GetMapping("/getSerialNo")
    public Object getSerialNo() {
        String serialNo = dhApiService.getSerialNo(addr);
        return serialNo;
    }
}
