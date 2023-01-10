package HandleStaticAndDynamicWebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PaginationTable {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();

        //Login
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.clear();
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.clear();
        password.sendKeys("demo");

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        if (driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        }

        // Customers->customers
        driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();

        //Number of pages
        String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        int totalPages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
        System.out.println("Total number of pages: " + totalPages);

        for (int p = 1; p < totalPages; p++) {
            if (totalPages > 1) {
                WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()=" + p + "]"));
                System.out.println("Active page: " + activePage.getText());
                //activePage.click();
                Thread.sleep(2000);
            }

            int noOfrows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            System.out.println("Total no of rows in active Page: " + noOfrows);

            for (int r = 1; r <= noOfrows; r++) {
                String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]")).getText();
                String customerEmail = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[3]")).getText();
                String customerStatus = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[5]")).getText();

                System.out.println(customerName + "   " + customerEmail + "   " + customerStatus);
            }
        }
        driver.quit();
    }
}
