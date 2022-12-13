package WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class GetMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //1) get(url) command
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //2) getTitle() command
        String title = driver.getTitle();
        System.out.println("Title is:"  + title);

        //3) getCurrentURL() command
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //4) getPageSource() command
        //System.out.println("Page source: " + driver.getPageSource());

        //5) getWindowHandle() command
        //System.out.println(driver.getWindowHandle());
        // 1. run : Current window ID: CDwindow-88CF7813B246A0ED938F3970FF3CBF7D
        // 2. run : Current window ID: CDwindow-EC894B3D2F74031F58C2F1619D62D647

        Thread.sleep(1000);

        //6) getWindowHandles() command
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();//opens new browser window
        Set<String> windowIDs = driver.getWindowHandles();
        for (String s: windowIDs) {
            System.out.println(s);
        }
        
    }
}
