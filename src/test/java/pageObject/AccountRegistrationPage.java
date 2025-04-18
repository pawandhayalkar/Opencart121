package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
   
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver); 
	}
	

	    // WebElements

	    @FindBy(id = "input-firstname")
	    WebElement firstName;

	    @FindBy(id = "input-lastname")
	    WebElement lastName;

	    @FindBy(id = "input-email")
	    WebElement email;

	    @FindBy(id = "input-telephone")
	    WebElement telephone;

	    @FindBy(id = "input-password")
	    WebElement password;

	    @FindBy(id = "input-confirm")
	    WebElement confirmPassword;

	    @FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	    WebElement newsletterYes;

	    @FindBy(xpath = "//input[@name='newsletter' and @value='0']")
	    WebElement newsletterNo;

	    @FindBy(name = "agree")
	    WebElement privacyPolicyCheckbox;

	    @FindBy(xpath = "//input[@type='submit' and @value='Continue']")
	    
	     WebElement continueButton;
	 // Success message (confirmation)
	    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	    WebElement confirmationMessage;

	    // Actions

	    public void enterFirstName(String fname) {
	        firstName.sendKeys(fname);
	    }

	    public void enterLastName(String lname) {
	        lastName.sendKeys(lname);
	    }

	    public void enterEmail(String emailText) {
	        email.sendKeys(emailText);
	    }

	    public void enterTelephone(String phone) {
	        telephone.sendKeys(phone);
	    }

	    public void enterPassword(String pass) {
	        password.sendKeys(pass);
	    }

	    public void enterConfirmPassword(String confirmPass) {
	        confirmPassword.sendKeys(confirmPass);
	    }

	    public void selectNewsletterYes() {
	        newsletterYes.click();
	    }

	    public void selectNewsletterNo() {
	        newsletterNo.click();
	    }

	    public void checkPrivacyPolicy() {
	        privacyPolicyCheckbox.click();
	    }

	    public void clickContinue() {
	        continueButton.click();
	    }
	

	



//Method to get success message text
public String getConfirmationMessage() {
 return confirmationMessage.getText();
}
}