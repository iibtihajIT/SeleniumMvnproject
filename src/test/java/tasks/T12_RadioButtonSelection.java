package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T12_RadioButtonSelection {
    WebDriver driver;
    WebDriverWait wait;
//    Navigate to "https://demoqa.com/radio-button". Create a test that:
//    Attempts to select each radio button (Yes, Impressive, No)
//    Prints whether each option is enabled/disabled
//    For enabled options, select them and verify selection
//    Print confirmation message for each successful selection

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testRadioButtons() {
        String[] ids = {"yesRadio", "impressiveRadio", "noRadio"};

        for (String id : ids) {
            WebElement input = driver.findElement(By.id(id));
            System.out.println(id + " enabled? " + input.isEnabled());

            if (input.isEnabled()) {
                WebElement label = driver.findElement(By.cssSelector("label[for='" + id + "']"));
                wait.until(ExpectedConditions.elementToBeClickable(label));
                try {
                    label.click();
                } catch (Exception e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label);
                }

                Assertions.assertTrue(driver.findElement(By.id(id)).isSelected(), id + " not selected!");
                System.out.println("Selected " + id + " successfully ");
            } else {
                System.out.println(id + " is disabled — cannot select.");
            }
        }
    }
}
