package herokupages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropPage {

    WebDriver driver;

    public DragDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    private WebElement findColumn(String id) {
        return driver.findElement(By.id(id));
    }

    public void dragDropColumn() {
        WebElement a = findColumn("column-a");
        WebElement b = findColumn("column-b");
        new Actions(driver).dragAndDrop(a, b).perform();
    }

    public String getColumnText(String id) {
        return findColumn(id).getText();
    }
}