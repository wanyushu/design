package com.jiuzhou.desgin.excel.Impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.fastjson.JSON;
import com.jiuzhou.desgin.excel.CommonImportService;
import com.jiuzhou.desgin.excel.dto.ImportResDTO;
import com.jiuzhou.desgin.excel.fun.CommentCellWriteHandler;
import com.jiuzhou.desgin.excel.vo.StudentScore;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 * @author yushu
 * @email 921784721@qq.com
 * @date 2025/1/7 11:26
 */
@Slf4j
@Service
public class ScoreImportServiceImpl extends CommonImportService<StudentScore>  {



    @Override
    public String importCheck(AnalysisContext context, StudentScore studentScore,
                              ImportResDTO importResDTO, List<StudentScore> importList,
                              List<StudentScore> updateList, List<StudentScore> sList) {
        String s = this.importCheck(context, studentScore, importResDTO, importList, updateList);
        studentScore.setComment(s);
        sList.add(studentScore);
        return s;
    }

    @Override
    public String importCheck(AnalysisContext context, StudentScore studentScore, ImportResDTO importResDTO,
                            List<StudentScore> importList, List<StudentScore> updateList) {
        int row = context.getCurrentRowNum()+1;
        //检查是否都是空
        if(this.checkLastLine(studentScore)){
            return null;
        }
        String s = this.checkData(studentScore);

        importResDTO.setTotal(importResDTO.getTotal()+1);
        if(StringUtils.isEmpty(s)){
            //todo 判断数据是否存在
            boolean exit= false;
            if(exit){
                updateList.add(studentScore);
            }else{
                importList.add(studentScore);
            }
            importResDTO.setSucc(importResDTO.getSucc()+1);
        }else{
            importResDTO.getErrorMap().put("第"+row+"行",s);
            int fail = importResDTO.getFail();
            importResDTO.setFail(fail+1);
        }
        return s;
    }

    @Override
    public void saveData(List<StudentScore> importList) {
        log.info("开始新增数据:{}", JSON.toJSONString(importList));
        //todo 实际入库操作
    }

    @Override
    public void updateData(List<StudentScore> importList) {
        log.info("开始更新数据:{}", JSON.toJSONString(importList));
        //todo 实际入库操作
    }

    @Override
    public String uploadMeta(List<StudentScore> sList) {
        log.info("开始上传元数据相关信息到文件服务器以便后续下载异常信息");
        try {
            // 重新写入文件并添加批注样式
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            EasyExcel.write(outputStream,StudentScore.class)
                    .registerWriteHandler(getCellStyleStrategy())
                    .registerWriteHandler(new CommentCellWriteHandler())
                    .sheet("data")
                    .doWrite(sList);
            InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            // todo 将文件存入文件服务器

            String replace = UUID.randomUUID().toString().replace("-", "");
            return replace;
        } catch (Exception e) {
            log.error("异常文件上传至服务器发生异常");
            e.printStackTrace();
        }
        return null;
    }

}
