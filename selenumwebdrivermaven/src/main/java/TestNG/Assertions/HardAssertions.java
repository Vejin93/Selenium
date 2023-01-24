package TestNG.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

    @Test
    void test()
    {
        int x = 10;
        int y = 15;
//
//        if(x==y)
//        {
//            System.out.println("Test passed.");
//        }else
//        {
//            System.out.println("Test failed.");
//        }

//        Assert.assertEquals(x,y); //Exmpl 1

        Assert.assertEquals(x>y,true,"x is not greater than y");
    }

}
