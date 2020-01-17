package UI_Tests.Tests;

import UI_Tests.PageObjects.WileyHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForthTest{
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

        objWHP.clickSubjectsMenuList();
        objWHP.checkThatEducationIsDisplayed();
        objWHP.moveOnEducationMenuSubjectsItem();

        objWHP.checkInformationLibraryScienceSubjectsItem();
        objWHP.checkEducationPublicPolicySubjectsItem();
        objWHP.checkK12GeneralSubjectsItem();
        objWHP.checkHigherEducationGeneralSubjectsItem();
        objWHP.checkVocationalTechnologySubjectsItem();
        objWHP.checkConflictResolutionAndMediationSubjectsItem();
        objWHP.checkCurriculumToolsGeneralSubjectsItem();
        objWHP.checkSpecialEducationalNeedsSubjectsItem();
        objWHP.checkTheoryOfEducationSubjectsItem();
        objWHP.checkEducationSpecialTopicsSubjectsItem();
        objWHP.checkEducationalResearchAndStatisticsSubjectsItem();
        objWHP.checkLiteracyAndReadingSubjectsItem();
        objWHP.checkClassroomManagementSubjectsItem();

        objWHP.countSubjectItems();

    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

}