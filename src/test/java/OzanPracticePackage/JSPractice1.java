package OzanPracticePackage;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.*;

public class JSPractice1 {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        //WebElement yesButton= driver.findElement(By.xpath("//input[@id='yesRadio']"));
        //Actions actions=new Actions(driver);
        //actions.click(yesButton).perform();
        //JavascriptExecutor js=(JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click()",yesButton);

        //WebElement message= driver.findElement(By.cssSelector(".mt-3"));

        //String actualMessage= BrowserUtils.getText(message);
        //String expectedButton="You have selected Yes";
        //Assert.assertEquals(actualMessage,expectedButton);

        WebElement noRadioButton= driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noRadioButton.isEnabled());



        WebElement impressive=driver.findElement(By.cssSelector("#impressiveRadio"));
        //Actions actions=new Actions(driver);
        //actions.click(impressive).perform();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",impressive);

        WebElement impressiveMessage=driver.findElement(By.cssSelector(".mt-3"));
        String actualImpressive=BrowserUtils.getText(impressiveMessage);
        String expectedImpressive="You have selected Impressive";
        Assert.assertEquals(actualImpressive,expectedImpressive);
    }

    @Test
    public void Practice2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement copyright= driver.findElement(By.xpath("//div[contains(text(),'Copyright © 2023')]"));
        BrowserUtils.scrollWithJS(driver,copyright);
        String actualText=copyright.getText();
        String expectedText="Copyright © 2023";
        Assert.assertEquals(actualText,expectedText);

        WebElement applyNow= driver.findElement(By.xpath("//span[contains(text(),'Apply Now')]"));
        BrowserUtils.scrollWithJS(driver,applyNow);
        BrowserUtils.clickWithJS(driver,applyNow);
        String actualTitle=BrowserUtils.getTitleWithJS(driver);
        String expectedTitle="Apply Now";
        Assert.assertEquals(actualTitle,expectedTitle);
        List<WebElement> allInformation=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String>expectedInformation=Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for (int i = 0; i < allInformation.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));
        }




    }
}
