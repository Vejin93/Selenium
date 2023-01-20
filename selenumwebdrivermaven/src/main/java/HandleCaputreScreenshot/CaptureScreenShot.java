package HandleCaputreScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CaptureScreenShot {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //Capture full page screenshot - in selinium 3 & 4
        /*
        TakesScreenshot takeScreen = (TakesScreenshot) driver;
        File source1 = takeScreen.getScreenshotAs(OutputType.FILE);
        File target1 = new File("C:\\Users\\Sladja\\Desktop\\seleniumwebdriver\\selenumwebdrivermaven\\screenshots\\FullPage.png");
        FileUtils.copyFile(source1,target1);
        */

        //Capture screenshot of specific area from webpage - in selinium 4+
        WebElement electronicProducts = driver.findElement(By.xpath("//img[@title='Show products in category Electronics']"));
        File source2 = electronicProducts.getScreenshotAs(OutputType.FILE);
        File target2 = new File("C:\\Users\\Sladja\\Desktop\\seleniumwebdriver\\selenumwebdrivermaven\\screenshots\\ElectronicProducts.png");
        FileUtils.copyFile(source2,target2);

    }
}
