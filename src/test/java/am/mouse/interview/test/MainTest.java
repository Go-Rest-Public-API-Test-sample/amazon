package am.mouse.interview.test;

import am.mouse.interview.scraper.components.Item;
import am.mouse.interview.scraper.components.PriceFilter;
import am.mouse.interview.scraper.pages.HomePage;
import am.mouse.interview.scraper.pages.ItemPage;
import am.mouse.interview.scraper.pages.SearchResultPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(MainTest.class);
    private static final String SUT_FQDN="https://www.amazon.com/";
    private static final String SEARCHED_ITEM = "dress";


    @Test
    public void mainTestExample() throws InterruptedException {
        driver.get(SUT_FQDN);

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage=  homePage.navigationBelt().search(SEARCHED_ITEM);

        SearchResultPage filteredSearchResultPage = searchResultPage.priceFilter().filter(PriceFilter.PriceFilters.FROM_25_TO_50);

        List<Item> items= filteredSearchResultPage.items();
        Assert.assertFalse(items.isEmpty(),"Items not found");
        Item lowCostItem = items.get(0);
        Integer lowCostItemPrice = lowCostItem.price().getMaxPriceValueInCent();

        for(int i = 1;i< items.size(); i++ ){
            Item item = items.get(i);
            try {
                Integer itemPrice = item.price().getMaxPriceValueInCent();
                logger.info("Item Price:"+itemPrice);
                if(lowCostItemPrice > itemPrice){
                    lowCostItem = item;
                    lowCostItemPrice = itemPrice;
                }
            }catch (NoSuchElementException e){
                logger.warn("Price not found");
            }
        }
        logger.info("Lowest price "+lowCostItemPrice);
        ItemPage itemPage = lowCostItem.open();
        itemPage.selectFirstSize();
        Thread.sleep(1000);
        itemPage.addToCart();
        logger.info("IINFO");
        logger.warn("WARNING");
        logger.error("error");
        Assert.assertTrue(true);
        Thread.sleep(5*1000);
    }
}
