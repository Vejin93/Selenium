package HandleHeadlessTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

    public static void main(String[] args) throws InterruptedException {

        // Headless mode - Approach 1
        /*
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        // 1) Open browser
        WebDriver driver = new ChromeDriver(options);
        */

        // Headless mode - Approach 2 WebDriverManager 5.1+
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        //WebDriver driver = WebDriverManager.chromedriver().create(); //regular with open browser
        WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();// with headless



        // 2) open URL - https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Open full window
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // 3) Provide username
        driver.findElement(By.name("username")).sendKeys("Admin");

        // 4) Provide password
        driver.findElement(By.name("password")).sendKeys("admin123");

        // 5) Click on submit button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);

        // 6) Verify the title of dashboard
        String act_title = driver.getTitle();
        String exp_title = "OrangeHRM";
        if (act_title.equals(exp_title)) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Failed.");
        }

        //7) close browser
        driver.close();
    }
}


