package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC002_LoginTest extends BaseClass {

@Test(groups={"Sanity","Master"} )
public void verify_Login() {
    logger.info("********** Starting TC002_LoginTest ************");
    try {
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.enterEmail(p.getProperty("email"));
        lp.enterPassword(p.getProperty("password"));
        lp.clickLogin();

        MyAccountPage macc = new MyAccountPage(driver);
        boolean targetPage = macc.isMyAccountPageExists();
     // Corrected method name

        Assert.assertTrue(targetPage, "Login failed");

     } catch(Exception e) {
        logger.error("Exception occurred: " + e.getMessage());
        Assert.fail();
    }
    logger.info("********** Finished TC002_LoginTest ************");
}
}
