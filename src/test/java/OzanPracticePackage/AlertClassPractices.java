package OzanPracticePackage;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertClassPractices {
    @Test
    public void AlertPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert= driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText().trim();
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement message= driver.findElement(By.cssSelector("#result"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void AlertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsConfirm= driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirm.click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        WebElement message= driver.findElement(By.cssSelector("#result"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="You clicked: Cancel";
        Assert.assertEquals(actualMessage,expectedMessage);


    }

    @Test
    public void AlertKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt= driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("Homework is Important");
        Thread.sleep(2000);
        alert.accept();
        WebElement message= driver.findElement(By.cssSelector("#result"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="You entered: Homework is Important";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void practiceJSAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement alertBox= driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement messageAlertBox= driver.findElement(By.cssSelector("#output"));
        System.out.println(BrowserUtils.getText(messageAlertBox));

        WebElement confirmBox= driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();
        Thread.sleep(1000);
        alert.dismiss();
        System.out.println(BrowserUtils.getText(messageAlertBox));

        WebElement promptBox= driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();
        alert.sendKeys("Ozan");
        alert.accept();
        String actualTextPrompt=BrowserUtils.getText(messageAlertBox);
        String expectedTextPrompt="You entered text Ozan in prompt popup";
        Assert.assertEquals(actualTextPrompt,expectedTextPrompt);






    }
}
