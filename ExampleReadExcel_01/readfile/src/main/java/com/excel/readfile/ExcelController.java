package com.excel.readfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ExcelController {

    private final ExcelReaderService excelReaderService;

    public ExcelController(ExcelReaderService excelReaderService) {
        this.excelReaderService = excelReaderService;
    }

    @GetMapping("/read-excel")
    public List<FinancialTransaction> readExcel(@RequestParam String filePath) throws IOException {
        return excelReaderService.readExcelFile(filePath);
    }
}
