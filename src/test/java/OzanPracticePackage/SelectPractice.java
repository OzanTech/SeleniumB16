package OzanPracticePackage;

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
import java.util.List;

public class SelectPractice {
    @Test
    public void validateCountry() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/ozancifci/Downloads/Techtorial.html");

        //TASK1: Validate the default option is selected UNITED STATES
        WebElement country= driver.findElement(By.xpath("//select[@name='country']"));
        Select dropDown=new Select(country);
        String actual= dropDown.getFirstSelectedOption().getText().trim();
        String expected="UNITED STATES ".trim();
        Assert.assertEquals(actual,expected);

        //TASK 2: Print out all the options

        int counter=0;
        List<WebElement> cntry=dropDown.getOptions();
        for (WebElement allCountries: cntry) {
            System.out.println(allCountries.getText().trim());
              counter++;
        }
        System.out.println(counter);

        //TASK: Choose your country with visibleText method
        //Choose Favorite country with value
        //choose travel country with index
        //NOTE: Put Thread.sleep() between them to see how they are changing.

        dropDown.selectByVisibleText("TURKEY");
        Thread.sleep(2000);
        dropDown.selectByValue("208");
        Thread.sleep(1000);
        dropDown.selectByIndex(9);



    }
}
