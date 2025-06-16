import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBaseClass.BaseClass;

public class practice {
	@Test
	public void test() {
		
		
        WebDriver driver = new ChromeDriver();
        driver.get("https://int.zigzag.lk/collections/work-wear-1/products/side-pleated-long-sleeve-brown-satin-top");
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        String expectedText = driver.findElement(By.xpath("//span[contains(text(),'Note: Product Colour May Slightly Vary Due To Phot')]")).getText();
						
        
        Assert.assertEquals(expectedText, "Note: Product Colour May Slightly Vary Due To Photographic Lighting Sources Or Your Monitor Setting.");
		
	}
	

}
