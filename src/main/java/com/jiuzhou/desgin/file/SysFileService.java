package com.jiuzhou.desgin.file;

import org.springframework.web.multipart.MultipartFile;

/**
 * 【问题】群组表
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2024/4/3 9:27
 */
public interface SysFileService {

    Object uploadFile(MultipartFile file, String fileName, boolean isApk);
}
