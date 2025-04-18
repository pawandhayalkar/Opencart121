package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage  {
	public HomePage(WebDriver driver)
	{
		super(driver);//Without invoke the consructer we caannot connect with parent class
	}


	  // Elements with @FindBy
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(linkText = "Register")
    WebElement register;
     
 @FindBy(xpath="//a[normalize-space()='Login']")
 WebElement linkLogin;
    // Actions
    public void clickMyAccount() {
        myAccount.click();
    }

    public void clickRegister() {
        register.click();
    }
    public void clickLogin()
    {
     linkLogin.click();
    }
}
