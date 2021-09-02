package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FAQPage extends BasePage{

    public FAQPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[text()=\"FAQ\"]")
    WebElement FAQTextInFaqPage;

    public boolean faqPageGetsLoaded(){
        return isDisplayed(FAQTextInFaqPage);
    }
}
