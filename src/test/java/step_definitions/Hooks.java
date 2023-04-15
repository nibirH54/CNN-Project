package step_definitions;

import com.oracle.deploy.update.UpdateCheck;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;


public class Hooks {
    public static WebDriver driver;
    private final Logger LOGGER =  LogManager.getLogger(this.getClass().getName());

    @Before
    public void initialize(Scenario scenario){
        LOGGER.info(String.format("-------------Scenario: %s----------------", scenario.getName()));
        driver = DriverFactory.getInstance().getDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        DriverFactory.getInstance().removeDriver();
        LOGGER.info(String.format("-------------End Scenario: %s----------------", scenario.getName()));

    }
}
