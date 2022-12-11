package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        //For custom XPath
        //String textOfElement = driver.findElement(By.xpath("//a[text()='MacBook']")).getText();
        //For Absolute XPath
        String textOfElement = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/h4[1]/a[1] ")).getText();


        System.out.println(textOfElement);
    }
}
