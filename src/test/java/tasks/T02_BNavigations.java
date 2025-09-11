package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02_BNavigations {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // Open URL: https: https://www.google.com/
        driver.get("https://www.google.com/");
// Maximize the window.
        driver.manage().window().maximize();
// Print the position and size of the page.
        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());
        //Set the position of the page to x=50 and y=50.
        driver.manage().window().setPosition(new org.openqa.selenium.Point(50, 50));
// Set the size of the page to width=600 and height=600.
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(600, 600));
        Thread.sleep(3000);

// Minimize the page.
        driver.manage().window().minimize();

// Wait 5 seconds in the icon state and maximize the page.
        Thread.sleep(5000);
        driver.manage().window().maximize();
// Print the position and dimensions of the page in maximized state.
        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());
// Make the page fullscreen.
        driver.manage().window().fullscreen();
// Close the Browser.
        driver.close();


    }
}