package HandleDatePickerAndHiddenOptionDropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DropDownWithHiddenElements {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]")).click();

        // Dropdown

        driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]")).click(); //opens the dropdown

        List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span")); // find in DOM (over EvenListener - remove blur)

        for(WebElement option : options){
            //System.out.println(option.getText());
            if(option.getText().equals("Software Engineer")){
                option.click();
                break;
            }
        }


    }

}
