package WebDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://amazon.in/");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https://flipkart.com/");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl()); // amazon.in

        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl()); // flipkart

        driver.navigate().refresh();
    }
}
