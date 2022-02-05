package pages;

import base.BasePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//pravim trecu stranicu
public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    //Full Name placeholder na stranici TextBoxPage
    public @FindBy (id = "userName")
    WebElement fullName;

    //Email placeholder na stranic TextBoxPage
    public @FindBy (id ="userEmail")
    WebElement email;

    //Current Address placeholder na stranici TextBoxPage
    public @FindBy (id = "currentAddress")
    WebElement currentAddress;

    //Permanent  Address placeholder na stranici TextBoxPage
    public @FindBy (id = "permanentAddress")
    WebElement permanentAddress;

    //Submit Button na stranici TextBoxPage
    public @FindBy (id = "submit")
    WebElement submitButton;

    //Output na stranici TextBoxPage
    public @FindBy (id ="output")
    WebElement output;

    //---------------------------------------

    //saljem unos u Full Name Placeholder
    public void inputFullName(String name){
        fullName.clear();//bri[em unos ukoliko je postojjao
        fullName.sendKeys(name);//upisujem ime

    }

    //saljem unos u Email placeholder
    public void inputEmail(String mail){
        email.clear();
        email.sendKeys(mail);
    }

    public void inputCurrentAddress(String address){
        currentAddress.clear();
        currentAddress.sendKeys(address);
    }

    public void inputPermanentAddress(String address){
        permanentAddress.clear();
        permanentAddress.sendKeys(address);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }




}
