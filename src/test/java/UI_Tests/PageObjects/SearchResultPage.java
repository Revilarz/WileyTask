package UI_Tests.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchResultPage {
    private ChromeDriver driver;

    private By oBookId = By.xpath(".//*[@id=\"eBundlePlpTabMainTabPanel\"]//*[@role=\"tabpanel\" and contains(@id, \"O-Book\")]");

    private By containsJavaTitles = By.xpath(".//*[@class='product-item']//*[contains(text(),'Java')]");

    private By titlesOnThePage = By.xpath(".//*[@class='product-item']");

    public SearchResultPage(ChromeDriver driver) {
        this.driver = driver;
    }

    /**
     * Only titles containing “Java” are displayed 
     */
    public void checkThatAllTitlesContainsJava() {
        Assert.assertTrue(driver.findElements(containsJavaTitles).size() >= 10);
    }

    /**
     * There are 10 titles on the page
     */
    public void checkThatOnly10TitlesOnPage() {
        Assert.assertEquals(driver.findElements(titlesOnThePage).size(), 10);
    }

    /**
     * Each title has at least one “Add to Cart” button for E-Book
     */
    public void checkIfEBookThanHasAddToCardButton() {
        String dataCodeEBook = driver.findElement(By.xpath(".//*[@data-medium-type='E-Book']")).getAttribute("data-code");
        driver.findElement(By.id("addToCartForm" + dataCodeEBook)).isDisplayed();
    }

    /**
     * Each title has at least one “Add to Cart” button for Print
     */
    public void checkIfPrintThanHasAddToCardButton() {
        String dataCodePrint = driver.findElement(By.xpath(".//*[@data-medium-type='Paperback']")).getAttribute("data-code");
        driver.findElement(By.id("addToCartForm" + dataCodePrint)).isDisplayed();
    }

    private int i;
    private String dataCodeOBook;

    /**
     * Each title has at least one VIEW ON WILEY ONLINE LIBRARY” for O-BOOK version
     */
    public void checkIfOBookThanHasViewOnWileyOnlineLibraryButton() {
        if (driver.findElements(oBookId).get(i).isDisplayed()) {
            String[] parts = driver.findElement(oBookId).getAttribute("id").split("_");
            dataCodeOBook = parts[0];
        } else {
            i++;
        }
        driver.findElement(By.xpath(".//*[@href='http://onlinelibrary.wiley.com/resolve/openurl?genre=book&isbn="+dataCodeOBook+"']")).isDisplayed();
    }

}
