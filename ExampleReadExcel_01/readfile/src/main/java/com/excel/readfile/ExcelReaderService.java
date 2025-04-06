package com.excel.readfile;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ExcelReaderService {
    public List<FinancialTransaction> readExcelFile(String filePath) throws IOException {
        List<FinancialTransaction> transactions = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath);
             HSSFWorkbook workbook = new HSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

            int firstLine = 1;
            for (int i = firstLine; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                FinancialTransaction transaction = new FinancialTransaction();

                // Column A: Date Operation
                Cell dateOperationCell = row.getCell(0);
                if (dateOperationCell != null && dateOperationCell.getCellType() == CellType.STRING) {

                    Date date = formatter.parse(dateOperationCell.getStringCellValue());
                    dateOperationCell.setCellValue(date);

                    transaction.setOperationDate(
                            dateOperationCell.getDateCellValue()
                                    .toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate()
                    );
                }

                // Column B: Date Processing
                Cell dateProcessingCell = row.getCell(1);
                if (dateProcessingCell != null && dateProcessingCell.getCellType() == CellType.STRING) {

                    Date date = formatter.parse(dateProcessingCell.getStringCellValue());
                    dateProcessingCell.setCellValue(date);

                    transaction.setProcessingDate(
                            dateProcessingCell.getDateCellValue()
                                    .toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate()
                    );
                }

                // Column C: Description
                Cell descriptionCell = row.getCell(2);
                if (descriptionCell != null) {
                    if (descriptionCell.getCellType() == CellType.STRING) {
                        transaction.setDescription(descriptionCell.getStringCellValue());
                    } else if (descriptionCell.getCellType() == CellType.NUMERIC) {
                        transaction.setDescription(String.valueOf(descriptionCell.getNumericCellValue()));
                    }
                }

                // Column D: Value moviment
                Cell valueCell = row.getCell(3);
                if (valueCell != null && valueCell.getCellType() == CellType.NUMERIC) {
                    transaction.setMovementValue(valueCell.getNumericCellValue());
                }

                // Column E: Balance
                Cell balanceCell = row.getCell(4);
                if (balanceCell != null && balanceCell.getCellType() == CellType.NUMERIC) {
                    transaction.setBalance(balanceCell.getNumericCellValue());
                }

                transactions.add(transaction);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return transactions;
    }
}
