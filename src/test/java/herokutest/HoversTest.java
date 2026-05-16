package herokutest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTest {
    @Test
    void avatarInfo() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement avatar1 = driver.findElement(By.xpath("//div[@id='content']//div[@class='figure'][1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(avatar1).perform();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//div[@class='figure'][1]//h5")).isDisplayed());

    }
}
