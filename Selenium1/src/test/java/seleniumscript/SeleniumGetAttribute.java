package seleniumscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumGetAttribute {

	WebDriver driver;
	
	public void loginmethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation training\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		
		
	}
	
	
}
