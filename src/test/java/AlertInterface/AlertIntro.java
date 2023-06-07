package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void AlertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JsAlert= driver.findElement(By.xpath("//button[contains(@onClick,'jsAlert')]"));
        JsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText().trim(); //will get the text from pop-up that I cannot inspect
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();//will click OK button otherwise you will get UNHANDLED ALERT EXCEPTION
        WebElement message= driver.findElement(By.cssSelector("#result"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void AlertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JsConfirm= driver.findElement(By.xpath("//button[contains(@onClick,'jsConfirm')]"));
        JsConfirm.click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        alert.dismiss();
        Thread.sleep(3000);
        WebElement resultMessage= driver.findElement(By.xpath("//p[contains(@id,'result')]"));
        Assert.assertEquals(BrowserUtils.getText(resultMessage),"You clicked: Cancel");

    }

    @Test
    public void AlertSendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt= driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Homework is Important");
        Thread.sleep(2000);
        alert.accept();
        WebElement message= driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(message),"You entered: Homework is Important");

    }

    @Test
    public void projectJsAlert(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement click1= driver.findElement(By.cssSelector("#alertBox"));
        click1.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText().trim();
        String expectedText="I am an alert box!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement message1= driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(message1),"You selected alert popup");

        WebElement click2= driver.findElement(By.cssSelector("#confirmBox"));
        click2.click();
       // Alert alert1=driver.switchTo().alert();
        String actualMessage2=alert.getText().trim();
        String expected2="Press a button!";
        Assert.assertEquals(actualMessage2,expected2);
        alert.dismiss();

        WebElement message2= driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(message2),"You pressed Cancel in confirmation popup");

        WebElement click3= driver.findElement(By.cssSelector("#promptBox"));
        click3.click();
       // Alert alert3=driver.switchTo().alert();
        String actual3=alert.getText().trim();
        String expected3="Please enter your name:";
        Assert.assertEquals(actual3,expected3);
        alert.sendKeys("Ozan");
        alert.accept();

        WebElement message3= driver.findElement(By.cssSelector("#promptBox"));
        Assert.assertEquals(BrowserUtils.getText(message3),"You entered text Ozan in propmt popup");










    }
}
