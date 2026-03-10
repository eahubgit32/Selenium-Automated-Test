package pages;

import extension.UIElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DeletionOfEmployee {

    private WebDriver driver;
    private WebDriverWait wait;

    // Use Relative Locators for stability
//    private By searchBox = By.name("searchTerm");
//    private By searchBtn = By.cssSelector("input[type='submit'], .btn-default, button");
//    private By deleteLinkInTable = By.xpath("//a[contains(@href, 'Delete')]");
//    private By confirmDeleteBtn = By.cssSelector("input[type='submit'], .btn-danger");

    public DeletionOfEmployee(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "searchTerm")
    private WebElement searchBox;

    @FindBy(css = ".btn-search")
    private WebElement searchBtn;

    @FindBy(css = ".btn-del")
    private WebElement deleteLinkInTable;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/form/button")
    private WebElement confirmDeleteBtn;
//    @FindBy(css = )

    public void performDeletion(String name) {
        while (true) {
            try {
                // RE-INITIALIZE elements at the start of every loop to prevent Stale Elements
                PageFactory.initElements(driver, this);

                wait.until(ExpectedConditions.visibilityOf(searchBox));
                searchBox.clear();
                searchBox.sendKeys(name);
                searchBtn.click();

                // Try to find the delete link.
                // If search returns no results, this will throw NoSuchElementException
                wait.until(ExpectedConditions.elementToBeClickable(deleteLinkInTable)).click();

                // Handle the confirmation page
                wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn)).click();

                System.out.println("Deleted one instance of: " + name);

                // Wait for the list to reload before looping again
                wait.until(ExpectedConditions.urlContains("Employee"));

            } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
                // This is the ONLY way we should exit the loop
                System.out.println("Clean up complete: " + name + " is no longer found.");
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                // If elements go stale, just continue the loop to re-init them
                continue;
            }
        }
    }
}


//public DeletionOfEmployee(WebDriver driver){
//    this.driver = driver;
//}
//
//private By searchBox = By.name("searchTerm");
//private By searchButton = By.xpath("/html/body/div[1]/main/form/div/button");
//private By deleteButton = By.xpath("/html/body/div[1]/main/div[2]/table/tbody/tr/td[7]/div/a[3]");
//
//
//public void cleanUpEmployee(String name) {
//    while (true) {
//        driver.findElement(searchBox).clear();
//        driver.findElement(searchBox).sendKeys(name);
//        driver.findElement(searchButton).click();
//
//        try {
//            // Re-find the element inside the loop to avoid StaleElement exceptions
//            WebElement deleteLink = driver.findElement(deleteButton);
//            deleteLink.click();
//
//            // Confirm deletion
//            driver.findElement(By.xpath("/html/body/div[1]/main/div/div/form/button")).click();
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            System.out.println("Clean up complete: " + name + " is gone.");
//            break;
//        }
//    }
//}