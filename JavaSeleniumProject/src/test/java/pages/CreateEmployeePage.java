package pages;

import extension.UIElementExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateEmployeePage {

    private WebDriver driver;


    public CreateEmployeePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locator
    @FindBy(id = "Name")
    private WebElement txtUsername;

    @FindBy(id = "Age")
    private WebElement txtAge;

    @FindBy(id = "DurationWorked")
    private WebElement txtDurationWorked;

    @FindBy(id = "Salary")
    private WebElement txtSalary;

    @FindBy(id = "Email")
    private WebElement txtEmail;

    @FindBy(xpath = "/html/body/div[1]/main/div[2]/div[2]/form/div[4]/button")
    private WebElement btnCreate;

    @FindBy(id = "Grade")
    private WebElement dropDownGrade;

    public void performEmployeeCreation(String name, String durationWork, String email, String age, String salary, String grade){
        UIElementExtension.performSendKeys(txtUsername, name );
        UIElementExtension.performSendKeys(txtDurationWorked, durationWork );
        UIElementExtension.performSendKeys(txtEmail, email );
        UIElementExtension.performSendKeys(txtSalary, salary );
        UIElementExtension.performSendKeys(txtAge, age );
        UIElementExtension.performDropdownSelectionByText(dropDownGrade, grade);
        UIElementExtension.performClick(btnCreate);
        new EmployeeListPage(driver);
    }


}

//    //Locator
//    private By createEmployeeButton = By.xpath("/html/body/div[1]/main/div[2]/div[2]/form/div[4]/button");
//
//    //Action Method
//    public void performDropdown(String locator, String dropDownText){
//        Select select = new Select(driver.findElement(By.id(locator)));
//        select.selectByContainsVisibleText(dropDownText);
//    }
//
//    public void performEmployeeCreation(String locator, String value){
//        driver.findElement(By.id(locator)).sendKeys(value);
//    }
//
//    public void performClick(){
//        driver.findElement(createEmployeeButton).click();
//    }
