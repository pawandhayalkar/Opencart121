package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage (WebDriver driver) {
	super (driver);

}
	
	 @FindBy(id = "input-email")
	     WebElement emailInput;

	    @FindBy(id = "input-password")
	     WebElement passwordInput;

	    @FindBy(xpath = "//input[@value='Login']")
	     WebElement loginButton;
	    
	    
	 // Methods to interact with the elements
	    public void enterEmail(String email) {
	        emailInput.sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        passwordInput.sendKeys(password);
	    }

	    public void clickLogin() {
	        loginButton.click();
	    }
}
	    
	    
	    
	    
	    
