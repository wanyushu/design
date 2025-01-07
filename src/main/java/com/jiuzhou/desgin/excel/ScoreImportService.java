package com.jiuzhou.desgin.excel;

import com.alibaba.excel.EasyExcel;
import com.jiuzhou.desgin.excel.vo.StudentScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreImportService {

    @Autowired
    private ImportService importService;

    public EasyExcelListener importScores(MultipartFile file) throws IOException {
        List<StudentScore> studentScores = new ArrayList<>();
        EasyExcelListener listener = new EasyExcelListener(0,importService,studentScores);
        EasyExcel.read(file.getInputStream()).head(StudentScore.class)
                .registerReadListener(listener).headRowNumber(1).doReadAll();
        return listener;
    }
}