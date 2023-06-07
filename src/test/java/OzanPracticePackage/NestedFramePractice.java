package OzanPracticePackage;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFramePractice {
    @Test
    public void Practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");

        WebElement leftFrame= driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(leftFrame);
        WebElement left= driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(left));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleFrame= driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(middleFrame));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightFrame=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(rightFrame));

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrame=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottomFrame));





    }
}
