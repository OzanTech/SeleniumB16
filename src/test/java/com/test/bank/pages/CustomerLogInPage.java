package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerLogInPage {
     /*
TASK:
 1-Click homeButton from top(You can store in Manager Page or LoginPage)
 2-Click Customer Login
 3-Find Your name from the List
 4-Click Login
 5-Validate the "Welcome Your Name" from header
 6-Click Deposit and put 500
 7-Validate "Deposit Successful
 8-Click Withdrawl and put 300
 9-Validate "Transaction successful"
 10-Get the balance from the Customer Page(200)
 11-Click Transactions
 12-get the 500 and 300 from the table and substract them
 13-Validate balance from customer page amount(200) equals to transaction amount(500-300).
 14-Quit the driver

 NOTE:YOu should have another CustomerPage class and CustomerTest class and do your validation under customerTest
 */

    public CustomerLogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userSelect")
    WebElement nameList;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement logIn;

    @FindBy(xpath = "//strong[contains(text(),' Welcome ')]")
    WebElement actualHeader;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement deposit;

    @FindBy(xpath = "//input[@type='number']")
    WebElement depositAmount;

    @FindBy(xpath = "//button[.='Deposit']")
    WebElement depositButton;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositConfirmation;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawalTab;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawalAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement withdrawButton;

    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement withdrawalConfirmation;

    @FindBy(xpath = "//strong[.='200']")
    WebElement balance;

    @FindBy(xpath = "//button[@ng-click='transactions()']")
    WebElement transactionsButton;


    public void customerLoginValidation(String name, String expectedHeader, String depositMoney, String expectedDeposit, String withdrawMoney,
                                        String expectedWithdrawal){
        BrowserUtils.selectBy(nameList,name,"text");
        logIn.click();
        Assert.assertEquals(BrowserUtils.getText(actualHeader),expectedHeader);
        deposit.click();
        depositAmount.sendKeys(depositMoney);
        depositButton.click();
        Assert.assertEquals(BrowserUtils.getText(depositConfirmation),expectedDeposit);
        withdrawalTab.click();
        withdrawalAmount.sendKeys(withdrawMoney);
        withdrawButton.click();
        Assert.assertEquals(BrowserUtils.getText(withdrawalConfirmation),expectedWithdrawal);
        System.out.println(balance);
        transactionsButton.click();
        int total=(Integer.parseInt(BrowserUtils.getText(depositAmount))-Integer.parseInt(BrowserUtils.getText(withdrawalAmount)));




    }

}

