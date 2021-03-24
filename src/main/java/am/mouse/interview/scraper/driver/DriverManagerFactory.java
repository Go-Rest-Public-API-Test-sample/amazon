package am.mouse.interview.scraper.driver;

import am.mouse.interview.entity.DriverType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverManagerFactory {
    private static final Logger logger = LogManager.getLogger(DriverManagerFactory.class);
    private static DriverManager driverManager;

    public static DriverManager getDriverManager(DriverType driverType) {
        logger.info("Driver type : " + driverType.name());
        switch (driverType) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
        }
        return driverManager;
    }
}
