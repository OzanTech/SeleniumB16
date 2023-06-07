package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));//header of the main page (Opening a new Window)
        System.out.println(driver.getWindowHandle());//main pageID-->The internet
        //EE2C4D77A871EF2B0BC6960FBFBA7C67 -->mainPageID
        String mainPageId=driver.getWindowHandle();
        Set<String> allPagesID=driver.getWindowHandles();
        for (String id:allPagesID) {
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button2= driver.findElement(By.cssSelector("#newTabBtn"));
        button2.click();
        String currentPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id : allPagesId){
            if(!id.equals(currentPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        String actualTitle = driver.getTitle();
        String expectedTitle = "AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement header = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement clickMe = driver.findElement(By.cssSelector("#alertBox"));
        clickMe.click();

    }
}
