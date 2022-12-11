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
        //driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
        //CSS with id
        //driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("MacBook");

        //CSS Tag & class
        //driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Test");
        //CSS class
        //driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Test");

        //CSS Tag & attribute
        //driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Attribute");
        //CSS attribute
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Attribute");
    }
}