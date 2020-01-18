package UI_Tests.Tests;

import UI_Tests.PageObjects.WileyHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 2.	Check search functionality:
 * Enter “Java” in the search input and do not press the search button (with magnifying glass icon)
 * ·                     Area with related content is displayed right under the search header 
 */
public class SecondTest {
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

        //Enter “Java” in the search input and do not press the search button
        objWHP.inputWordInSearchBox("Java");

        //check appear Area with related content
        objWHP.checkAppearContextMenu();

        //check no crossing and no distance by Y
        objWHP.checkByHeightAndY();

        //check that whey have the same X pos
        objWHP.checkByXPos();

        //check that whey have the same X width
        objWHP.checkByWidth();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}