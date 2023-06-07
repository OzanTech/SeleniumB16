package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {
        //LOCATORS -->is a way to locate(find) element and manipulate on it
        //ID LOCATOR:

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("file:///Users/ozancifci/Downloads/Techtorial.html");
        driver.manage().window().maximize();
        WebElement header= driver.findElement(By.id("techtorial1"));
        String actualHeader= header.getText().trim();//it gets the text from element
        String expectedHeader="Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader) ? "CORRECT":"WRONG");

        WebElement paragraph= driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //NAME LOCATOR

        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ozan");

        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Cifci");

        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("123456");

        WebElement email= driver.findElement(By.id("userName"));
        email.sendKeys("oz@xyz.com");

        WebElement address= driver.findElement(By.name("address1"));
        address.sendKeys("Winter Garden");

        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Orlando");

        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("FL");

        WebElement postalCode= driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("34787");

        //CLASS LOCATOR

        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
        WebElement javaBox= driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()) {
              javaBox.click();
        }
        System.out.println(javaBox.isDisplayed()?"SELECTED":"NOT SELECTED");

        WebElement testNG=driver.findElement(By.id("cond3"));
        if (testNG.isDisplayed() && !testNG.isSelected()) {
            testNG.click();
        }
        System.out.println(testNG.isDisplayed()? "CHECKED":"NOT CHECKED");

        WebElement cucumber=driver.findElement(By.id("cond4"));
        if (cucumber.isDisplayed() && !cucumber.isSelected()){
            cucumber.click();
        }
        System.out.println(cucumber.isDisplayed()? "CHECKED":"NOT CHECKED");


        //TAG NAME LOCATOR:

        WebElement header2=driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement tagName=driver.findElement(By.tagName("u"));
        System.out.println(tagName.getText());

        Thread.sleep(2000);

        driver.quit();







    }

    }

