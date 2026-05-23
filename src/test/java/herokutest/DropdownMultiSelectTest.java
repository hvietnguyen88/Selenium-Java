package herokutest;

import herokupages.DropdownMultiSelectPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.List;

import static common.Browsers.*;

public class DropdownMultiSelectTest {
    DropdownMultiSelectPage dropdownMultiSelectPage;

    @Parameters({"browserName"})
    @BeforeClass
    void setup(String browserName) {
        openBrowser(browserName);
        dropdownMultiSelectPage = new DropdownMultiSelectPage();

    }

    @BeforeMethod
    void open() {
        dropdownMultiSelectPage.openPage();
    }

    @DataProvider(name="expected")
    Object[][] testData() {
        return new Object[][] {
                {new String[]{"Green", "Red", "Blue", "Black"}},
                {new String[]{"Green", "Red", "Blue"}},
                {new String[]{"Green", "Red"}},
                {new String[]{"Green"}}
        };
    }

    @Test(dataProvider="expected")
    void successfullySelectOptions(String[] expected) {
        dropdownMultiSelectPage.selectMultiOptions(expected);
        List<String> actual = dropdownMultiSelectPage.getSelectedOptions();
        Assert.assertEqualsNoOrder(actual.toArray(), expected);
    }

    @Test(dataProvider="expected")
    void successfullyRemoveOptions(String[] expected) throws InterruptedException {
        dropdownMultiSelectPage.selectMultiOptions(new String[]{"Green", "Red", "Blue", "Black"});
        dropdownMultiSelectPage.removeOptions(expected);
        Thread.sleep(1000);
        List<String> actual = dropdownMultiSelectPage.getSelectedOptions();
        Assert.assertEquals(actual.size(), 4-expected.length);
    }

    @AfterMethod
    void clearUp(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            captureScreenshot(testResult.getMethod().toString());
        }
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        quit();
    }
}
