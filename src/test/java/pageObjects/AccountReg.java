package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountReg extends BasePage {

    public AccountReg(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='userName']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@id='register']")
    WebElement registerButton;

    public void enterFirstName(String fname)
    {
        firstName.sendKeys(fname);
    }
    public void enterLastName(String lname)
    {
        lastName.sendKeys(lname);
    }
    public void enterUserName(String user)
    {
        userName.sendKeys(user);
    }
    public void enterPassword(String pass)
    {
        password.sendKeys(pass);
    }

    public void clickRegisterButton()
    {
        registerButton.click();
    }



}
