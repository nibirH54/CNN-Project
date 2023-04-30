package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr extends NavigationBar {
    private final By CalculatorTab = By.xpath("//label[.='Calculator']");
    private final By HomePriceInputField = By.name("HomeValue");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    private final By DownPaymentInputField = By.name("DownPayment");
    private final By InterestRateInputField = By.name("Interest");
    private final By LengthOfFinance = By.name("Length");
    private final By CalculateButton = By.name("calculate");
    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);

    public RealApr(WebDriver driver){

        super(driver);
    }
    public RealApr waitForPageToLoad(){
        LOGGER.debug("Waiting for the Page to Load");
        ActOn.element(driver, CalculatorTab).waitForElementToBeVisible();
        return this;
    }
    public RealApr typeHomePrice(String value){
        LOGGER.debug("Typing Home Value: " + value);
        ActOn.element(driver, HomePriceInputField).setValue(value);
        return this;

    }
    public RealApr SelectDownPaymentInDollar(){
        LOGGER.debug("Click on $ as Down Payment");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }
    public RealApr typeDownPayment(String value){
        LOGGER.debug("Type down payment amount: " + value);
        ActOn.element(driver, DownPaymentInputField).setValue(value);
        return this;
    }
    public RealApr typeInterestRate(String value){
        LOGGER.debug("Type interest rate: " + value);
        ActOn.element(driver, InterestRateInputField).setValue(value);
        return this;
    }
    public RealApr typeLengthOfGinance(String value){
        LOGGER.debug("Type length of Finance: " + value);
        ActOn.element(driver, LengthOfFinance).setValue(value);
        return this;

    }
    public RealApr clickOnCalculateButton(){
        LOGGER.debug("Click on calculate Button");
        ActOn.element(driver, CalculateButton).click();
        return this;
    }


    public void validateRealAprRate(String realApr) {
    }
}
