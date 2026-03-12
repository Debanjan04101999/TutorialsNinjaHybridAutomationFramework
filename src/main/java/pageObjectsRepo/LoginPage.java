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
	
	@FindBy(css = ".alert.alert-danger.alert-dismissible")
	private WebElement errorMsg;

	@FindBy(linkText = "Login")
	private WebElement loginbreadcrumb;;

	@FindBy(linkText = "Continue")
	private WebElement newCustomerContinueButton;

	@FindBy(css = ".alert")
	private WebElement loginWarning;

	@FindBy(xpath = "//aside[@id='column-right']//a[text()='Register']")
	private WebElement registerOption;

	@FindBy(linkText = "Forgotten Password")
	private WebElement forgotPasswordLink;

	@FindBy(xpath = "//aside[@id='column-right']//a[text()='Login']")
	private WebElement emailAddressPlaceholder;

	@FindBy(xpath = "//aside[@id='column-right']//a[text()='Register']")
	private WebElement passworrdPlaceholder;
	
	
	public MyAccountPage login(String user, String pass) {

		emailAddress.clear();
        password.clear();

        if (!user.equalsIgnoreCase("blank"))
        	emailAddress.sendKeys(user);

        if (!pass.equalsIgnoreCase("blank"))
            password.sendKeys(pass);

        clickSubmitButton.click();
        return new MyAccountPage(driver);
    }
	

	 public boolean isErrorDisplayed() {
	        return errorMsg.isDisplayed();
	    }
	
	/*
	 * public void enterEmailAddress(String email) { emailAddress.clear();
	 * emailAddress.sendKeys(email); }
	 * 
	 * public void enterPassword(String pswd) { password.clear();
	 * password.sendKeys(pswd); }
	 * 
	 * public MyAccountPage clickOnLoginButton() { clickSubmitButton.click(); return
	 * new MyAccountPage(driver); }
	 */

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

	public boolean isEmailAddressPlaceholderDisplayed() {
		return emailAddress.getDomAttribute("placeholder").equals("E-Mail Address");
	}

	public boolean isPasswordPlaceholderDisplayed() {
		return password.getDomAttribute("placeholder").equals("Password");

	}
}
