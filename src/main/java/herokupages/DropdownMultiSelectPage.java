package herokupages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropdownMultiSelectPage {
    WebDriver driver;

    // Constructor
    public DropdownMultiSelectPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By dropdownBox = By.id("react-select-4-input");
    By allOptions = By.xpath("//div[contains(@class,'option')]");
    By singleOption(String text) {return By.xpath("//div[text()='" + text + "']");}
    By selectedValues = By.xpath("//div[contains(@class,'multiValue')]");
    By dropdownBoxTitle = By.xpath("//*[contains(text(),'Multiselect drop down')]");

    // Actions
    public void openPage() {
        driver.get("https://demoqa.com/select-menu");
    }

    private void openDropdownBox() {
        driver.findElement(dropdownBox).click();
    }

    private void closeDropdownBox() {
        driver.findElement(dropdownBoxTitle).click();
    }

    public List<String> getAllOptions() {
        openDropdownBox();
        List<WebElement> elements = driver.findElements(allOptions);
        List<String> allOptions = new ArrayList<>();
        for (WebElement element : elements) {
            allOptions.add(element.getText());
        }
        closeDropdownBox();
        return allOptions;
    }

    public void selectAllOptions() {
        openDropdownBox();
        for (WebElement option : driver.findElements(allOptions)) {
            option.click();
        }
        closeDropdownBox();
    }

    public void selectMultiOptions(String... values) {
        openDropdownBox();
        for (String value : values) {
            driver.findElement(singleOption(value)).click();
        }
        closeDropdownBox();
    }

    public List<String> getSelectedOptions() {
        List<WebElement> elements = driver.findElements(selectedValues);
        List<String> selectedOptions = new ArrayList<>();
        for (WebElement element : elements) {
            selectedOptions.add(element.getText());
        }
        return selectedOptions;
    }
}
