package am.mouse.interview.scraper.pages;


import am.mouse.interview.scraper.ExtendedFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebScraper {
    private static final Logger logger = LogManager.getLogger(BaseWebScraper.class);
    private static final long MAX_WAIT_TIME = 60L;
    private static final String SCROLL_JS = "arguments[0].scrollIntoView();";
    protected final WebDriverWait wait;
    protected final WebDriver driver;

    protected BaseWebScraper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, MAX_WAIT_TIME);
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }

    protected void scrollDown(WebElement element) {
        logger.info("Scrolling down " + this.getClass().getSimpleName());
        ((JavascriptExecutor) driver).executeScript(SCROLL_JS, element);
    }
}
