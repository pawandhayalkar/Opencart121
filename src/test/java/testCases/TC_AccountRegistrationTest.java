package testCases;



import org.apache.commons.lang3.RandomStringUtils;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;



public class TC_AccountRegistrationTest extends BaseClass {
	

    @Test(groups="regression")
    public void verify_account_registration()
    {
    	logger.info("*********StartingC_AccountRegistrationTest********");
    	try
    	{
    	HomePage hp=new HomePage(driver);
    	hp.clickMyAccount();
    	logger.info("Clicked on MyAccount Link");
    	hp.clickRegister(); 
    logger.info("Clicked on Registered link..... ");
    AccountRegistrationPage repage = new AccountRegistrationPage(driver);
    logger.info("providing the info");
    repage.enterFirstName(randomString().toUpperCase());
    repage.enterLastName(randomString().toUpperCase());
    repage.enterEmail(randomString()+"@gmail.com"); // random generate the email.
    repage.enterTelephone(randomNumber());
    // String password=randomAlphaNumeric();
    
    
    String password=randomAlphaNumeric();
    
    repage.enterPassword(password);
    repage.enterConfirmPassword(password);
    repage.checkPrivacyPolicy();
    repage.clickContinue();
    logger.info("Validating Expected Message.....");
    String confmsg=repage.getConfirmationMessage();
    if(confmsg.equals(confmsg))
    
    {
    	Assert.assertTrue(true);
    }
    else
    {
    	Assert.assertTrue(false);
    }
   
    Assert.assertEquals(confmsg, "Your Account Has Been Created!");

    	}
    	catch(Exception e)
    	{
    		logger.error("Test Failed....");
    		logger.debug("Debug logs....");
    		Assert.fail();
    	}
    	logger.info("*******Finished TC_AccountRegistrationTest********** "); 
    }   
  
}
