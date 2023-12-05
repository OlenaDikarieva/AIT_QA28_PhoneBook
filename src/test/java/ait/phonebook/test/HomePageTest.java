package ait.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends TestBase{
    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass");
    }

    //  @AfterMethod(enabled = true)
    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass");
    }

    @BeforeMethod
    public void
    ensurePrecondition() {
        System.out.println("@BeforeMethod");

        if(!app.getHomepage().isHomeComponentPresent()){
            app.getHomepage().clickOnHomeLink();
        }
    }


    @Test
    public void
    isHomeComponentPresentTest() {
       // System.out.println("Home component is" +isHomeComponentPresent());
        Assert.assertTrue(app.getHomepage().isHomeComponentPresent());

    }

}
