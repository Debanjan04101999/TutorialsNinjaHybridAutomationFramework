
package tutorialsNinjaAllTestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjectsRepo.AccountPage;
import pageObjectsRepo.AccountSuccessPage;
import pageObjectsRepo.LandingPage;
import pageObjectsRepo.LoginPage;
import pageObjectsRepo.MyAccountPage;
import pageObjectsRepo.NewsletterSubscriptionPage;
import pageObjectsRepo.RegisterPage;
import pageObjectsRepo.RightColumnOption;
import pageObjectsRepo.SearchPage;
import testBaseClass.BaseClass;

public class ScarchAllTest extends BaseClass {
	LandingPage landingPage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	AccountPage accountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;
	LoginPage loginPage;
	RightColumnOption rightColumnOption;
	SearchPage searchPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setup() {

		landingPage = new LandingPage(driver);

	}

	@Test(priority = 1)
	public void VerifyScarchingWithAnExistingProductName() {

		landingPage.enterProductIntoSearchBoxField(prop.getProperty("existingProduct"));
		searchPage = landingPage.clickOnSearchButton();

		Assert.assertTrue(searchPage.didWeNavgateToScerchResultPage());
		Assert.assertTrue(searchPage.isProductDisplayedInSearchResults());

	}

	@Test(priority = 2)
	public void VerifyScarchingWithAnNonExistingProductName() {
		landingPage.enterProductIntoSearchBoxField(prop.getProperty("nonexistingProduct"));
		searchPage = landingPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.didWeNavgateToScerchResultPage());
		Assert.assertEquals(searchPage.getNoProductMessage(), "There is no product that matches the search criteria.");

	}

	@Test(priority = 3)
	public void VerifyScarchingWithoutProvidingProductName() {

		searchPage = landingPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.didWeNavgateToScerchResultPage());
		Assert.assertEquals(searchPage.getNoProductMessage(), "There is no product that matches the search criteria.");

	}

	@Test(priority = 4)
	public void validateSearchingForAProductAfterLoginTheApplication() {

		landingPage.clickOnMyAccountDropMenu();
		loginPage = landingPage.selectLoginOption();
		myAccountPage = loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		Assert.assertTrue(myAccountPage.didWeNavigatToMyAccounPage());
		
		  landingPage.enterProductIntoSearchBoxField(prop.getProperty("existingProduct"  )); searchPage = landingPage.clickOnSearchButton();
		  Assert.assertTrue(searchPage.didWeNavgateToScerchResultPage());
		  Assert.assertTrue(searchPage.isProductDisplayedInSearchResults());
		 
	}

	@Test(priority = 5)
	public void verifyProductSeachResultingMultipleProducts() {

		landingPage.enterProductIntoSearchBoxField(prop.getProperty("existingProducttwo"));
		searchPage = landingPage.clickOnSearchButton();

		Assert.assertTrue(searchPage.didWeNavgateToScerchResultPage());
		Assert.assertTrue(searchPage.getProductsCount() > 1);

	}

	@Test(priority = 6)
	public void verifySearchFunctionalityFieldsPlaceHolders() {

		Assert.assertEquals(landingPage.getSearchBoxPlaceholderText(), "Search");
		searchPage = landingPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.didWeNavgateToScerchResultPage());
		Assert.assertEquals(searchPage.getSearchCreteriaBoxFieldPlaceholderText(), "Keywords");

	}

	@Test(priority = 7)
	public void verifySearchFunctionalityUsingSearchCriteriaField() {
		searchPage = landingPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.didWeNavgateToScerchResultPage());
		searchPage.enterProductIntoSearchCreteriaBoxField(prop.getProperty("existingProduct"));
		searchPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.didWeNavgateToScerchResultPage());
		Assert.assertTrue(searchPage.isProductDisplayedInSearchResults());
	}

	@Test(priority = 8)
	public void verifySearchUsingTextInProductDescription() {
		searchPage = landingPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.didWeNavgateToScerchResultPage());
		searchPage.enterProductIntoSearchCreteriaBoxField(prop.getProperty("textInProductDescription"));
		searchPage.clickOnScerchInProductDescriptionCheckBox();
		searchPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.didWeNavgateToScerchResultPage());
		Assert.assertTrue(searchPage.isProductHavingTextInItsDescriptionDisplayedInSearchResults());

	}

	@Test(priority = 9)
	public void verifySearchBySelectingTheCategory() throws InterruptedException {
		searchPage = landingPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.didWeNavgateToScerchResultPage());

		searchPage.enterProductIntoSearchCreteriaBoxField(prop.getProperty("existingProductThree"));
		Thread.sleep(2000);
		searchPage.selectCategoryFromDropDown("categoryName");
		searchPage.clickOnSearchButton();

		searchPage.enterProductIntoSearchCreteriaBoxField(prop.getProperty("existingProductThree"));

	}
}
