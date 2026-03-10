package pages;

import extension.UIElementExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //Constructor
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //locators Refactored
    @FindBy(id = "UserName")
    private WebElement txtUsername;

    @FindBy(id = "Password")
    private WebElement txtPassword;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/form/button")
    private WebElement btnLogin;

    public Homepage performLogin(String userName, String password){
        UIElementExtension.performSendKeys(txtUsername, userName);
        UIElementExtension.performSendKeys(txtPassword, password);
        UIElementExtension.performClick(btnLogin);
        return new Homepage(driver);
    }
}

//private By txtUsername = By.id("UserName");
//private By txtPassword = By.id("Password");
//private By btnLogin = By.xpath("/html/body/div[1]/div/div[2]/form/button");
//
//public Homepage performLogin(String userName, String password){
//    driver.findElement(txtUsername).sendKeys(userName);
//    driver.findElement(txtPassword).sendKeys(password);
//    driver.findElement(btnLogin).click();
//    return new Homepage(driver);
//}
