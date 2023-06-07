package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement name= driver.findElement(By.xpath("//input[@id='userName']"));
        name.sendKeys("Ozan Cifci");

        WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("xyz@yahoo.com");

        WebElement currentAddress= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("7521 W Sand Lake Rd");

        WebElement permanentAddress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("564 Semoran Blvd");

        WebElement submit=driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();

        if (currentAddress.isDisplayed() && currentAddress.equals(permanentAddress)){
            System.out.println("ADDRESS MATCHED");
        }else {
            System.out.println("ADDRESS NOT MATCHED");
        }

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://demoqa.com/text-box";
        System.out.println(actualUrl.equals(expectedUrl)?"PASSED URL":"FAILED URL");
        Thread.sleep(3000);
        driver.quit();






    }
}
