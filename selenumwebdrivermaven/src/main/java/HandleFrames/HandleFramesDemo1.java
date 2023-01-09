package HandleFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFramesDemo1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("org.openqa.selenium")).click(); // frame1

        driver.findElement(By.linkText("WebDriver")).click();// frame2

        driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Overview']")).click(); // frame 3
    }
}
