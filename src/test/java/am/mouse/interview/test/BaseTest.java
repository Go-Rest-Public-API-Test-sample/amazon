package am.mouse.interview.test;

import am.mouse.interview.entity.DriverType;
import am.mouse.interview.scraper.driver.DriverManager;
import am.mouse.interview.scraper.driver.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void initializeWebDriver() {
        DriverManager driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
        driver = driverManager.getDriver();
    }

    @AfterSuite
    public void cleanWebDriver() {
        if (driver != null) {
            driver.close();
        }
    }


}
