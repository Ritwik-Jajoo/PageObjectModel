package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage extends BasePage {

    public AboutUsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//h3[text()=\"About Us\"]")
    WebElement AboutUsTextInAboutUsPage;

    public boolean aboutUsPageGetsLoaded(){
        return isDisplayed(AboutUsTextInAboutUsPage);
    }
}
