package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {

    @Test(priority = 1)
    void openApplication()
    {
        Assert.assertTrue(true);
    }

    @Test(priority = 2, dependsOnMethods = {"openApplication"})
    void login()
    {
//        Assert.assertTrue(true);
        Assert.assertTrue(true);
    }

    @Test(priority = 3, dependsOnMethods = {"login"})
    void search()
    {
        Assert.assertTrue(true);
    }

    @Test(priority = 4, dependsOnMethods = {"login", "search"})
    void advancedSearch()
    {
        Assert.assertTrue(true);
    }

    @Test(priority = 5, dependsOnMethods = {"login"})
    void logout()
    {
        Assert.assertTrue(true);
    }
}
