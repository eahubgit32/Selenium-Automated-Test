package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateEmployeePage {

    private WebDriver driver;


    public CreateEmployeePage(WebDriver driver){
        this.driver = driver;
    }

    //Locator
    private By createEmployeeButton = By.xpath("/html/body/div[1]/main/div[2]/div[2]/form/div[4]/button");

    //Action Method
    public void performDropdown(String locator, String dropDownText){
        Select select = new Select(driver.findElement(By.id(locator)));
        select.selectByContainsVisibleText(dropDownText);
    }

    public void performEmployeeCreation(String locator, String value){
        driver.findElement(By.id(locator)).sendKeys(value);
    }

    public void performClick(){
        driver.findElement(createEmployeeButton).click();
    }

}
