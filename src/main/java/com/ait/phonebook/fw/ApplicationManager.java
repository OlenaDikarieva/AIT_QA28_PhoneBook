package com.ait.phonebook.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager{

    String browser;
    WebDriver driver;
    UserHelper user;
    ContactHelper contact;
    HomePagehelper homepage;

    public ApplicationManager(String browser) {
        this.browser =browser;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
//            //work browser in hide mode
//            ChromeOptions options=new ChromeOptions();
//            options.addArguments("headless");
//            driver = new ChromeDriver(options);
//            options.addArguments("windows-size=1800x900");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            driver =new FirefoxDriver();
        }
        driver.get("https://telranedu.web.app");
        //in work browser in hide mode 2 strock comment
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user=new UserHelper(driver);
        contact=new ContactHelper(driver);
        homepage=new HomePagehelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomePagehelper getHomepage() {
        return homepage;
    }

    public void stop() {
        driver.quit();
    }


}
