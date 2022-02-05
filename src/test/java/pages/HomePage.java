package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//pravim stranicu HomePage koju extendujem iz BasePage
public class HomePage extends BasePage {

    //pravim metodu za anotacije pa necu morati da pravim kontruktor i getere
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //dodajem elemente sa stranice

    //element sa svim karticama
    public @FindBy(className = "card-up")
    List<WebElement> cardsList;

    //pravim element samo za skrolovanje
    public @FindBy(className = "card-up")
    WebElement cards;



    //------------------------------------


    //pravim metode koja ce proci kroz sve elemente i kliknuti na onaj koji sam navela u metodi
    public void clickOnElements() {
        for(int j = 0; j < cardsList.size(); j++) {
            if(cardsList.get(j).getText().equals("Elements")) {
                cardsList.get(j).click();
                break;
            }
        }
    }



}


