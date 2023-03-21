package testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class SeleniumScript2 {
	
	WebDriver driver;
	WebElement dropyear;
	public String msg=null;
	Select combobox_Value;
	@Test
	public void loginfacebook() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Automation training\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/login.php?next=https%3A%2F%2Fwww.facebook.com%2Fdevice");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		// clickcreate new account		
		By createnewacc=By.xpath("//*[@id=\"login_link\"]/div[3]/a");
		//creat account
		By editbox1=By.xpath("//input[contains(@name,'firstname')]");
		By editbox2=By.xpath("//input[contains(@name,'lastname')]");
		By editbox3=By.xpath("//input[contains(@name,'reg_email__')]");
		By editbox4=By.xpath("//input[contains(@name,'reg_passwd__')]");
		//dropdown
		By birthday_mon=By.xpath("//select[contains(@name,'birthday_month')]");
		By birthday_day=By.xpath("//select[contains(@name,'birthday_day')]");
		By birthday_year=By.xpath("//select[contains(@name,'birthday_year')]");
		//radio button
		By radio_button=By.xpath("//label[contains(text(),'Female')]");
		//sign up
		By sign_up=By.xpath("(//button[contains(text(),'Sign Up')])[1]");
		
		//createnewacc.findElement(driver).click();
		button_click(createnewacc,"Create New account","Login Page");
		Thread.sleep(3000);
		//account page
		editBox_Util(editbox1,"First name","Create accountpage","Joycelin");
		//editbox1.findElement(driver).sendKeys("Joycelin");
		//editbox2.findElement(driver).sendKeys("Sudesh");
		editBox_Util(editbox2,"last name","Create accountpage","Sudesh");
		//editbox3.findElement(driver).sendKeys("6026298153");
		editBox_Util(editbox3,"last name","Create accountpage","6026298153");
		//editbox4.findElement(driver).sendKeys("asdfghr@12");
		editBox_Util(editbox4,"last name","Create accountpage","asdfghr@12");
		//dropdown
		Select dropdown_box;
		//birthday_mon.findElement(driver).click();
		
		button_click(birthday_mon,"Birthday Month","Create accountpage");
		dropdown_select(birthday_mon, "Birthday Month", "Create accountpage", 8);
		//dropdown_box=new Select(birthday_mon.findElement(driver));
		//dropdown_box.selectByIndex(8);
		
		button_click(birthday_day,"Birthday Day","Create accountpage");
		dropdown_select(birthday_day, "Birthday Day", "Create accountpage", 18);
		/*birthday_day.findElement(driver).click();
		dropdown_box=new Select(birthday_day.findElement(driver));
		dropdown_box.selectByIndex(18);*/
		
		//button_click(birthday_year,"Birthday year","Create accountpage");
		//driver.findElement(By.xpath("//select[contains(@name,'birthday_year")).click();    
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//select[contains(@name,'birthday_year/option[34]")));
		//dropdown_select(birthday_year, "Birthday Year", "Create accountpage", 1986);
		//selecting option fron dropdown wihtout methods
		//WebElement element=driver.findElement(By.xpath("//select[contains(@name,'birthday_year"));
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click()", "1986");
		birthday_year.findElement(driver).click();
		dropdown_box=new Select(birthday_year.findElement(driver));
		dropdown_box.selectByValue("1986");
		
		/*find the dropdown using xpath
		WebElement dropdownElement = driver.findElement(By.xpath("//select[contains(@name,'birthday_year')]"));

		//cast driver object to JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		//set the dropdown vaue t0 say 'Monday' using javascript
		jse.executeScript("arguments[0].value='1986'", dropdownElement);*/

		
		//radiobutton
		//radio_button.findElement(driver).click();
		button_click(radio_button,"Female","Create accountpage");
		//sign_up.findElement(driver).click();
		button_click(sign_up,"Sign Up","Create accountpage");
		
	}

	public  String elementPresent(By locator, String locatorName, String pageName) {
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		//WebElement element =(WebElement) locator;
		try {

			Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver)

					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class);			

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			System.out.println("I have entered into catch block");
			//e.printStackTrace();
			msg = "Locator Name:-"+locatorName+" : "+locator+" is not identified in Page : "+pageName;
		}
		return msg;	
}
	public void button_click(By locator, String locatorName,String pageName) {
		System.out.println(driver);
		System.out.println(driver);
		msg=elementPresent(locator,locatorName,pageName);
		if(msg==null) {
			locator.findElement(driver).click();
		}else {
	System.out.println(msg);
	}
}
	
	public void editBox_Util(By locator, String locatorName,String pageName, String value) {
		System.out.println(driver);
		System.out.println(locator);
		msg = elementPresent(locator, locatorName, pageName);
		if(msg==null) {		 
		locator.findElement(driver).sendKeys(Keys.chord(Keys.CONTROL,"a"),value);

		}else {

		System.out.println(msg);

		}
	}
	public void dropdown_select(By locator, String locatorName,String pageName, int value) {
		System.out.println(driver);
		System.out.println(locator);
		msg = elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			locator.findElement(driver).click();
			combobox_Value=new Select(locator.findElement(driver));
			combobox_Value.selectByIndex(value);
		}else {
			System.out.println(msg);
		}
	}
	
}