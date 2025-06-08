package tutorialsNinjaRegister;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.Utilities;

public class TC_RF_008 {

	@Test
	public void verifyRegisteringAccountByProvidingMismatchingPasswords() {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys("Motoori");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generatebrandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("abcd");
		driver.findElement(By.id("input-confirm")).sendKeys("1234");
  		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedError = "Password confirmation does not match password!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(), expectedError);
		
		//driver.quit();
	}
}
