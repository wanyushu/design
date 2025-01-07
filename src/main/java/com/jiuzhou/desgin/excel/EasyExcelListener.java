package com.jiuzhou.desgin.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.jiuzhou.desgin.excel.dto.ImportResDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 */
@Slf4j
public class EasyExcelListener<T> extends AnalysisEventListener<T> {

    /**
     * 读取的头行
     */
    private int sheetNo;

    /**
     * 保存的数据
     */
    private List<T> saveData;

    /**
     * 更新的数据
     */
    private List<T> updateData;

    /**
     * 记录导入的异常信息
     */
    private ImportResDTO importResDTO;
    /**
     * 导入的接口实例
     */
    private ImportService importService;

    /**
     * 元数据信息
     */
    private List<T> sList;
    /**
     * 插入一次量
     */
    private int  BATCH_COUNT = 1000;


    public EasyExcelListener(Integer sheetNo, ImportService importService,List<T> sList) {
        this.sheetNo = sheetNo;
        this.saveData = new ArrayList<>();
        this.updateData = new ArrayList<>();
        this.importResDTO = new ImportResDTO();
        this.importService = importService;
        this.sList = sList;

    }

    @Override
    public void invoke(T t, AnalysisContext context) {
        if(context.readSheetHolder().getSheetNo()!=sheetNo)return;
        if(null==this.sList){
            importService.importCheck(context,this.importResDTO,t,this.saveData,updateData);
        }else{
            importService.importCheck(context,t,importResDTO,this.saveData,this.updateData,this.sList);
        }

        if (saveData.size() >= BATCH_COUNT) {
            importService.saveData(saveData);
            saveData.clear();
        }
        if (updateData.size() >= BATCH_COUNT) {
            importService.updateData(updateData);
            updateData.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if(context.readSheetHolder().getSheetNo()!=sheetNo)return;
        //数据入库逻辑
        if(saveData.size()>0){
            importService.saveData(saveData);
        }
        if(updateData.size()>0){
            importService.updateData(updateData);
        }
        //处理数据解析完成时
        if(importResDTO.getFail()>0){
            String s = importService.uploadMeta(sList);
            this.getRes().setServiceId(s);
        }
    }
    public ImportResDTO getRes() {
        return importResDTO;
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        super.onException(exception, context);
        log.error(exception.getMessage());
    }
}
