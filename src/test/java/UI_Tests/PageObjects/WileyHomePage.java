package UI_Tests.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WileyHomePage {

    private ChromeDriver driver;
    Actions action;

    private By buttonYes = By.xpath("//*[@class='changeLocationConfirmBtn button large button-teal']");
    private By buttonWhoWeServe = By.xpath("//*[contains(text(),'WHO WE SERVE')]");
    private By menuItemStudents = By.xpath("//*[@href=\"/en-us/students\"]");
    private By menuItemInstructors = By.xpath("//*[@href=\"/en-us/instructors\"]");
    private By menuItemBookAuthors = By.xpath("//*[@href=\"/en-us/book-authors\"]");
    private By menuItemProfessionals = By.xpath("//*[@href=\"/en-us/professionals\"]");
    private By menuItemResearchers = By.xpath("//*[@href=\"/en-us/researchers\"]");
    private By menuItemInstitutions = By.xpath("//*[@href=\"/en-us/institutions\"]");
    private By menuItemLibrarians = By.xpath("//*[@href=\"/en-us/librarians\"]");
    private By menuItemCorporations = By.xpath("//*[@href=\"/en-us/corporations\"]");
    private By menuItemSocieties = By.xpath("//*[@href=\"/en-us/societies\"]");
    private By menuItemJournalEditors = By.xpath("//*[@href=\"/en-us/journal-editors\"]");
    private By menuItemGovernment = By.xpath("//*[@href=\"/en-us/government\"]");

    private By menuWhoWeServeItems = By.xpath(".//*[@id=\"Level1NavNode1\"]//*[@class=\"dropdown-item \"]");

    private By searchBox = By.id("js-site-search-input");
    private By searchButton = By.className("input-group-btn");
    private By contextMenu = By.id("ui-id-2");

    private By buttonSubjects = By.xpath(".//*[@href=\"/en-us/subjects\"]");

    private By educationMenuSubjectsItem = By.xpath(".//*[@href=\"/en-us/Education-c-ED00\"]");

    private By titleSubjects = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Subjects')]");
    private int titleSubjectSize;
    private By menuItemInformationLibraryScience = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Information & Library Science')]");
    private By menuItemEducationPublicPolicy = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Education & Public Policy')]");
    private By menuItemK12General = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'K-12 General')]");
    private By menuItemHigherEducationGeneral = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Higher Education General')]");
    private By menuItemVocationalTechnology = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Vocational Technology')]");
    private By menuItemConflictResolutionAndMediation = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Conflict Resolution & Mediation (School settings)')]");
    private By menuItemCurriculumToolsGeneral = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Curriculum Tools- General')]");
    private By menuItemSpecialEducationalNeeds = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Special Educational Needs')]");
    private By menuItemTheoryOfEducation = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Theory of Education')]");
    private By menuItemEducationSpecialTopics = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Education Special Topics')]");
    private By menuItemEducationalResearchAndStatistics = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Educational Research & Statistics')]");
    private By menuItemLiteracyAndReading = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Literacy & Reading')]");
    private By menuItemClassroomManagement = By.xpath(".//*[@class=\"side-panel\"]//*[contains(text(),'Classroom Management')]");

    private By menuItems = By.xpath("/html/body/main/div[3]/div/div/div[4]/div[1]/ul/li");

    public WileyHomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void clickYesInChoseLocationWindow() {
        driver.findElement(buttonYes).click();
    }

    /**
     * Move on main-menu item Who We Serve
     */
    public void moveToButtonWhoWeServeMenuList() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement btn = driver.findElement(buttonWhoWeServe);
        action.moveToElement(btn).build().perform();
        Thread.sleep(3000);
    }

    /**
     * Check title Students
     */
    public void checkWhoWeServeMenuListItemStudents() {
        driver.findElement(menuItemStudents).isDisplayed();
        String Students = driver.findElement(menuItemStudents).getText();
        Assert.assertEquals(Students, "Students");
    }

    /**
     * Check title Instructors
     */
    public void checkWhoWeServeMenuListInstructors() {
        driver.findElement(menuItemInstructors).isDisplayed();
        String Instructors = driver.findElement(menuItemInstructors).getText();
        Assert.assertEquals(Instructors, "Instructors");
    }

    /**
     * Check title Book Authors
     */
    public void checkWhoWeServeMenuListBookAuthors() {
        driver.findElement(menuItemBookAuthors).isDisplayed();
        String BookAuthors = driver.findElement(menuItemBookAuthors).getText();
        Assert.assertEquals(BookAuthors, "Book Authors");
    }

    /**
     * Check title Professionals
     */
    public void checkWhoWeServeMenuListProfessionals() {
        driver.findElement(menuItemProfessionals).isDisplayed();
        String Professionals = driver.findElement(menuItemProfessionals).getText();
        Assert.assertEquals(Professionals, "Professionals");
    }

    /**
     * Check title Researchers
     */
    public void checkWhoWeServeMenuListResearchers() {
        driver.findElement(menuItemResearchers).isDisplayed();
        String Researchers = driver.findElement(menuItemResearchers).getText();
        Assert.assertEquals(Researchers, "Researchers");
    }

    /**
     * Check title Institutions
     */
    public void checkWhoWeServeMenuListInstitutions() {
        driver.findElement(menuItemInstitutions).isDisplayed();
        String Institutions = driver.findElement(menuItemInstitutions).getText();
        Assert.assertEquals(Institutions, "Institutions");
    }

    /**
     * Check title Librarians
     */
    public void checkWhoWeServeMenuListLibrarians() {
        driver.findElement(menuItemLibrarians).isDisplayed();
        String Librarians = driver.findElement(menuItemLibrarians).getText();
        Assert.assertEquals(Librarians, "Librarians");
    }

    /**
     * Check title Corporations
     */
    public void checkWhoWeServeMenuListCorporations() {
        driver.findElement(menuItemCorporations).isDisplayed();
        String Corporations = driver.findElement(menuItemCorporations).getText();
        Assert.assertEquals(Corporations, "Corporations");
    }

    /**
     * Check title Societies
     */
    public void checkWhoWeServeMenuListSocieties() {
        driver.findElement(menuItemSocieties).isDisplayed();
        String Societies = driver.findElement(menuItemSocieties).getText();
        Assert.assertEquals(Societies, "Societies");
    }

    /**
     * Check title Journal Editors
     */
    public void checkWhoWeServeMenuListJournalEditors() {
        driver.findElement(menuItemJournalEditors).isDisplayed();
        String JournalEditors = driver.findElement(menuItemJournalEditors).getText();
        Assert.assertEquals(JournalEditors, "Journal Editors");
    }

    /**
     * Check title Government
     */
    public void checkWhoWeServeMenuListGovernment() {
        driver.findElement(menuItemGovernment).isDisplayed();
        String Government = driver.findElement(menuItemGovernment).getText();
        Assert.assertEquals(Government, "Government");
    }

    /**
     * Check that are 11 items under resources sub-header (but now is 12 - mb new item Bookstores)
     */
    public void checkThatInWhoWeServe11Items() {
        int items = driver.findElements(menuWhoWeServeItems).size();
        Assert.assertEquals(items, 11);
    }

    /**
     * Enter “Java” in the search input
     */
    public void inputWordInSearchBox(String strWord) throws InterruptedException {
        driver.findElement(searchBox).sendKeys(strWord);
        Thread.sleep(3000);
    }

    /**
     * Check appear search header 
     */
    public void checkAppearContextMenu() {
        driver.findElement(contextMenu).isDisplayed();
    }

    /**
     * Check no cross and no distance
     */
    public void checkByHeightAndY() {
        int searchBoxTopYPos = driver.findElement(searchBox).getLocation().y;
        int searchBoxHeight = driver.findElement(searchBox).getSize().height;
        int contextMenuTopYPos = driver.findElement(contextMenu).getLocation().y;
        Assert.assertEquals((contextMenuTopYPos - searchBoxTopYPos), searchBoxHeight);
    }

    /**
     * Check by x - searchBoxXPos = contextMenuXPos
     */
    public void checkByXPos() {
        int searchBoxXPos = driver.findElement(searchBox).getLocation().x;
        int contextMenuXPos = driver.findElement(contextMenu).getLocation().x;
        Assert.assertEquals(searchBoxXPos,contextMenuXPos);
    }

    /**
     * Check by Width - inputGroupWidth = contextMenuWidth
     */
    public void checkByWidth() {
        int searchBoxWidth = driver.findElement(searchBox).getSize().width;
        int searchButtonWidth = driver.findElement(searchButton).getSize().width;
        int inputGroupWidth = searchBoxWidth+searchButtonWidth;
        int contextMenuWidth = driver.findElement(contextMenu).getSize().width;
        Assert.assertEquals(inputGroupWidth, contextMenuWidth);
    }

    /**
     * press the search button 
     */
    public void clickButtonSearch() throws InterruptedException {
        driver.findElement(searchButton).click();
        Thread.sleep(3000);
    }

    /**
     * Move on main-menu item Subjects
     */
    public void clickSubjectsMenuList() throws InterruptedException {
        action = new Actions(driver);
        WebElement btn = driver.findElement(buttonSubjects);
        action.moveToElement(btn).build().perform();
        Thread.sleep(3000);
    }

    public void checkThatEducationIsDisplayed() {
        driver.findElement(educationMenuSubjectsItem).isDisplayed();
        //System.out.println(driver.findElement(educationMenuSubjectsItem).getLocation().x);
        //System.out.println(driver.findElement(educationMenuSubjectsItem).getSize().width);
    }

    /**
     * Click on Subject menu-item Education
     */
    public void clickOnEducationMenuSubjectsItem() throws InterruptedException {
        action = new Actions(driver);
        WebElement btn = driver.findElement(educationMenuSubjectsItem);
        action.moveToElement(btn).click().build().perform();
        Thread.sleep(3000);
    }

    /**
     * Check that "Education & Public Policy" is Displayed
     */
    public void checkEducationPublicPolicySubjectsItem() {
        driver.findElement(menuItemEducationPublicPolicy).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemEducationPublicPolicy).getLocation().x
                + driver.findElement(menuItemEducationPublicPolicy).getSize().width) < 620);
    }

    /**
     * Check that title "Subjects" is Displayed and on the left side (620 is a half of main-sticky-header
     * (main header panel) = 1240, if x top left position plus width less then 620 it means that it on left side)
     */
    public void checkSubjectsTitlePosition() {
        driver.findElement(titleSubjects).isDisplayed();
        Assert.assertTrue((driver.findElement(titleSubjects).getLocation().x
                + driver.findElement(titleSubjects).getSize().width) < 620);
        titleSubjectSize = driver.findElement(titleSubjects).getLocation().x
                + driver.findElement(titleSubjects).getSize().width;

    }

    /**
     * Check that "Information & Library Science" is Displayed
     */
    public void checkInformationLibraryScienceSubjectsItem() {
        driver.findElement(menuItemInformationLibraryScience).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemInformationLibraryScience).getLocation().x
                + driver.findElement(menuItemInformationLibraryScience).getSize().width) <= titleSubjectSize);
    }

    /**
     * Check that "K-12 General" is Displayed
     */
    public void checkK12GeneralSubjectsItem() {
        driver.findElement(menuItemK12General).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemK12General).getLocation().x
                + driver.findElement(menuItemK12General).getSize().width) <= titleSubjectSize);
    }

    /**
     * Check that "Higher Education General" is Displayed
     */
    public void checkHigherEducationGeneralSubjectsItem() {
        driver.findElement(menuItemHigherEducationGeneral).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemHigherEducationGeneral).getLocation().x
                + driver.findElement(menuItemHigherEducationGeneral).getSize().width) <= titleSubjectSize);
    }

    /**
     * Check that "Vocational Technology" is Displayed
     */
    public void checkVocationalTechnologySubjectsItem() {
        driver.findElement(menuItemVocationalTechnology).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemVocationalTechnology).getLocation().x
                + driver.findElement(menuItemVocationalTechnology).getSize().width) <= titleSubjectSize);
    }

    /**
     * Check that "Conflict Resolution & Mediation (School settings)" is Displayed
     */
    public void checkConflictResolutionAndMediationSubjectsItem() {
        driver.findElement(menuItemConflictResolutionAndMediation).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemConflictResolutionAndMediation).getLocation().x
                + driver.findElement(menuItemConflictResolutionAndMediation).getSize().width) <= titleSubjectSize);
    }

    /**
     * Check that "Curriculum Tools- General" is Displayed
     */
    public void checkCurriculumToolsGeneralSubjectsItem() {
        driver.findElement(menuItemCurriculumToolsGeneral).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemCurriculumToolsGeneral).getLocation().x
                + driver.findElement(menuItemCurriculumToolsGeneral).getSize().width) <= titleSubjectSize);
    }

    /**
     * Check that "Special Educational Needs" is Displayed
     */
    public void checkSpecialEducationalNeedsSubjectsItem() {
        driver.findElement(menuItemSpecialEducationalNeeds).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemSpecialEducationalNeeds).getLocation().x
                + driver.findElement(menuItemSpecialEducationalNeeds).getSize().width) <= titleSubjectSize);
    }

    /**
     * Check that "Theory of Education" is Displayed
     */
    public void checkTheoryOfEducationSubjectsItem() {
        driver.findElement(menuItemTheoryOfEducation).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemTheoryOfEducation).getLocation().x
                + driver.findElement(menuItemTheoryOfEducation).getSize().width) <= titleSubjectSize);
    }

    /**
     * Check that "Education Special Topics" is Displayed
     */
    public void checkEducationSpecialTopicsSubjectsItem() {
        driver.findElement(menuItemEducationSpecialTopics).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemEducationSpecialTopics).getLocation().x
                + driver.findElement(menuItemEducationSpecialTopics).getSize().width) <= titleSubjectSize);
    }

    /**
     * Check that "Educational Research & Statistics" is Displayed
     */
    public void checkEducationalResearchAndStatisticsSubjectsItem() {
        driver.findElement(menuItemEducationalResearchAndStatistics).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemEducationalResearchAndStatistics).getLocation().x
                + driver.findElement(menuItemEducationalResearchAndStatistics).getSize().width) <= titleSubjectSize);
    }

    /**
     * Check that "Literacy & Reading" is Displayed
     */
    public void checkLiteracyAndReadingSubjectsItem() {
        driver.findElement(menuItemLiteracyAndReading).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemLiteracyAndReading).getLocation().x
                + driver.findElement(menuItemLiteracyAndReading).getSize().width) <= titleSubjectSize);
    }

    /**
     * Check that "Classroom Management" is Displayed
     */
    public void checkClassroomManagementSubjectsItem() {
        driver.findElement(menuItemClassroomManagement).isDisplayed();
        Assert.assertTrue((driver.findElement(menuItemClassroomManagement).getLocation().x
                + driver.findElement(menuItemClassroomManagement).getSize().width) <= titleSubjectSize);
    }

    public void countSubjectItems() {
        int items = driver.findElements(menuItems).size();
        Assert.assertEquals(items, 13);
    }
}