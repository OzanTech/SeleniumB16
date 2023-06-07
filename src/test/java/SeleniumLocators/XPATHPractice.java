package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        /*
     1-Please fill all the boxes
     2-CLick privacy box
     3-Click continue and validate the message "Your Account Has Been Created!
     4-Click Continue and validate url
 */

        WebElement firstName= driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Ozan");

        WebElement lastName= driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Cifci");

        WebElement email= driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("123458880400@gmail.com");

        WebElement telephone= driver.findElement(By.xpath("//input[@id=\"input-telephone\"]"));
        telephone.sendKeys("123-45-67");

        WebElement password= driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
        password.sendKeys("123456");

        WebElement confirmPassword= driver.findElement(By.xpath("//input[@id=\"input-confirm\"]"));
        confirmPassword.sendKeys("123456");

        WebElement newsLetter=driver.findElement(By.xpath("//input[@name=\"newsletter\"]"));
        newsLetter.click();

        WebElement privacyPolicy= driver.findElement(By.xpath("//input[@name=\"agree\"]"));
        privacyPolicy.click();

        WebElement confirm= driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        confirm.click();



        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String actualHeader= header.getText().trim();
        String expectedHeader="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader)? "header passed":"header failed");

        WebElement continue2= driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        continue2.click();


        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(actualUrl.equals(expectedUrl)?"PASSED URL":"FAILED URL");
        Thread.sleep(3000);
        driver.quit();

    }
}
