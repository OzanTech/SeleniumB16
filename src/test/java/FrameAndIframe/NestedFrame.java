package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;

public class NestedFrame {
    @Test
    public void NestedFramePractice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        //Name or ID iframe
        driver.switchTo().frame("frame-top");
        //WebElement iframe
        WebElement iframeLeft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iframeLeft);
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(left));
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement middle= driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(middle));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));

        //Can you print out BOTTOM
        driver.switchTo().parentFrame();//TOP FRAME
        driver.switchTo().parentFrame();//MAIN HTML
        driver.switchTo().defaultContent();//this will go to the main HTML no matter what
        //SWITCHING FRAME WITH INDEXING
        driver.switchTo().frame(1);//Bottom
        WebElement bottom=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottom));


    }
}
