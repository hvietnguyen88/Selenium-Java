package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownMultiSelectTest {
    /**
     * TC: AbleToSelectMultiOPtions
     * 1. Open browser.
     * 2. Navigate to https://demoqa.com/select-menu.
     * 3. Select Green and Red in Multiselect dropdown.
     * 4. Verify:
     *   *  - Green and Red are selected.
     */
    @Test
    void ableToSelectMultiOptions() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");

        driver.findElement(By.id("react-select-4-input")).click();
        driver.findElement(By.xpath("//div[text()='Green']")).click();
        driver.findElement(By.xpath("//div[text()='Red']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Multiselect drop down')]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Green']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Red']")).isDisplayed());

        driver.quit();
    }

}
