package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class C04_BasicNavigations {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
// Go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");

// Verify the page title contains the word video.
        String titleOfThePage = driver.getTitle();
        System.out.println("titleOfThePage = " + titleOfThePage);
        if (titleOfThePage.contains("video"))
            System.out.println("It contains the word 'video'");
        else System.out.println("It does not contain that one");

// Close the driver.
        driver.close();
    }
}
