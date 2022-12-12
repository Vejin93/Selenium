package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XPathAxes {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
        driver.manage().window().maximize();

        //Self  - Selects the current node
        String text = driver.findElement(By.xpath("//a[contains(text(),'NIIT Ltd')]/self::a")).getText();
        System.out.println("Self : " + text);

        //Parent - Selects the parent of the current node (always one)
        text = driver.findElement(By.xpath("//a[contains(text(),'NIIT Ltd')]/parent::td")).getText();
        System.out.println("Parent : " + text);

        //Child - Selects all children of the current node (One or many)
        List<WebElement> childs = driver.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/child::td"));
        System.out.println("Number of child elements:" + childs.size());
    }
}
