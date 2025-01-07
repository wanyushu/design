package com.jiuzhou.desgin.excel;

import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.jiuzhou.desgin.excel.dto.ImportResDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

/**
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 * @author yushu
 * @email 921784721@qq.com
 * @date 2025/1/7 11:30
 */
@Slf4j
public  abstract class CommonImportService<T > extends BaseCommon implements ImportService<T, ImportResDTO> {

    public abstract void saveData(List<T> importList);

    public abstract void updateData(List<T> importList);

    public String uploadMeta(List<T> sList){
        return null;
    }

    protected HorizontalCellStyleStrategy getCellStyleStrategy() {
        // 表头样式
        WriteCellStyle headCellStyle = new WriteCellStyle();
        WriteFont headFont = new WriteFont();
        headFont.setFontHeightInPoints((short) 12);
        headCellStyle.setWriteFont(headFont);

        // 内容样式
        WriteCellStyle contentCellStyle = new WriteCellStyle();
        contentCellStyle.setWrapped(true);

        return new HorizontalCellStyleStrategy(headCellStyle, contentCellStyle);
    }

}
