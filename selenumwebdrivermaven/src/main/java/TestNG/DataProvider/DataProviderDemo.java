package TestNG.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    WebDriver driver;
    @BeforeClass
    void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "dataProvider1")
    void testLogin(String email, String password)
    {
       driver.get("https://demo.nopcommerce.com/login");
       driver.manage().window().maximize();
       driver.findElement(By.id("Email")).sendKeys(email);
       driver.findElement(By.id("Password")).sendKeys(password);
       driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

       String exp_title = "nopCommerce demo store";
       String act_title = driver.getTitle();

        Assert.assertEquals(exp_title,act_title);
    }
    @AfterClass
    void close()
    {
        driver.quit();
    }

    @DataProvider(name = "dataProvider1")
    Object [][] loginData()
    {
        String data[][] = {
                            {"abc@gmail.com","test123"},
                            {"pavanol@gmail.com","test@123"},
                            {"pavanoltraining@gmail.com","test3"},
                            {"pavanoltraining@gmail.com","test@123"},
                            {"pavanoltraining@gmail.com","test@123"}
                          };

        return data;
    }

    @DataProvider(name = "dataProvider2")
    Object [][] loginData2()
    {
        String data[][] = {
                {"abc@gmail.com","test123"},
                {"pavanol@gmail.com","test@123"},
                {"pavanoltraining@gmail.com","test3"},
                {"pavanoltraining@gmail.com","test@123"},
                {"pavanoltraining@gmail.com","test@123"}
        };

        return data;
    }

}
