package tutorialsNinjaAllTestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.CommonUtils;
import pageObjectsRepo.AccountPage;
import pageObjectsRepo.AccountSuccessPage;
import pageObjectsRepo.LandingPage;
import pageObjectsRepo.LoginPage;
import pageObjectsRepo.NewsletterSubscriptionPage;
import pageObjectsRepo.RegisterPage;
import pageObjectsRepo.RightColumnOption;
import testBaseClass.BaseClass;

public class LogoutAllTest extends BaseClass {
	
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
	public void verifyLoggingOutUsingMyAccountDropMenu() {
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtils.generatebrandNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();
 
		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		Assert.assertTrue(accountSuccessPage.isAccountSuccessPageDisplayed());
	}
	

	

}
