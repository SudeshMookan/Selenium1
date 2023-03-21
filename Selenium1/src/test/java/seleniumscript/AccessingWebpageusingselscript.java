package seleniumscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AccessingWebpageusingselscript {

	WebDriver driver;
	@Test


	public void loginmethod() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Automation training\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.catamilacademy.org/cta/login.aspx");
		driver.findElement(By.id("Txt_Mail_Id")).sendKeys("joycelins@north.aztamilschools.org");
		driver.findElement(By.id("Txt_Password")).sendKeys("Passw0rd.");
		driver.findElement(By.name("Btn_Login")).click();
		driver.manage().window().maximize();

		Thread.sleep(3000);


		//hover
		Actions action=new Actions(driver);
		//WebElement element =driver.findElement(By.xpath("(//span[contains(text(),'Profile')])[1]"));
		action.moveToElement(driver.findElement(By.xpath("(//span[contains(text(),'Profile')])[1]"))).perform();
		driver.findElement(By.xpath("(//span[contains(text(),'Modify My Profile')])[1]")).click();
		Thread.sleep(3000);
		//modify profile page
		driver.findElement(By.xpath("//td[contains(text(),'User Name')]")).sendKeys("Joycelin");
		driver.findElement(By.xpath("//td[contains(text(),'User Email')]")).sendKeys("joycelins@north.aztamilschools.org");

		Thread.sleep(6000);

		driver.switchTo().frame(driver.findElement(By.id("contentFrame")));
		Thread.sleep(3000);
		//gettext for label1
		String expected_Result = "User Name";
		String var = driver.findElement(By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[2]/td")).getText();
		System.out.println(var);
		if(expected_Result.equalsIgnoreCase(var)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}

		//getattribute for value1
		expected_Result = "Joycelins123";
		String userNameValue = driver.findElement(By.id("Txt_Uname")).getAttribute("value");
		System.out.println(userNameValue);

		if(expected_Result.equalsIgnoreCase(userNameValue)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}
		//gettext for label2
		String expected_Result2 = "User Email";
		String var1 = driver.findElement(By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[3]/td")).getText();
		System.out.println(var1);
		if(expected_Result2.equalsIgnoreCase(var1)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}
		//getattribute for value2
		expected_Result2="JoycelinS@north.aztamilschools.org";
		String useremailvalue=driver.findElement(By.id("Txt_Mailid")).getAttribute("value");
		System.out.println(useremailvalue);
		if(expected_Result2.equalsIgnoreCase(useremailvalue)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}
		//gettext for label3
		String expected_Result3="Street";
		String var2=driver.findElement(By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[6]/td")).getText();
		System.out.println(var2);
		if(expected_Result3.equalsIgnoreCase(var2)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}

		//getattribute for value3
		expected_Result3="1";
		String streetvalue=driver.findElement(By.id("Txt_Street")).getAttribute("value");
		System.out.println(streetvalue);
		if(expected_Result2.equalsIgnoreCase(streetvalue)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}

		//gettext for label4
		String expected_Result4="City";
		String var3=driver.findElement(By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[7]/td")).getText();
		System.out.println(var2);
		if(expected_Result3.equalsIgnoreCase(var3)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}

		//getattribute for value4
		expected_Result3="1";
		String cityvalue=driver.findElement(By.id("Txt_City")).getAttribute("value");
		System.out.println(cityvalue);
		if(expected_Result2.equalsIgnoreCase(cityvalue)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}
		//gettext for label5
		String expected_Result5="Zip/Postal Code";
		String var4=driver.findElement(By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[9]/td")).getText();
		System.out.println(var4);
		if(expected_Result3.equalsIgnoreCase(var4)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}

		//getattribute for value5
		expected_Result5="1";
		String postalvalue=driver.findElement(By.id("Txt_Zip")).getAttribute("value");
		System.out.println(postalvalue);
		if(expected_Result2.equalsIgnoreCase(postalvalue)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}
		//gettext for label6
		String expected_Result6="Phone #1";
		String var5=driver.findElement(By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[9]/td")).getText();
		System.out.println(var5);
		if(expected_Result3.equalsIgnoreCase(var5)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}

		//getattribute for value6
		expected_Result6="1";
		String phonevalue=driver.findElement(By.id("Txt_Zip")).getAttribute("value");
		System.out.println(phonevalue);
		if(expected_Result2.equalsIgnoreCase(phonevalue)) {
			System.out.println("Expectd and Actual values are same");
		}else {
			System.out.println("Expectd and Actual values are not same");
		}

	}


}







