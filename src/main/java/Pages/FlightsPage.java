package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage extends BasePage{

    public FlightsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class=\"container\"]/h2[text()=\"SEARCH FOR BEST FLIGHTS\"]")
    WebElement FlightsPageText;

    public boolean flightsPageDisplayed(){
        return isDisplayed(FlightsPageText);
    }
}
