package ActionsClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HoverOverPractice {
    @Test
    public void practiceMoveToElement() throws InterruptedException {
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
       // actions.scrollByAmount(400,400).perform();

        List<WebElement>allPics=driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));//images
        List<WebElement>allNames=driver.findElements(By.xpath("//div[@class='product-description']//h3"));//names
        List<WebElement>allPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));//prices



        TreeMap<String, String> allList=new TreeMap<>();
        for (int i = 0; i < allPics.size(); i++) {
            //Thread.sleep(500);
            actions.moveToElement(allPics.get(i)).perform();
            allList.put(BrowserUtils.getText(allNames.get(i)),BrowserUtils.getText(allPrices.get(i)));

        }
        System.out.print(allList);





    }
}
