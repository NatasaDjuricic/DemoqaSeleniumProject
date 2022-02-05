package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//pravim test stranicu

public class TestHomePage extends BasePage {

    //pravim @BeforeMethod kojim inicijalizujem stranicu

    @BeforeMethod
    public void setUpHomePage(){
      driver.manage().window().maximize();//maximiziram prozor
        driver.navigate().to(homeURL);//idem na stranicu koju sam u BasePage nazvala homeURL
    }


    @Test (priority = 10)

    public void verifyThatUserIsOnHomePage(){
        String actualURL = driver.getCurrentUrl();
        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(actualURL, expectedURL);


    }

}
