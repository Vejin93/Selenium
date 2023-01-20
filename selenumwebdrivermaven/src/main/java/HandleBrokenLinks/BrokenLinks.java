package HandleBrokenLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: " + links.size()); //48

        int brokenLinks = 0;

        for(WebElement linkElement : links){
            String hrefAttributeValue = linkElement.getAttribute("href");
            //System.out.println(hrefAttributeValue);

            //pre-requisite for checking broken link
            if(hrefAttributeValue==null || hrefAttributeValue.isEmpty()) {
                System.out.println("href attribute value is empty.");
                continue;
            }

            //cheking link is broken or not
            URL linkURL = new URL(hrefAttributeValue); // convert String -> URL Format

            HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();// send request to server - open, connect
            connection.connect();

            if( connection.getResponseCode()>=400){
                System.out.println(linkElement.getText() + "       " +"Broken link...");
                brokenLinks++;
            }else{
                System.out.println(linkElement.getText() + "       " +"Not Broken link...");
            }
        }

        System.out.println("Total number of broken links: " + brokenLinks);

    }
}
