package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement userName= driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement passWord= driver.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys("secret_sauce");

        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        System.out.println(actualUrl.equals(expectedUrl)? "URL PASSED":"URL IS FAILED");
        Thread.sleep(2000);
        driver.quit();
    }
}
