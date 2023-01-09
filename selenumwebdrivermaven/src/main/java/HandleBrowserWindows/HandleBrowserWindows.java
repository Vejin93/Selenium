package HandleBrowserWindows;

import org.checkerframework.common.value.qual.ArrayLen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {

    public static void main (String[] args){

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("OrangeHRM, Inc")).click();

        //capture id's for browser windows
        Set<String> windowIDs = driver.getWindowHandles(); // store 2 window id's

        /*
        //Approach 1 - using List collection
        List<String> windowIdsList = new ArrayList(windowIDs); // converted Set --> List

        String parentWidnowId = windowIdsList.get(0);
        String childWidnowId = windowIdsList.get(1);

        //Switch to child window
        driver.switchTo().window(childWidnowId);
        driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();

        //Switch to parent window
        driver.switchTo().window(parentWidnowId);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Vlado");
        */

        //Approach 2
        for(String winid : windowIDs){
            String title = driver.switchTo().window(winid).getTitle();

            if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM")){
                driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
            }
        }

        driver.quit();

    }
}
