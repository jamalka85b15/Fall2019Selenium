package com.automation.tests.day13;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;

public class ReadDataFromExcel {

    @Test
    public void readFromExcelTest() throws Exception{
        File file=new File("VytrackTestUsers.xlsx");

        Workbook workbook = WorkbookFactory.create(file);
        Sheet worksheet= workbook.getSheet("QA1-short");
        Row firstRow=worksheet.getRow(0);
        Cell firstCell=firstRow.getCell(0);
        String value =firstCell.getStringCellValue();
        String secondCellValue= firstRow.getCell(1).getStringCellValue();
        System.out.println(value);
        System.out.println(secondCellValue);

        int lastCell=firstRow.getLastCellNum();
        System.out.println("++++++++++++++++++++++++++");
        for (int i = 0; i <lastCell ; i++) {
            System.out.print(firstRow.getCell(i)+" | ");

            int numberOfRows=worksheet.getLastRowNum();
            int numberOfRows2=worksheet.getPhysicalNumberOfRows();

            System.out.println("\nIndex of last row: "+ numberOfRows);
            System.out.println("\nnumberOfRows2 = " + numberOfRows2);
            System.out.println("======================================");
            for (int row = 0; row <worksheet.getPhysicalNumberOfRows() ; row++) {
                for (int cell = 0; cell <worksheet.getRow(row).getLastCellNum() ; cell++) {
                    String cellValue=worksheet.getRow(row).getCell(cell).getStringCellValue();
                    System.out.println();

                }

            }

        }
    }
}
