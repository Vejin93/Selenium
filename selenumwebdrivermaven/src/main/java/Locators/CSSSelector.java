package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelector {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //CSS with tag & id
        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
        //CSS with id
        driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("MacBook");


    }
}
