package FirstWebDriverScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {

    public static void main(String[] args) throws InterruptedException {
        /*Test case
            1) Launch browser
            2) open url
                https://opensource-demo.orangehrmlive.com/
            3) Provide username  - Admin
            4) Provide password  - admin123
            5) Click on Login button
            6) Verify the title of dashboard page
                Exp title : OrangeHRM
            7) close browser
        */

        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Sladja\\Desktop\\chromedriver.exe");
        // Automatic configuration with WebDriverManager from pom.xml(dependency)
        //WebDriverManager.chromedriver().setup();

        //1) Launch browser
        //ChromeDriver driver  = new ChromeDriver();
        WebDriver driver  = new ChromeDriver();

        //2)Open URL on the browser
        driver.get("https://opensource-demo.orangehrmlive.com/");
            //Open full window
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //3) Provide username
            //WebElement txtUsername = driver.findElement(By.name("username"));
            //txtUsername.sendKeys("Admin");

            //Another way in one line(shorter)
        driver.findElement(By.name("username")).sendKeys("Admin");

        //4) Provide password
        //driver.findElement(By.name("password")).sendKeys("admin123");
        // Wrong password
        driver.findElement(By.name("password")).sendKeys("wrongpasssword");

        //5) Click on submit button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

        //6) Verify the title of dashboard
        String act_title = driver.getTitle();
        String exp_title = "OrangeHRM";
        //String exp_title = "OrangeHRM123";
        if(act_title.equals(exp_title)){
            System.out.println("Test passed!");
        }else{
            System.out.println("Failed.");
        }

        //7) close browser
        driver.close();
    }
}
