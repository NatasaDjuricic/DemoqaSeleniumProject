package pages;

import base.BasePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//pravim trecu stranicu
public class RadioButtonPage extends BasePage {
    public RadioButtonPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    //Yes Radio Button na https://demoqa.com/radio-button
    public @FindBy (css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(1) > div:nth-child(2) > label")
    List <WebElement> radioButtons;

   public @FindBy (css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(1) > p > span")
   WebElement yesMessage;

    //---------------------------------------

    public void clickOnYesRadioButton(){
            for(int j = 0; j < radioButtons.size(); j++) {
                if(radioButtons.get(j).getText().equals("Yes")) {
                    radioButtons.get(j).click();
                    break;
                }
            }
        }

    }


