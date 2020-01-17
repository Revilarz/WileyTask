package UI_Tests.Tests;

import UI_Tests.PageObjects.WileyHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    private ChromeDriver driver;

    @Before
    public void openLink() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.wiley.com/en-us");
    }

    @Test
    public void firstTestWhoWeServeItems() throws InterruptedException {
        WileyHomePage objWHP = new WileyHomePage(driver);

        objWHP.clickYesInChoseLocationWindow();

        objWHP.clickWhoWeServeMenuList();

        objWHP.checkWhoWeServeMenuListItemStudents();
        objWHP.checkWhoWeServeMenuListInstructors();
        objWHP.checkWhoWeServeMenuListBookAuthors();
        objWHP.checkWhoWeServeMenuListProfessionals();
        objWHP.checkWhoWeServeMenuListResearchers();
        objWHP.checkWhoWeServeMenuListInstitutions();
        objWHP.checkWhoWeServeMenuListLibrarians();
        objWHP.checkWhoWeServeMenuListCorporations();
        objWHP.checkWhoWeServeMenuListSocieties();
        objWHP.checkWhoWeServeMenuListJournalEditors();
        objWHP.checkWhoWeServeMenuListGovernment();

        objWHP.checkThatInWhoWeServe11Items();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

}