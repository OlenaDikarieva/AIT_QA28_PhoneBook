package com.ait.phonebook.fw;

import com.ait.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper{
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        //enter lastname
        type(By.cssSelector("input:nth-child(2)"), contact.getLastname());
        //enter phone
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        //enter email
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        //enter address
        type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
        //enter password
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());
    }

    public void clickOnAddlink() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean isContactCreatedByText(String text) {
        List<WebElement> contacts=  driver.findElements(By.cssSelector("h2"));
        for (WebElement element: contacts) {
            if (element.getText().contains(text))
                return true;
        }

        return false;
    }

    public void removeContact() {
        //click on Contact card
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //click on button remove
        click(By.xpath("//button[.='Remove']"));
    }
    public  int sizeOfContacts(String text){
        if (isElementPresent(By.cssSelector(text))){
            return  driver.findElements(By.cssSelector(text)).size();
        }
        return 0;
    }
}
