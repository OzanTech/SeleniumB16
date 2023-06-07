package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FramePractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");

        WebElement box=driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));

    }

    @Test
    public void practice1() throws InterruptedException {
        /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Java" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Java Tutorial – Basic to Advance"
  5-Print out(NO validation) Table of Content options on console(loop and getText())
  6-Wait for Second task
 */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        WebElement pavilion= driver.findElement(By.linkText("Pavilion"));
        pavilion.click();

        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"qavalidation");
        Thread.sleep(3000);
        WebElement seleniumTab= driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(seleniumTab).perform();
        WebElement javaPhyton= driver.findElement(By.linkText("Selenium-Python"));
        actions.click(javaPhyton).perform();
        WebElement header= driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Selenium-Python Tutorial";
        Assert.assertEquals(actualHeader,expectedHeader);
        List<WebElement>allLinks=driver.findElements(By.xpath("//p//a"));

        for (WebElement link:allLinks) {
            System.out.println(BrowserUtils.getText(link));
        }

        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */

        BrowserUtils.switchByTitle(driver,"iframes");//this is where my driver pointing
        driver.switchTo().frame("Frame1");
        WebElement category=driver.findElement(By.xpath("//a[.='Category1']"));
        category.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives");
        WebElement header1= driver.findElement(By.xpath("//div[@class='page-title-head hgroup']"));
        Assert.assertEquals(BrowserUtils.getText(header1),"Category Archives: SeleniumTesting");

        List<WebElement>allHeaders=driver.findElements(By.xpath("//h3//a[@rel='bookmark']"));
        for (WebElement header2:allHeaders) {
            System.out.println(BrowserUtils.getText(header2));
        }

        /*
TASK 3:
1-Go back mainPage
2-Click Category3
3-Validate the header "Category Archives: SoftwareTesting"

 */

        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement message=driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(message));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement cat3=driver.findElement(By.xpath("//a[.='Category3']"));
        cat3.click();
        BrowserUtils.switchByTitle(driver,"qavalidation");
        WebElement header3= driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header3),"Category Archives: SoftwareTesting");




    }

}
