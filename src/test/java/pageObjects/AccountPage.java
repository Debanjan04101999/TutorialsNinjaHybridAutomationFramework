package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBaseClass.BaseClass;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	
	@FindBy(linkText="Subscribe / unsubscribe to newsletter")
	private WebElement subscribeUnsubscribeNewsletterOption;
	
	@FindBy(linkText="Logout")
	private boolean logoutOption;
	
	public boolean navigatedToAccountPage() {
		 return editYourAccountInformationOption.isDisplayed();
	}
	
	public NewsletterSubscriptionPage clickOnSubscribeUnscribeToNewsletterOption(){
		subscribeUnsubscribeNewsletterOption.click();
		return new NewsletterSubscriptionPage(driver);
	}
	
	public boolean isUserLoggedIn() {
		return logoutOption;
	}

}
