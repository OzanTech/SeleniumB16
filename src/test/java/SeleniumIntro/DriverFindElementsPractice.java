package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup(); //setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//ait times
        driver.get("https://the-internet.herokuapp.com/"); //url

        List<WebElement> elements = driver.findElements(By.tagName("li"));
        int count =0;
        for (WebElement link: elements){
            count++;
            System.out.println(link.getText());
        }
        System.out.println(count);
        System.out.println(elements.size());

        //TASK
        //Print it if length is equal and more than 12 and count how many

        int counter2=0;
        for (WebElement link: elements) {
            if (link.getText().length()>=12){
                System.out.println(link.getText());
                counter2++;
            }
        }
        System.out.println(counter2);

    }
}
