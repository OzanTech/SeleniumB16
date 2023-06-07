package OzanPracticePackage;

import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

public class ActionsPractice {
    @Test
    public void practiceDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement dropBox= driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessage= BrowserUtils.getText(dropBox);
        String expectedMessage="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement dragBox=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragBox,dropBox).perform();
        dropBox= driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualAfterDragAndDrop=BrowserUtils.getText(dropBox);
        String expectedAfterDragAndDrop="Dropped!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);
        String actualColor=dropBox.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);

    }

    @Test
    public void clickAndHoldPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement accept= driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        accept.click();

        WebElement notAcceptable= driver.findElement(By.cssSelector("#notAcceptable"));
        String actualMessage=BrowserUtils.getText(notAcceptable);
        Thread.sleep(2000);
        String expectedMessage="Not Acceptable";
        Assert.assertEquals(actualMessage,expectedMessage);


        WebElement dropBox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualMessage1=BrowserUtils.getText(dropBox);
        String expectedMessage1="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);
        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptable).moveToElement(dropBox).release().perform();
        String actualMessageAfterAction=BrowserUtils.getText(dropBox);
        String expectedMessageAfterAction="Drop here";
        Assert.assertEquals(actualMessageAfterAction,expectedMessageAfterAction);


    }

}
