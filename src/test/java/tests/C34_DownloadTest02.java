package tests;

import Utilites.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class C34_DownloadTest02 extends TestBase {
    /*
    Go to https://claruswaysda.github.io/downloadUpload.html
    Click on download
    Verify that 'QAProgram.png' file is downloaded
    */

    @Test
    void downloadTest() throws InterruptedException {
//        Go to https://claruswaysda.github.io/downloadUpload.html
        driver.get("https://claruswaysda.github.io/downloadUpload.html");

//        Click on download
        driver.findElement(By.xpath("//*[@class='download-btn']")).click();
        Thread.sleep(3000);

//        Verify that 'QAProgram.png' file is downloaded
        String filePath = System.getProperty("user.home") + "/Downloads/QAProgram.png";
        boolean isFileDownloaded = java.nio.file.Files.exists(java.nio.file.Path.of(filePath));
        System.out.println("isFileDownloaded = " + isFileDownloaded);
        assert isFileDownloaded;

    }
}