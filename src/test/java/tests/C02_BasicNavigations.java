package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Go to www.facebook.com
        driver.get("https://facebook.com");

        // Maximize Window
        driver.manage().window().maximize();

        // Go to www.amazon.com
        driver.navigate().to("https://amazon.com");

        // Navigate Back
        Thread.sleep(3000);
        driver.navigate().back();

        // Navigate Forward
        Thread.sleep(3000);
        driver.navigate().forward();

        // Refresh The Page
        Thread.sleep(3000);
        driver.navigate().refresh();

        //Thread.sleep(3000);
        driver.close();

    }
}
