package am.mouse.interview.scraper.components;

import am.mouse.interview.scraper.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationBelt extends BaseComponent {
    public NavigationBelt(WebElement webElement, WebDriver driver) {
        super(webElement, driver);
    }

    @FindBy(id="twotabsearchtextbox")
    private WebElement searchInputBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement submitButton;

    public SearchResultPage search(String searchItem){
        searchInputBox.clear();
        searchInputBox.sendKeys(searchItem);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
        return new SearchResultPage(driver);
    }

}
