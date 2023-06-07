package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OzanPractice1 {
    public static void main(String[] args) throws InterruptedException {

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

        WebElement paragraph1=driver.findElement(By.id("details2"));
        System.out.println(paragraph1.getText());

        //NAME LOCATOR

        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ozan");

        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("Cifci");


        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("407-782-4866");


        WebElement email= driver.findElement(By.id("userName"));
        email.sendKeys("ozancifci@yahoo.com");


        WebElement address= driver.findElement(By.name("address1"));
        address.sendKeys("9440 Woodcrane Dr,");


        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Winter Garden");


        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("FL");


        WebElement zipCode=driver.findElement(By.name("postalCode"));
        zipCode.sendKeys("34787");
        Thread.sleep(3000);


        //CLASS LOCATOR

        WebElement tools= driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());
        WebElement javaBox1=driver.findElement(By.id("cond1"));
        if (javaBox1.isDisplayed() && !javaBox1.isSelected()){
            javaBox1.click();
        }
        System.out.println(javaBox1.isDisplayed()? "JAVA IS SELECTED" : "NOT SELECTED");

        WebElement selenium=driver.findElement(By.id("cond2"));
        if (selenium.isDisplayed()&& !selenium.isSelected()){
            selenium.click();
        }
        System.out.println(selenium.isDisplayed() ?" SELENIUM IS SELECTED":"NOT SELECTED");

        WebElement testNG= driver.findElement(By.id("cond3"));
        if (testNG.isDisplayed()&&!testNG.isSelected() ){
            testNG.click();
        }
        System.out.println(testNG.isDisplayed()?"TESTNG IS SELECTED":"NOT SELECTED" );

        WebElement cucumber=driver.findElement(By.id("cond4"));
        if (cucumber.isDisplayed() && !cucumber.isSelected()){
            cucumber.click();
        }
        System.out.println(cucumber.isDisplayed()?"CUCUMBER IS SELECTED":"NOT SELECTED");

        WebElement header2=driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement javaVersion=driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());
        Thread.sleep(2000);

        //LINKTEXT LOCATOR

        WebElement javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader=driver.findElement(By.tagName("h1"));
        String actualHeader1=javaHeader.getText().trim();
        String expectedHeader1="Java";
        System.out.println(actualHeader1.equals(expectedHeader1)? "Java Link is Correct":" Java Link is False");

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
        WebElement seleniumLink=driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader=driver.findElement(By.tagName("h1"));
        String actualHeader2=seleniumHeader.getText().trim();
        String expectedHeader2="Selenium automates browsers. That's it!";
        System.out.println(actualHeader2.equals(expectedHeader2)? "Selenium link is Correct":"Failed");
        Thread.sleep(2000);

        driver.navigate().back();
        WebElement cucumberLink= driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberHeader=driver.findElement(By.tagName("h1"));
        String actualHeader3=cucumberHeader.getText().trim();
        String expectedHeader3="Tools & techniques that elevate teams to greatness";
        System.out.println(actualHeader3.equals(expectedHeader3)? "Cucumber Link correct":"Cucumber failed");
        Thread.sleep(2000);

        driver.navigate().back();
        WebElement testNGLink=driver.findElement(By.linkText("TestNG"));
        testNGLink.click();
        WebElement testNGHeader=driver.findElement(By.tagName("h2"));
        String actualHeader4=testNGHeader.getText().trim();
        String expectedHeader4="TestNG";
        System.out.println(actualHeader4.equals(expectedHeader4) ?"TESTNG CORRECT": "TESTNG IS FAILED");
        Thread.sleep(2000);

        driver.navigate().back();
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="file:///Users/ozancifci/Downloads/Techtorial.html";
        System.out.println(actualUrl.equals(expectedUrl)? "URL PASSED":"URL IS FAILED");
        Thread.sleep(2000);
        driver.quit();


    }
}
