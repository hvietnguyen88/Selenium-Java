package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {
    @Test
    void successfullySelectDropdownOptions(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");
        WebElement option1 = driver.findElement(By.xpath("//option[.='Option 1']"));
        Assert.assertTrue(option1.isSelected());

        dropdown.selectByVisibleText("Option 2");
        WebElement option2 = driver.findElement(By.xpath("//option[.='Option 2']"));
        Assert.assertTrue(option2.isSelected());

        driver.quit();
    }
}
