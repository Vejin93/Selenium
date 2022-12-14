package WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().window().maximize();

        //1) isDisplayed() command
        Boolean statusLogo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
        System.out.println("Logo is displayed: " + statusLogo);

        //2) isEnabled() method
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        System.out.println("Display status: " + searchBox.isDisplayed());
        System.out.println("Enable status: " + searchBox.isEnabled());

        //3) isSelected() method
        WebElement male_rd = driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement female_rd = driver.findElement(By.xpath("//input[@id='gender-female']"));

        //Before selection
        System.out.println("Before selection...............");
        System.out.println(male_rd.isSelected());
        System.out.println(female_rd.isSelected());

        //After selection of male radiobutton
        male_rd.click();
        System.out.println("After selection...............");
        System.out.println(male_rd.isSelected());
        System.out.println(female_rd.isSelected());
    }
}
