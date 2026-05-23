package herokutest;

import herokupages.DropdownPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownTest {
    WebDriver driver;
    DropdownPage dropdownPage;

    @BeforeClass
    void openPage() {
        driver = new ChromeDriver();
        dropdownPage = new DropdownPage(driver);
        dropdownPage.openPage();
    }

    @Test
    void successfullySelectDropdownOptions() {
        String[] options = {"Option 1", "Option 2"};
        for (String option : options) {
            dropdownPage.selectOption(option);
            Assert.assertTrue(dropdownPage.isOptionSelected(option));
        }
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }

//    @Test
//    void successfullySelectDropdownOptions(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/dropdown");
//
//        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
//        dropdown.selectByVisibleText("Option 1");
//        WebElement option1 = driver.findElement(By.xpath("//option[.='Option 1']"));
//        Assert.assertTrue(option1.isSelected());
//
//        dropdown.selectByVisibleText("Option 2");
//        WebElement option2 = driver.findElement(By.xpath("//option[.='Option 2']"));
//        Assert.assertTrue(option2.isSelected());
//
//        driver.quit();
//    }
}
