package ActionsClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        Actions actions=new Actions(driver);
        actions.scrollByAmount(200,200).perform();

        WebElement orangeBox= driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actualMessage= BrowserUtils.getText(orangeBox);
        String expectedMessage="...Or here.";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualBackGroundColor=orangeBox.getCssValue("background-color");
        String expectedBackGroundColor="rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualBackGroundColor,expectedBackGroundColor);
        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(3000);
        actions.dragAndDrop(draggable,orangeBox).perform();
        Thread.sleep(2000);
        orangeBox=driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actualAfterDragAndDrop=BrowserUtils.getText(orangeBox);
        String expectedAfterDragAndDrop="You did great!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);


    }

    @Test
    public void DragAndDropPractice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement blueBox= driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage=BrowserUtils.getText(blueBox);
        String expectedMessage="Drag the small circle here ...";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColor=blueBox.getCssValue("background-color").trim();
        String expectedColor="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor,expectedColor);
        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
        blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualAfterAction=BrowserUtils.getText(blueBox);
        String expectedAfterAction="You did great!";
        Assert.assertEquals(actualAfterAction,expectedAfterAction);

    }
}
