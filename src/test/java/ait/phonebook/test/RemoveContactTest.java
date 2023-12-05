package ait.phonebook.test;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.ait.phonebook.utils.ContactData.NAME;

public class RemoveContactTest extends TestBase{
    //precondition:
    @BeforeMethod
    public void ensurePrecondition(){
        //precondition: User should be logged out
        if (!app.getUser().isLoginPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("eledi@gmail.com")
                .setPassword("Neuer1234$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //click on Add Link
        app.getContact().clickOnAddlink();
        //enter name
        app.getContact().fillContactForm(new Contact()
                .setName(NAME)
                .setLastname("Adam")
                .setPhone("123456789012")
                .setEmail("adam@gm.com")
                .setAddress("Koblenz")
                .setDescription("goalkeeper"));
        //click on save button
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void removeContactPositiveTest(){
        //get size of contacts before remove
        int sizeBefore= app.getContact().sizeOfContacts(".contact-item_card__2SOIM");
        app.getContact().removeContact();
        app.getContact().pause(1000);
        //get size of contacts after remove
        int sizeAfter= app.getContact().sizeOfContacts(".contact-item_card__2SOIM");
        //assert: contact is removed
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }


}
