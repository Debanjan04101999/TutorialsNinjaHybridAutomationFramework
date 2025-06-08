package pageObjectsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSuccessPage extends BasePage  {

	public AccountSuccessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText="Logout")
	private WebElement logoutOption; 
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Success']")
	private WebElement accountSuccessBreadcrumbOption;
	
	@FindBy(id="content")
	private WebElement successPageContent;
	
	@FindBy(linkText="Continue")
	private WebElement continueButton; 
	
	public boolean isUserLoggedIn() {
		return logoutOption.isDisplayed();
	}
	
	public boolean isAccountSuccessPageDisplayed() {
		return accountSuccessBreadcrumbOption.isDisplayed();
	}
	
	public String getProperContentDisplayed() {
		return successPageContent.getText();
	}
	
	public AccountPage clickOnContinueButton() {
		continueButton.click();
		return new AccountPage(driver);
	}


}
