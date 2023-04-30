package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar {
    private final By HomeValueInputField = By.id("homeval");
    private final By DownPaymentInputField = By.id("downpayment");
    private final By DownPaymentTypeInDollar = By.name("param[downpayment_type");
    private final By LoanAmountInputField = By.id("loanamt");
    private final By InterestRateInputField = By.id("intrstsrate");
    private final By LoanTermInputField = By.id("loanterm");
    private final By StartMonthDropDown = By.name("param[start_month]");
    private final By StartYearInputField = By.id("start_year");
    private final By PropertyTaxInputField = By.id("pptytax");
    private final By PmiInputField = By.id("pmi");
    private final By HomeInsuranceInputField = By.id("hoi");
    private final By MonthlyHoaInputField = By.id("hoa");
    private final By LoanTypeDropDown = By.name("param[milserve]");
    private final By BuyOrRefiDropDown = By.name("param[refiorbuy]");
    private final By calculateButton = By.name("cal");
    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public Home(WebDriver driver){
        super(driver);
    }

    public Home typeHomePrice(String value){
        LOGGER.debug("Typing home value: " + value);
        ActOn.element(driver,HomeValueInputField).setValue(value);
        return this;
    }
    public Home typeDownPayment(String value){
        LOGGER.debug("Typing downpayment value: " + value);
        ActOn.element(driver,DownPaymentInputField ).setValue(value);
        return this;
    }
    public Home ClickDownPaymentInDollar(){
        LOGGER.debug("Clicking on $ radio Button");
        ActOn.element(driver,DownPaymentTypeInDollar).click();
        return this;
    }
    public Home typeLoanAmount(String value){
        LOGGER.debug("Typing the loan amount: " + value);
        ActOn.element(driver,LoanAmountInputField  ).setValue(value);
        return this;
    }
    public Home typeInterestRate(String value){
        LOGGER.debug("Typing the interest rate: " + value);
        ActOn.element(driver,InterestRateInputField ).setValue(value);
        return this;
    }
    public Home typeLoanTermYears(String value){
        LOGGER.debug("Typing the Loan Term: " + value);
        ActOn.element(driver, LoanTermInputField).setValue(value);
        return this;
    }
    public Home selectMonth(String month){
        LOGGER.debug("Select the start date month:" + month);
        ActOn.element(driver,StartMonthDropDown ).setValue(month);
        return this;
    }
    public Home typeYear(String year){
        LOGGER.debug("Select the start date year: " + year);
        ActOn.element(driver,StartYearInputField ).setValue(year);
        return this;
    }
    public Home typePropertyTax(String value){
        LOGGER.debug("Typing the property tax: " + value);
        ActOn.element(driver,PropertyTaxInputField ).setValue(value);
        return this;
    }
    public Home typePMI(String value){
        LOGGER.debug("Typing the PMI" + value);
        ActOn.element(driver,PmiInputField).setValue(value);
        return this;
    }
    public Home TypeHomeOwnerInsurance(String value){
        LOGGER.debug("Typing the Home owner Insurance " + value);
        ActOn.element(driver, HomeInsuranceInputField ).setValue(value);
        return this;
    }
    public Home typeMonthlyHOA(String value){
        LOGGER.debug("Typing the monthly HOA: " + value);
        ActOn.element(driver,MonthlyHoaInputField ).setValue(value);
        return this;
    }
    public Home selectLoanType(String value){
        LOGGER.debug("Selecting Loam Type : " + value );
        ActOn.element(driver, LoanTypeDropDown).setValue(value);
        return this;
    }
    public Home selectBuyOrRefinance(String value){
        LOGGER.debug("Selecting option: " + value);
        ActOn.element(driver,BuyOrRefiDropDown ).setValue(value);
        return this;
    }
    public Home clcickOnCalculateButton(){
        LOGGER.debug("Clicking on calculate button");
        ActOn.element(driver, calculateButton).click();
        return this;
    }
    public Home validateTotalMonthlyPayment(String totalMonthlyPayment) {
        LOGGER.debug("Validating Total Monthly payment is: " + totalMonthlyPayment);
        String formattedXpath = String.format("//h3[text()='$%s']", totalMonthlyPayment);
        AssertThat.elementAssertions(driver, By.xpath(formattedXpath)).elementIsDisplayed();
        return this;
    }
}
