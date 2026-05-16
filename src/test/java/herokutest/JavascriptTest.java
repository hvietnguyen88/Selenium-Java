package herokutest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavascriptTest {
    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void clickForJsAlert() {
        driver.findElement(By.xpath("//button[contains(.,'Click for JS Alert')]")).click();
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "You successfully clicked an alert");
    }

    @Test
    void clickForJsConfirmOK() {
        driver.findElement(By.xpath("//button[contains(.,'Click for JS Confirm')]")).click();
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "You clicked: Ok");
    }

    @Test
    void clickForJsConfirmCancel() {
        driver.findElement(By.xpath("//button[contains(.,'Click for JS Confirm')]")).click();
        driver.switchTo().alert().dismiss();
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "You clicked: Cancel");
    }

    @Test
    void clickForJsPrompt() {
        driver.findElement(By.xpath("//button[contains(.,'Click for JS Prompt')]")).click();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "You entered: Hello");
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
