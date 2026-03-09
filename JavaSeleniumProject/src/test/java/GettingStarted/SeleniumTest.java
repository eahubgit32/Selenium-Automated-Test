package GettingStarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CreateEmployeePage;
import pages.DeletionOfEmployee;
import pages.EmployeeListPage;
import pages.Homepage;


public class SeleniumTest {

    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://eaapp.somee.com");

        Homepage homepage = new Homepage(driver);

        //Page Navigation Concept
        // 1. Log in
        var loginPage = homepage.clickLogin();
        loginPage.performLogin("admin", "password");

        // 2. Go to Employee List (Assume clickEmployeeList returns EmployeeListPage)
        EmployeeListPage employeeList = homepage.clickEmployeeList();
        DeletionOfEmployee listPage = homepage.clickSearchEmployeeList();
        listPage.cleanUpEmployee("Sora");

        // 3. Click Create New (This returns CreateEmployeePage)
        CreateEmployeePage createPage = employeeList.clickCreationOfNewEmployeeButton();

        createPage.performDropdown("Grade", "Junior");
        createPage.performEmployeeCreation("Salary", "2000");
        createPage.performEmployeeCreation("DurationWorked", "24");
        createPage.performEmployeeCreation("Age", "24");
        createPage.performEmployeeCreation("Name", "Sora");
        createPage.performEmployeeCreation("Email", "Sora@mail.com");
        createPage.performClick();

        driver.quit();
        System.out.println("The automation has finished Exiting...");
    }
}