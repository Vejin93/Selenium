package HandleMouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocationOfElement {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        System.out.println("Logo location before maximizing: " + logo.getLocation());

        driver.manage().window().maximize();

        System.out.println("Logo location after maxmizing: " + logo.getLocation());

        driver.manage().window().minimize();

        System.out.println("Logo location after minimizing: " + logo.getLocation());

        Point p = new Point(50, 50);
        driver.manage().window().setPosition(p);

        System.out.println("After setting window 50 x 50: " + logo.getLocation());
    }
}
