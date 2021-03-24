package am.mouse.interview.scraper.pages;

import am.mouse.interview.scraper.components.ShoppingCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BaseAmazonPage {

    @FindBy(id = "sc-active-cart")
    private ShoppingCart shoppingCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCart shoppingCart(){
        return shoppingCart;
    }
}
