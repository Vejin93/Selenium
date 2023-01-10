package HandleStaticAndDynamicWebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StaticTableDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().window().maximize();

        // 1) Find total number of rows

        // Fist approach

        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); // 7 preferred
        System.out.println("Number of rows: " + rows);

        // Second approach
            /*
            int rows = driver.findElements(By.tagName("tr")).size(); // 8 preferred only if we have only table
            System.out.println("Number of rows: " + rows);
            */

        // 2) Find total number of columns
        int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size(); // 7 preferred
        System.out.println("Number of columns: " + columns);


        // 3) Read specific row & column data
        String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]//td[1]")).getText();
        System.out.println(value);

        // 4) Reate data from all the rows & columns
        for (int r = 2; r <= rows; r++) { // r=2, because fist row is heading
            for (int c = 1; c <= columns; c++) {
                String retVal = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
                System.out.print(retVal+" ");
            }
            System.out.println();
        }

        // 5) Print book names whose authr is Amit
        for (int r = 2; r <= rows; r++) { // r=2, because fist row is heading
            String retVal = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
            if(retVal.equals("Amit")){
                String retVal2 = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
                System.out.println(retVal2);
            }
        }

        // 6) Find sum of prices for all the books
        int sum = 0;
        for (int r = 2; r <= rows; r++) { // r=2, because fist row is heading
            String retVal = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]")).getText();
            sum = sum + Integer.valueOf(retVal);
        }
        System.out.println("Total price of books:" + sum);
    }
}
