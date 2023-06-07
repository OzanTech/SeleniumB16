package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement userName= driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("java");

        WebElement passWord= driver.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys("Selenium");

        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Error message validation successful!");
        } else {
            System.out.println("Error message validation failed!");
        }
        Thread.sleep(2000);
        driver.quit();








    }
}
