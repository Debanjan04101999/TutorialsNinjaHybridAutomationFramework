package pageObjectsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericUtilities.Utilities;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;

	@FindBy(xpath = "//input[@name='newsletter'][@value='0']")
	private WebElement noNewsletterOption;

	@FindBy(name = "agree")
	private WebElement privacyPolicyField;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(className = "col-sm-9")
	private WebElement errorMessage;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	@FindBy(className = "text-danger")
	private WebElement passworconfirmationMismatchWarning;
	
	
	
	@FindBy(css = ".alert")
	private WebElement PrivacyPolicyWarning;
	


	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement existingEmailWarning;
	
	@FindBy(css= "div[id='account-register'] li:nth-child(3) a:nth-child(1)")
	private WebElement registerPageBreadcrumb;

	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}

	public void enterTelephoneNumber(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		passwordConfirmField.sendKeys(confirmPasswordText);
	}

	public void selectYesForNewsletter() {
		if (!yesNewsletterOption.isSelected()) {
			yesNewsletterOption.click();
		}
	}

	public void selectNoForNewsletter() {
		if (!noNewsletterOption.isSelected()) {
			noNewsletterOption.click();
		}
	}

	public void selectPrivacyPolicyOption() {
		if (!privacyPolicyField.isSelected()) {
			privacyPolicyField.click();
		}
	}

	public AccountSuccessPage clickContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);

	}

	public String getErrorMessege() {
		return errorMessage.getText();

	}

	public String getExistingEmailWarning() {
		return existingEmailWarning.getText();
	}

	
	public String getPrivacyPolicyWarning() {
		return PrivacyPolicyWarning.getText();
	}

	
	public String getPasswordWarning() {
		return passwordWarning.getText();
	}
	
	public String getPasswordConfirmMismatchWarning() {
		return passworconfirmationMismatchWarning.getText();
	}
	
	

	public String getEmailWarning() {
		return emailWarning.getText();
	}

	public String getTelephoneWarning() {
		return telephoneWarning.getText();
	}

	public String getLastNameWarning() {
		return lastNameWarning.getText();
	}

	public String getFirstNameWarning() {
		return firstNameWarning.getText();
		
	}
	
	public boolean didWeNavigatToRegisterPage() {
		return registerPageBreadcrumb.isDisplayed();
	}

	public boolean isFirstNameWarningMessageDisplayed() {
		return firstNameWarning.isDisplayed();
	}

	public boolean isLastNameWarningMessageDisplayed() {
		return lastNameWarning.isDisplayed();
	}

	public boolean isEmailWarningMessageDisplayed() {
		return emailWarning.isDisplayed();
	}

	public boolean isTelephoneWarningMessageDisplayed() {
		return telephoneWarning.isDisplayed();
	}

	public boolean isPasswordWarningMessageDisplayed() {
		return passwordWarning.isDisplayed();
	}

}
