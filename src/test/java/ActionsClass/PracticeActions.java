package ActionsClass;

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

public class PracticeActions {
    @Test
    public void practiceDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement drop=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessage=BrowserUtils.getText(drop);
        String expectedMessage="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement drag= driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        drop=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualAfterDragAndDrop=BrowserUtils.getText(drop);
        String expectedAfterDragAndDrop="Dropped!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);
        String actualColor=drop.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);
    }

    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement acceptButton= driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        acceptButton.click();
        Thread.sleep(2000);

        WebElement notAcceptable=driver.findElement(By.cssSelector("#notAcceptable"));
        String actualText=BrowserUtils.getText(notAcceptable);
        Thread.sleep(2000);
        String expectedText="Not Acceptable";
        Assert.assertEquals(actualText,expectedText);

        WebElement dropBox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualMessage=BrowserUtils.getText(dropBox);
        String expectedMessage="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);
        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptable).moveToElement(dropBox).release().perform();
        String actualMessageAfterAction=BrowserUtils.getText(dropBox);
        String expectedMessageAfterAction="Drop here";
        Assert.assertEquals(actualMessageAfterAction,expectedMessageAfterAction);










    }
}
