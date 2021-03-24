package am.mouse.interview.scraper.components;

import am.mouse.interview.entity.WebComponent;
import am.mouse.interview.scraper.ExtendedFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseComponent implements WebComponent {
    private static final long WEB_DRIVER_WAIT_TIMEOUT = 40L;
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BaseComponent(final WebElement webElement, final WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, WEB_DRIVER_WAIT_TIMEOUT);
        PageFactory.initElements(new ExtendedFieldDecorator(webElement, driver), this);
    }
}