import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestFile {

    public static void main(String[] args) {
        // Necessary for your specific Linux environment issue
        System.setProperty("java.io.tmpdir", "/home/aw6/sel_tmp");

        WebDriver driver = new FirefoxDriver();
        // Set a wait timer (up to 10 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.navigate().to("http://eaapp.somee.com");
            driver.manage().window().maximize();

            // 1. ACT: Perform Login
            driver.findElement(By.linkText("Login")).click();
            driver.findElement(By.id("UserName")).sendKeys("admin");
            driver.findElement(By.id("Password")).sendKeys("password");

            // Using a simpler CSS selector for the login button
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // 2. OBSERVE: Wait for the Log off button to appear
            WebElement logOffButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log off")));

            // 3. ASSERT: Pass/Fail based on behavior
            if (logOffButton.isDisplayed()) {
                System.out.println("TEST PASSED: Successful login. User is on the dashboard.");
            } else {
                System.out.println("TEST FAILED: Login button not found.");
            }

        } catch (Exception e) {
            System.out.println("TEST FAILED: An error occurred during the scenario: " + e.getMessage());
        } finally {
            // Always quit to free up Linux memory
            driver.quit();
        }
    }
}