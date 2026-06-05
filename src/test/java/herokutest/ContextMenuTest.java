package herokutest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ContextMenuTest {
    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }

    @Test
    void successfullyRightClickOnSquareBox() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        driver.switchTo().alert().accept();
        captureScreenshot("successfullyRightClickOnSquareBox");
    }

    private void captureScreenshot(String testcaseName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", testcaseName, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }
}
