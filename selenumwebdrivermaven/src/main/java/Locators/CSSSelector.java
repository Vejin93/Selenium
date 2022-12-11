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
        //driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Id");
        //CSS with id
        //driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Id");

        //CSS Tag & class
        //driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Class");
        //CSS class
        //driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Class");

        //CSS Tag & attribute
        //driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Attribute");
        //CSS attribute
        //driver.findElement(By.cssSelector("[type='text']")).sendKeys("Attribute");

        //CSS Tag, class & attribute
        driver.findElement(By.cssSelector("input.search-box-text[type='text']")).sendKeys("Class&Attribute");
    }
}
