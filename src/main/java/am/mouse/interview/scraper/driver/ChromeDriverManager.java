package am.mouse.interview.scraper.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected WebDriver createLocalWebDrive() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        Capabilities cap = getDesiredCapabilities();
        options.merge(cap);
        return new ChromeDriver(options);
    }


    @Override
    protected DesiredCapabilities getDesiredCapabilitiesByType() {
        return DesiredCapabilities.chrome();
    }
}