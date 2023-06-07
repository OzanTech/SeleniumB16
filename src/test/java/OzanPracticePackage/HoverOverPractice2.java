package OzanPracticePackage;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HoverOverPractice2 {

    @Test
    public void PriceMoveToElement() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        /*
1-Navigate to the website
2-If you have cookies pop-up then click
3-Hover over each pictures and get the names and store it in List<String> allNames
4-Hover over each pictures and get the prices and store it in List<String> all prices
5-Put them all of the names as key of map, and all of the prices as value of map
6-Print out map

CLUES:You can use 1 regular(indexing) loop for adding the name and prices into the lists
CLUES:You can use same loop for putting into the map
CLUES:TO ab ele to get names and prices you need to hover over first
CLUES:DO not forget perform
 */

        Thread.sleep(1000);
        Actions actions=new Actions(driver);

        List<WebElement> allPics=driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement>allNames=driver.findElements(By.xpath("//div[@class='product k-listview-item']//h3"));
        List<WebElement>allPrices=driver.findElements(By.xpath("//div[@class='product k-listview-item']//p"));

        Map<String,String> allList=new TreeMap<>();
        for (int i = 0; i < allNames.size(); i++) {
            actions.moveToElement(allPics.get(i)).perform();
            allList.put(BrowserUtils.getText(allNames.get(i)),BrowserUtils.getText(allPrices.get(i)));
            System.out.println(allList);
        }
    }
}
