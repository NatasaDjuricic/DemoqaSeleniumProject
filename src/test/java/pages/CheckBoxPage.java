package pages;

import base.BasePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//pravim trecu stranicu
public class CheckBoxPage extends BasePage {
    public CheckBoxPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    // Check Box Button na stranici https://demoqa.com/checkbox
    public @FindBy (className = "rct-checkbox")
    WebElement checkboxButton;


    //---------------------------------------

    public void clickOnCheckBoxButton(){
        checkboxButton.click();
    }
}
