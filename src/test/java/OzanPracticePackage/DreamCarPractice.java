package OzanPracticePackage;

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

public class DreamCarPractice {
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

    @Test
    public void myCar() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");

        WebElement newUsed= driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed,"new","value");

        WebElement makes= driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(makes,"lexus","value");

        WebElement model=driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");

        WebElement price= driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceList=new Select(price);
        String actualPrice=BrowserUtils.getText(priceList.getFirstSelectedOption());
        String expectedPrice="No max price";
        Assert.assertEquals(actualPrice,expectedPrice);

        WebElement distance=driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40","value");

        WebElement zipCode= driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.sendKeys("60056");

        WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();

        WebElement header= driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        String actualHeader= BrowserUtils.getText(header);
        String expectedHeader="New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);

        WebElement sort= driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sort,"list_price","value");
        Thread.sleep(2000);

        List<WebElement>lexusHeader=driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement lexusList: lexusHeader) {
            Assert.assertTrue(lexusList.getText().contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(lexusList));
        }

        List<WebElement>lexusPrice=driver.findElements(By.cssSelector("primary-price"));
        List<Integer>actualPrices=new ArrayList<>();
        List<Integer>expectedPrices=new ArrayList<>();
        for (int i = 0; i < lexusPrice.size(); i++) {
            String numbers=BrowserUtils.getText(lexusPrice.get(i)).replace("$","".replace(",",""));
            actualPrices.add(Integer.parseInt(numbers));
            expectedPrices.add(Integer.parseInt(numbers));
        }

        Collections.sort(expectedPrices);
        Assert.assertEquals(actualHeader,expectedHeader);







    }
}
