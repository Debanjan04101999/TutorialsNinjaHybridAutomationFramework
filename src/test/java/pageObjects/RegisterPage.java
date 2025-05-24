package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import utilities.Utilities;

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

}
