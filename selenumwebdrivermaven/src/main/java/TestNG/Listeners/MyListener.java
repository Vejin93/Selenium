package TestNG.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener
    //public class MyListener extends TestListenerAdapter
{
    public void onTestStart(ITestResult result)
    {
        System.out.println("Test started....");
    }

    public void onTestSuccess(ITestResult result)
    {
        System.out.println("On test success....");
    }

    public void onTestFailure(ITestResult result)
    {
        System.out.println("On test failure....");
    }

    public void onTestSkipped(ITestResult result)
    {
        System.out.println("On test skipped....");
    }

    public void onFinish(ITestContext context)
    {
        System.out.println("On test finish....");
    }

}
