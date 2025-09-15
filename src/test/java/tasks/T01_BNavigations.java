package tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01_BNavigations {
    public static void main(String[] args) throws InterruptedException{
        ;// Invoke Chrome Browser
        WebDriver driver = new ChromeDriver();

// Navigate to URL: https://www.clarusway.com/
        driver.get("https://www.clarusway.com/");
// Navigate to URL: https://amazon.com/
        driver.get("https://amazon.com/");
// Come back to the clarusway using the back command.
        Thread.sleep(3000);
        driver.navigate().back();
// Again go back to the amazon website using forward command
        Thread.sleep(3000);
        driver.navigate().forward();
// Refresh the Browser using refresh command.
        Thread.sleep(3000);
        driver.navigate().refresh();
// Close the Browser.
        Thread.sleep(3000);
        driver.close();
    }
}
