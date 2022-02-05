package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

}
