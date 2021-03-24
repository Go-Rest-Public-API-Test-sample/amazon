package am.mouse.interview.scraper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ItemPage extends BaseAmazonPage{
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    private static final String ON_CHANGE_EVENT_FIRE_SCRIPT = "var event = new Event('input', {\n" +
            "    bubbles: true,\n" +
            "    cancelable: true,\n" +
            "}); \n" +
            "arguments[0].dispatchEvent(event);";

    @FindBy(css = "#dropdown_selected_size_name .a-dropdown-prompt")
    private WebElement sizeDropDown;


    @FindBy(css = "[id^=\"size_name\"] > a")
    private List<WebElement> sizeList;

    @FindBy(name = "submit.add-to-cart")
    private WebElement addToCartButton;


    @FindBy(xpath = "\"//span[@class='a-dropdown-prompt' and contains(text(), 'Select')]\"")
    private WebElement small;


    public void selectFirstSize() {
        wait.until(ExpectedConditions.elementToBeClickable(sizeDropDown));
        sizeDropDown.click();
        JavascriptExecutor jsex = (JavascriptExecutor) driver;
        sizeList.get(1).click();
        jsex.executeScript(ON_CHANGE_EVENT_FIRE_SCRIPT, sizeDropDown);
        wait.until(ExpectedConditions.visibilityOfAllElements(sizeDropDown));
    }


    public void addToCart(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit.add-to-cart")));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

}
