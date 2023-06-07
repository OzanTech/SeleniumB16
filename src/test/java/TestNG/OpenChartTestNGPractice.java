package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");

        WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
        Thread.sleep(2000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @Test
    public void failedlogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("xy");

        WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector("#alert"));
        String actualMessage = errorMessage.getText().trim();
        String expectedMessage = "No match for Username and/or Password.";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Thread.sleep(2000);

        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        Thread.sleep(2000);
        xButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);

        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productButton.isDisplayed());
        Assert.assertTrue(productButton.isEnabled());

    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Thread.sleep(2000);

        WebElement xButton = driver.findElement(By.cssSelector(".btn-close"));
        Thread.sleep(2000);
        xButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);

        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        Thread.sleep(2000);

        /*
        STEPS:

        1-Find the all boxes location
        2-Use regular for loop and start from 1(int i=1
        3-Inside of the loop you should have:

          1-Thread.sleep
          2-IsDisplayed(true)
          3-IsEnabled(true)
          4-IsSelected(false)
          5-Click
          6-IsSelected(true) -->AssertTrue
          7-box.sendKeys(Keys.Arrow_Down)

         */


        List<WebElement>boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 1; i < boxes.size(); i++) {
            Thread.sleep(1000);
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertTrue(boxes.get(i).isEnabled());
            Assert.assertFalse(boxes.get(i).isSelected());//as default it should not be selected
            boxes.get(i).click();
            Assert.assertTrue(boxes.get(i).isSelected());//this one should be selected
            boxes.get(i).sendKeys(Keys.ARROW_DOWN);



        }

    }

    @Test
    public void validateProductNameFunctionalityAscending() throws InterruptedException {
        /*
        1-You will click the productName button
        2-You should create 2 arraylist
          *-One of them will be actualData
          *-Another will be expectedData
        3-For(int i=1)
          *-store all the names for both of the list
        4-For expected List -->you will use Collections.sort(expectedList)
                            -->Collections.reverse(expected)
                            Assert.equals(actualList, expectedList)


         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Thread.sleep(2000);

        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        Thread.sleep(2000);
        xButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);

        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();

        List<WebElement> allProducts=driver.findElements(By.xpath("//td[@class='text-start']")); //11 elements

        List<String> actualProductOrder=new ArrayList<>();
        List<String> expectedProductOrder=new ArrayList<>();

        for (int i = 1; i < allProducts.size(); i++) {
            actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());//same order same item
            expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());//same order same item
        }
        Collections.sort(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder,expectedProductOrder);


    }

    @Test
    public void validateDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Thread.sleep(2000);

        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        Thread.sleep(2000);
        xButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);

        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        WebElement productName= driver.findElement(By.xpath("//a[.='Product Name']"));
        productName.click();
        Thread.sleep(3000);

        List<WebElement> allProducts=driver.findElements(By.xpath("//td[@class='text-start']")); //11 elements

        List<String> actualProductOrder=new ArrayList<>();
        List<String> expectedProductOrder=new ArrayList<>();


        for (int i = 1; i < allProducts.size(); i++) {
            actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());//same order same item
            expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());//same order same item
        }
        Collections.sort(expectedProductOrder);
        Collections.reverse(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder,expectedProductOrder);
    }
}