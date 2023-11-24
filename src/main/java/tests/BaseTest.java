package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.extentreports.ExtentManager;

import java.lang.reflect.Method;

import static utils.extentreports.ExtentTestManager.startTest;

public class BaseTest {

    ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void SetUpBrowser() {
        Configuration.browser = ChromeDriverProvider.class.getName();
    }

    @AfterSuite(alwaysRun = true)
    void closeBrowser() {
        ExtentManager.createReportEnv();
        ExtentManager.extentReports.flush();
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }

    @BeforeMethod
    public void setup(Method method) {
        String reportTestName = method.getAnnotation(Test.class).testName(); //This will be: 'Verify if the save button is enabled'
        String reportTestDescription = method.getAnnotation(Test.class).description(); //This will be: 'Verify if the save button is enabled'
        test = startTest(reportTestName, reportTestDescription);
    }


}
