package am.mouse.interview.scraper.pages;

import am.mouse.interview.scraper.components.Item;
import am.mouse.interview.scraper.components.PriceFilter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BaseAmazonPage {
    @FindBy(id = "priceRefinements")
    private PriceFilter priceFilter;
    @FindBy(css = "div.sg-col-4-of-12> div> span > div > div")
    private List<WebElement> itemElements;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public PriceFilter priceFilter() {
        return priceFilter;
    }

    public List<Item> items() {
        List<Item> items = new ArrayList<>();
        for (WebElement itemElement : itemElements) {
            Item item = new Item(itemElement, driver);
            items.add(item);
        }
        return items;
    }
}
