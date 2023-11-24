package utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Arrays;

import static com.codeborne.selenide.Configuration.browserVersion;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");

//        extentReports.setSystemInfo( "OS NAME" , System.getProperty("os.name"));
//        extentReports.setSystemInfo("ENGINEER", System.getProperty("user.name"));
//        extentReports.setSystemInfo("ENVIRONMENT", "QA");
//        extentReports.setSystemInfo("JAVA VERSION", System.getProperty("java.version"));
//        extentReports.setSystemInfo("BROWSER NAME", System.getProperty("browser"));
//        extentReports.setSystemInfo("BROWSER VERSION",System.getProperty("driver.version"));

        reporter.config().setReportName("Sample Extent Report");
        reporter.config().setEncoding("ANSI");
//        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.DARK);
//        reporter.filter().statusFilter().as(new Status[]{Status.FAIL, Status.PASS}).apply();
        extentReports.attachReporter(reporter);
        return extentReports;
    }

    public static ExtentReports createReportEnv() {
        extentReports.setSystemInfo("OS NAME", System.getProperty("os.name"));
        extentReports.setSystemInfo("ENGINEER", System.getProperty("user.name"));
        extentReports.setSystemInfo("ENVIRONMENT", "QA");
        extentReports.setSystemInfo("JAVA VERSION", System.getProperty("java.version"));
        extentReports.setSystemInfo("BROWSER NAME", System.getProperty("browser"));
        extentReports.setSystemInfo("BROWSER VERSION", System.getProperty("driver.version"));
        return extentReports;
    }
}
