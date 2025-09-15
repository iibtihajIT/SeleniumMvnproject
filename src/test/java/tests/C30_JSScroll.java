package tests;

import org.junit.jupiter.api.Test;
import Utilites.JSUtils;
import Utilites.TestBase;

public class C30_JSScroll extends TestBase {

    @Test
    void scrollDownTest() throws InterruptedException {

        driver.get("https://testpages.eviltester.com/styled/index.html");

        Thread.sleep(3000);
        JSUtils.scrollDownByPx(driver, 500);
        Thread.sleep(3000);
        JSUtils.scrollDownByPx(driver, 100);
        Thread.sleep(3000);
        JSUtils.scrollDownByPx(driver, 1000);

    }

}