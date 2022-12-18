package HandleCheckboxesAndDropDowns;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleAlerts {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        //Alert alertWindow = driver.switchTo().alert();
        Alert alertIsAvailable = myWait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alertIsAvailable.getText());

        //alertIsAvailable.accept(); // close alert window by using ok button
        alertIsAvailable.dismiss(); // close alert window by using cancel button
    }
}
