package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {

    private WebDriver driver;

    public Homepage(WebDriver driver){
        this.driver = driver;

    }

    private By linkLogin = By.linkText("Login");
    private By linkEmployeeList = By.xpath("/html/body/div[1]/main/div[1]/div[4]/div[1]/div[1]/a");
    private By employeeListSearchBox = By.name("searchTerm");

    public LoginPage clickLogin(){
        driver.findElement(linkLogin).click();
        return new LoginPage(driver);
    }

    public EmployeeListPage clickEmployeeList(){
        driver.findElement(linkEmployeeList).click();
        return new EmployeeListPage(driver);
    }

    public DeletionOfEmployee clickSearchEmployeeList(){
        driver.findElement(employeeListSearchBox);
        return new DeletionOfEmployee(driver);
    }
}
