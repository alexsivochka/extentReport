package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreatingLogs {


    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void config()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report-log.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Test
    public void logsGeneration()
    {
        test = extent.createTest("logsGeneration");
        test.log(Status.INFO,"createTest() method will return the ExtentTest object");
        test.log(Status.INFO, "I am in actual Test");
        test.log(Status.INFO, "We can write the actual test logic in this Test");

        // Using Labels
        test.log(Status.INFO, MarkupHelper.createLabel("*************** Using Labels ***************", ExtentColor.RED));
        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 1", ExtentColor.BLUE));
        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 2", ExtentColor.BLUE));
        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 3", ExtentColor.BLUE));
        test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 4", ExtentColor.BLUE));
    }

    @AfterTest
    public void tearDown()
    {
        extent.flush();
    }

}
