package ait.phonebook.test;

import com.ait.phonebook.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTest(Method method, Object[] p){
        logger.info("Start test"+method.getName()+ "with data: "+ Arrays.asList(p));
    }

    @BeforeSuite
    public void setUp() {
        app.init();
        //   System.out.println("@BeforeSuite");
    }

    @BeforeMethod
    public void beforeTest() {
        //  System.out.println("BeforeMethod");
    }

    //  @AfterMethod(enabled = true)
    @AfterSuite
    public void tearDown() {
        app.stop();
        //    System.out.println("AfterSuite");
    }

    @AfterMethod(enabled = false)
    public void afterTest() {
        //  System.out.println("AfterMethod");
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: " + result.getMethod().getMethodName());
        }
        logger.info("===========================================");
    }
}
