package HandleCheckboxesAndDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HandleDropdownWithSelectTag {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.opencart.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='btn btn-black navbar-btn']")).click();

        WebElement dropDownCountryElement= driver.findElement(By.xpath("//select[@id='input-country']"));

        Select dropDownCountry = new Select(dropDownCountryElement);

        //1) Selecting option from dropdown
        //dropDownCountry.selectByVisibleText("Samoa");
        //dropDownCountry.selectByValue("3"); // use only if value attribute is present for option tag
        //dropDownCountry.selectByIndex(12);

        //2) Total number of options in dropdown
        List<WebElement> dropDownAllOptions = dropDownCountry.getOptions();
        System.out.println("Number of options: " + dropDownAllOptions.size());

        //3) Print first 20 options in console
        for(int i=1;i<21;i++){
            System.out.println(i+". " + dropDownAllOptions.get(i).getText());
        }
    }
}