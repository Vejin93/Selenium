package WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        Thread.sleep(3000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();

        //1) close() method - close single browser window (which is in driver instance)
        //driver.close();

        //1) close() method - close all browser windows
        driver.quit();
    }
}
