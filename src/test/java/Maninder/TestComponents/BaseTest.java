package Maninder.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.pageobjects.Login;

public class BaseTest {
	WebDriver driver;
	public Login login;
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");	
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//code to initialize firefox browser
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public Login launchApplication() throws IOException {
		driver = initializeDriver();
		login = new Login(driver);
		login.goTo();
		return login;
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
