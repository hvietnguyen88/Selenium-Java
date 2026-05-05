package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTestNG {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test(description = "Verify and Toggle Checkbox states")
    public void testCheckboxes() {
        // Selectors derived from the DOM structure
        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes input[type='checkbox']:nth-of-type(1)"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkboxes input[type='checkbox']:nth-of-type(2)"));

        // 1. Assert initial states as per the screenshot
        // TestNG Assertions: Assert.assertEquals(actual, expected) or Assert.assertTrue(condition)
        Assert.assertFalse(checkbox1.isSelected(), "Checkbox 1 should be unchecked initially.");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 should be checked initially.");

        // 2. Perform action: Toggle the first checkbox
        checkbox1.click();

        // 3. Verify the change
        Assert.assertTrue(checkbox1.isSelected(), "Checkbox 1 was not checked after the click.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}