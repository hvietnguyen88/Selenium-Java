package herokutest.pages;

import heroku.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TablePage {
    WebDriver driver;
    List<Person> personList = new ArrayList<>();

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/tables");
        getTable();
    }

    private void getTable() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (WebElement row : rows) {
            String[] cells = row.getText().split(" ");
            Person person = new Person();
            person.setLastName(cells[0]);
            person.setFirstName(cells[1]);
            person.setDue(cells[3]);
            personList.add(person);
//            personList.add(new Person(cells[0], cells[1], cells[3]));
        }
    }

    private Double getMaxDue() {
        return personList
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .get()
                .getDue();
    }

    private Double getMinDue() {
        return personList
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .get()
                .getDue();
    }

    public List<String> getMaxDuePersons() {
        return personList
                .stream()
                .filter(person -> person.getDue().equals(getMaxDue()))
                .map(Person::getFullName)
                .toList();
    }

    public List<String> getMinDuePersons() {
        return personList
                .stream()
                .filter(person -> person.getDue().equals(getMinDue()))
                .map(Person::getFullName)
                .toList();
    }
}
