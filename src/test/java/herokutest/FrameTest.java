package herokutest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest {
    /*
Open browser
Navigate to https://the-internet.herokuapp.com/nested_frames
Verify Text present:
Copy
          LEFT
          RIGHT
          MIDDLE
          BOTTOM
     */
    @Test
    void successfullyVerifyTextPresent() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        String leftText =  driver.switchTo().frame("frame-top")
                .switchTo()
                .frame("frame-left")
                .findElement(By.xpath("//body"))
                .getText();
        Assert.assertEquals(leftText, "LEFT");

        String middleText =  driver.switchTo().parentFrame()
                .switchTo()
                .frame("frame-middle")
                .findElement(By.xpath("//body"))
                .getText();
        Assert.assertEquals(middleText, "MIDDLE");

        String rightText =  driver.switchTo().parentFrame()
                .switchTo().frame("frame-right").findElement(By.xpath("//body")).getText();
        Assert.assertEquals(rightText, "RIGHT");

        String bottomText = driver.switchTo().defaultContent()
                .switchTo().frame("frame-bottom").findElement(By.xpath("//body")).getText();
        Assert.assertEquals(bottomText, "BOTTOM");
    }
}
