package am.mouse.interview.scraper.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManager extends DriverManager {

    @Override
    protected WebDriver createLocalWebDrive() {
        return new FirefoxDriver();
    }

    @Override
    protected DesiredCapabilities getDesiredCapabilitiesByType() {
        return DesiredCapabilities.firefox();
    }
}
