package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DreamCar {
    @Test
    public void HeadersOfTheCar() throws InterruptedException {
         /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
12-Validate the Lowest to
     */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");

        WebElement newCar=driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newCar,"new","value");

        WebElement Make= driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(Make,"lexus","value");

        WebElement model= driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");

        WebElement price=driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceSelect=new Select(price);
        String actualPrice= BrowserUtils.getText(priceSelect.getFirstSelectedOption());
        String expectedPrice="No max price";
        Assert.assertEquals(actualPrice,expectedPrice);

        WebElement distance=driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40","value");

        WebElement zipCode=driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        Thread.sleep(2000);

        WebElement search=driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        search.click();
        Thread.sleep(2000);

        WebElement newLexus=driver.findElement(By.cssSelector(".sds-page-section__title"));
        String actualLexus=BrowserUtils.getText(newLexus);
        String expectedLexus="New Lexus RX 350 for sale";
        Assert.assertEquals(actualLexus,expectedLexus);
        Thread.sleep(2000);

        WebElement sort=driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sort,"list_price","value");
        Thread.sleep(2000);

        List<WebElement> allCars=driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement title: allCars) {
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(title));
        }
        Thread.sleep(1000);

        List<WebElement> allPrices=driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Integer>actualPrices=new ArrayList<>();
        List<Integer> expectedPrices=new ArrayList<>();
        Thread.sleep(3000);
        for (int i = 0; i < allPrices.size(); i++) {
            String numbers= BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","");
            actualPrices.add(Integer.parseInt(numbers));
            expectedPrices.add(Integer.parseInt(numbers));
        }
        Collections.sort(expectedPrices);
        Assert.assertEquals(actualPrices,expectedPrices);

        System.out.println(actualPrices);//these are optional
        System.out.println(expectedPrices);//these are optional

    }
}