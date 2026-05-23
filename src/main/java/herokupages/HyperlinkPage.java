package herokupages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HyperlinkPage {
    WebDriver driver;

    public HyperlinkPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickLink(String text) {
        driver.findElement(By.linkText(text)).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
