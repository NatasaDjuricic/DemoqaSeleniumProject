package tests;

import base.BasePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RadioButtonPage;

public class TestElementsPage extends BasePage {
    @BeforeMethod
    public void setUpTestElements() {
        driver.manage().window().maximize();
        driver.navigate().to(elementsPageURL);
    }

    //ovaj ce se test prvi izvrsiti
    //stavljam vrednost 10 jer cu sledeci 20 pa ako dodajem izmedju testove da imam prostora
    @Test (priority = 10)
    public void verifyThatUserIsRedirectedToElementsPage(){
        String actualURL = driver.getCurrentUrl();
        String expectedURL = excelReader.getStringData("URL", 2, 2);
        Assert.assertEquals(actualURL, expectedURL);
    }

    //Evo zasto je dobro indexirati priorete dekadno
    //u medjuvremenu sam se setila da stavim jedan test izmedju prvog i drugog
    //cak i da sam napisala ispod testa sa prioritetom 20, ovaj sa 15 bi se izvrsio prvi
    @Test (priority = 15)
    public void verifyThatElementsMenuCollapseWhenClickingOnIt() throws InterruptedException {
        //samo da vidim da li radi skupljanje i sirenje elementa Elements
        elementsPage.clickOnElements();
        Thread.sleep(5000);
        elementsPage.clickOnElements();
        //test prolazi ali nije dobar jer pokazuje da je tacan i kad je element rasiren
        Assert.assertFalse(elementsPage.elementisShown());

    }


    @Test (priority = 20)
    public void verifyThatUserCanInputTextInFullNamePlaceHolder() {
        homePage.clickOnElements();//klikni na element Elements
        elementsPage.clickOnTextBox();//klikni na TextBox
        //dohvatam validUsername iz excela i stavljam ga u promenljivu tipa String
        String beforeInput = textBoxPage.fullName.getAttribute("value");
        //citam sta je napisano u placeholderu pre mog unosa
        String validUsername = excelReader.getStringData("Credentials", 1, 2);
        textBoxPage.inputFullName(validUsername);//unesi validno ime
        //citam sta je napisano u placeholderu nakon mog unosa
        String afterInput = textBoxPage.fullName.getAttribute("value");
        //uporedjujem da li vrednost ppaceholdera pre unosa NIJE ista sa vrednoscu nakon unosa
        Assert.assertNotEquals(beforeInput, afterInput);
        //proveravam da li je vrednost nakon unosa jednaka onoj koju sam mu poslala
        Assert.assertEquals(afterInput, validUsername);
    }

    @Test (priority = 30)
    public void verifyThatUserCanSuccessfullySubmitForm(){
        elementsPage.clickOnTextBox();//klikni na TextBox dugme
        //Iz excela vucem podatke za unos u formu
        String validUsername = excelReader.getStringData("Credentials", 1, 2);
        String validEmail = excelReader.getStringData("Credentials", 2, 2);
        String validCurrentAddress = excelReader.getStringData("Credentials", 3, 2);
        String validPermanentAddress = excelReader.getStringData("Credentials", 4, 2);
        textBoxPage.inputFullName(validUsername);//unesi validno ime
        textBoxPage.inputEmail(validEmail);//unesi validan email
        textBoxPage.inputCurrentAddress(validCurrentAddress);//unesi validnu trenutnu adresu
        scroll(textBoxPage.permanentAddress);//moram da skrolujem da bi mogao da nastavi unos
        textBoxPage.inputPermanentAddress(validPermanentAddress);//unesi validnu stalnu adresu
        textBoxPage.clickOnSubmitButton();//klikni na Submit Buton

        //expected rezult ==> prikazan je output unosa
        Assert.assertTrue(textBoxPage.output.isDisplayed());

    }

    @Test (priority  = 40)
    public void verifyThatUserCanClickOnHomeButton() {
        //ne klikce mi check box
        waitClickability(elementsPage.checkBoxButton);
        elementsPage.clickOnCheckBox();//klikni na Check Box Button


    }


    @Test (priority = 50)
    public void verifyThatUserCanChooseYesRadioButton(){
        driver.navigate().to(radioButtonPageURL);//idi na Radio Button Page
        radioButtonPage.clickOnYesRadioButton();//klikni na "Yes" Radio Button

        //proveravam da li je izasla poruka u kojoj se nalazi res Yes jer je to jedini deo poruke koji se menja
        //u skladu sa tim sta sam cekirala
        String yesRadioButtonText = excelReader.getStringData("Message Text", 2, 2);
        Assert.assertEquals(radioButtonPage.radioButtonMessage.getText(), yesRadioButtonText);


    }

    @Test (priority = 60)
    public void verifyThatWhenClickingOnImpressiveRadioButtonYesRadioButtonIsUnchecked(){
        driver.navigate().to(radioButtonPageURL);//idi na Radio Button Page
        radioButtonPage.clickOnYesRadioButton();//klikni na "Yes" Radio Button
        radioButtonPage.clickOnImpressiveRadioButton();//klikni na Impressive Radio Button


        //proveravam da li i dalje postoji poruka da je kliknuto na Yes Radio Button
        //Kopirala sam ispravne poruke u excel pa ih odatle izvalcim
        //Ovo radim u slucaju da vise elemenata na vise stranica ima istu poruku pa da menjam poruku u excelu, a ne u kodu
        String yesRadioButtonText = excelReader.getStringData("Message Text", 2, 2);
        Assert.assertNotEquals(radioButtonPage.radioButtonMessage.getText(), yesRadioButtonText);

    }

    @Test (priority = 70)

    public void verifyThatClickMeButtonIsActtivatedAfterClickingOnIt(){
        driver.navigate().to(buttonPageURL);// idi na Buttons Page URL
        buttonsPage.clickOnClickMeButton();//klikni na Click Me Button

        //proveravam da li je izasla poruka "You have done a dynamic click"
        String clickMeText = excelReader.getStringData("Message Text", 3, 2);
        Assert.assertEquals(buttonsPage.clickMeButtonMessage.getText(), clickMeText);

    }

    @Test (priority = 80)
    public void verifyThatUserMustDoubleClickOnClickMeButtonToActivateIt(){
        driver.navigate().to(buttonPageURL);//idi na ButtonsPage URL

        //videti kako da napravim assert da se klikne jednom, a da ne izlazi poruka da je uradjen doubleclick

        doubleClick(buttonsPage.doubleClickButton);//uradi double click na Double Click Button
        //proveri da li se prikazuje poruka da je uradjen double clik
        String doubleClickMeText = excelReader.getStringData("Message Text", 4, 2);
        Assert.assertEquals(buttonsPage.doubleClickButtonMessage.getText(), doubleClickMeText);
    }

    @Test (priority = 90)
    public void verifyThatUserMustPerformRightClickOnRightClickButtonToActivateIt(){
        driver.navigate().to(buttonPageURL);//idi na Button Page URL
        rightClick(buttonsPage.rightClickButton);//uradi desni click na Right Click Button

        //proveri da li se prikazuje poruka da je uradjen double click
        String rightClickText = excelReader.getStringData("Message Text", 5, 2);
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), rightClickText);
    }

    @Test (priority = 100)
    public void verifyThatWhenClickingOnHomeLinkNewTabWithHomePageURLOpens()  {
        driver.navigate().to(linksPageURL);// idi na Links Page URL
        String originalWindow = driver.getWindowHandle();//Cuvam ID originalnog tab-a
        //Check we don't have other windows open already
        assert driver.getWindowHandles().size() == 1;//proveravam da nemamo jos neki tab otvoren
        linksPage.clickOnHomeLink();//klikcem na link koji se otvara u novom tabu
        waitNewTabs(2);//cekam novi Tab
        //Prolazim kroz petlju dok ne pronadjemo novi window handle i ne prebacimo se na novi tab
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {//ako nadjemo novi window handle
                driver.switchTo().window(windowHandle);//prebacimo se na novi tab
                break;
            }
        }

        String actualURL = driver.getCurrentUrl();//citamo URL stranicw na kojoj se nalazimo
        String expectedURL = excelReader.getStringData("URL", 1, 2);//home Page URL

        Assert.assertEquals(actualURL, expectedURL);//uporedi da li je URL trenutne strane isti kao URL Home Page strane





    }
}
