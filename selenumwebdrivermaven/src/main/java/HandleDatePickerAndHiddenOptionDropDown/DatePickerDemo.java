package HandleDatePickerAndHiddenOptionDropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickerDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        driver.switchTo().frame(0); // switch to the frame

        // Approach 1
        //driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("15/10/2022"); // mm/dd/yyyy

        // Approach 2

        String year = "2023";
        String month = "April";
        String date = "16";

        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        // select month & year
        while (true) {
            String monthActual = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String yearActual = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (monthActual.equals(month) && yearActual.equals(year)) {
                break;
            }

            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Future date button
            //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // Past date button
        }

        // select date
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
                break;
            }
        }

    }
}
