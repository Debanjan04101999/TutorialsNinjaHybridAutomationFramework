package tutorialsNinjaAllTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.Utilities;
import genericUtilities.loggerUtil;
import pageObjectsRepo.AccountPage;
import pageObjectsRepo.AccountSuccessPage;
import pageObjectsRepo.LandingPage;
import pageObjectsRepo.LoginPage;
import pageObjectsRepo.NewsletterSubscriptionPage;
import pageObjectsRepo.RegisterPage;
import pageObjectsRepo.RightColumnOption;
import testBaseClass.BaseClass;
import testBaseClass.BaseClass;

public class RegisteAllTest extends BaseClass {
	LandingPage landingPage;
	RegisterPage registerPage = new RegisterPage(driver);
	AccountSuccessPage accountSuccessPage;
	AccountPage accountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;
	LoginPage loginPage;
	RightColumnOption rightColumnOption;

	@BeforeMethod
	public void setup() {

		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();

	}

	@Test(priority = 1)
	public void verifyRegistingAccountUsingMandtoryFields() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generatebrandNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();

		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		Assert.assertTrue(accountSuccessPage.isAccountSuccessPageDisplayed());

		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperDetailsSix = "contact us";

		String actualProperDetails = accountSuccessPage.getProperContentDisplayed();

		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix));

		accountPage = accountSuccessPage.clickOnContinueButton();

		Assert.assertTrue(accountPage.navigatedToAccountPage());

	}

	/*
	 * @Test(priority = 2) public void verifyConfirmationEmail() { }
	 */

	@Test(priority = 3)
	public void validateregisteringAnAccountByprovidingAllTheFields() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generatebrandNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectYesForNewsletter();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();

		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		Assert.assertTrue(accountSuccessPage.isAccountSuccessPageDisplayed());

		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperDetailsSix = "contact us";

		String actualProperDetails = accountSuccessPage.getProperContentDisplayed();

		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix));

		accountPage = accountSuccessPage.clickOnContinueButton();

		Assert.assertTrue(accountPage.navigatedToAccountPage());

	}

	@Test(priority = 4)
	public void verifyRegisterWithoutProvidingAnyFields() {

		registerPage.clickContinueButton();

		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(registerPage.getPrivacyPolicyWarning(), expectedPrivacyPolicyWarning);
		Assert.assertEquals(registerPage.getFirstNameWarning(), expectedFirstNameWarning);
		Assert.assertEquals(registerPage.getLastNameWarning(), expectedLastNameWarning);
		Assert.assertEquals(registerPage.getEmailWarning(), expectedEmailWarning);
		Assert.assertEquals(registerPage.getTelephoneWarning(), expectedTelephoneWarning);
		Assert.assertEquals(registerPage.getPasswordWarning(), expectedPasswordWarning);

	}

	@Test(priority = 5)
	public void verifyRegisterWhenYesOptionIsSelectedForNewsletterField() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generatebrandNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectYesForNewsletter();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();
		accountPage = accountSuccessPage.clickOnContinueButton();

		newsletterSubscriptionPage = accountPage.clickOnSubscribeUnscribeToNewsletterOption();
		Assert.assertTrue(newsletterSubscriptionPage.isYesNewsletterOptionSelected());

	}

	@Test(priority = 6)
	public void verifyRegisterWhenNoOptionIsSelectedForNewsletterField() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generatebrandNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectNoForNewsletter();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();
		accountPage = accountSuccessPage.clickOnContinueButton();

		newsletterSubscriptionPage = accountPage.clickOnSubscribeUnscribeToNewsletterOption();
		Assert.assertTrue(newsletterSubscriptionPage.isNoNewsletterOptionSelected());

	}

	@Test(priority = 7)
	public void validateDifferentWysOfNavigatingToRegisterAccountPage() throws InterruptedException {

		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();
		Assert.assertTrue(registerPage.didWeNavigatToRegisterPage());

		landingPage.clickOnMyAccountDropMenu();
		loginPage = landingPage.selectLoginOption();
		loginPage.clickOnnewCustomerContinueButton();
		Assert.assertTrue(registerPage.didWeNavigatToRegisterPage());

		landingPage.clickOnMyAccountDropMenu();
		loginPage = landingPage.selectLoginOption();
		registerPage = loginPage.clickOnRegisterOption();
		Assert.assertTrue(registerPage.didWeNavigatToRegisterPage());

	}

	@Test(priority = 8)
	public void verifyRegisteringAccountByProvidingMismatchingPasswords() throws InterruptedException {

		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generatebrandNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("invalidPassword"));
		registerPage.selectNoForNewsletter();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();
		Thread.sleep(5000);

		String expectedError = "Password confirmation does not match password!";

		Assert.assertEquals(registerPage.getPasswordConfirmMismatchWarning(), expectedError);

	}

	@Test(priority = 9)
	public void verifyRegisteringAccountByProvidingExistingAcountDetails() throws InterruptedException {

		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("validEmail"));
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectNoForNewsletter();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();
		Thread.sleep(5000);

		String expectedError = "Warning: E-Mail Address is already registered!";

		Assert.assertEquals(registerPage.getExistingEmailWarning(), expectedError);

	}

	@Test(priority = 10)
	public void verifyRegisteringAccountByProvidingInvalideEmail() throws InterruptedException {

		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();

		loggerUtil.logger.info("******Starting verifyRegisteringAccountByProvidingInvalideEmail******");
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("invalidEmail"));
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectNoForNewsletter();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();
		Thread.sleep(5000);

		String expectedError = "Warning: E-Mail Address is already registered!";

		Assert.assertEquals(registerPage.getExistingEmailWarning(), expectedError);

	}

	@Test(priority = 11)
	public void verifyRegisteringAccountByProvidingInvalidePhoneNumber() throws InterruptedException {

		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();

		loggerUtil.logger.info("******Starting verifyRegisteringAccountByProvidingInvalideTelePhoneNumber******");
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generatebrandNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("invalidtelephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectNoForNewsletter();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();

		String expectedWarningMessage = "Telephone number entered by you is invalid!";
		String actualWarningMessage = registerPage.getTelephoneWarning();
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);

		/*
		 * boolean state = false; try { if
		 * (registerPage.getTelephoneWarning().contains(expectedWarningMessage)) { state
		 * =true; }
		 * 
		 * } catch (NoSuchElementException e) { state =false; }
		 * Assert.assertTrue(state);
		 */

	}
	
	@Test(priority = 12)
	public void verifyRegisterAccountByKeyboardKeys() {

		

	}

	@Test(priority = 13)
	public void verifyRegisterAccountPagePlaceholders() {

		Assert.assertEquals(registerPage.getFirstNameFieldPlaceholderText(), "First Name");
		Assert.assertEquals(registerPage.getLastNameFieldPlaceholderText(), "Last Name");
		Assert.assertEquals(registerPage.getEmailFieldPlaceholderText(), "E-Mail");
		Assert.assertEquals(registerPage.getTelephoneFieldPlaceholderText(), "Telephone");
		Assert.assertEquals(registerPage.getPasswordFieldPlaceholderText(), "Password");
		Assert.assertEquals(registerPage.getPasswordConfirmFieldPlaceholderText(), "Password Confirm");

	}
	
	@Test(priority = 16)
	public void validateRegisterAcountwhetherTheMandatoryFieldsAreAcceptingOnlySpaces() {
	
		registerPage.enterFirstName("  ");
		registerPage.enterLastName("   ");
		registerPage.enterEmail("   ");
		registerPage.enterTelephoneNumber("   ");
		registerPage.enterPassword("   ");
		registerPage.enterConfirmPassword("   ");
		
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();

		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedPasswordConfirmWarning = "Password confirmation does not match password!";
		String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

		
		Assert.assertEquals(registerPage.getFirstNameWarning(), expectedFirstNameWarning);
		Assert.assertEquals(registerPage.getLastNameWarning(), expectedLastNameWarning);
		Assert.assertEquals(registerPage.getEmailWarning(), expectedEmailWarning);
		Assert.assertEquals(registerPage.getTelephoneWarning(), expectedTelephoneWarning);
		Assert.assertEquals(registerPage.getPasswordWarning(), expectedPasswordWarning);
		Assert.assertEquals(registerPage.getPasswordConfirmMismatchWarning(), expectedPasswordConfirmWarning);
		Assert.assertEquals(registerPage.getPrivacyPolicyWarning(), expectedPrivacyPolicyWarning);

		
	}
	
	@Test(priority = 19)
	public void verifyRegisterAccountUsingLeadingAndTrailingSpacesAreTrimmedAutomatic() {
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generatebrandNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectYesForNewsletter();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();
		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		Assert.assertTrue(accountSuccessPage.isAccountSuccessPageDisplayed());
		
	}
	
	@Test(priority =20)
	public void verifyRegisterAccountWhetheTheePrivacyPolicyFieldNotSelectedByDefault()
	{
		Assert.assertFalse(registerPage.isPrivacyPolicyOptionSelected());
	}
		
		
	
	
	@Test(priority = 21)
	public void verifyRegisteringAccountwothoutSelectPrivacyPolicyField()
	{
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generatebrandNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.selectYesForNewsletter();
		registerPage.clickContinueButton();

		Assert.assertEquals(registerPage.getPrivacyPolicyWarning(), "Warning: You must agree to the Privacy Policy!");
		
	}
	
	@Test(priority = 22)
	public void verifyRegisteringAccountPasswordFieldsForSecurity()
	{
		// Verify that password and confirm password fields are of type password
		Assert.assertEquals(registerPage.getPasswordFieldDomAttribute("type"), "password");
		Assert.assertEquals(registerPage.getPasswordConfirmFieldDomAttribute("type"), "password");

		
	}
	@Test(priority = 24)
	public void verifyRegisterAccountByFillingPasswordAndNotFillingPasswordConfirmField() {
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generatebrandNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.selectYesForNewsletter();
		registerPage.selectPrivacyPolicyOption();
		registerPage.clickContinueButton();
		
		Assert.assertEquals(registerPage.getPasswordConfirmMismatchWarning(), "Password confirmation does not match password!");
			

	}
	
	
	@Test(priority = 25)
	public void verifyRegisterAccountPageBreadcrumbURLTitleHeading() {
			Assert.assertEquals(registerPage.didWeNavigatToRegisterPage(), true);
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("registerPageURL"));
			Assert.assertEquals(driver.getTitle(), "Register Account");
			Assert.assertEquals(registerPage.getPageHeading() , "Register Account");
			

	}

	@Test(priority = 27)
	public void verifyRegisterAccountInAllEnvironments() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generatebrandNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectYesForNewsletter();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();
		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		Assert.assertTrue(accountSuccessPage.isAccountSuccessPageDisplayed());

	}
}
