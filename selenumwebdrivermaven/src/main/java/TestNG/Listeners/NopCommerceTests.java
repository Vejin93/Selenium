package TestNG.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.*;

import java.time.Duration;

//@Listeners(ExtentReportsManager.class)
public class NopCommerceTests
{
    WebDriver driver;

    @BeforeClass
    void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void testLogo()
    {
        try {
            boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
            Assert.assertEquals(status, true);
        }
        catch (NoSuchElementException e)
        {
            Assert.assertTrue(false);
        }
    }

    // register user manualy on site user with email: xyz123@gmail.com and password: test123
    @Test(priority = 2)
    void testLogin()
    {
        try {
            driver.findElement(By.linkText("Log in")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("xyz12r3@gmail.com");
            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("test123");
            driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
            Thread.sleep(3000);
            //validation
            boolean status = driver.findElement(By.linkText("My account")).isDisplayed();
            Assert.assertEquals(status, false);
        }
        catch (Exception e)
        {
            Assert.fail();
        }
    }

    @Test(priority = 3, dependsOnMethods = {"testLogin"})
    void testLogout() throws InterruptedException
    {
        driver.findElement(By.linkText("Log out")).click();
        Thread.sleep(3000);
        boolean status = driver.findElement(By.linkText("Register")).isDisplayed();
        Assert.assertEquals(status,true);
    }

    @AfterClass
    void closeApplication()
    {
        driver.quit();
    }
}
