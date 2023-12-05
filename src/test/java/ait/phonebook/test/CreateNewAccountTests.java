package ait.phonebook.test;

import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static com.ait.phonebook.utils.UserData.EMAIL;
import static com.ait.phonebook.utils.UserData.PASSWORD;

public class CreateNewAccountTests extends TestBase {
    //precondition:
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test(enabled = false)
    public void createNewAccountPositivTest(){
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email

        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("eledi@gmail.com")
                .setPassword("Neuer1234$"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void registerExistedUserNegativeTest(){
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email      
        // enter password
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(EMAIL)
                .setPassword(PASSWORD));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //assert Alert is present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
/*
    @Test
    public void registerNewUserPositiveTest(){
      //  int i=new Random().nextInt(1000)+1000;
        int i =(int)System.currentTimeMillis()/1000;

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("eledi"+i+"@gmail.com")
                .setPassword("Neuer1234$"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //assert Alert is present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
 */


}
