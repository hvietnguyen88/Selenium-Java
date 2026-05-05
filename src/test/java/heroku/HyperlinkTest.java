package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperlinkTest {
    @Test
    void successfullyAccessHyperlinks() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/200");
        Thread.sleep(1000);
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/301");
        Thread.sleep(1000);
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/404");
        Thread.sleep(1000);

    }
}
