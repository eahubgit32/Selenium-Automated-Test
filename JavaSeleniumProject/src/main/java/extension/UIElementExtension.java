package extension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UIElementExtension {


    public static void performSelection(WebElement locator, String value){

        locator.click();
        locator.clear();
        locator.sendKeys(value);

    }

    public static void performClick(WebElement locator){
        locator.click();
    }

    public static void performSendKeys(WebElement locator, String value){
        locator.sendKeys(value);
    }

    public static void performDropdownSelectionByText(WebElement locator, String dropDownText){
        Select select = new Select((locator));
        select.selectByContainsVisibleText(dropDownText);

    }

    public static void performDropdownSelectionByValue(WebElement locator, String dropDownValue){
        Select select = new Select(locator);
        select.selectByValue(dropDownValue);
    }

    public static void performDropdownSelectionByIndex(WebElement locator, int index){
        Select select = new Select(locator);
        select.selectByIndex(index);
    }

    public static boolean isElementPresent(WebDriver driver, By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public static void performClearField(WebElement locator){
        locator.clear();
    }


}
