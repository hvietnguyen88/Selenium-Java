package herokupages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage {
    WebDriver driver;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    private WebElement findCheckbox(int index) {
        return driver.findElement(
                By.xpath("//form[@id='checkboxes']/input[" + index + "]")
        );
    }

    public void checkCheckbox(int index) {
        if (!findCheckbox(index).isSelected()) {
            findCheckbox(index).click();
        }
    }

    public void uncheckCheckbox(int index) {
        if (findCheckbox(index).isSelected()) {
            findCheckbox(index).click();
        }
    }

    public boolean isCheckboxSelected(int index) {
        return findCheckbox(index).isSelected();
    }
}