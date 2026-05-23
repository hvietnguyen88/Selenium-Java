package herokutest;

import herokupages.HyperlinkPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HyperlinkTest {
    WebDriver driver;
    HyperlinkPage hyperlinkPage;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        hyperlinkPage = new HyperlinkPage(driver);
        hyperlinkPage.openPage();
    }

    @Test
    void successfullyAccessHyperlinks() {
        String[] statusCodes = {"200", "301", "404", "500"};
        for (String code : statusCodes) {
            hyperlinkPage.clickLink(code);
            Assert.assertEquals(hyperlinkPage.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/" + code);
            hyperlinkPage.clickLink("here");
        }
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }

//    @Test
//    void successfullyAccessHyperlinks(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/status_codes");
//
//        driver.findElement(By.linkText("200")).click();
//        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/200");
//        driver.findElement(By.linkText("here")).click();
//
//        driver.findElement(By.linkText("301")).click();
//        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/301");
//        driver.findElement(By.linkText("here")).click();
//
//        driver.findElement(By.linkText("404")).click();
//        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/404");
//        driver.findElement(By.linkText("here")).click();
//
//        driver.findElement(By.linkText("500")).click();
//        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/500");
//        driver.findElement(By.linkText("here")).click();
//
//        driver.quit();
//    }
}
