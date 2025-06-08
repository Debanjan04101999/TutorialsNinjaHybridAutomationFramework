package tutorialsNinjaRegister;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtilities.Utilities;
import pageObjectsRepo.LandingPage;
import testBaseClass.BaseClass;

public class TC_RF_001 extends BaseClass {
	
	LandingPage landingPage;
	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
	
	@BeforeMethod
	public void setup() {
		
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		//registerPage = landingPage.selectRegisterOption();
		
	}

	@Test
	public void verifyRegisterWithMandatoryFields() {
		
			

		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Debanjan");
		driver.findElement(By.id("input-lastname")).sendKeys("Ghosh Dostidar");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generatebrandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

		String expectedHeading = "Your Account Has Been Created!";

		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);

		String actualProperDetailsOne = "ongratulations! Your new account has been successfully created!";
		String actualProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetailsFour = "contact us";

		String expectedProperDetails = driver.findElement(By.id("content")).getText();

		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));

		driver.findElement(By.xpath("//a[text()='Continue']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

		driver.quit();
	}
}
