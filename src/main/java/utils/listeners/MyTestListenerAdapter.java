package utils.listeners;

import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestListenerAdapter extends TestListenerAdapter {

    private ThreadLocal<String> testName = new ThreadLocal<>();

    @Override
    public void onFinish(ITestContext context) {
//        Iterator<ITestResult> skippedTestCases = context.getSkippedTests().getAllResults().iterator();
//        while (skippedTestCases.hasNext()) {
//            ITestResult skippedTestCase = skippedTestCases.next();
//            ITestNGMethod method = skippedTestCase.getMethod();
//            if (context.getSkippedTests().getResults(method).size() > 0) {
//                System.out.println("Removing:" + skippedTestCase.getTestClass().toString());
//                skippedTestCases.remove();
//            }
//        }
    }
}