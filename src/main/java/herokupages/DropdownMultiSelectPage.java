package herokupages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

import static common.Browsers.*;

public class DropdownMultiSelectPage {

    By dropdownBox = By.id("react-select-4-input");
    By selectedValues = By.xpath("//div[contains(@class,'multiValue')]");
    By dropdownBoxTitle = By.xpath("//*[contains(text(),'Multiselect drop down')]");

    public void openPage() {
        visit("https://demoqa.com/select-menu");
    }

    private void openDropdownBox() {
        click(dropdownBox);
    }

    private void closeDropdownBox() {
        click(dropdownBoxTitle);
    }

    public void selectMultiOptions(String[] values) {
        openDropdownBox();
        for (String value : values) {
            By option = RelativeLocator
                    .with(By.xpath(String.format("//div[.='%s']",value)))
                    .below(dropdownBoxTitle);
            click(option);
        }
        closeDropdownBox();
    }

    public List<String> getSelectedOptions() {
        return all(selectedValues).stream().map(WebElement::getText).toList();
    }

    public void removeOptions(String[] options) {
        for (String option : options) {
            click(By.cssSelector(String.format("[aria-label=\"Remove %s\"]",option)));
        }
    }
}
