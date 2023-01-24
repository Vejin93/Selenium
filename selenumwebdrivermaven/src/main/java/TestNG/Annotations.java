package TestNG;


import org.testng.annotations.*;

public class Annotations {

    @BeforeMethod
    void login()
    {
        System.out.println("Login...");
    }
    @Test(priority = 1)
    void search()
    {
        System.out.println("Search...");
    }
    @Test(priority = 2)
    void advancedSearch()
    {
        System.out.println("Advanced search...");
    }

    @AfterMethod
    void logout()
    {
        System.out.println("Logout...");
    }

}
