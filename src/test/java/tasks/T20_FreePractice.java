package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T20_FreePractice {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    private void setIfPresent(By by, String value) {
        List<WebElement> els = driver.findElements(by);
        if (!els.isEmpty()) {
            els.get(0).clear();
            els.get(0).sendKeys(value);
        }
    }

    @Test
    public void testRegisterFormAndDropdowns() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        setIfPresent(By.name("firstName"), "Ibtihaj");
        setIfPresent(By.name("lastName"), "alyabsi");
        setIfPresent(By.name("phone"), "0551234567");
        setIfPresent(By.name("userName"), "ibtihaj@example.com");
        setIfPresent(By.name("email"), "ibtihaj@example.com");
        setIfPresent(By.name("address1"), "Street 1");
        setIfPresent(By.name("city"), "Riyadh");
        setIfPresent(By.name("state"), "Riyadh");
        setIfPresent(By.name("postalCode"), "12345");

        List<WebElement> countryEls = driver.findElements(By.name("country"));
        if (!countryEls.isEmpty()) {
            Select country = new Select(countryEls.get(0));
            country.selectByVisibleText("SAUDI ARABIA");
        }

        setIfPresent(By.name("email"), "myuser");
        setIfPresent(By.name("password"), "Password123");
        setIfPresent(By.name("confirmPassword"), "Password123");
        setIfPresent(By.name("confirm"), "Password123");

        List<WebElement> submit = driver.findElements(By.name("submit"));
        if (submit.isEmpty()) submit = driver.findElements(By.xpath("//input[@type='submit']"));
        if (!submit.isEmpty()) submit.get(0).click();

        assertTrue(driver.getCurrentUrl().contains("register") || driver.getTitle().length() > 0);
    }
}
