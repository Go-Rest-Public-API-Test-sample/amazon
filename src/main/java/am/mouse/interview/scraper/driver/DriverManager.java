package am.mouse.interview.scraper.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;


public abstract class DriverManager {
    private static final Logger logger = (Logger) LogManager.getLogger(DriverManager.class);
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    protected WebDriver driver;

    public WebDriver getDriver() {
        if (driverThread.get() == null) {
            logger.info("creating driver");
            driverThread.set(initWebDriver());
        }
        driverThread.get();
        return driverThread.get();
    }

    protected abstract WebDriver createLocalWebDrive();

    protected abstract DesiredCapabilities getDesiredCapabilitiesByType();

    private WebDriver initWebDriver() {
        WebDriver driver;
        logger.info("Initializing new WebDriver");
        driver = createLocalWebDrive();
        assert driver != null;
            driver.manage().window().maximize();
        return driver;
    }

    protected DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities cap = getDesiredCapabilitiesByType();
        cap.setCapability(CapabilityType.LOGGING_PREFS, getLoggingPreferences());
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return cap;
    }

    private LoggingPreferences getLoggingPreferences() {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.CLIENT, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        logs.enable(LogType.PERFORMANCE, Level.ALL);
        logs.enable(LogType.PROFILER, Level.ALL);
        logs.enable(LogType.SERVER, Level.ALL);
        return logs;
    }
}
