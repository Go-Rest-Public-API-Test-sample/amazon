package am.mouse.interview.scraper.components;

import am.mouse.interview.scraper.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceFilter extends BaseComponent{

    public PriceFilter(WebElement webElement, WebDriver driver) {
        super(webElement, driver);
    }


    @FindBy(css = "#p_36\\/2661613011 > span:nth-child(1) > a:nth-child(1)")
    private WebElement from25to50link;

    public SearchResultPage filter(PriceFilters filter){
        switch (filter){
            case FROM_25_TO_50:
                from25to50link.click();
                break;
            default:
                throw new RuntimeException("Filter not implemented yet");
        }
        return new SearchResultPage(driver);
    }

    public enum PriceFilters{
        UNDER_25,
        FROM_25_TO_50,
        FROM_50_TO_100
    }

}
