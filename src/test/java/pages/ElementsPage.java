package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//pravim drugu stranicu-na koju sam otisla kad sam kliknula element Elements
public class ElementsPage extends BasePage {
    public ElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    //pravim listu elemenata jer za svaki element kao identifikator imam samo text pa cu napraviti
    //dole metodu za kliktanje konkretno a taj element
    public @FindBy(className = "header-text")
    List<WebElement> cardsList;

    //pokusavam da izvucem samo taj element kada ima atribut da je rasiren
    //ali mi ne ide
    public @FindBy (css = ".element-list collapse.show")
    WebElement elementsShown;

    //kada je skupljen
    public @FindBy (css = ".element-list.collapse")
    WebElement elementsCollapsed;

    //Text Box Button
    public @FindBy(id = "item-0")
    WebElement textBoxButton;

    //Check Box Button
    public @FindBy (id = "item-1")
    WebElement checkBoxButton;


//-----------------------------------------------

    //pravim metode koja ce proci kroz sve elemente i kliknuti na onaj koji sam navela u metodi
    public void clickOnElements() {
        for(int j = 0; j < cardsList.size(); j++) {
            if(cardsList.get(j).getText().equals("Elements")) {
                cardsList.get(j).click();
                break;
            }
        }
    }

    //pokusavam ovako da napravim metodu za collapse/expand ali nesto nije dobro
    //test prolazi, ali ne pokazuje dobro
    public boolean elementisShown() {
        for(int j = 0; j < cardsList.size(); j++) {
            if(cardsList.get(j).getText().equals("Elements")) {
                cardsList.get(j).getCssValue(".element-list.collapse.show");
                break;
            }
        }
        return false;
    }

    //klikcem na Text Box button
    public void clickOnTextBox() {
        textBoxButton.click();
    }

    //klikcem na Check Box button
    public void clickOnCheckBox(){
        checkBoxButton.click();
    }
}
