package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T03_BNavigations {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // Go to the Amazon URL : https://www.Amazon.com/
        driver.get("https://www.amazon.com/");
// Print the position and size of the page.
        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());
// Set the position of the page to x=50 and y=50.
        driver.manage().window().setPosition(new org.openqa.selenium.Point(50, 50));
// Set the size of the page to width=600 and height=600.
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(600, 600));
        Thread.sleep(3000);
// Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new org.openqa.selenium.Point(100, 100));
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(800, 800));
        Thread.sleep(3000);
// Test that the page is in the position and size you want.
        System.out.println("New Position: " + driver.manage().window().getPosition());
        System.out.println("New Size: " + driver.manage().window().getSize());

// Close the page.
        Thread.sleep(3000);
        driver.close();

    }
}