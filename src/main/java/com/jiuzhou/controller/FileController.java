package com.jiuzhou.controller;

import com.jiuzhou.desgin.file.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【问题】群组表
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2024/4/3 9:26
 */

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private SysFileService sysFileService;
    /**
     * 上传文件
     * 文件名采用uuid,避免原始文件名中带"-"符号导致下载的时候解析出现异常
     *
     * @param file 资源
     * @return R(/ admin / bucketName / filename)
     */
    @PostMapping("/upload/{filename}")
    public Object upload(@RequestParam("file") MultipartFile file, @PathVariable("filename") String filename, boolean isApk) {
        return sysFileService.uploadFile(file,filename,isApk);
    }


}
