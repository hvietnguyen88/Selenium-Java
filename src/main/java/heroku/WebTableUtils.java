package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebTableUtils {
    public static List<Double> getDueValues (WebDriver driver) {
        List<WebElement> table = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        List<Double> dueValues = new ArrayList<>();
        for (WebElement row : table) {
            String dueText = row.findElement(By.xpath("td[4]")).getText();
            double dueValue = Double.parseDouble(dueText.replace("$", ""));
            dueValues.add(dueValue);
        }
        return dueValues;
    }

    public static List<String> getPersonsByDue (WebDriver driver, double targetDue) {
        List<WebElement> table = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        List<String> persons = new ArrayList<>();
        for (WebElement row : table) {
            String dueText = row.findElement(By.xpath("td[4]")).getText();
            double dueValue = Double.parseDouble(dueText.replace("$", ""));
            if (dueValue == targetDue) {
                String lastName = row.findElement(By.xpath("td[1]")).getText();
                String firstName = row.findElement(By.xpath("td[2]")).getText();
                persons.add(lastName + " " + firstName);
            }
        }
        return persons;
    }

    public static double getMaxDue (List<Double> dueValues) {
        double maxDue = Double.NEGATIVE_INFINITY;
        for (double value : dueValues) {
            if (value > maxDue) {
                maxDue = value;
            }
        }
        return maxDue;
    }

    public static double getMinDue (List<Double> dueValues) {
        double minDue = Double.POSITIVE_INFINITY;
        for (double value : dueValues) {
            if (value < minDue) {
                minDue = value;
            }
        }
        return minDue;
    }
}
