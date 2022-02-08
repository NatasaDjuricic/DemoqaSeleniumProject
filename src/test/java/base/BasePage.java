/*napravila sam tri paketa:
                            base
                            page
                            tests
*/


package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;
import tests.TestHomePage;

import java.io.IOException;
import java.time.Duration;

//U base paketu pravim BasePage
public class BasePage {
    public WebDriver driver; // deklarisem driver
    public WebDriverWait wdwait; //deklarisem waiter
    public HomePage homePage;//"uknjizavam" stranicu
    public ElementsPage elementsPage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public ExcelReader excelReader;//deklarisem ExcelReader
    public String homeURL;//deklarisem URL koji cu citati iz excela
    public String elementsPageURL;//deklarisem URL za ElementsPage
    public String textBoxPageURL;//deklarisem URL za TextBoxPage
    public String checkBoxPageURL;//deklarisem URL za CheckBoxPge
    public String radioButtonPageURL;
    public String webTablesPageURL;
    public String buttonPageURL;
    public String linksPageURL;




    //U ovoj klasi pravim @BeforClass koji ce se pokrenuti pre TestPage-a
    //inicijalizujem drivere, waiter, excelReader, stranice i URL-ove

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        excelReader = new ExcelReader("C:\\Users\\natad\\IdeaProjects\\DemoqaSeleniumProject\\TextBook.xlsx");
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage(driver);
        checkBoxPage = new CheckBoxPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
        webTablesPage = new WebTablesPage(driver);
        buttonsPage = new ButtonsPage(driver);
        linksPage = new LinksPage(driver);
        homeURL = excelReader.getStringData("URL", 1, 2);//citam adresu iz Excela
        elementsPageURL = excelReader.getStringData("URL", 2, 2);
        textBoxPageURL = excelReader.getStringData("URL", 3, 2);
        checkBoxPageURL = excelReader.getStringData("URL", 4, 2);
        radioButtonPageURL = excelReader.getStringData("URL", 5, 2);
        webTablesPageURL = excelReader.getStringData("URL", 6, 2);
        buttonPageURL = excelReader.getStringData("URL", 7, 2);
        linksPageURL = excelReader.getStringData("URL", 8, 2);




    }

    //pravim waitere i scroll koji ce mi mozda trebati
    //ako ih ne budem koristila zakomentarisacu ih, inace mi ne treba da budu ovde ako ih ne koristim
    //sve sto se zuti znaci da postoji bolji nacin da se napise, sve sto se sivi znaci da nigde nije pozvano i da je visak

    //waiter za vidljivost elementa
    public void waitVisibility(WebElement element){
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    //waiter za klikabilnost elementa
    public void waitClickability(WebElement element){
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //mogu da dodam waiter koji mi treba

    //metoda da skroluje do elementa u slucaju da se element inicijalno ne vidi
    public void scroll(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    //za kliktanje na element koji nije vidljiv
    public void click (WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    //za doubleClick
    public void doubleClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    //za right click
    public void rightClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }




    //pravim @AfterClass koji ce posle pustenog testa da oblrise kolacice, ugasi tab i browser
    //dok testiram ovo drim zakomentarisano, kad saljem odkomentarisem

    @AfterClass
    public void tearDown(){
        //driver.manage().deleteAllCookies();obrisala sam kolacice
        //driver.close();ugasila sam tab na kom se trenutno nalazim
        //driver.quit();ugasila sam ceo browser
    }


}
