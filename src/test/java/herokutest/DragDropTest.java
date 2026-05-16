package herokutest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest {
    @Test
    void testDragDrop() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions actions = new Actions(driver);

        WebElement objA = driver.findElement(By.id("column-a"));
        WebElement objB = driver.findElement(By.id("column-b"));
        actions.dragAndDrop(objA, objB).perform();

        Assert.assertEquals(objA.getText(), "B");
    }
}
