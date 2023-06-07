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
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

import static org.testng.AssertJUnit.assertEquals;

public class SelectMidLevelPractice {
    @Test
    public void validateOrderMessage(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        /*
        1-Navigate to the website
        2-Select one way trip button
        3-Choose 4 passangers(1 wife-1 husband-2 kids)
        4-Validate the depart from is default "Acapulco"
        5-Choose the depart from is Paris
        6-Choose the date August 15th
        7-Choose the arrive in is San Francisco
        8-Choose the date December 15th
        10-Click first class option.
        11-Validate All the options from Airline
        12-Choose the Unified option from airline list
        13-Click Continue
        14-Validate the message at the top.There is a bug here/
        "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */

        WebElement oneWay= driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();

        WebElement passCount= driver.findElement(By.name("passCount"));
        Select passangerSelect=new Select(passCount);
        passangerSelect.selectByVisibleText("4");

        WebElement departureFrom= driver.findElement(By.name("fromPort"));
        Select departFromSelect=new Select(departureFrom);
        String departSelectOption=departFromSelect.getFirstSelectedOption().getText();
        Assert.assertEquals("Acapulco",departSelectOption);

        departFromSelect.selectByVisibleText("Paris");

        WebElement departMonthDropdown=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select departMonthSelect=new Select(departMonthDropdown);
        departMonthSelect.selectByVisibleText("August");
        WebElement departDayDropdown=driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select departDaySelect=new Select(departDayDropdown);
        departDaySelect.selectByValue("15");

        WebElement arrivingForm=driver.findElement(By.name("toPort"));
        Select arrivingFromSelect=new Select(arrivingForm);
        arrivingFromSelect.selectByValue("San Francisco");

        WebElement returningMonthDropDown=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returningSelect=new Select(returningMonthDropDown);
        returningSelect.selectByVisibleText("December");
        WebElement returningDropDown=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returningDaySelect=new Select(returningDropDown);
        returningDaySelect.selectByVisibleText("15");

        WebElement firstClass=driver.findElement(By.xpath("//input[@value='Coach']"));
        firstClass.click();


        WebElement airlines=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineDropDown=new Select(airlines);

        List<WebElement> actualOption=airlineDropDown.getOptions();
        List<String> expectedOptions=Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for (int i = 0; i < actualOption.size(); i++) {
            Assert.assertEquals(actualOption.get(i).getText().trim(),expectedOptions.get(i).trim());
        }

        airlineDropDown.selectByVisibleText("Unified Airlines");

        WebElement continueButton=driver.findElement(By.name("findFlights"));
        continueButton.click();

        WebElement message=driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage=message.getText().trim();
        String expectedMessage="        After flight finder - No Seats Available  ".trim();
        Assert.assertEquals(actualMessage,expectedMessage);
        driver.quit();


    }

    @Test
    public void validateOrderMessageShortCut(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");


        WebElement oneWay= driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();

        WebElement passCount= driver.findElement(By.name("passCount"));
        BrowserUtils.selectBy(passCount,"4","value");

        WebElement departureFrom= driver.findElement(By.name("fromPort"));
        Select departFromSelect=new Select(departureFrom);
        String departSelectOption=departFromSelect.getFirstSelectedOption().getText();
        Assert.assertEquals("Acapulco",departSelectOption);

        //departFromSelect.selectByVisibleText("Paris");
        BrowserUtils.selectBy(departureFrom,"Paris","text");

        WebElement departMonthDropdown=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(departureFrom,"7","index");

        WebElement departDayDropdown=driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(departDayDropdown,"3","value");

        WebElement arrivingForm=driver.findElement(By.name("toPort"));
        BrowserUtils.selectBy(arrivingForm,"San Francisco","text");

        WebElement returningMonthDropDown=driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(returningMonthDropDown,"December","text");

        WebElement returningDropDown=driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(returningDropDown,"14","index");

        WebElement firstClass=driver.findElement(By.xpath("//input[@value='Coach']"));
        firstClass.click();


        WebElement airlines=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineDropDown=new Select(airlines);

        List<WebElement> actualOption=airlineDropDown.getOptions();
        List<String> expectedOptions=Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for (int i = 0; i < actualOption.size(); i++) {
            Assert.assertEquals(actualOption.get(i).getText().trim(),expectedOptions.get(i).trim());
        }

        airlineDropDown.selectByVisibleText("Unified Airlines");
        WebElement continueButton=driver.findElement(By.name("findFlights"));
        continueButton.click();
        WebElement message=driver.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(BrowserUtils.getText(message),"After flight finder - No Seats Available");

    }

}

