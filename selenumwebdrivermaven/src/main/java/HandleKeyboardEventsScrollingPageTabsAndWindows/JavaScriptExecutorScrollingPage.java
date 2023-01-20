package HandleKeyboardEventsScrollingPageTabsAndWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorScrollingPage {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1) scroll down page by pixel
        js.executeScript("window.scrollBy(0,3000)","");
        System.out.println(js.executeScript("return window .pageYOffset;")); //3000

        // 2) scroll down the page till the element is present
        WebElement flagSerbiaElement = driver.findElement(By.xpath("//img[@alt='Flag of Serbia']"));
        js.executeScript("arguments[0].scrollIntoView()",flagSerbiaElement);

        // 3) scroll down till end of the page/document
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // 4) scroll back to initial position
        js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
    }
}
