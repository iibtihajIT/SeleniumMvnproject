package tests;

import org.apache.poi.ss.usermodel.Cell;
import Utilites.ExcelUtils;

public class C38_ExcelUtil {

    public static void main(String[] args) {

        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/People.xlsx");
        Cell r3c5 = excelUtils.getCell("Sheet1", 2, 2);
        System.out.println("r3c5 = " + r3c5.getStringCellValue());

        ExcelUtils excelUtils2 = new ExcelUtils("src/test/resources/ExcelUtils.xlsx");
        Cell r4c6 = excelUtils2.getCell("Sheet1", 3, 2);
        System.out.println("r4c6 = " + r4c6);


    }


}
