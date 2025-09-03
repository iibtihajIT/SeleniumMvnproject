import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

Thread.sleep(3000);
        driver.close();

    }
}
