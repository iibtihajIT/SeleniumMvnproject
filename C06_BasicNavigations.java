package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_BasicNavigations {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // Go To the Amazon URL: https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        // Verify that it writes "Performance Metrics" or "Gateway" from the Source Code.
        String pageSource = driver.getPageSource();
        if (pageSource.contains("Performance Metrics") || pageSource.contains("Gateway"))
            System.out.println("Page source test PASSED");
        else System.out.println("Page source test FAILED");
        // Close the driver.
        driver.close();

    }
}
