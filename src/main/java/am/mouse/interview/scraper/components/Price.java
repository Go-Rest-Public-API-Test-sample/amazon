package am.mouse.interview.scraper.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Price extends BaseComponent {
    @FindBy(className = "a-price-whole")
    List<WebElement> dollarPart;
    @FindBy(className = "a-price-fraction")
    List<WebElement> centPart;

    public Price(WebElement webElement, WebDriver driver) {
        super(webElement, driver);
    }

    public int getMaxPriceValueInCent() {
        assert dollarPart.size() == centPart.size();
        int maxPrice = 100*Integer.parseInt(dollarPart.get(0).getText())+Integer.parseInt(centPart.get(0).getText());
        for(int i = 1;i< dollarPart.size();i++){
            int price = 100*Integer.parseInt(dollarPart.get(0).getText())+Integer.parseInt(centPart.get(0).getText());
            if(maxPrice > price){
                maxPrice = price;
            }
        }
        return maxPrice;
    }

}
