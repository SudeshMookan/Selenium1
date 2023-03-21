package seleniumscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class Webpage {
	
	WebDriver driver;
	public String msg=null;
	
	@Test
	public void login() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation training\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://www.catamilacademy.org/cta/login.aspx");
		
		//login page
		By userEmail=By.id("Txt_Mail_Id");
		By password=By.id("Txt_Password");
		By LoginButton=By.name("Btn_Login");
		By profile=By.xpath("By.xpath(\"(//span[contains(text(),'Profile')])[1]");
		
		editBox_Util(userEmail,"User Email","Login Page","joycelins@north.aztamilschools.org");
		editBox_Util(password,"Password","Login Page","Passw0rd.");
		//click
		button_menu_click(LoginButton, "Login", "Login Page");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		//mousehover(profile,"Profile","Main Page");
		
		//WebElement element =driver.findElement(By.xpath("(//span[contains(text(),'Profile')])[1]"));
				action.moveToElement(driver.findElement(By.xpath("(//span[contains(text(),'Profile')])[1]"))).perform();
				driver.findElement(By.xpath("(//span[contains(text(),'Modify My Profile')])[1]")).click();
				Thread.sleep(3000);
		
		
	}

	public  String elementPresent(By locator, String locatorName, String pageName) {		

		try {

		Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver)	
		.withTimeout(Duration.ofSeconds(30))
		.pollingEvery(Duration.ofSeconds(5))
		.ignoring(StaleElementReferenceException.class);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {		
		System.out.println("I have entered into catch block");		
		msg = "Locator Name:-"+locatorName+" : "+locator+" is not identified in Page : "+pageName;
		}
		return msg;

		}
	public void editBox_Util(By locator, String locatorName,String pageName,String value) {
		System.out.println(driver);
		System.out.println(locator);
		msg=elementPresent(locator,locatorName, pageName);
		if(msg==null) {
			//locator.sendKeys(Keys.chord(Keys.CONTROL,"a"),value);
			locator.findElement(driver).sendKeys(Keys.chord(Keys.CONTROL,"a"),value);
		}else {
			System.out.println(msg);
		}
}

	//click
			public void button_menu_click(By locator, String locatorName, String pageName) {
				System.out.println(driver);
				System.out.println(locator);
				msg = elementPresent(locator, locatorName, pageName);
				if(msg==null) {
					locator.findElement(driver).click();
				}else {
					System.out.println(msg);
				}
			}
	
			public void mousehover(By locator, String locatorName, String pageName) {
				System.out.println(driver);
				System.out.println(locator);
				msg = elementPresent(locator, locatorName, pageName);
				if(msg==null) {
					locator.findElement(driver).click();
				}else {
					System.out.println(msg);
				}
			}
}
