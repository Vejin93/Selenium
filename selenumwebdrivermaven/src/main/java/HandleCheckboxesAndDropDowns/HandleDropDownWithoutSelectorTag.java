package HandleCheckboxesAndDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleDropDownWithoutSelectorTag {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();

        //clicking on dropdown
        driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();

        List<WebElement> allDropDownOptions = driver.findElements(By.xpath("//ul[contains(@class,multiselect)]//label"));

        //find total number of options
        System.out.println("Total number of options: " + allDropDownOptions.size());

        //print all options from dropdown
//        for (WebElement option : allDropDownOptions) {
//            System.out.println(option.getText());
//        }

        //select options from dropdown
//        for (int i = 0; i < allDropDownOptions.size(); i++) {
//            if (allDropDownOptions.get(i).getText().equals("Java")) {
//                allDropDownOptions.get(i).click();
//                break;
//            }
//        }

        for (WebElement option : allDropDownOptions) {
            if(option.getText().equals("Java") || option.getText().equals("Python"))
                option.click();
        }

//        driver.close();
    }
}
