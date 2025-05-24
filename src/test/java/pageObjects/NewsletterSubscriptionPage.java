package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsletterSubscriptionPage extends BasePage {

	public NewsletterSubscriptionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='0']")
	private WebElement noNewsletterOption;
	
	public boolean isYesNewsletterOptionSelected() {
		return yesNewsletterOption.isSelected();
	}
	
	public boolean isNoNewsletterOptionSelected() {
		return noNewsletterOption.isSelected();
	}

}
