package genericUtilities;

import java.io.FileReader;
import java.util.Date;
import java.util.Properties;

public class Utilities {
	public static final int EXPLICIT_WAIT_TIME = 30;
	public static final int IMPLICIT_WAIT_TIME = 3;

	public static String generatebrandNewEmail() {
		String brandNewEmail = new Date().toString().replace(" ", "").replace(":", "") + "@gmail.com";
		return brandNewEmail;

	}

	public static Properties loadPropertiesFile() {

		Properties prop = null;

		try {
			prop = new Properties();
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\ApplicationData.properties");
			prop.load(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;

	}

}
