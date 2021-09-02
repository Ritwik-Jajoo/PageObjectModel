package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermsOfUsePage extends BasePage{

    public TermsOfUsePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[text()=\"Terms of Use\"]")
    WebElement TermsOfUseTextInTermsOfUsePage;

    public boolean termsOfUsePageGetsLoaded(){
        return isDisplayed(TermsOfUseTextInTermsOfUsePage);
    }
}
