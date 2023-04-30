package step_definitions;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class LogInSteps {
    private static final By FullName = By.id("name");
    private static final By Password = By.id("password");
    private static final By Login = By.id("login");
    private static final By LogOut = By.id("logout");
    private static final By InvalidPassword = By.xpath("//*[@id='pageLogin']/form//div[text()='Password is invalid']");
    private Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver = Hooks.driver;

    //Precondition
    @Given("^a user is on the login page$")
    public void navigateToLoginPage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("TestAppURL"));
        LOGGER.info("User is in the login page");
    }

    //Main Action
    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void enterUserCredentials(String username, String password){
        ActOn.element(driver, FullName).setValue(username);
        ActOn.element(driver, Password).setValue(password);
        LOGGER.info("User has entered credentials");
    }
    @And("^click on login button$")
    public void clickOnLogin(){
        ActOn.element(driver, Login).click();
        LOGGER.info("User clicked on the Login button");
    }
    @When("^user clcik on login button upon entering credentials$")
    public void userClickOnLogInUponEnteringCredentials(DataTable table){
        List<Map<String,String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String>cells:data){
            ActOn.element(driver, FullName).setValue(cells.get("username"));
            ActOn.element(driver,Password).setValue(cells.get("Password"));
            LOGGER.info("User has entered credentials");
        }

    }
    @Then("^User is navigated to home page$")
    public void validateUserLoggedinSuccessfully(){
        AssertThat.elementAssertions(driver, LogOut).elementIsDisplayed();
        LOGGER.info("User is in the HomePage");
    }
    @Then("^User is failed to login$")
    public void validateUserIsFailedToLogin(){
        AssertThat.elementAssertions(driver, InvalidPassword).elementIsDisplayed();
        LOGGER.info("User is still on the login Page");
    }
}
