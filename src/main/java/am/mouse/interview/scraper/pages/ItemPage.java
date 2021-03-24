package am.mouse.interview.scraper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ItemPage extends BaseAmazonPage{
    public ItemPage(WebDriver driver) {
        super(driver);
    }
    private static final String CART_INFO_BOX = "a-box-group";

    @FindBy(css = "#dropdown_selected_size_name .a-dropdown-prompt")
    private WebElement sizeDropDown;


    @FindBy(css = "[id^=\"size_name\"] > a")
    private List<WebElement> sizeList;

    @FindBy(name = "submit.add-to-cart")
    private WebElement addToCartButton;


    @FindBy(id = "productTitle")
    private WebElement title;

    public void selectFirstSize() {
        wait.until(ExpectedConditions.elementToBeClickable(sizeDropDown));
        sizeDropDown.click();
        assert  sizeList.size() > 0;
        sizeList.get(1).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(sizeDropDown));
    }

    public void addToCart(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(CART_INFO_BOX)));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public String title(){
        return title.getText();
    }

}
