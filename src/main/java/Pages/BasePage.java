package Pages;

import Utilities.Setup;
import Utilities.Utils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class BasePage extends Utils {

    public WebDriver driver;
    public FileInputStream fis;
    public static Properties properties;

    public BasePage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        try{
            fis = new FileInputStream("resources/config.properties");
            properties.load(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//div[@class=\"logo\"]//img[@alt=\"logo\"]")
    WebElement logoOnTheBasePage;

    @FindBy(xpath = "//ul[@aria-labelledby=\"currency\"]/li")
    List<WebElement> CurrencyDropDown;

    @FindBy(xpath = "//button[@id=\"currency\"]")
    WebElement CurrencyButton;

    @FindBy(xpath = "//a[@class=\"theme-btn theme-btn-small waves-effect\"]")
    WebElement SignupButton;

    @FindBy(xpath = "//button[@id=\"cookie_stop\"]")
    WebElement GotItButton;

    @FindBy(xpath = "//a[@class=\"theme-btn theme-btn-small theme-btn-transparent ml-1 waves-effect\"]")
    WebElement LoginButton;

    @FindBy(xpath = "(//a[text()=\"Company \"])[1]")
    WebElement CompanyButton;

    @FindBy(xpath = "//div[@class=\"main-menu-content\"]//li[@class=\"footm\"]//ul[@class=\"dropdown-menu-item\"]/li")
    List<WebElement> CompanyDropdown;

    @FindBy(xpath = "//div[@class=\"main-menu-content\"]/nav/ul/li")
    List<WebElement> MultipleFilterOptions;

    @FindBy(xpath = "//ul[@class=\"nav nav-tabs listitems\"]/li")
    List<WebElement> MultipleTabs;

    @FindBy(xpath = "//span[@aria-labelledby=\"select2-tours_city-container\"]")
    WebElement TourCityBox;

    @FindBy(xpath = "//input[@class=\"select2-search__field\"]")
    WebElement TourCitySearchBox;

    @FindBy(xpath = "//form[@id=\"tours-search\"]//button[@id=\"submit\"]")
    WebElement SearchButtonInToursSection;

    @FindBy(xpath= "//div[@class=\"frame-code active\"]")
    WebElement ErrorPageForToursSearch;

    public boolean isLogoVisible() {
        return isDisplayed(logoOnTheBasePage);
    }

    public void clickOnCurrencyButton() {
        click(CurrencyButton);
        holdExecution(2);
    }

    public boolean isListOfCurrenciesVisible() {
        return areDisplayed(CurrencyDropDown);
    }

    public void clickOnSignupButton() {
        click(SignupButton);
    }

    public void acceptCookie() {
        click(GotItButton);
    }

    public void clickOnLoginButton() {
        click(LoginButton);
    }

    public void hoverOnCompanyButton() {
        hover(CompanyButton);
    }

    public boolean valuesOfCompanyDropdownAreDisplayed() {
        return areDisplayed(CompanyDropdown);
    }

    public void clickOnAboutUsValueInCompanyDropdown() {
        click(CompanyDropdown.get(0));
        holdExecution(2);
    }

    public void clickOnTermsOfUseValueInCompanyDropdown() {
        click(CompanyDropdown.get(1));
        holdExecution(2);
    }

    public void clickOnFAQValueInCompanyDropdown() {
        click(CompanyDropdown.get(2));
        holdExecution(2);
    }

    public void clickOnHomeButton() {
        click(MultipleFilterOptions.get(0));
    }

    public void clickOnHotelsButton(){
        click(MultipleFilterOptions.get(1));
    }

    public void clickOnFlightsButton(){
        click(MultipleFilterOptions.get(2));
    }

    public void clickOnToursTab(){
        click(MultipleTabs.get(2));
    }

    public void enterCityDetailsUnderToursSection(){
        enterTextUsingKeys(TourCityBox, Keys.ENTER);
        enterText(TourCitySearchBox,"Kolkata");
        holdExecution(2);
        enterTextUsingKeys(TourCitySearchBox,Keys.ARROW_DOWN);
        enterTextUsingKeys(TourCitySearchBox,Keys.ENTER);
    }

    public void clickOnSearchButtonInToursSection(){
        click(SearchButtonInToursSection);
        holdExecution(2);
    }

    public boolean errorPageIsDisplayed(){
        return isDisplayed(ErrorPageForToursSearch);
    }

}
