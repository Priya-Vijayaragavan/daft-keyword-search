package PageObjectModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class DaftPageObjects {
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"CookieConsent.acceptAll();\"]")
    WebElement _cookies;
    @FindBy(how = How.ID, using = "search-box-input")
    WebElement _searchArea;
    @FindBy(how = How.ID, using = "attraction-modal-create-buying-budget")
    WebElement _calculatorBudget;
    @FindBy(how = How.CLASS_NAME, using = "styles__CloseContainer-qea560-4")
    WebElement _closeCalculator;
    @FindBy(how = How.XPATH, using = "//button[@data-testid='open-filters-modal']")
    WebElement _filterTab;
    @FindBy(how = How.ID, using = "keywordtermsModal")
    WebElement _keywordSearchBox;
    @FindBy(how = How.XPATH, using = "//button[@data-testid='filters-modal-show-results-button']")
    WebElement _showResults;
    @FindBy(how = How.CLASS_NAME, using = "DefaultLayout__Main-sc-164pcf8-0")
    WebElement _pageText;


    public WebDriver webDriver;
    public Actions action;

    public DaftPageObjects(WebDriver _webDriver) {
        webDriver = _webDriver;
        PageFactory.initElements(_webDriver, this);
        action = new Actions(webDriver);
    }

    public DaftPageObjects acceptCookies() {
        _cookies.click();
        return this;
    }

    public DaftPageObjects enteringLocation() {
        _searchArea.click();
        webDriver.findElement(By.xpath("//*[@id=\"search-box-item-15\"]/span/span[1]")).click();
        return this;
    }

    public DaftPageObjects checkResultForSelectedLocation(String string) throws InterruptedException {
        Thread.sleep(5000);
        if (_calculatorBudget.isDisplayed()) {
            _closeCalculator.click();
        }

        List<WebElement> resultAddress = webDriver.findElements(By.xpath("//p[@data-testid='address']"));
        WebElement checkResultAddress = resultAddress.stream()
                .filter(Item -> Item.getText().contains(string))
                .findFirst()
                .orElse(null);
        Assert.assertNotEquals(checkResultAddress, null);
        return this;
    }

    public DaftPageObjects clickFilterTab() {
        _filterTab.click();
        return this;
    }

    public DaftPageObjects enterTextInTheKeywordSearch(String text) throws InterruptedException {

        Thread.sleep(2000);
        action.scrollToElement(_keywordSearchBox);
        _keywordSearchBox.sendKeys(text);
        _showResults.click();
        return this;
    }

    public DaftPageObjects checkFilterCount(String count) {
        String filterCount = _filterTab.getAttribute("aria-label");
        filterCount.contains(count);
        return this;
    }

    public DaftPageObjects openingOneOfTheSearchResult() {
        List<WebElement> results = webDriver.findElements(By.xpath("//div[@data-testid='card-wrapper']"));
        WebElement oneOftheResult = results.stream().filter(item -> item.getText().contains("Dublin")).findFirst().orElse(null);
        oneOftheResult.click();
        return this;
    }

    public DaftPageObjects checkKeywordInTheResult(String keyword) {
        _pageText.getText().contains(keyword);
        return this;
    }


}
