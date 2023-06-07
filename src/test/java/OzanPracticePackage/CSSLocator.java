package OzanPracticePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class CSSLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.etsy.com/");
        WebElement search= driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        search.sendKeys("watch");
        WebElement button= driver.findElement(By.cssSelector(".global-enhancements-search-input-btn-group__btn"));
        button.click();
        System.out.println(driver.getCurrentUrl());


    }
}
