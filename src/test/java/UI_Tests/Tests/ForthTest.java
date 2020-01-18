package UI_Tests.Tests;

import UI_Tests.PageObjects.WileyHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 4.	Go to “Subjects” top menu, select “Education” 
 * ·                     Check “Education” header is displayed 
 * ·                     13 items are displayed under “Subjects” on the left side of the screen and the texts are:
 * "Information & Library Science","Education & Public Policy",  "K-12 General",  "Higher Education General",   
 * "Vocational Technology",   "Conflict Resolution & Mediation (School settings)","Curriculum Tools- General",   
 * "Special Educational Needs",   "Theory of Education","Education Special Topics",  "Educational Research & Statistics", 
 * "Literacy & Reading",  "Classroom Management" 
 */
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

        //then I opened url appear choice location window
        objWHP.clickYesInChoseLocationWindow();

        //Go to “Subjects” top menu
        objWHP.clickSubjectsMenuList();

        // Check “Education” header is displayed 
        objWHP.checkThatEducationIsDisplayed();

        //select “Education” 
        objWHP.clickOnEducationMenuSubjectsItem();

        //check that title “Subjects” is Displayed on the left side
        objWHP.checkSubjectsTitlePosition();

        //check that all 13 “Subjects” items is Displayed under title
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

        //check that 13 items on Subjects menu
        objWHP.countSubjectItems();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}