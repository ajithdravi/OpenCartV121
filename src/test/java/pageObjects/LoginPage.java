package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='newUser']")
    WebElement registerButton;

    @FindBy(xpath = "//input[@id='userName']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath="//button[@id='login']")
    WebElement loginButton;

    @FindBy(xpath = "//label[@id='userName-value']")
    WebElement getUsername;


    public void clickRegister()
    {
        registerButton.click();
    }
    public  void enterUserName(String user)
    {
        username.sendKeys(user);
    }
    public  void enterPass(String pass)
    {
        password.sendKeys(pass);

    }
    public void clickLoginButton()
    {
        loginButton.click();
    }
    public String getUsernameLogin()
    {
        return getUsername.getText();
    }

}
