package herokutest;

import heroku.Person;
import herokupages.TablePage;
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
    void successfullyValidateMaxDuePersonsNew() {
        Assert.assertEquals(tablePage.getMaxDuePersons(), List.of("Jason Doe"));
    }

    @Test
    void successfullyValidateMinDuePersonsNew() {
        Assert.assertEquals(tablePage.getMinDuePersons(), List.of("John Smith", "Tim Conway"));
    }

//    @Test
//    void successfullyValidateMaxDuePerons() {
//        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
//        List<Person> personList = new ArrayList<>();
//        for (WebElement row : rows) {
//            String[] cells = row.getText().split(" ");
//            personList.add(new Person(cells[0], cells[1], cells[3]));
//        }
//        Double maxDue = personList.stream().max(Comparator.comparing(Person::getDue)).get().getDue();
//        List<String> maxDuePersons = personList
//                .stream()
//                .filter(person -> person.getDue().equals(maxDue))
//                .map(Person::getFullName)
//                .toList();
//        Assert.assertEquals(maxDuePersons, List.of("Jason Doe"));
//    }
//
//    @Test
//    void successfullyValidateMinDuePersons() {
//        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
//        List<Person> personList = new ArrayList<>();
//        for (WebElement row : rows) {
//            String[] cells = row.getText().split(" ");
//            personList.add(new Person(cells[0], cells[1], cells[3]));
//        }
//        Double minDue = personList.stream().min(Comparator.comparing(Person::getDue)).get().getDue();
//        List<String> minDuePersons = personList
//                .stream()
//                .filter(person -> person.getDue().equals(minDue))
//                .map(Person::getFullName)
//                .toList();
//        Assert.assertEquals(minDuePersons, List.of("John Smith", "Tim Conway"));
//    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }
}
