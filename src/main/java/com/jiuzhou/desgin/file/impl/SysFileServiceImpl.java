package com.jiuzhou.desgin.file.impl;

import com.jiuzhou.desgin.file.SysFileService;
import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 【问题】群组表
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2024/4/3 9:28
 */
@Service
public class SysFileServiceImpl implements SysFileService {

    @Override
    public Object uploadFile(MultipartFile file, String fileName1, boolean isApk) {
        Map<String, String> resultMap = new HashMap<>();
        System.out.println("文件名称,"+file.getOriginalFilename());
        if(file.getOriginalFilename().contains(".apk")){
            System.out.println(1111);
        }
        resultMap.put("pageName",parseApk());
        return resultMap;
    }
    //  文件名称
    private static String name = "";
    //  apk的绝对地址
    private static String apkPath = "C:\\Users\\Administrator\\Documents\\WeChat Files\\wxid_ae6v9rdt27jx22\\FileStorage\\File\\2024-04\\TestAuth.apk";
    //  拷贝图标的存放位置
    private static String fileName = "E:\\" + name + ".png";

    public String parseApk() {

        try {
            File file = new File(apkPath);
            if (file.exists() && file.isFile()) {
                ApkFile apkFile = new ApkFile(file);
                ApkMeta apkMeta = apkFile.getApkMeta();

                //  拷贝出的icon文件名 根据需要可以随便改
                name = apkMeta.getLabel();

                System.out.println("应用名称   :" + apkMeta.getLabel());
                System.out.println("包名       :" + apkMeta.getPackageName());
                System.out.println("版本号     :" + apkMeta.getVersionName());
                System.out.println("图标       :" + apkMeta.getIcon());
                System.out.println("大小       :" + (double) (file.length() * 100 / 1024 / 1024) / 100 + " MB");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
