package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC02LoginTest extends BaseClass {

    @Test(groups = {"sanity","regression"})
    public void LoginToAccount()
    {
        try {
            logger.info("Login to the account");
            LoginPage loginPage = new LoginPage(driver);
            scrollDown();
            loginPage.enterUserName(p.getProperty("username"));
            loginPage.enterPass(p.getProperty("password"));
            loginPage.clickLoginButton();
            String userLoggedin=loginPage.getUsernameLogin();
            Assert.assertEquals(userLoggedin,p.getProperty("username"));
        }catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
