package HandleCheckboxesAndDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckbox {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();

        //select specific one checkbox
        //driver.findElement(By.xpath("//input[@id='monday']")).click();

        //total number of checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

        //select all the checkboxes
//        for (WebElement cb : checkboxes) {
//            cb.click();
//        }

        //select last 2 checkboxes
//        for(int i=checkboxes.size()-1;i>checkboxes.size()-3;i--){
//            checkboxes.get(i).click();
//        }

        //select first 2 checkboxes
//        for(int i=0;i<2;i++){
//            checkboxes.get(i).click();
//        }

        //uncheck checkboxes/clear
        //for normal loop
//        for(int i=0;i<checkboxes.size();i++){
//            checkboxes.get(i).click();
//        }

//        for(int i=0;i<3;i++){
//            checkboxes.get(i).click();
//        }
//
//        Thread.sleep(2000);
//
//        for(int i=0;i<checkboxes.size();i++){
//            if(checkboxes.get(i).isSelected())
//            checkboxes.get(i).click();
//        }
        // FOREACH LOOP
        for (int i = 0; i < 3; i++) {
            checkboxes.get(i).click();
        }

        Thread.sleep(2000);

//        for(int i=0;i<checkboxes.size();i++){
//            if(checkboxes.get(i).isSelected())
//            checkboxes.get(i).click();
//          }
        for (WebElement cb : checkboxes) {
            if (cb.isSelected())
                cb.click();
        }

    }
}
