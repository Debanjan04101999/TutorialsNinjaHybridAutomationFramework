package pageObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "input-email")
	private WebElement emailAddress;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(css = "input[type='submit']")
	private WebElement clickSubmitButton;

	@FindBy(linkText = "Login")
	private WebElement loginbreadcrumb;;

	@FindBy(linkText = "Continue")
	private WebElement newCustomerContinueButton;

	@FindBy(css = ".alert")
	private WebElement loginWarning;

	@FindBy(xpath = "//aside[@id='column-right']//a[text()='Register']")
	private WebElement registerOption;
	
	@FindBy(linkText ="Forgotten Password")
	private WebElement  forgotPasswordLink;
	
	

	public void enterEmailAddress(String email) {
		emailAddress.clear();
		emailAddress.sendKeys(email);
	}

	public void enterPassword(String pswd) {
		password.clear();
		password.sendKeys(pswd);
	}

	public MyAccountPage clickOnLoginButton() {
		clickSubmitButton.click();
		return new MyAccountPage(driver);
	}

	public void clickOnnewCustomerContinueButton() {
		// elementUtils.clickOnElement(myAccountDropMenu,Utilities.EXPLICIT_WAIT_TIME);
		newCustomerContinueButton.click();
	}

	public RegisterPage clickOnRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}

	public boolean didWeNavigatToLoginPage() {
		return loginbreadcrumb.isDisplayed();
	}

	public String invalidCredencialWarning() {

		return loginWarning.getText();

	}
	
	public ForgottenPasswordPage clickOnForgotPasswordLink() {
		 forgotPasswordLink.click();
		return new ForgottenPasswordPage(driver);
		
	}

}
