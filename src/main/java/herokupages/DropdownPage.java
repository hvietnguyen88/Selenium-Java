package herokupages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    WebDriver driver;

    // Constructor
    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By dropdown = By.id("dropdown");

    // Open page
    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    // Select Dropdown box
    private Select selectDropdownBox() {
        return new Select(driver.findElement(dropdown));
    }

    public void selectOption(String text) {
        selectDropdownBox().selectByVisibleText(text);
    }

    public boolean isOptionSelected(String text) {
        return driver.findElement(By.xpath("//option[.='" + text + "']")).isSelected();
    }
}