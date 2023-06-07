package OzanPracticePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //setup
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize(); //maximize
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> links=driver.findElements(By.xpath("//li"));
        int counter=0;
        for (WebElement link: links) {
            System.out.println(link.getText());
            counter++;
            }
        System.out.println(counter);

         int counter2=0;
        for (WebElement link: links) {
            if (link.getText().length()>=12){
                System.out.println(link.getText().trim());
                counter2++;
            }
        }
        System.out.println(counter2);

        driver.quit();

        }
    }

