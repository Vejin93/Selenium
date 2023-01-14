package HandleMouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDoubleClickDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();

        driver.switchTo().frame("iframeResult"); // switch to frame

        WebElement inputBox1 = driver.findElement(By.xpath("//input[@id='field1']"));
        inputBox1.clear();
        inputBox1.sendKeys("Jelena");

        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        // Double click
        Actions act = new Actions(driver);

        act.doubleClick(button).perform();

        if (driver.findElement(By.xpath("//input[@id='field1']")).getText().equals(driver.findElement(By.xpath("//input[@id='field2']")).getText())) {
            System.out.println("Copy is successful!!!");
        } else {
            System.out.println("Sorry, copy is unsuccessful!!!");
        }

    }

}
