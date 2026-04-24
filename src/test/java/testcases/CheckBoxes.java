package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxes {
    public static void checkCheckBox(WebElement checkbox) {
        if(!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public static void uncheckCheckBox(WebElement checkbox) {
        if(checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @Test
    void testCheckboxed() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless=new");

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        checkCheckBox(checkbox1);
        Assert.assertTrue(checkbox1.isSelected());
        checkCheckBox(checkbox2);
        Assert.assertTrue(checkbox2.isSelected());

        driver.quit();
    }
}
