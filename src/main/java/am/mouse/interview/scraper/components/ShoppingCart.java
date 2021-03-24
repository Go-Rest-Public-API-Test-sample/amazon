package am.mouse.interview.scraper.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends BaseComponent {
    @FindBy(css = "[id^=\"sc-item\"]")
    private List<WebElement> cartElementItems;


    public ShoppingCart(WebElement webElement, WebDriver driver) {
        super(webElement, driver);
    }


    public List<CartItem> getCartItems() {
        List<CartItem> cartItems = new ArrayList<>();
        for (WebElement item : cartElementItems) {
            cartItems.add(new CartItem(item, driver));
        }
        return cartItems;
    }
}
