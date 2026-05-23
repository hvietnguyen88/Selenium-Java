package herokupages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    private void enterAccount(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    private void clickSubmit(By locator) {
        driver.findElement(locator).click();
    }

    public void login(String username, String password) {
        enterAccount(By.id("username"), username);
        enterAccount(By.id("password"), password);
        clickSubmit(By.xpath("//button[@type='submit']"));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
