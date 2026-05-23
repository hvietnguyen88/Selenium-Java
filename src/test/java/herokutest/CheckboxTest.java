package herokutest;

import herokupages.CheckboxesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckboxTest {
    WebDriver driver;
    CheckboxesPage page;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        page = new CheckboxesPage(driver);
        page.openPage();
    }

    @Test
    void successfullyCheckUncheckCheckboxes() {
        // Check checkbox 1
        page.checkCheckbox(1);
        Assert.assertTrue(page.isCheckboxSelected(1));

        // Uncheck checkbox 2
        page.uncheckCheckbox(2);
        Assert.assertFalse(page.isCheckboxSelected(2));
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }

    //    public static void checkCheckbox(WebElement checkbox) {
//        if(!checkbox.isSelected()) {
//            checkbox.click();
//        }
//    }
//
//    public static void uncheckCheckbox(WebElement checkbox) {
//        if(checkbox.isSelected()) {
//            checkbox.click();
//        }
//    }
//
//    @Test
//    void successfullyCheckUncheckCheckboxes() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/checkboxes");
//
//        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
//        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
//
//        checkCheckbox(checkbox1);
//        Assert.assertTrue(checkbox1.isSelected());
//        Thread.sleep(1000);
//
//        uncheckCheckbox(checkbox2);
//        Assert.assertFalse(checkbox2.isSelected());
//        Thread.sleep(1000);
//
//        driver.quit();
//    }
}