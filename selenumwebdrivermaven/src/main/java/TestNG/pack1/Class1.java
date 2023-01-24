package TestNG.pack1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1 {

    @Test
    void abc()
    {
        System.out.println("This is abc from class1.");
    }
    @BeforeTest
    void m()
    {
        System.out.println("This is before test method...");
    }

    @BeforeSuite
    void beforeSuite()
    {
        System.out.println("This is before suite....");
    }
    @AfterSuite
    void afterSuite()
    {
        System.out.println("This is after suite....");
    }

}
