package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DeletionOfEmployee {


    private WebDriver driver;

    public DeletionOfEmployee(WebDriver driver){
        this.driver = driver;
    }

    private By searchBox = By.name("searchTerm");
    private By searchButton = By.xpath("/html/body/div[1]/main/form/div/button");
    private By deleteButton = By.xpath("/html/body/div[1]/main/div[2]/table/tbody/tr/td[7]/div/a[3]");


    public void cleanUpEmployee(String name) {
        while (true) {
            driver.findElement(searchBox).clear();
            driver.findElement(searchBox).sendKeys(name);
            driver.findElement(searchButton).click();

            try {
                // Re-find the element inside the loop to avoid StaleElement exceptions
                WebElement deleteLink = driver.findElement(deleteButton);
                deleteLink.click();

                // Confirm deletion
                driver.findElement(By.xpath("/html/body/div[1]/main/div/div/form/button")).click();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("Clean up complete: " + name + " is gone.");
                break;
            }
        }
    }
}