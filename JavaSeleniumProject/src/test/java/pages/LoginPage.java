package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //Constructor
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By txtUsername = By.id("UserName");
    private By txtPassword = By.id("Password");
    private By btnLogin = By.xpath("/html/body/div[1]/div/div[2]/form/button");

    public Homepage performLogin(String userName, String password){
        driver.findElement(txtUsername).sendKeys(userName);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
        return new Homepage(driver);
    }

}
