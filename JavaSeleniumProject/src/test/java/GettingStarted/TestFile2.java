package GettingStarted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestFile2 {

    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://eaapp.somee.com");

        LogIn(driver);
        createEmployee(driver);
        searchEmployee(driver);

//        while (true) {
//            searchEmployee(driver); // Refresh the table results
//
//            // Check if any row contains "Sora"
//            // Better locator: finds the <span> containing 'Sora' in the table
//            List<WebElement> results = driver.findElements(By.xpath("//table//span[contains(text(), 'Sora')]"));
//
//            if (results.size() > 0) {
//                System.out.println("Sora found. Proceeding with deletion...");
//                performDeletion(driver);
//            } else {
//                System.out.println("No more instances of Sora found.");
//                break; // Exit the loop when no results are left
//            }
//        }



        //driver.quit();
        System.out.println("The automation has finished Exiting...");
    }

    public static void LogIn(WebDriver driver){

        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebElement userName = driver.findElement(By.id("UserName"));
        userName.sendKeys("admin");

        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys("password");

        WebElement signIn= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/button"));
        signIn.click();


    }

    public static void createEmployee(WebDriver driver){
        WebElement viewEmployees = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[4]/div[1]/div[1]/a"));
        viewEmployees.click();

        driver.findElement(By.xpath("/html/body/div[1]/main/form/a")).click();

        WebElement dropdownElement = driver.findElement(By.id("Grade"));

        // Step 2: Instantiate the Select class
        Select select = new Select(dropdownElement);
        select.selectByContainsVisibleText("Junior");

        driver.findElement(By.id("Salary")).sendKeys("2000");
        driver.findElement(By.id("DurationWorked")).sendKeys("24");
        driver.findElement(By.id("Name")).sendKeys("Sora");
        driver.findElement(By.id("Email")).sendKeys("Sora@mail.com");
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[2]/form/div[4]/button")).click();

    }

    public static void searchEmployee(WebDriver driver){
        driver.findElement(By.name("searchTerm")).sendKeys("sora");
        driver.findElement(By.xpath("/html/body/div[1]/main/form/div/button")).click();
    }

}





