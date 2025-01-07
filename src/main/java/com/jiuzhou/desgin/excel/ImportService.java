package com.jiuzhou.desgin.excel;

import com.alibaba.excel.context.AnalysisContext;

import java.util.List;

/**
 * 接口
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2025/1/7 11:13
 */
public interface ImportService<T,R> {
    /**
     * 处理数据接口
     * @param context
     * @param t
     * @param r
     * @param importList
     * @param updateList
     */
    String importCheck(AnalysisContext context, T t, R r, List<T> importList, List<T> updateList);

    /**
     * 返回元数据相关信息
     */

    String importCheck(AnalysisContext context, T t, R r, List<T> importList, List<T> updateList, List<T> sList);
    /**
     * 保存导入的信息
     * @param importList 导入的数据对象
     */
    void saveData( List<T> importList);

    /**
     * 需要更新的data
     */
    void updateData( List<T> importList);

    /**
     * 数据解析完成时
     */
    String uploadMeta(List<T> sList);
}
