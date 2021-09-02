package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"col-lg-12 mx-auto responsive--column-l\"]")
    WebElement MultipleFilterOptionsContainer;

    public boolean homePageDisplayed(){
        return isDisplayed(MultipleFilterOptionsContainer);
    }
}
