package ait.phonebook.test;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import com.ait.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.PasswordAuthentication;

import static com.ait.phonebook.utils.ContactData.*;
import static com.ait.phonebook.utils.UserData.PASSWORD;

public class AddNewContactTests extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginPresent()) {
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(EMAIL)
                .setPassword(PASSWORD));
        //click on Login button
        app.getUser().clickOnLoginButton();
    }


    @Test
    public void addNewContactPoitiveTest(Contact contact) {
        //click on Add Link
        app.getContact().clickOnAddlink();
        logger.info("Test run with data: "+ contact);
        //enter name
        app.getContact().fillContactForm(new Contact()
                .setName(NAME)
                .setLastname(LAST_NAME)
                .setPhone(PHONE)
                .setEmail(EMAIL)
                .setAddress(ADDRESS)
                        .setDescription(DESCRIPTION));
        //click on save button
        app.getContact().clickOnSaveButton();
        //assert
        Assert.assertTrue(app.getContact().isContactCreatedByText(NAME));
    }
    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }


    @Test(dataProvider = "addnewContact",dataProviderClass = DataProvider.class)
    public void addNewContactFromDataProviderPoitiveTest(String name,String lastname,
                                                         String phone, String email,
                                                         String address,
                                                         String desc) {

    app.getContact().clickOnAddlink();
    app.getContact().fillContactForm(new Contact()
            .setName(name)
            .setLastname(lastname)
            .setPhone(phone)
            .setEmail(email)
            .setAddress(address)
            .setDescription(desc));

    app.getContact().clickOnSaveButton();
}

    @Test(dataProvider = "addnewContactFromCSV",dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProvaderCSWPoitiveTest(Contact contact) {
        logger.info("Tests run with data: " + contact.toString());
        app.getContact().clickOnAddlink();

        app.getContact().fillContactForm(contact);

        app.getContact().clickOnSaveButton();
     //
        Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getName()));
      //  Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getPhone()));

    }

}

