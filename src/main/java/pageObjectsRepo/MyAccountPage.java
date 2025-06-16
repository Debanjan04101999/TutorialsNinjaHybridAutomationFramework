package pageObjectsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(linkText = "My Account")
	private WebElement myAccount;
	
	
	public boolean didWeNavigatToMyAccounPage() {
		return myAccount.isDisplayed();
	}

}
