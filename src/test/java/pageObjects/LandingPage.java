package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(name = "search")
	private WebElement searchBoxField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public void clickOnMyAccountDropMenu() {
		// elementUtils.clickOnElement(myAccountDropMenu,Utilities.EXPLICIT_WAIT_TIME);
		myAccountDropMenu.click();
	}

	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}

	public LoginPage selectLoginOption() {
		 loginOption.click();
		return new LoginPage(driver);
	}
/*
	public void enterSearhTerm(String searchTermText) {
		elementUtils.enterTextIntoElement(searchBoxField, Utilities.EXPLICIT_WAIT_TIME, searchTermText);
	}

	public SearchPage clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton,Utilities.EXPLICIT_WAIT_TIME);
		return new SearchPage(driver);
*/
}
