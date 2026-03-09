package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EmployeeListPage {

    private WebDriver driver;


    private By createNewEmployeeButton = By.xpath("/html/body/div[1]/main/form/a");

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateEmployeePage clickCreationOfNewEmployeeButton() {
        driver.findElement(createNewEmployeeButton).click();
        return new CreateEmployeePage(driver);
    }
}








