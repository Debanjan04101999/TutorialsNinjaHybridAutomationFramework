package pageObjectsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgottenPasswordPage extends BasePage {

	public ForgottenPasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText= "Forgotten Password")
	private WebElement forgottenPageBreadcrumb;

	

	public boolean didWeNavigattoForgottenPasswordPage() {
		return forgottenPageBreadcrumb.isDisplayed();
	}

}
