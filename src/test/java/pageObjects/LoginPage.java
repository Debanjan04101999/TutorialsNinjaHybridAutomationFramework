package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText ="Continue")
	private WebElement newCustomerContinueButton;
	
	public void clickOnnewCustomerContinueButton() {
		// elementUtils.clickOnElement(myAccountDropMenu,Utilities.EXPLICIT_WAIT_TIME);
		newCustomerContinueButton.click();
	}


}
