package TestNG.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

    //@Test
    void testHardAssertions()
    {
        System.out.println("Testing.....");
        System.out.println("Testing.....");
        System.out.println("Testing.....");
        System.out.println("Testing.....");

        Assert.assertEquals(1,2);

        System.out.println("Hard assertion completed.....");

        Assert.assertEquals(1,1);
    }

    @Test
    void testSoftAssertions()
    {
        System.out.println("Testing.....");
        System.out.println("Testing.....");
        System.out.println("Testing.....");
        System.out.println("Testing.....");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(1,2);

        System.out.println("Soft assertion completed.....");

        softAssert.assertAll();
    }

}
