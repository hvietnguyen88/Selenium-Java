package herokutest;

import herokupages.DropdownMultiSelectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownMultiSelectTest {
    WebDriver driver;
    DropdownMultiSelectPage dropdownMultiSelectPage;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        dropdownMultiSelectPage = new DropdownMultiSelectPage(driver);
        dropdownMultiSelectPage.openPage();
    }

//    @Test
//    void successfullySelectAllOptions() {
//        List<String> expected = dropdownMultiSelectPage.getAllOptions();
//        dropdownMultiSelectPage.selectAllOptions();
//        List<String> actual = dropdownMultiSelectPage.getSelectedOptions();
//        Assert.assertEqualsNoOrder(actual.toArray(), expected.toArray());
//        driver.quit();
//    }

    @Test
    void successfullySelectMultiOptions() {
        String[] expected = {"Green", "Red", "Blue"};
        dropdownMultiSelectPage.selectMultiOptions(expected);
        List<String> actual = dropdownMultiSelectPage.getSelectedOptions();
        Assert.assertEqualsNoOrder(actual.toArray(), expected);
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }

    //    /**
//     * TC: AbleToSelectMultiOPtions
//     * 1. Open browser.
//     * 2. Navigate to <a href="https://demoqa.com/select-menu">...</a>.
//     * 3. Select Green and Red in Multiselect dropdown.
//     * 4. Verify:
//     *   *  - Green and Red are selected.
//     */
//    @Test
//    void successfullySelectMultiOptions() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://demoqa.com/select-menu");
//
//        driver.findElement(By.id("react-select-4-input")).click();
//        driver.findElement(By.xpath("//div[text()='Green']")).click();
//        driver.findElement(By.xpath("//div[text()='Red']")).click();
//        driver.findElement(By.xpath("//*[contains(text(),'Multiselect drop down')]")).click();
//
//        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Green']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Red']")).isDisplayed());
//
//        driver.quit();
//    }

}
