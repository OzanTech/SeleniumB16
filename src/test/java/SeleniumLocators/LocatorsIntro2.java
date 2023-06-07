package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///Users/ozancifci/Downloads/Techtorial.html");

        //LINKTEXT LOCATOR
        WebElement javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader=driver.findElement(By.tagName("h1"));
        String actualHeader=javaHeader.getText().trim();
        String expectedHeader="Java";
        System.out.println(actualHeader.equals(expectedHeader)? "CORRECT" : "FALSE");

        /*
    1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
    2-Go back to the main page
    3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
    4-Go back to the main page
    5-Click TestNG and validate(ternary) header -->TestNG
    6-Go back to the main page
    7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */

        driver.navigate().back();
        WebElement seleniumLink=driver.findElement(By.linkText("Selenium"));//it has a tagName and Text
        seleniumLink.click();
        WebElement seleniumHeader= driver.findElement(By.tagName("h1"));
        String actualHeader1= seleniumHeader.getText().trim();
        String expectedHeader1="Selenium automates browsers. That's it!";
        System.out.println(actualHeader1.equals(expectedHeader1)? "SELENIUM CORRECT":"SELENIUM FAILED");

        driver.navigate().back();
        WebElement cucumberLink= driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberHeader= driver.findElement(By.tagName("h1"));
        String actualHeader2=cucumberHeader.getText().trim();
        String expectedHeader2="Tools & techniques that elevate teams to greatness";
        System.out.println(actualHeader2.equals(expectedHeader2)?"CUCUMBER PASSED":"CUCUMBER FAILED");

        driver.navigate().back();
        WebElement testNGLink= driver.findElement(By.linkText("TestNG"));
        testNGLink.click();
        WebElement testNGHeader= driver.findElement(By.tagName("h2"));
        String actualHeader3=testNGHeader.getText().trim();
        String expectedHeader3="TestNG";
        System.out.println(actualHeader3.equals(expectedHeader3)?"TESTNG PASSED":"TEST IS FAILED");

        driver.navigate().back();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="file:///Users/ozancifci/Downloads/Techtorial.html";
        System.out.println(actualUrl.equals(expectedUrl)?"PASSED URL":"FAILED URL");

        //LOCATOR PARTIAL LINK TEXT:

        WebElement restApi= driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());


    }
}
