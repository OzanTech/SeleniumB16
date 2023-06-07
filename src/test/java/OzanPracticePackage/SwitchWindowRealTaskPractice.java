package OzanPracticePackage;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwitchWindowRealTaskPractice {
    @Test
    public void RealTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */

        WebElement fourthButton= driver.findElement(By.cssSelector("newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,fourthButton);
        fourthButton.click();
        BrowserUtils.switchByTitle(driver,"Basic Controls");
        System.out.println(driver.getTitle());
        WebElement firstName= driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Ozan");
        WebElement lastName= driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Cifci");
        WebElement gender= driver.findElement(By.cssSelector("#malerb"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", gender);
        WebElement lang= driver.findElement(By.cssSelector("#englishchbx"));
        lang.click();
        WebElement email=driver.findElement(By.cssSelector("#email"));
        email.sendKeys("abc@gmail.com");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("12345");
        WebElement registerButton=driver.findElement(By.cssSelector("#registerbtn"));
        registerButton.click();
        WebElement registration=driver.findElement(By.cssSelector("#msg"));
        Assert.assertEquals(BrowserUtils.getText(registration),"Registration is Successful");
        BrowserUtils.switchByTitle(driver,"Window Handles Practice");





    }

}
