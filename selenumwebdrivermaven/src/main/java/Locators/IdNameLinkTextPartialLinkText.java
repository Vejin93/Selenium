package Locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdNameLinkTextPartialLinkText {
    public static void main(String[] args) throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Open app
        driver.get("https://www.djaksport.com/");
        driver.manage().window().maximize();

        //Search box
        driver.findElement(By.name("ctl04$ctl07$txtName")).sendKeys("majica");

        //Search button
        driver.findElement(By.id("ctl04_ctl07_btnSearch")).click();

        //Link text & partial link text
//        driver.findElement(By.linkText("ZIMA")).click();
        driver.findElement(By.partialLinkText("IMA")).click();

        driver.close();
    }
}
