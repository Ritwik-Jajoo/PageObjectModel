package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils extends Setup {

    public static boolean isDisplayed(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()) {
                flag = true;
            }
        } catch (NoSuchElementException e) {
            flag = false;
        }
        return flag;
    }

    public static boolean areDisplayed(List<WebElement> elements) {
        boolean flag = false;
        for (WebElement e : elements) {
            if (isDisplayed(e))
                flag = true;
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void holdExecution(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement wait(WebElement e) {
        return wait.until(ExpectedConditions.visibilityOf(e));
    }

    public static void click(WebElement element) {
        try {
            wait(element);
            element.click();
        } catch (StaleElementReferenceException e) {
            holdExecution(10);
            element.click();
        } catch (NoSuchElementException e) {
            holdExecution(10);
            element.click();
        } catch (ElementClickInterceptedException e) {
            holdExecution(10);
            element.click();
        }
    }

    public static void enterText(WebElement element, String text) {
        try {
            wait(element).clear();
            element.sendKeys(text);
        } catch (StaleElementReferenceException e) {
            holdExecution(10);
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            holdExecution(10);
            element.sendKeys(text);
        }catch (InvalidElementStateException e){
            holdExecution(10);
            element.sendKeys(text);
        }
    }

    public void handleDropdownOfSelectTagUsingValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void enterTextForListOfWebElements(List<WebElement> elements, List<String> details) {
        for (int i = 0; i < details.size(); i++) {
            enterText(elements.get(i), details.get(i));
        }
    }

    public void scrollTillTheElementIsVisible(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false)", element);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1600)");
    }

    public void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public static void enterTextUsingKeys(WebElement element, Keys key) {
        try {
            wait(element).clear();
            element.sendKeys(key);
        } catch (StaleElementReferenceException e) {
            holdExecution(10);
            element.sendKeys(key);
        } catch (NoSuchElementException e) {
            holdExecution(10);
            element.sendKeys(key);
        }catch (InvalidElementStateException e){
            holdExecution(10);
            element.sendKeys(key);
        }
    }

    public static String timestamp(){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(timestamp);
    }
}
