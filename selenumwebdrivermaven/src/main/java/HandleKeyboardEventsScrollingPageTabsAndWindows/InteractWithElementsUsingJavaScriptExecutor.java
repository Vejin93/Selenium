package HandleKeyboardEventsScrollingPageTabsAndWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractWithElementsUsingJavaScriptExecutor {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        driver.switchTo().frame(0);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // First name
        WebElement inputBox = driver.findElement(By.id("RESULT_TextField-1"));
        js.executeScript("arguments[0].setAttribute('value','john')",inputBox);

        // Radiobutton
        WebElement maleRadioButton = driver.findElement(By.id("RESULT_RadioButton-7_0"));
        //maleRadioButton.click();// ClickInterceptedException
        js.executeScript("arguments[0].click();",maleRadioButton);

        // Checkbox
        WebElement checkboxWednesday= driver.findElement(By.id("RESULT_CheckBox-8_3"));
        js.executeScript("arguments[0].click();",checkboxWednesday);

        // button
        WebElement button = driver.findElement(By.id("FSsubmit"));
        js.executeScript("arguments[0].click();",button);

    }
}
