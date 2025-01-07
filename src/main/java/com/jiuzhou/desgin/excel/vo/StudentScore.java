package com.jiuzhou.desgin.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.jiuzhou.desgin.excel.annotation.CheckData;
import lombok.Data;

@Data
@ContentRowHeight(15)
@HeadRowHeight(20)
@ColumnWidth(20)
public class StudentScore {

    @CheckData(value = "学生姓名",dictName = "",required = true)
    @ExcelProperty("学生姓名")
    private String studentName;
    @CheckData(value = "学科",dictName = "",required = true)
    @ExcelProperty("学科")
    private String subject;
    @CheckData(value = "成绩",dictName = "",required = true)
    @ExcelProperty("成绩")
    private Integer score;

    // 用于存放批注信息
    @ExcelProperty("批注")
    private String comment;
}