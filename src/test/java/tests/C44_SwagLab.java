package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import Utilites.TestBase;

public class C44_SwagLab extends TestBase {
    /*
        1. Navigate to https://www.saucedemo.com/v1/index.html
        2. Log in as the standard user.
        3. Capture screenshots of:
             - The lowest-priced product (including its image, price, and details).
             - The highest-priced product (including its image, price, and details).
        4. Log out of the application.
        5. Assert each step for validation.
        6. Log all steps using Log4j.
        7. Generate an Extent Report containing all steps.
    */

    @Test
    void swagLabTest() {
//        1. Navigate to https://www.saucedemo.com/v1/index.html
        driver.get("https://www.saucedemo.com/v1/index.html");

//        2. Log in as the standard user.
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce", Keys.ENTER);

//        3. Capture screenshots of:
//                - The lowest-priced product (including its image, price, and details).
//                - The highest-priced product (including its image, price, and details).
        WebElement dropDown = driver.findElement(By.tagName("select"));
        new Select(dropDown).selectByVisibleText("Price (low to high)");
        WebElement lowest = driver.findElements(By.xpath("//div[@class='inventory_item']")).getFirst();
        WebElement highest = driver.findElements(By.xpath("//div[@class='inventory_item']")).getLast();
        takeElementsScreenshot(lowest);
        takeElementsScreenshot(highest);

//        4. Log out of the application.
        driver.findElement(By.xpath("//button[.='Open Menu']")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();

//        5. Assert each step for validation.

//        6. Log all steps using Log4j.

//        7. Generate an Extent Report containing all steps.


    }


}
