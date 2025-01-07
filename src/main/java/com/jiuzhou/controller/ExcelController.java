package com.jiuzhou.controller;

import com.jiuzhou.desgin.excel.EasyExcelListener;
import com.jiuzhou.desgin.excel.ScoreImportService;
import com.jiuzhou.desgin.excel.dto.ImportResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * easyExcel导入案例
 */
@RestController
@RequestMapping("consumerHandler")
public class ExcelController {

    @Autowired
    private ScoreImportService scoreImportService;

    @PostMapping("/import-scores")
    public ImportResDTO importScores(@RequestParam("file") MultipartFile file) throws IOException {
        EasyExcelListener listener = scoreImportService.importScores(file);
        return listener.getRes();
    }
}
