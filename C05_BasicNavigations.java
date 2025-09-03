package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_BasicNavigations {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //Navigate to Facebook homepage URL : https://www.facebook.com/
        driver.get("https://www.facebook.com/");

        // Verify expected equals actual URL
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.facebook.com/";
        if (actualUrl.equals(expectedUrl))
            System.out.println("URL test PASSED");
        else System.out.println("URL test FAILED");

        // Verify expected contains Facebook Word
        String actualTitle = driver.getTitle();
        String expectedWord = "Facebook";
        if (actualTitle.contains(expectedWord))
            System.out.println("Title test PASSED");
        else System.out.println("Title test FAILED");
        // Close the driver.
        driver.close();
    }
}
