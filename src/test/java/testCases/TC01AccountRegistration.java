package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountReg;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC01AccountRegistration extends BaseClass {

    @Test(groups = "regression")
    public void accountRegistration()
    {
        try {
            LoginPage loginPage = new LoginPage(driver);
            logger.info("Clicking in the Register button");
            scrollDown();
            loginPage.clickRegister();
            AccountReg accountReg = new AccountReg(driver);
            logger.info("Entering First name");
            accountReg.enterFirstName(randomString());
            logger.info("Entering Last name");
            accountReg.enterLastName(randomString());
            accountReg.enterUserName(randomAlphaNumeric());
            accountReg.enterPassword(randomAlphaNumeric());
        }catch (Exception e)
        {
            logger.error("Error log");
            logger.debug("Debug log");
            Assert.fail();
        }
    }
}
