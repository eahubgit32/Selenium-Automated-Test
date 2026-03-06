package extension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UIElementExtension {


    public static void performSelection(WebDriver driver, By locator, String value){

        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);

    }

    public static void performClick(WebDriver driver, By locator){
        driver.findElement(locator).click();
    }

    public static void performSendKeys(WebDriver driver, By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    public static void performDropdownSelectionByText(WebDriver driver, By locator, String dropDownText){
        Select select = new Select(driver.findElement(locator));
        select.selectByContainsVisibleText(dropDownText);

    }

    public static void performDropdownSelectionByValue(WebDriver driver, By locator, String dropDownValue){
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(dropDownValue);
    }

    public static void performDropdownSelectionByIndex(WebDriver driver, By locator, int index){
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }

    public static boolean isElementPresent(WebDriver driver, By locator) {
        return !driver.findElements(locator).isEmpty();
    }

}
