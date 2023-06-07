package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        //WebDriver driver=new Chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile=driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/ozancifci/Downloads/usa.png");
        WebElement uploadButton= driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();
        //uploadButton.click();
        WebElement validateFileName=driver.findElement(By.cssSelector("#uploaded-files"));
        String actualName=BrowserUtils.getText(validateFileName);
        String expectedName="usa.png";
        Assert.assertEquals(actualName,expectedName);

    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        //WebDriver driver=new Chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement chooseFile=driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("/Users/ozancifci/Downloads/usa.png");
        WebElement selectFileMessage= driver.findElement(By.xpath("//span[@class='field_title']//b[contains(text(),'Select file to send')]"));
        Assert.assertEquals(BrowserUtils.getText(selectFileMessage),"Select file to send(max 196.45 MB)");
        WebElement termsButton= driver.findElement(By.cssSelector("#terms"));
        if (termsButton.isEnabled() && !termsButton.isSelected() && termsButton.isDisplayed()){
            termsButton.click();
        }

        WebElement submitFile= driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitFile.click();
        Thread.sleep(2000);
        WebElement message= driver.findElement(By.xpath("//h3[@id='res']"));
        String actual = BrowserUtils.getText(message);
        String expected="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actual,expected);

    }
}
