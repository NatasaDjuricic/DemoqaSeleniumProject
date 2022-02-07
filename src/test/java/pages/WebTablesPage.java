package pages;

import base.BasePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//pravim trecu stranicu
public class WebTablesPage extends BasePage {
    public WebTablesPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }


    //---------------------------------------



}
