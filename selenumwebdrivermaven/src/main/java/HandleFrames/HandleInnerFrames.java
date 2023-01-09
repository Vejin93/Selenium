package HandleFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleInnerFrames {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        //Frame 1
        WebElement frm1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frm1);

        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("11111");

        driver.switchTo().defaultContent();

        //Frame 3
        WebElement frm3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frm3);

        //inner frame
        driver.switchTo().frame(0);

        driver.findElement(By.cssSelector(".AB7Lab")).click(); // select first radio button in frame

        driver.switchTo().defaultContent();
    }
}
