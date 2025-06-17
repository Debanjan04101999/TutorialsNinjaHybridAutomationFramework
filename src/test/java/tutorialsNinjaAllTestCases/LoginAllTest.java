package tutorialsNinjaAllTestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjectsRepo.AccountPage;
import pageObjectsRepo.AccountSuccessPage;
import pageObjectsRepo.ForgottenPasswordPage;
import pageObjectsRepo.LandingPage;
import pageObjectsRepo.LoginPage;
import pageObjectsRepo.MyAccountPage;
import pageObjectsRepo.NewsletterSubscriptionPage;
import pageObjectsRepo.RegisterPage;
import pageObjectsRepo.RightColumnOption;
import testBaseClass.BaseClass;

public class LoginAllTest extends BaseClass {
	LandingPage landingPage;
	RegisterPage registerPage = new RegisterPage(driver);
	AccountSuccessPage accountSuccessPage;
	AccountPage accountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;
	LoginPage loginPage;
	RightColumnOption rightColumnOption;
	MyAccountPage myAccountPage;
	ForgottenPasswordPage forgottenPasswordPage;

	@BeforeMethod
	public void setup() {

		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		loginPage = landingPage.selectLoginOption();

	}

	@Test(priority = 1)
	public void loginWithValidCredentials() {
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		myAccountPage = loginPage.clickOnLoginButton();
		Assert.assertTrue(myAccountPage.didWeNavigatToMyAccounPage());
	}

	@Test(priority = 2)
	public void verifyLoggingIntoApplicationUsingInvalidCredentials() {

		Assert.assertTrue(loginPage.didWeNavigatToLoginPage());
		loginPage.enterEmailAddress(prop.getProperty("invalidEmail"));
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.invalidCredencialWarning(),
				"Warning: No match for E-Mail Address and/or Password.");

	}

	@Test(priority = 3)
	public void verifyLoggingIntoApplicationUsingInvalidEmailAndValidPassword() {

		Assert.assertTrue(loginPage.didWeNavigatToLoginPage());
		loginPage.enterEmailAddress(prop.getProperty("invalidEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.invalidCredencialWarning(),
				"Warning: No match for E-Mail Address and/or Password.");

	}

	@Test(priority = 4)
	public void verifyLoggingIntoApplicationUsingValidEmailAndInvalidPassword() {

		Assert.assertTrue(loginPage.didWeNavigatToLoginPage());
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.invalidCredencialWarning(),
				"Warning: No match for E-Mail Address and/or Password.");

	}

	@Test(priority = 5)
	public void verifyLoggingIntoApplicationWithoutProvidingAnyCreadencial() {

		Assert.assertTrue(loginPage.didWeNavigatToLoginPage());
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.invalidCredencialWarning(),
				"Warning: No match for E-Mail Address and/or Password.");

	}
	
	@Test(priority = 6)
	public void verifyForgottenPasswordOptionIsAvailable() throws InterruptedException {

		Assert.assertTrue(loginPage.didWeNavigatToLoginPage());
		
		forgottenPasswordPage = loginPage.clickOnForgotPasswordLink();
		Assert.assertTrue(forgottenPasswordPage.didWeNavigattoForgottenPasswordPage());

		

	}


}
