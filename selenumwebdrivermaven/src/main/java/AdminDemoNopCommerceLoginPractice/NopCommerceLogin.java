package AdminDemoNopCommerceLoginPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NopCommerceLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Open URL
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

        // Provide username
        WebElement txtemailbox = driver.findElement(By.id("Email"));
        txtemailbox.clear();
        Thread.sleep(2000);
        txtemailbox.sendKeys("admin@yourstore.com");

        // Provide password
        WebElement txtpasswordbox = driver.findElement(By.id("Password"));
        txtpasswordbox.clear();
        //txtpasswordbox.sendKeys("admin");
        //Wrong password
        txtpasswordbox.sendKeys("adminadmin");

        // Click on LOG IN button
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();

        // Verify the title of dashboard page
        String act_title = driver.getTitle();
        String exp_title = "Dashboard / nopCommerce administration";
        if(act_title.equals(exp_title)){
            System.out.println("Test passed!(verify by Title of Dashboard)");
        }else{
            System.out.println("Test failed!(verify by Title of Dashboard)");
        }

        // Verify dashboard label
        String act_label = null;
        try{
            act_label = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText();
        }catch (NoSuchElementException e){
            act_label="";
        }
        String exp_label = "Dashboard";
        if(act_label.equals(exp_label)){
            System.out.println("Test success!(verify by Dashboard label)");
        }else{
            System.out.println("Test failed!(verify by Dashboard label)");
        }

        driver.close();
    }
}
