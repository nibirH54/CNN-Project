package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);
    //iT WILL NOT ALLOW TO CREATE AN OBJECT OUTSIDE FROM THE CLASS
    private DriverFactory() {
            // Do nothing
        }

        // Creating an instance object from this class
        private static final DriverFactory instance = new DriverFactory();

        public static DriverFactory getInstance () {
            return instance;
        }

        ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
            String environment = System.getProperty("environment") == null ? "local" : System.getProperty("environment");
            String browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
            URL gridUrl = null;

            try {
                gridUrl = new URL(ReadConfigFiles.getPropertyValues("GridURL"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            if (environment.equals("remote") && browser.equals("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                LOGGER.debug("Grid URL: " + gridUrl);
                LOGGER.info("Picked Up Selenium Grid and Chrome Browser");
                return new RemoteWebDriver(gridUrl, chromeOptions);
            } else if (environment.equals("remote") && browser.equals("firefox")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                LOGGER.debug("Grid URL: " + gridUrl);
                LOGGER.info("Picked Up Selenium Grid and firefox Browser");
                return new RemoteWebDriver(gridUrl, firefoxOptions);
            } else if (environment.equals("remote") && browser.equals("edge")) {
                LOGGER.debug("Grid URL: " + gridUrl);
                LOGGER.info("Picked Up Selenium Grid and edge Browser");
                EdgeOptions edgeOptions = new EdgeOptions();
                return new RemoteWebDriver(gridUrl, edgeOptions);
            } else {
                WebDriverManager.chromedriver().setup();
                LOGGER.info("Executing the test in local with chrome browser");
                return new ChromeDriver();
            }
        });

        public WebDriver getDriver () {
            return driver.get();
        }

        public void removeDriver () {
            driver.get().quit();
            driver.remove();
        }
    }

