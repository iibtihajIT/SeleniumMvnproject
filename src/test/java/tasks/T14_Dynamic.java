package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T14_Dynamic {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void dynamicTest() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        Faker faker = new Faker();

        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));
        for (int i = 0; i < 5; i++) {
            String task = faker.book().title();
            input.sendKeys(task + Keys.ENTER);
            System.out.println("➕ Added task: " + task);
        }

        List<WebElement> tasks = driver.findElements(By.tagName("li"));

        for (int i = 0; i < tasks.size(); i++) {

            tasks.get(i).click();
            System.out.println("✔ Marked completed: " + tasks.get(i).getText());

        }


        List<WebElement> remaining = driver.findElements(By.xpath("//li[@class='completed']"));
        for (WebElement t : remaining) {
            Assertions.assertTrue(t.getAttribute("class").contains("completed"));
            System.out.println(" Remaining task: " + t.getText());
        }

        System.out.println(" Only incomplete tasks remain!");
        List<WebElement> deleteButtons = driver.findElements(By.tagName("i"));
        for (WebElement btn : deleteButtons) {
            try {
                btn.click();
                System.out.println(" Deleted a completed task.");
            } catch (Exception ignored) {
            }
        }

        Thread.sleep(3000);
        System.out.println(driver.findElements(By.tagName("li")).size());
        Assertions.assertTrue(driver.findElements(By.tagName("li")).isEmpty());
        System.out.println(" All tasks deleted!");
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
