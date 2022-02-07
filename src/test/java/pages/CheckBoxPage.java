package pages;

import base.BasePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//pravim trecu stranicu
public class CheckBoxPage extends BasePage {
    public CheckBoxPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    // Check Box Button na stranici https://demoqa.com/checkbox
    public @FindBy (css = "#tree-node > ol > li > span > label > span.rct-checkbox > svg")
    List<WebElement> checkboxButtons;


    //---------------------------------------

    public void clickOnHomeCheckBox() {
        for(int j = 0; j < checkboxButtons.size(); j++) {
            if(checkboxButtons.get(j).getText().equals("Home")) {
                checkboxButtons.get(j).click();
                break;
            }
        }
    }
}
