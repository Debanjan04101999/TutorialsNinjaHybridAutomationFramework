package tutorialsNinjaRegister;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_007 {

	@Test
	public void verifyNavigatingToRegisterAccountUsingMultipleWay() {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div[id='account-register'] li:nth-child(3) a:nth-child(1)")).isDisplayed());

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div[id='account-register'] li:nth-child(3) a:nth-child(1)")).isDisplayed());
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > aside:nth-child(2) > div:nth-child(1) > a:nth-child(2)")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div[id='account-register'] li:nth-child(3) a:nth-child(1)")).isDisplayed());
		
		
		
		
		
		// driver.quit();
	}
}
