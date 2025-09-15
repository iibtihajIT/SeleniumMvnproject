package Tasks;

import Utilites.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T23_DragAndDropTest extends TestBase {

    String URL = "https://claruswaysda.github.io/dragAndDrop.html";

    @Test
    void dragAndDropItems() {
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for piece1 to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("piece1")));

        // Locate pieces
        WebElement piece1 = driver.findElement(By.id("piece1"));
        WebElement piece2 = driver.findElement(By.id("piece2"));
        WebElement piece3 = driver.findElement(By.id("piece3"));

        // Locate slots
        WebElement slot1 = driver.findElement(By.id("slot1"));
        WebElement slot2 = driver.findElement(By.id("slot2"));
        WebElement slot3 = driver.findElement(By.id("slot3"));

        // Use JavaScript to simulate HTML5 drag and drop
        String jsDragAndDrop = """
            function triggerDragAndDrop(source, target) {
                const dataTransfer = new DataTransfer();
                source.dispatchEvent(new DragEvent('dragstart', {dataTransfer}));
                target.dispatchEvent(new DragEvent('drop', {dataTransfer}));
                source.dispatchEvent(new DragEvent('dragend', {dataTransfer}));
            }
            triggerDragAndDrop(arguments[0], arguments[1]);
        """;

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(jsDragAndDrop, piece1, slot1);
        js.executeScript(jsDragAndDrop, piece2, slot2);
        js.executeScript(jsDragAndDrop, piece3, slot3);

        // Wait for success message
        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("celebrate"))
        );

        // Assert success message
        assertTrue(successMessage.isDisplayed(), "Success message should be displayed");
        assertTrue(successMessage.getText().contains("Congratulations!"), "Message should contain 'Congratulations!'");

        System.out.println("Final Message: " + successMessage.getText());
    }
}





