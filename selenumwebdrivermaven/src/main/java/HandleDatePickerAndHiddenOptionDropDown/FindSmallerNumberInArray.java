package HandleDatePickerAndHiddenOptionDropDown;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSmallerNumberInArray {

    public static void main (String[] args){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        //From destination
        driver.findElement(By.xpath("//select[@name='fromPort']")).click();
        driver.findElement(By.xpath("//option[@value='Philadelphia']")).click();

        //From destination
        driver.findElement(By.xpath("//select[@name='toPort']")).click();
        driver.findElement(By.xpath("//option[@value='London']")).click();

        //Find flights
        driver.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();

        //Get prices
        int numberOfFlights = driver.findElements(By.xpath("/html/body/div[2]/table/tbody/tr")).size();
        List<String> prices = new ArrayList<>();
        for(int i=1;i<=numberOfFlights;i++){
            prices.add(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr["+i+"]/td[6]")).getText());
        }
        Collections.sort(prices);

        // Get lowest price and check flight with that price
        for(int i=1;i<=numberOfFlights;i++){
            if(prices.get(0).equals(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr["+i+"]/td[6]")).getText())){
                driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]/input[1]")).click();
                break;
            }
        }

        // Fill data about the customer and purchase flight
        driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Jelena");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Suboticka");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Belgrade");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Serbia");
        driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("11000");
        driver.findElement(By.xpath("//select[@id='cardType']")).click();
        driver.findElement(By.xpath("//*[@id=\"cardType\"]/option[1]")).click();
        driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Jelena Cuk");
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

        // Validation flight
        if(driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText().equals("Thank you for your purchase today!")){
            System.out.println("Your purchase is successful!");
        }else {
            System.out.println("Your purchase was not successful!");
        }

    }

}
