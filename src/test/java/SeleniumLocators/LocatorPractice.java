package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ChromeOptions=new ChromeOptions();
        ChromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(ChromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */

        WebElement firstName= driver.findElement(By.name("firstname"));
        firstName.sendKeys("Ozan");

        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Cifci");

        WebElement genderMale= driver.findElement(By.id("sex-0"));
        genderMale.click();

        WebElement genderFemale= driver.findElement(By.id("sex-1"));
        genderFemale.click();

        WebElement experience1= driver.findElement(By.id("exp-0"));
        experience1.click();

        WebElement experience2= driver.findElement(By.id("exp-1"));
        experience2.click();

        WebElement experience3= driver.findElement(By.id("exp-2"));
        experience3.click();

        WebElement experience4= driver.findElement(By.id("exp-3"));
        experience4.click();

        WebElement experience5= driver.findElement(By.id("exp-4"));
        experience5.click();

        WebElement experience6= driver.findElement(By.id("exp-5"));
        experience6.click();

        WebElement experience7= driver.findElement(By.id("exp-6"));
        experience7.click();

        WebElement date= driver.findElement(By.id("datepicker"));
        date.sendKeys("5-16-2023");

        WebElement profession= driver.findElement(By.id("profession-0"));
        profession.click();

        WebElement profession1= driver.findElement(By.id("profession-1"));
        profession1.click();

        WebElement automationTools= driver.findElement(By.id("tool-2"));
        automationTools.click();

        WebElement continent= driver.findElement(By.id("continents"));
        continent.sendKeys("North America");

        WebElement button= driver.findElement(By.id("submit"));
        button.click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actualUrl.equals(expectedUrl)?"PASSED URL":"FAILED URL");
        driver.quit();
    }
}
