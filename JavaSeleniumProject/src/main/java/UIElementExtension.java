import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
