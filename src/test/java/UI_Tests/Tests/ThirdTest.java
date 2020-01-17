package UI_Tests.Tests;

import UI_Tests.PageObjects.SearchResultPage;
import UI_Tests.PageObjects.WileyHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThirdTest {
    private ChromeDriver driver;

    @Before
    public void openLink() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.wiley.com/en-us");
    }

    @Test
    public void secondTestSearchBox() throws InterruptedException {
        WileyHomePage objWHP = new WileyHomePage(driver);

        //then I opened url appear choice location window
        objWHP.clickYesInChoseLocationWindow();

        //Enter “Java” in the search input
        objWHP.inputWordInSearchBox("Java");
        //press the search button 
        objWHP.clickButtonSearch();

        SearchResultPage obSRP = new SearchResultPage(driver);
        //Only titles containing “Java” are displayed 
        obSRP.checkThatAllTitlesContainsJava();
        //  There are 10 titles on the page
        obSRP.checkThatOnly10TitlesOnPage();

        //Each title has at least one “Add to Cart” button for E-Book
        obSRP.checkIfEBookThanHasAddToCardButton();
        //Each title has at least one “Add to Cart” button for Print
        obSRP.checkIfPrintThanHasAddToCardButton();
        //Each title has at least one “VIEW ON WILEY ONLINE LIBRARY” for O-BOOK
        obSRP.checkIfOBookThanHasViewOnWileyOnlineLibraryButton();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}
