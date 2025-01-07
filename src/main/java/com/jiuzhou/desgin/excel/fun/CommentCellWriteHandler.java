package com.jiuzhou.desgin.excel.fun;

import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import org.apache.poi.ss.usermodel.*;

/**
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2025/1/7 15:24
 */
public class CommentCellWriteHandler  implements CellWriteHandler {

    @Override
    public void afterCellDispose(CellWriteHandlerContext context) {
        if (context.getCell().getCellComment()!= null) {
            Sheet sheet = context.getWriteSheetHolder().getSheet();
            Workbook workbook = sheet.getWorkbook();
            CreationHelper factory = workbook.getCreationHelper();
            Drawing<?> drawing = sheet.createDrawingPatriarch();
            Comment comment = drawing.createCellComment(factory.createClientAnchor());
            comment.setString(factory.createRichTextString(context.getCell().getCellComment().getAuthor()));
            comment.setAuthor("系统");
            Cell cell = context.getCell();
            cell.setCellComment(comment);
        }
    }
}
