package ait.phonebook.test;

import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.ait.phonebook.utils.UserData.EMAIL;
import static com.ait.phonebook.utils.UserData.PASSWORD;

public class LoginTests extends TestBase {
    //precondition:
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test
    public void LoginRegisteredUserPositiveTest(){
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(EMAIL)
                .setPassword(PASSWORD));

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginRegisteredUserNegativeTestWithoutEmail(){
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setPassword(PASSWORD));

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAlertPresent());
    }


}
