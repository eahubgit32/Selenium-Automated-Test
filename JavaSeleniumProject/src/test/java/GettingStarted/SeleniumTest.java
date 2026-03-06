package GettingStarted;

import extension.UIElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CreateEmployeePage;
import pages.Homepage;

public class SeleniumTest {

    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://eaapp.somee.com");

//        LogIn(driver);
//        createEmployee(driver);
//        searchEmployee(driver);
//        performDeletion(driver);

        Homepage homepage = new Homepage(driver);

        //Page Navigation Concept
        var loginPage = homepage.clickLogin();
        loginPage.performLogin("admin", "password");

        var employeeListPage = homepage.clickEmployeeList();
        employeeListPage.performEmployeeListPage("/html/body/div[1]/main/div[1]/div[4]/div[1]/div[1]/a");

        var createEmployee = homepage.creationOfNewEmployee();
        createEmployee.performClick(By.xpath("/html/body/div[1]/main/form/a"));
        createEmployee.performEmployeeCreation(By.id("Salary"), "2000");
        createEmployee.performEmployeeCreation(By.id("DurationWorked"), "24");
        createEmployee.performEmployeeCreation(By.id("Name"), "Sora");
        createEmployee.performEmployeeCreation(By.id("Email"), "Sora@mail.com");
        createEmployee.performDropdown("Grade", "Junior");
        createEmployee.performClick(By.xpath("/html/body/div[1]/main/div[2]/div[2]/form/div[4]/button"));

        driver.quit();
        System.out.println("The automation has finished Exiting...");
    }

    public static void LogIn(WebDriver driver){

    UIElementExtension.performClick(driver, By.linkText("Login"));
    UIElementExtension.performSendKeys(driver, By.id("UserName"), "admin");
    UIElementExtension.performSendKeys(driver, By.id("Password"), "password");
    UIElementExtension.performClick(driver, By.xpath("/html/body/div[1]/div/div[2]/form/button"));

    }

    public static void createEmployee(WebDriver driver){

        UIElementExtension.performClick(driver, By.xpath("/html/body/div[1]/main/div[1]/div[4]/div[1]/div[1]/a"));
        UIElementExtension.performClick(driver, By.xpath("/html/body/div[1]/main/form/a"));
        UIElementExtension.performDropdownSelectionByText(driver, By.id("Grade"), "Junior");
        UIElementExtension.performSendKeys(driver, By.id("Salary"), "2000");
        UIElementExtension.performSendKeys(driver, By.id("DurationWorked"), "24");
        UIElementExtension.performSendKeys(driver, By.id("Name"), "Sora");
        UIElementExtension.performSendKeys(driver, By.id("Email"), "Sora@mail.com");
        UIElementExtension.performClick(driver, By.xpath("/html/body/div[1]/main/div[2]/div[2]/form/div[4]/button"));

    }

    public static void searchEmployee(WebDriver driver){

        UIElementExtension.performSendKeys(driver, By.name("searchTerm"), "Sora");
        UIElementExtension.performClick(driver, By.xpath("/html/body/div[1]/main/form/div/button"));

    }

    public static void performDeletion(WebDriver driver){

        UIElementExtension.performClick(driver, By.xpath("/html/body/div[1]/main/div[2]/table/tbody/tr[1]/td[6]/div/a[3]"));
        UIElementExtension.performClick(driver, By.xpath("/html/body/div[1]/main/div/div/form/button"));

    }
}