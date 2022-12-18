package HandleCheckboxesAndDropDowns;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleAlertWithInputbox {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alertWindow = driver.switchTo().alert();

        System.out.println(alertWindow.getText());

        alertWindow.sendKeys("Jelena");
        alertWindow.accept();
    }
}
