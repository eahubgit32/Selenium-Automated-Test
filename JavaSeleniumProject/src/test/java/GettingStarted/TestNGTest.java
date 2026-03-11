package GettingStarted;

import model.CreateEmployee;
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

    //@Parameters({"UserName", "Password"})
    @Test(dataProvider = "CreateEmployeeWithCustomData")
    public void testWithDataProviderWithCustomType(CreateEmployee createEmployee){

        Homepage homepage = new Homepage(driver);

        var loginPage = homepage.clickLogin();
        homepage = loginPage.performLogin("admin", "password");

        // 2. Go to Employee List (Assume clickEmployeeList returns EmployeeListPage)
        var employeeListPage = homepage.clickEmployeeList();

        // 3. Checking if the name is not present in the EmployeeList
        var deletionOfEmployee = employeeListPage.clickSearchOfEmployeeButton();
        deletionOfEmployee.performDeletion(createEmployee.getName());
        System.out.println("Deleted an Account...");
        System.out.println("Performing Creation of an Account...");

        // 4. Creating Employee Action
        var createEmployeePage = employeeListPage.clickCreationOfNewEmployeeButton();
        createEmployeePage.performEmployeeCreation(createEmployee.getName(), createEmployee.getDurationWorked(), createEmployee.getEmail(), createEmployee.getAge(), createEmployee.getSalary(), createEmployee.getRole());

    }

    @DataProvider(name = "CreateEmployee")
    public static Object[][] createEmployee(){
        return new Object[][]{
                new Object[]{
                        "test", "23", "TestUser@mail.com", "25", "30022", "Junior"
                }
        };
    }

    @DataProvider(name = "CreateEmployeeWithCustomData")
    public static CreateEmployee[] createEmployeeDataWithCustomType(){
        return new CreateEmployee[]{
                new CreateEmployee("FromCustomData", "16", "CustomData@mail.com", "25000", "Junior", "23")
        };
}




    @AfterTest
    public void afterTest(){
        driver.quit();
        System.out.println("The automation has finished Exiting...");
    }
}
