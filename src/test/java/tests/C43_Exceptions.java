package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilites.TestBase;

import java.time.Duration;

public class C43_Exceptions extends TestBase {

    @Test
    void noSuchElementExceptionTest() {
        driver.get("https://google.com");
        driver.findElement(By.id("xyz"));//
    }

    @Test
    void timeoutExceptionTest() {
        driver.get("https://google.com");
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("xyz")));
    }

    @Test
    void staleElementReferenceExceptionTest() {
        driver.get("https://testpages.eviltester.com/styled/index.html");
        WebElement link = driver.findElement(By.linkText("Index"));
        driver.navigate().refresh();
        link = driver.findElement(By.linkText("Index"));
        link.click();//StaleElementReferenceException

    }

    @Test
    void noAlertPresentExceptionTest() {
        driver.get("https://testpages.eviltester.com/styled/index.html");
        driver.switchTo().alert();//NoAlertPresentException
    }


}
