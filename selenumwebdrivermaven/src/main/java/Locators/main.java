package Locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class main {
    public static void main(String[] args) throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Open app
        driver.get("https://www.djaksport.com/");
        driver.manage().window().maximize();

        //Search box
        driver.findElement(By.id("ctl04_ctl07_txtName")).sendKeys("T-shirts");

        //Search button
        driver.findElement(By.id("ctl04_ctl07_btnSearch")).click();


    }
}
