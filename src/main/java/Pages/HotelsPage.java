package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage extends BasePage {

    public HotelsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"container\"]/h2[text()=\"SEARCH FOR BEST HOTELS\"]")
    WebElement HotelsPageText;

    @FindBy(xpath = "//input[@type=\"search\"]")
    WebElement HotelsCitySearchBox;

    @FindBy(xpath = "//span[@class=\"select2-selection select2-selection--single\"]")
    WebElement HotelsCityBox;

    @FindBy(xpath = "//button[@id=\"submit\"]")
    WebElement SearchButton;

    @FindBy(xpath = "//section[@class=\"breadcrumb-area bread-bg-7\"]")
    WebElement SearchesDisplayed;

    public boolean hotelsPageGetsLoaded() {
        return isDisplayed(HotelsPageText);
    }

    public void enterCityInHotelsTab() {
        enterTextUsingKeys(HotelsCityBox, Keys.ENTER);
        enterText(HotelsCitySearchBox,"Kolkata");
        holdExecution(2);
        enterTextUsingKeys(HotelsCitySearchBox, Keys.ARROW_DOWN);
        enterTextUsingKeys(HotelsCitySearchBox, Keys.ENTER);
    }

    public void clickOnSearchButton(){
        click(SearchButton);
    }

    public boolean isSearchDisplayed(){
        return isDisplayed(SearchesDisplayed);
    }
}
