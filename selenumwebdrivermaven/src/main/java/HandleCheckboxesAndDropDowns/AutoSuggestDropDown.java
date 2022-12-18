package HandleCheckboxesAndDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropDown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
        Thread.sleep(3000);

        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
        System.out.println("Number of elements: " + listOfElements.size());

        //Select an option from list
        for (WebElement element : listOfElements) {
            System.out.println(element.getText());
            if(element.getText().equals("selenium testiranje")){
                element.click();
                break;
            }
        }
    }
}
