package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OzanPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://www.godaddy.com/");
        System.out.println(driver.getTitle());
        String actualTitle= driver.getTitle();
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        System.out.println(actualTitle.equals(expectedTitle)?"TITLE IS PASSED":"TITLE IS FAILED");
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/";
        System.out.println(actualUrl.equals(expectedUrl)? "URL IS PASSED": "URL IS FAILED");
        driver.close();

    }
}
