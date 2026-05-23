package herokutest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import herokupages.DragDropPage;

public class DragDropTest {
    WebDriver driver;
    DragDropPage page;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        page = new DragDropPage(driver);
        page.openPage();
    }

    @Test
    void testDragDrop() {
        page.dragDropColumn();
        Assert.assertEquals(page.getColumnText("column-a"), "B");
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }

    //    @Test
//    void testDragDrop() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
//
//        Actions actions = new Actions(driver);
//
//        WebElement objA = driver.findElement(By.id("column-a"));
//        WebElement objB = driver.findElement(By.id("column-b"));
//        actions.dragAndDrop(objA, objB).perform();
//
//        Assert.assertEquals(objA.getText(), "B");
//    }

}