package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage {
    public LinksPage(WebDriver driver){
        PageFactory.initElements(driver, this);

        }

        public @FindBy (id = "simpleLink")
        WebElement homeLink;



//--------------------------------------

    public void clickOnHomeLink(){
        homeLink.click();
    }

}
