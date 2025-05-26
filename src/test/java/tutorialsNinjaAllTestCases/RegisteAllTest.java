package tutorialsNinjaAllTestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBaseClass.BaseClass;
import utilities.Utilities;
import pageObjects.AccountPage;
import pageObjects.AccountSuccessPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.NewsletterSubscriptionPage;
import pageObjects.RegisterPage;
import testBaseClass.BaseClass;

public class RegisteAllTest extends BaseClass {
	LandingPage landingPage;
	RegisterPage registerPage = new RegisterPage(driver);
	AccountSuccessPage accountSuccessPage;
	AccountPage accountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;
	LoginPage loginPage;

	@Test(priority = 1)
	public void verifyRegistingAccountUsingMandtoryFields() {
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();

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
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();

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
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id=\"input-firstname\"]/following-sibling::div")).getText(),
				expectedFirstNameWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id=\"input-lastname\"]/following-sibling::div")).getText(),
				expectedLastNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),
				expectedEmailWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),
				expectedTelephoneWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),
				expectedPasswordWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),
				expectedPrivacyPolicyWarning);
	}

	@Test(priority = 5)
	public void verifyRegisterWhenYesOptionIsSelectedForNewsletterField() {
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();

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
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();

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

		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();
		Assert.assertTrue(
				driver.findElement(By.cssSelector("div[id='account-register'] li:nth-child(3) a:nth-child(1)"))
						.isDisplayed());

		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		loginPage = landingPage.selectLoginOption();
		loginPage.clickOnnewCustomerContinueButton();
		Assert.assertTrue(
				driver.findElement(By.cssSelector("div[id='account-register'] li:nth-child(3) a:nth-child(1)"))
						.isDisplayed());

		
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		loginPage = landingPage.selectLoginOption();
		Thread.sleep(5000);
		

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

		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(),
				expectedError);

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

		Assert.assertEquals(registerPage.getExistingEmailWarning(),expectedError);

	}
	
	@Test(priority = 10)
	public void verifyRegisteringAccountByProvidingInvalideEmail() throws InterruptedException {

		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();

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

		Assert.assertEquals(
				driver.findElement(By.className("alert-dismissible")).getText(),
				expectedError);

	}

}
