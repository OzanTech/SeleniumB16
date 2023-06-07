package OzanPracticePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class YouTubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");//url
        //Thread.sleep(2000)
        //song.sendKeys(Keys.ARROW_DOWN) -->put this inside of loop

        WebElement search= driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("hagi");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> allSongs=driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement song: allSongs) {
            if (song.getAttribute("title").equals("Gheorghe Hagi'nin Galatasaray'da Attığı En Güzel Goller")){
                Thread.sleep(500);
                song.sendKeys(Keys.ARROW_DOWN);
                song.click();
                break;
            }
        }
        }


        @Test
    public void practice() throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver=new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.youtube.com/");//url
            //Thread.sleep(2000)
            //song.sendKeys(Keys.ARROW_DOWN) -->put this inside of loop

            WebElement search= driver.findElement(By.xpath("//input[@id='search']"));
            search.sendKeys("baggio");
            search.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            List<WebElement>allList=driver.findElements(By.xpath("//a[@id='video-title']"));
            for (WebElement element:allList) {
                if (element.getAttribute("title").equals("Roberto Baggio From 2000 to 2023")){
                    Thread.sleep(500);
                    element.sendKeys(Keys.ARROW_DOWN);
                    element.click();
                    break;

                }
            }


        }
    }

