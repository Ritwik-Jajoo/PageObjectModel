package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[text()=\"Signup\"]")
    WebElement SignupText;

    @FindBy(xpath = "//div[@class=\"modal-body\"]//div[@class=\"input-box\"]//input")
    List<WebElement> SignupDetails;

    @FindBy(xpath = "//select[@id=\"account_type\"]")
    WebElement Dropdown;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement SignupButton1;

    @FindBy(xpath = "//h5[text()=\"Login\"]")
    WebElement LoginText;

    public ArrayList detailsToBeEntered() {
        List<String> details = new ArrayList<>();
        details.add(properties.getProperty("first_name"));
        details.add(properties.getProperty("last_name"));
        details.add(properties.getProperty("phone"));
        details.add(properties.getProperty("email"));
        details.add(properties.getProperty("password"));
        return (ArrayList) details;
    }

    public boolean isSignupPageLoaded() {
        return isDisplayed(SignupText);
    }

    public void enterSignupDetails() {
        ArrayList<String> details = detailsToBeEntered();
        enterTextForListOfWebElements(SignupDetails, details);

    }

    public void selectCustomerFromDropdown() {
        handleDropdownOfSelectTagUsingValue(Dropdown, "customers");
        holdExecution(2);
    }

    public void clickOnSignupButtonOnSignupPage() {
        scrollDown();
        click(SignupButton1);
        holdExecution(2);
    }

    public boolean isLoginTextDisplayed() {
        return isDisplayed(LoginText);
    }


}
