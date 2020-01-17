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

        //then I opened url appear choice location window
        objWHP.clickYesInChoseLocationWindow();

        //move to Who We Serve button
        objWHP.moveToButtonWhoWeServeMenuList();

        //check every menu item by task:  Titles are “Students”, “Instructors”, “Book Authors”, “Professionals”, “Researchers”, “Institutions”, “Librarians”, “Corporations”, “Societies”, “Journal Editors”, “Government” 
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

        //check that 11 items
        objWHP.checkThatInWhoWeServe11Items();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

}