package am.mouse.interview.scraper.pages;

import am.mouse.interview.scraper.components.NavigationBelt;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseAmazonPage extends BaseWebScraper {
    @FindBy(id = "nav-belt")
    private NavigationBelt navigationBar;



    protected BaseAmazonPage(WebDriver driver) {
        super(driver);
    }

    public NavigationBelt navigationBelt() {
        return navigationBar;
    }



}
