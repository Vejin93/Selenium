package Locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ClassNameTagName {
    public static void main(String[] args) throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Open app
        driver.get("https://www.djaksport.com/");
        driver.manage().window().maximize();

        //Find number of 'seg-product-image' on home page
        List<WebElement> elements = driver.findElements(By.className("seg-product-image"));
        System.out.println("Number of 'seg-product-image' elements: " +elements.size());

        //Find total images on home page
        List<WebElement> totalNumberOfImages = driver.findElements(By.tagName("img"));
        System.out.println("Total number of images on page: " + totalNumberOfImages.size());

        //Find total number of links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: "+ links.size());

        driver.close();
    }
}
