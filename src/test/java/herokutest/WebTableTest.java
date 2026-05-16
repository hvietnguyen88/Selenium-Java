package herokutest;

import heroku.Person;
import heroku.WebTableUtils;
import herokutest.pages.TablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebTableTest {
    WebDriver driver;
    TablePage tablePage;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        tablePage = new TablePage(driver);
        tablePage.open();
    }
    @Test
    void successfullyValidateMaxDuePersonNew() {
        Assert.assertEquals(tablePage.getMaxDuePersons(), List.of("Jason Doe"));
    }

    @Test
    void successfullyValidateMinDuePersonNew() {
        Assert.assertEquals(tablePage.getMinDuePersons(), List.of("John Smith", "Tim Conway"));
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }

//    @Test
//    void successfullyValidateMaxDuePerson() {
//        WebDriver driver = new ChromeDriver();
//        try {
//            driver.get("https://the-internet.herokuapp.com/tables");
//            List<Double> dueValues = WebTableUtils.getDueValues(driver);
//            double maxDue = WebTableUtils.getMaxDue(dueValues);
//            List<String> maxDuePersons = WebTableUtils.getPersonsByDue(driver, maxDue);
//
//            Assert.assertTrue(maxDuePersons.contains("Doe Jason"));
//        } finally {
//            driver.quit();
//        }
//    }
//
//    @Test
//    void successfullyValidateMinDuePerson() {
//        WebDriver driver = new ChromeDriver();
//        try {
//            driver.get("https://the-internet.herokuapp.com/tables");
//            List<Double> dueValues = WebTableUtils.getDueValues(driver);
//            double minDue = WebTableUtils.getMinDue(dueValues);
//            List<String> minDuePersons = WebTableUtils.getPersonsByDue(driver, minDue);
//
//            Assert.assertTrue(minDuePersons.contains("Smith John"));
//            Assert.assertTrue(minDuePersons.contains("Conway Tim"));
//        } finally {
//            driver.quit();
//        }
//    }
}
