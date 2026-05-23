package herokutest;

import herokupages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.openPage();
    }

    @Test
    void successfullyWithValidCredentials() {
        loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(loginPage.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }

//    @Test
//    void successfullyWithValidCredentials() {
//        WebDriver driver = new EdgeDriver();
//        driver.get("https://the-internet.herokuapp.com/login");
//
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
//        driver.quit();
//    }
}
