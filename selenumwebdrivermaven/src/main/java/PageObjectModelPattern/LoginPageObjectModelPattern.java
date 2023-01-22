package PageObjectModelPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObjectModelPattern {

    public WebDriver driver;

    // locators
    By imageLogoLocator = By.xpath("//img[@alt='company-branding']");
    By textUsernameLocator = By.name("username");
    By textPasswordLocator = By.cssSelector("input[placeholder='Password']");
    By buttonSubmitLocator = By.xpath("//button[normalize-space()='Login']");

    // Constuctor
    LoginPageObjectModelPattern(WebDriver driver) {
        this.driver = driver;
    }

    // action methods
    public void setUsername(String username) {
        driver.findElement(textUsernameLocator).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(textPasswordLocator).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(buttonSubmitLocator).click();
    }

    public boolean checkLogoPresents() {
        boolean status = driver.findElement(imageLogoLocator).isDisplayed();
        return status;
    }

}
