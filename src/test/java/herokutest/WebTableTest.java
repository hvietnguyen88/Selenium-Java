package herokutest;

import heroku.WebTableUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {
    @Test
    void successfullyValidateMaxDuePerson() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/tables");
            List<Double> dueValues = WebTableUtils.getDueValues(driver);
            double maxDue = WebTableUtils.getMaxDue(dueValues);
            List<String> maxDuePersons = WebTableUtils.getPersonsByDue(driver, maxDue);

            Assert.assertTrue(maxDuePersons.contains("Doe Jason"));
        } finally {
            driver.quit();
        }
    }

    @Test
    void successfullyValidateMinDuePerson() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/tables");
            List<Double> dueValues = WebTableUtils.getDueValues(driver);
            double minDue = WebTableUtils.getMinDue(dueValues);
            List<String> minDuePersons = WebTableUtils.getPersonsByDue(driver, minDue);

            Assert.assertTrue(minDuePersons.contains("Smith John"));
            Assert.assertTrue(minDuePersons.contains("Conway Tim"));
        } finally {
            driver.quit();
        }
    }
}
