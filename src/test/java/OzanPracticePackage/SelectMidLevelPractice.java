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
import java.util.*;
import java.util.stream.Collectors;

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
        3-Choose 4 passengers(1 wife-1 husband-2 kids)
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

        /*
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

        for (int i = 0; i < expectedOptions.size(); i++) {
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

         */

        /*
        1-Navigate to the website
        2-Select one way trip button
        3-Choose 4 passengers(1 wife-1 husband-2 kids)
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
        WebElement onewayButton= driver.findElement(By.xpath("//input[@value='oneway']"));
        onewayButton.click();

        WebElement PassengersDropDown= driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passenger= new Select(PassengersDropDown);
        passenger.selectByValue("4");

        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departure = new Select(departingFrom);
        String departSelectOption = departure.getFirstSelectedOption().getText();
        Assert.assertEquals("Acapulco",departSelectOption);

        departure.selectByVisibleText("Paris");

        WebElement monthDropDown=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select departureMonth=new Select(monthDropDown);
        departureMonth.selectByVisibleText("August");

        WebElement fromDaySelection=driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select departureDay=new Select(fromDaySelection);
        departureDay.selectByValue("15");

        WebElement arrivalDestination=driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivalLocation=new Select(arrivalDestination);
        arrivalLocation.selectByVisibleText("San Francisco");

        WebElement returningMonth=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returnMonth=new Select(returningMonth);
        returnMonth.selectByValue("12");

        WebElement returningDate=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returningDay=new Select(returningDate);
        returningDay.selectByValue("15");

        WebElement serviceClass=driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();

        WebElement Airline=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineDropDown=new Select(Airline);

        List<WebElement> actualOption=airlineDropDown.getOptions();
        List<String> expectedOption=Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for (int i = 0; i < expectedOption.size(); i++) {
            Assert.assertEquals(actualOption.get(i).getText().trim(),expectedOption.get(i).trim());
        }

        airlineDropDown.selectByVisibleText("Unified Airlines");

        WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement message=driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage=message.getText().trim();
        String expectedMessage="        After flight finder - No Seats Avaialble  ".trim();
        Assert.assertEquals(actualMessage,expectedMessage);
        driver.quit();























    }
}
