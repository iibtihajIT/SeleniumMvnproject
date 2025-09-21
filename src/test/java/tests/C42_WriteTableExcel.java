package tests;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utilites.TestBase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class C42_WriteTableExcel extends TestBase {

    /*
    Go to https://claruswaysda.github.io/webTable.html
    Write the entire Table 1 to a new Excel sheet.
    */

    @Test
    void writeTableExcelTest() throws IOException {

//        Go to https://claruswaysda.github.io/webTable.html
        driver.get("https://claruswaysda.github.io/webTable.html");

//        Write the entire Table 1 to a new Excel sheet.
        Workbook workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet("Sheet1");
        WebElement table1 = driver.findElement(By.id("t1"));
        List<WebElement> rows = table1.findElements(By.xpath(".//tr"));
        //rows.forEach(t -> System.out.println(t.getText()));
        List<WebElement> columns = rows.getFirst().findElements(By.xpath(".//th"));//First row header
        columns.forEach(t -> System.out.println(t.getText()));



        //Header
        sheet.createRow(0);
        for (int j = 0; j < columns.size(); j++) {//Cell-Column Control
            sheet.getRow(0).createCell(j).setCellValue(columns.get(j).getText());
        }

        //Table Body
        for (int i = 1; i < rows.size(); i++) {//Row control
            sheet.createRow(i);
            columns = rows.get(i).findElements(By.xpath(".//td"));
            for (int j = 0; j < columns.size(); j++) {//Cell-Column Control
                sheet.getRow(i).createCell(j).setCellValue(columns.get(j).getText());
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/Table1.xlsx");
        workbook.write(fileOutputStream);

    }


}
