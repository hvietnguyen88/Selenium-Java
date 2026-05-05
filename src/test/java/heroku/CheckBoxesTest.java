package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTest {
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
    void successfullyCheckUncheckCheckboxes() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        checkCheckBox(checkbox1);
        Assert.assertTrue(checkbox1.isSelected());
        Thread.sleep(1000);

        uncheckCheckBox(checkbox2);
        Assert.assertFalse(checkbox2.isSelected());
        Thread.sleep(1000);

        driver.quit();
    }
}
