import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://eaapp.somee.com");
        driver.manage().window().maximize();

        //driver.findElement(By.linkText("/Account/ForgotPassword"));
        //By locator = By.linkText("/Account/ForgotPassword");
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebElement userName = driver.findElement(By.id("UserName"));
        userName.sendKeys("admin");

        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys("password");

        WebElement signIn= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/button"));
        signIn.click();

//        WebElement logOut = driver.findElement(By.xpath("/html/body/header/nav/div/div/ul[2]/li[2]/form/button"));
//        logOut.click();
    }
}