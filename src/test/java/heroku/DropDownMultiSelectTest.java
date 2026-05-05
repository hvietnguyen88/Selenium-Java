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

        driver.findElement(By.xpath("//div[contains(text(), 'Select...')]")).click();
        driver.findElement(By.xpath("//div[contains(text(), 'Green')]")).click();
        driver.findElement(By.xpath("//div[contains(text(), 'Red')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Green')]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Red')]")).isSelected());


    }

}
