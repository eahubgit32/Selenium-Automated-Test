package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateEmployeePage {

    private WebDriver driver;


    public CreateEmployeePage(WebDriver driver){
        this.driver = driver;
    }

    private By iDentification = By.id("Grade");


//    public Homepage perfromLogin(String userName, String password){
//        driver.findElement(txtUsername).sendKeys(userName);
//        driver.findElement(txtPassword).sendKeys(password);
//        driver.findElement(btnLogin).click();
//        return new Homepage(driver);
//    }

    public LoginPage performDropdown(String locator, String dropDownText){
        Select select = new Select(driver.findElement(By.id(locator)));
        select.selectByContainsVisibleText(dropDownText);
        return new LoginPage(driver);
    }

    public LoginPage performEmployeeCreation(By locator, String value){
        driver.findElement(locator).sendKeys(value);
        return new LoginPage(driver);
    }

    public LoginPage performClick(By locator){
        driver.findElement(locator).click();
        return new LoginPage(driver);
    }



}
