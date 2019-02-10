package com.cybertek.pages.loginPages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends TestBase {


    public LogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public @FindBy(xpath = "/html/body/div[1]/div/div[2]/a[2]")
    WebElement DemoSelector;

    public @FindBy(id = "login")
    WebElement userName;

    public @FindBy(id = "password")
    WebElement passWord;

    public @FindBy(xpath = "//b[contains(text(),'Sign in')]")
    WebElement signinBtn;

    public @FindBy(xpath = "//button[@type='submit']")
    WebElement logInBtn;


    public void login() {

        signinBtn.click();
        userName.sendKeys(ConfigurationReader.getProperty("username"));
        passWord.sendKeys(ConfigurationReader.getProperty("password"));
        logInBtn.click();
        wait.until(ExpectedConditions.titleContains("nbo"));


    }

    public void open() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        DemoSelector.click();
    }
}
