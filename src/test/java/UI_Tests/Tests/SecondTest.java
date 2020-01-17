package UI_Tests.Tests;

import UI_Tests.PageObjects.WileyHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

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

        objWHP.clickYesInChoseLocationWindow();

        objWHP.inputWordInSearchBox("Java");
        objWHP.checkAppearContextMenu();

        objWHP.getTopYAndHeightOfSearchBox();
        objWHP.getTopYOfContextMenu();

        objWHP.checkContextMenuUnderSearchBox();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}