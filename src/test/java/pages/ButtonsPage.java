package pages;

import base.BasePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver){
        PageFactory.initElements(driver, this);


    }


    public @FindBy(css = "#doubleClickBtn")
    WebElement doubleClickButton;

    public @FindBy(css = "#rightClickBtn")
    WebElement rightClickButton;

    public @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/button")
    WebElement clickMeButton;

    public @FindBy(css = "#dynamicClickMessage")
    WebElement clickMeButtonMessage;

    public @FindBy(css = "#doubleClickMessage")
    WebElement doubleClickButtonMessage;

    public @FindBy(css = "#rightClickMessage")
    WebElement rightClickMessage;


    //---------------------------------------


    public void clickOnClickMeButton(){
        clickMeButton.click();

    }

    public void clickOnDoubleClickButton(){
        doubleClickButton.click();


    }

    }



