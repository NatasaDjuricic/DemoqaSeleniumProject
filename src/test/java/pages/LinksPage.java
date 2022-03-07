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

        public @FindBy (id = "created")
        WebElement NoContentLink;


        public @FindBy (id = "linkResponse")
        WebElement linkMessage;

//--------------------------------------

    public void clickOnHomeLink(){
        homeLink.click();
    }

    public void linkMessageText() {
        linkMessage.getText();
    }

}
