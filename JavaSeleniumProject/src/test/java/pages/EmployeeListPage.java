package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage {

    private WebDriver driver;

    public EmployeeListPage(WebDriver driver){
        this.driver = driver;
    }

    public EmployeeListPage performEmployeeListPage(String text){
        driver.findElement(By.xpath(text));
        return new EmployeeListPage(driver);
    }
}

