package testCases;
/*Data is valid -Login success -test pass -logout
 * Data is valid -Login failed -test fail
 * Data is invalid -Login success -test fail -logout
 * Data is invalid -Login failed -test pass
 */

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass  {
	//getting data Provider from different class
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	
	public void verify_Login(String email,String pwd,String exp) throws InterruptedException {
		logger.info("*********startingTC_003_LoginDDT************");
		try
		{
	    
	//HomePage
	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        hp.clickLogin();
    //Login
	        LoginPage lp = new LoginPage(driver);
	        lp.enterEmail(email);
	        lp.enterPassword(pwd);
	        lp.clickLogin();

	        
	//Account
	        MyAccountPage macc = new MyAccountPage(driver);
	        boolean targetPage = macc.isMyAccountPageExists();
	        if (exp.equalsIgnoreCase("valid"))
	        	{
	        	if(targetPage==true)
	        	{
	        		Assert.assertTrue(true);
	        		macc.clickLogout();
	        	}
	        	else
	        	{
	        		Assert.assertTrue(false);
	        	}
	        	
	        }
	        else
	        {
	        	if(exp.equalsIgnoreCase("invalid"))
	        
	        if(targetPage==true)
        	{
        		Assert.assertTrue(true);
        		macc.clickLogout();
        		Assert.assertTrue(false);
        	}	
	        else
	        {
	        	Assert.assertTrue(true);
	        }
	        	
	        }
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("*********FinishedTC_003_LoginDDT************");
	
	}
}
