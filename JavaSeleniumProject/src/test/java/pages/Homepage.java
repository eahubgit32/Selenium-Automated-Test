package pages;

import extension.UIElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    private WebDriver driver;

    public Homepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //locators Refactored
    @FindBy(linkText = "Login")
    private WebElement linkLogin;

    @FindBy(xpath = "/html/body/div[1]/main/div[1]/div[4]/div[1]/div[1]/a")
    private WebElement linkEmployeeList;

    @FindBy(name = "searchTerm")
    private WebElement employeeListSearchBox;


    public LoginPage clickLogin(){
        UIElementExtension.performClick(linkLogin);
        return new LoginPage(driver);
    }

    public EmployeeListPage clickEmployeeList(){
        UIElementExtension.performClick(linkEmployeeList);
        return new EmployeeListPage(driver);
    }
}