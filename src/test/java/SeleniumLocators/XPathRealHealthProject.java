package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathRealHealthProject {
    public static void main(String[] args) throws InterruptedException {
        /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");


        //WebElement appointmentLink= driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        //appointmentLink.click();

        //CSS  with ID
        WebElement appointmentCSS= driver.findElement(By.cssSelector("#btn-make-appointment"));
        appointmentCSS.click();


        WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");

        WebElement Password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        Password.sendKeys("ThisIsNotAPassword");

        WebElement login=driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();

        WebElement facility= driver.findElement(By.xpath("//select [@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");

        WebElement hospital= driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (hospital.isDisplayed() && !hospital.isSelected()) {
            hospital.click();
        }

        WebElement healthCareProgram= driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        healthCareProgram.click();

        WebElement visitDate= driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitDate.sendKeys("11/05/2023");

        WebElement comment=driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I want to book appointment");

        //WebElement bookAppointment= driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        //bookAppointment.click();

        //CSS with Class
        WebElement button = driver.findElement(By.cssSelector(".btn-default"));
        button.click();

        WebElement header= driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String actualHeader= header.getText().trim();
        String expectedHeader="Appointment Confirmation";
        if (actualHeader.equals(expectedHeader)){
            System.out.println("HEADER IS PASSED");
        }else {
            System.out.println("HEADER IS FAILED");
        }
        System.out.println(expectedHeader);

        WebElement facilityValidate=driver.findElement(By.xpath("//p[@id='facility']"));
        System.out.println(facilityValidate.getText());

        WebElement reAdmission=driver.findElement(By.xpath("//p[@id='hospital_readmission']"));
        System.out.println(reAdmission.getText());

        WebElement HealthCareProgramVerification=driver.findElement(By.xpath("//p[@id='program']"));
        System.out.println(HealthCareProgramVerification.getText());

        WebElement visitDateConfirmation= driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(visitDateConfirmation.getText());

        //WebElement comment1= driver.findElement(By.xpath("//p[contains(text(),Selenium')]"));

        WebElement goHome= driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        goHome.click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://katalon-demo-cura.herokuapp.com/";
        System.out.println(actualUrl.equals(expectedUrl)?"PASSED URL":"FAILED URL");
        Thread.sleep(3000);
        driver.quit();







    }
}
