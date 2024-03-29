package TestNG.Grouping;

/*
loginByEmail - sanity & regression
loginByFacebook - sanity
loginByTwitter - sanity

signupByEmail - sanity & regression
signupByFacebook - regression
signupByTwitter - regression

paymentInRupees - sanity & regression
paymentInDollar - sanity
paymentReturnByBank - regression
 */

import org.testng.annotations.Test;

public class Grouping
{
    @Test(priority = 1, groups = {"sanity","regression"})
    void loginByEmail()
    {
        System.out.println("This is login by email.");
    }

    @Test(priority = 2, groups = {"sanity"})
    void loginByFacebook()
    {
        System.out.println("This is login by Facebook.");
    }

    @Test(priority = 3, groups = {"sanity"})
    void loginByTwitter()
    {
        System.out.println("This is login by Twitter.");
    }

    @Test(priority = 4, groups = {"sanity","regression"})
    void signupByEmail()
    {
        System.out.println("This is sign up by Email.");
    }

    @Test(priority = 5, groups = {"regression"})
    void signupByFacebook()
    {
        System.out.println("This is sign up by Facebook.");
    }

    @Test(priority = 6, groups = {"regression"})
    void signupByTwitter()
    {
        System.out.println("This is sign up by Twitter.");
    }

    @Test(priority = 7, groups = {"sanity","regression"})
    void paymentInRupees()
    {
        System.out.println("This is payment by Rupees method.");
    }

    @Test(priority = 8, groups = {"sanity"})
    void paymentInDollar()
    {
        System.out.println("This is payment by dollar method.");
    }

    @Test(priority = 9, groups = {"regression"})
    void paymentReturnByBank()
    {
        System.out.println("Payment return by bank.");
    }
}