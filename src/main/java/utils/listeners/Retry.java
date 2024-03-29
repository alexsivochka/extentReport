package utils.listeners;

import com.aventstack.extentreports.Status;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import tests.BaseTest;

import static utils.extentreports.ExtentTestManager.getTest;

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTry = 1; //Run the failed test 2 times

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                     //Check if test not succeed
            if (count < maxTry) {                           //Check if maxTry count is reached
                count++;                                    //Increase the maxTry count by 1
//                iTestResult.setStatus(ITestResult.SKIP); //Mark test as failed and take base64Screenshot
//                extendReportsFailOperations();   //ExtentReports fail operations
                return true;                                //Tells TestNG to re-run the test
            }
        }
        return false;
    }

    public void extendReportsFailOperations() {
        String base64Screenshot = "data:image/png;base64," + Selenide.screenshot(OutputType.BASE64);
        getTest().log(Status.FAIL, "Test Failed",
                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }
}
