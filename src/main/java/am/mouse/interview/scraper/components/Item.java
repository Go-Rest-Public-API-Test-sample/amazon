package am.mouse.interview.scraper.components;

import am.mouse.interview.scraper.pages.ItemPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Item extends BaseComponent{
    public Item(WebElement webElement, WebDriver driver) {
        super(webElement, driver);
    }

    @FindBy(className = "a-price")
    private Price price;

    @FindBy(css = ".a-spacing-none > h2 > a")
    private WebElement name;


    public Price price(){
        return price;
    }

    public ItemPage open(){
        name.click();
        return new ItemPage(driver);
    }
}
