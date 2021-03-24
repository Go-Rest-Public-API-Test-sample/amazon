package am.mouse.interview.scraper.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartItem extends BaseComponent {
    @FindBy(className = "a-list-item")
    private WebElement name;

    public CartItem(WebElement webElement, WebDriver driver) {
        super(webElement, driver);
    }

    public String name() {
        return name.getText();
    }
}
