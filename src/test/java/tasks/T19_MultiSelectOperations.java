package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T19_MultiSelectOperations {


    @Test

    void Tester() throws InterruptedException {

        WebDriver driver = new ChromeDriver();



        driver.manage().window().maximize();


        driver.get("https://demoqa.com/select-menu");


        Thread.sleep(2000);


        WebElement multiSelectElement = driver.findElement(By.id("cars"));


        Select select = new Select(multiSelectElement);
        if (select.isMultiple()) {
            System.out.println("Element is multi-select.");


            select.selectByIndex(2);
            Thread.sleep(1000);


            select.deselectByIndex(2);
            Thread.sleep(1000);


            select.selectByValue("saab");
            Thread.sleep(1000);


            select.deselectByValue("saab");
            Thread.sleep(1000);


            select.deselectAll();
            System.out.println("All options deselected.");
        } else {
            System.out.println("Element is NOT multi-select.");
        }


        Thread.sleep(2000);
        driver.quit();
    }
}





