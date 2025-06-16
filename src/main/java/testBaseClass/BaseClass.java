package testBaseClass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;

	@BeforeMethod
	@Parameters({ "os", "browser" })
	public void setup(@Optional("windows") String os, @Optional("chrome") String br) throws IOException {
		FileReader file = new FileReader("C:\\Users\\LENOVO\\eclipse-workspace\\TutorialsNinjaHybridAutomationFramework\\src\\test\\recources\\ApplicationData.properties");
		prop = new Properties();
		prop.load(file);

		if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid browser name..");
				return;
			}
		}
		
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("appURL1"));// reading usl from properties file
		
		

	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

}
