package PageObjectModelPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPageFactoryPageObjectModelPattern {

    public WebDriver driver;

    // Constuctor
    LoginPageFactoryPageObjectModelPattern(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // WebElements locators + identification
    @FindBy(xpath = "//img[@alt='company-branding']") WebElement imageLogo;
    @FindBy(name = "username") WebElement textUsername;
    @FindBy(css = "input[placeholder='Password']") WebElement textPassword;
    @FindBy(xpath = "//button[normalize-space()='Login']") WebElement buttonSubmit;

//    @FindBy(tagName = "a") List<WebElement> links; // just for presentation

    // action methods
    public void setUsername(String username) {
        textUsername.sendKeys(username);
    }

    public void setPassword(String password) {
        textPassword.sendKeys(password);
    }

    public void clickSubmit() {
        buttonSubmit.click();
    }

    public boolean checkLogoPresents() {
        boolean status = imageLogo.isDisplayed();
        return status;
    }

}
