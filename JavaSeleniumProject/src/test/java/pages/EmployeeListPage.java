package pages;

import extension.UIElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeeListPage {

    private WebDriver driver;

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(css = ".btn-create")
    private WebElement btnCreateNew;

    @FindBy(css = ".btn-search")
    private WebElement btnSearch;

    //Action of clicking the Creation of New Employee Button
    public CreateEmployeePage clickCreationOfNewEmployeeButton(){
        UIElementExtension.performClick(btnCreateNew);
        return new CreateEmployeePage(driver);
    }

    //Action of Clicking the Search of Employee Button
    public DeletionOfEmployee clickSearchOfEmployeeButton(){
        UIElementExtension.performClick(btnSearch);
        return new DeletionOfEmployee(driver);
    }
}



//private By createNewEmployeeButton = By.xpath("/html/body/div[1]/main/form/a");
//private By lnkSearch = By.name("searchTerm");
//private By searchButton = By.xpath("/html/body/div[1]/main/form/div/button");
//
//
//public CreateEmployeePage clickCreationOfNewEmployeeButton() {
//    driver.findElement(createNewEmployeeButton).click();
//    return new CreateEmployeePage(driver);
//}
//
//public DeletionOfEmployee searchEmployee(){
//    UIElementExtension.performSendKeys((WebElement) lnkSearch, "Sora");
//    UIElementExtension.performClick(searchButton);
//    return new DeletionOfEmployee(driver);





