package GettingStarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.Homepage;

public class TestNGTest {


    private WebDriver driver;


    @BeforeTest
    public void beforeTest(){
        driver = new FirefoxDriver();
        driver.navigate().to("http://eaapp.somee.com");
    }

    @Test
    public void runTest(){

        Homepage homepage = new Homepage(driver);

        var loginPage = homepage.clickLogin();
        homepage = loginPage.performLogin("admin", "password");

        // 2. Go to Employee List (Assume clickEmployeeList returns EmployeeListPage)
        var employeeListPage = homepage.clickEmployeeList();

        // 3. Checking if the name is not present in the EmployeeList
        var deletionOfEmployee = employeeListPage.clickSearchOfEmployeeButton();
        deletionOfEmployee.performDeletion("Sora");
        System.out.println("Deleted an Account...");
        System.out.println("Performing Creation of an Account...");

        // 4. Creating Employee Action
        var createEmployeePage = employeeListPage.clickCreationOfNewEmployeeButton();
        createEmployeePage.performEmployeeCreation("Sora", "24", "sora@mail.com", "24", "2000", "Junior");

    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        System.out.println("The automation has finished Exiting...");
    }
}
