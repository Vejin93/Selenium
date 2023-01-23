package PageObjectModelPattern;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPageFactoryLoginPageObjectModelPattern {

    WebDriver driver;
    LoginPageFactoryPageObjectModelPattern loginPageClass;

    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1)
    void testLogo(){
        loginPageClass = new LoginPageFactoryPageObjectModelPattern(driver);
        Assert.assertEquals(loginPageClass.checkLogoPresents(),true);
    }

    @Test(priority = 2)
    void TestLoginPageObjectModelPattern(){
        loginPageClass = new LoginPageFactoryPageObjectModelPattern(driver);

        loginPageClass.setUsername("Admin");
        loginPageClass.setPassword("admin123");
        loginPageClass.clickSubmit();

        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @AfterClass
    void closeBrowser(){
        driver.quit();
    }
}
