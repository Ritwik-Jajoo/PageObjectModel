package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form//div[@class=\"input-box\"]//input")
    List<WebElement> LoginDetails;

    @FindBy(xpath = "(//button[@type=\"submit\"])[1]")
    WebElement LoginButton1;

    @FindBy(xpath = " (//a[text()=\" Dashboard\"])[2]")
    WebElement Dashboard;

    @FindBy(xpath = "//div[@class=\"modal-content col align-self-center\"]")
    WebElement LoginBox;

    public ArrayList loginDetailsToBeEntered() {
        List<String> details = new ArrayList<>();
        details.add(properties.getProperty("email"));
        details.add(properties.getProperty("password"));
        return (ArrayList) details;
    }

    public boolean isLoginBoxDisplayed() {
        return isDisplayed(LoginBox);
    }

    public void enterLoginDetails() {
        List<String> details = loginDetailsToBeEntered();
        enterTextForListOfWebElements(LoginDetails, details);
    }

    public void clickOnLoginButtonOnLoginPage() {
        scrollTillTheElementIsVisible(LoginButton1);
        click(LoginButton1);
    }

    public boolean isDashboardDisplayed() {
        return isDisplayed(Dashboard);
    }
}
