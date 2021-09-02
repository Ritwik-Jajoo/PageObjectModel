package TestCases;

import Pages.*;
import Utilities.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdatedTCs extends Setup {

    public WebDriver driver;
    BasePage basePage;
    SignUpPage signUpPage;
    LoginPage loginPage;
    AboutUsPage aboutUsPage;
    TermsOfUsePage termsOfUsePage;
    FAQPage faqPage;
    HomePage homePage;
    HotelsPage hotelsPage;
    FlightsPage flightsPage;

    @BeforeClass
    public void tearUp() {
        driver = launchBrowser("chrome");
        basePage = new BasePage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
        aboutUsPage = new AboutUsPage(driver);
        termsOfUsePage = new TermsOfUsePage(driver);
        faqPage = new FAQPage(driver);
        homePage = new HomePage(driver);
        hotelsPage = new HotelsPage(driver);
        flightsPage = new FlightsPage(driver);
    }

    @BeforeMethod
    public void launchWebsite() {
        driver.get(basePage.properties.getProperty("url"));
    }

    @Test(priority = 1)
    public void verifyLogoOnTheBasePage() {
        Assert.assertTrue(basePage.isLogoVisible());
    }

    @Test(priority = 2)
    public void verifyListOfCurrencyDropdownVisible() {
        basePage.clickOnCurrencyButton();
        Assert.assertTrue(basePage.isListOfCurrenciesVisible());
    }

    @Test(priority = 3)
    public void verifyFunctionalityOfSignUpButton() {
        basePage.acceptCookie();
        basePage.clickOnSignupButton();
        Assert.assertTrue(signUpPage.isSignupPageLoaded());
        signUpPage.enterSignupDetails();
        signUpPage.selectCustomerFromDropdown();
        signUpPage.clickOnSignupButtonOnSignupPage();
        Assert.assertTrue(signUpPage.isLoginTextDisplayed());
    }

    @Test(priority = 4)
    public void verifyFunctionalityOfLoginButton() {
        basePage.clickOnLoginButton();
        Assert.assertTrue(loginPage.isLoginBoxDisplayed());
        loginPage.enterLoginDetails();
        loginPage.clickOnLoginButtonOnLoginPage();
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }

    @Test(priority = 5)
    public void verifyValuesInCompanyDropdown() {
        basePage.hoverOnCompanyButton();
        Assert.assertTrue(basePage.valuesOfCompanyDropdownAreDisplayed());
    }

    @Test(priority = 6)
    public void verifyUserNavigatesToAboutUsPageWhenClickedOnAboutUsInCompanyDropdown() {
        basePage.hoverOnCompanyButton();
        basePage.clickOnAboutUsValueInCompanyDropdown();
        Assert.assertTrue(aboutUsPage.aboutUsPageGetsLoaded());
    }

    @Test(priority = 7)
    public void verifyUserNavigatesToTermsOfUsePageWhenClickedOnTermsOfUseInCompanyDropdown() {
        basePage.hoverOnCompanyButton();
        basePage.clickOnTermsOfUseValueInCompanyDropdown();
        Assert.assertTrue(termsOfUsePage.termsOfUsePageGetsLoaded());
    }

    @Test(priority = 8)
    public void verifyUserNavigatesToFAQPageWhenClickedOnFAQInCompanyDropdown() {
        basePage.hoverOnCompanyButton();
        basePage.clickOnFAQValueInCompanyDropdown();
        Assert.assertTrue(faqPage.faqPageGetsLoaded());
    }

    @Test(priority = 9)
    public void verifyUserNavigatesToHomePageOnClickingHomePageButton() {
        basePage.clickOnHomeButton();
        Assert.assertTrue(homePage.homePageDisplayed());
    }

    @Test(priority = 10)
    public void verifyUserNavigatesToHotelsPageOnClickingHotelsPageButton() {
        basePage.clickOnHotelsButton();
        Assert.assertTrue(hotelsPage.hotelsPageGetsLoaded());
    }

    @Test(priority = 11)
    public void verifyUserNavigatesToFlightsPageOnClickingFlightsPageButton() {
        basePage.clickOnFlightsButton();
        Assert.assertTrue(flightsPage.flightsPageDisplayed());
    }

    @Test(priority = 12)
    public void verifySearchFunctionalityUnderHotelsTab() {
        basePage.clickOnHotelsButton();
        Assert.assertTrue(hotelsPage.hotelsPageGetsLoaded());
        hotelsPage.enterCityInHotelsTab();
        hotelsPage.clickOnSearchButton();
        Assert.assertTrue(hotelsPage.isSearchDisplayed());
    }

    @Test(priority = 13)
    public void verifySearchFunctionalityUnderToursTab() {
        basePage.clickOnToursTab();
        basePage.enterCityDetailsUnderToursSection();
        basePage.clickOnSearchButtonInToursSection();
        //Assert.assertTrue(basePage.errorPageIsDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
