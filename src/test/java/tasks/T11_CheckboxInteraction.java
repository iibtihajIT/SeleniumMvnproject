package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


import java.time.Duration;

public class T11_CheckboxInteraction {

//    Go to "https://the-internet.herokuapp.com/checkboxes".
//    Checks the current state of both checkboxes
//    Ensures both checkboxes are selected (click only if not already selected)
//    Verify both checkboxes are checked after the operations
//    Print the status of each checkbox to console

    @Test
    void checkboxInteractionTest() {
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkBox : checkBoxList) {
            if (!checkBox.isSelected()) {
                checkBox.click();
            }
            System.out.println("Checkbox is selected: " + checkBox.isSelected());

            if (!checkBox.isSelected()) {
                Assertions.fail();
            }
        }

    }

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
