package testng;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class SeleniumFindByClassFluent {
	//p 
	WebDriver driver;
	public String msg=null;
	Select combobox_Value;
	

	@FindBy(id="auth_user_name") WebElement username;
	@FindBy(id="auth_password") WebElement password;
	@FindBy(id="auth_school") WebElement school;
	@FindBy(name="Login") WebElement LoginButton;
	//Exam
		@FindBy(xpath="//span[contains(text(),'EXAMS')]") WebElement Exam;
		@FindBy(xpath="//a[contains(text(),'Marks Entries')]") WebElement MarksEntries;
		@FindBy(id="class_name") WebElement class_name;
		@FindBy(id="section_id") WebElement section_id;
		@FindBy(id="exam_main_type_id_for_exam_name_combo") WebElement exam_id;
		@FindBy(id="exam_type_id_for_exam_type_combo") WebElement exam_type;
		@FindBy(xpath="//a[contains(text(),'Exam Type Master')]") WebElement exam_master;
	
@Test
	public void loginmethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		driver.get("https://demo.eschool360.in/index.php");
		//login
		editBox_Util(username, "User Name", "Login Page", "admin");
		editBox_Util(password, "User Name", "Login Page", "admin");
		editBox_Util(school, "User Name", "Login Page", "1");
		button_menu_click(LoginButton, "Login Button", "Login Page");
		driver.manage().window().maximize();
		//exam
		button_menu_click(Exam, "EXAMS", "Menu Page");
		button_menu_click(MarksEntries, "Marks Entries", "Marks Entries under Exam");
		driver.switchTo().frame(1);
		//dropdown
		
		dropdown_select(class_name, "Class", "class under mark entries submenu", 3);
		dropdown_select(section_id, "Section", "section under mark entries submenu", 1);
		dropdown_select(exam_id, "exam Main TypeId", "exam typeID under mark entries submenu", 1);
		dropdown_select(exam_type, "exam Main Type", "exam type under mark entries submenu", 1);
		
		
		
	}
	
	public  String elementPresent(WebElement element, String locatorName, String pageName) {
		
		try {

			Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver)

					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class);

			//.ignoring(StaleElementReferenceException.class);

			//.until(ExpectedConditions.visibilityOfElementLocated(By.id("auth_user_name")));

			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			System.out.println("I have entered into catch block");
			//e.printStackTrace();
			msg = "Locator Name:-"+locatorName+" : "+element+" is not identified in Page : "+pageName;
		}
		return msg;
	}
		public void editBox_Util(WebElement locator, String locatorName,String pageName,String value) {
			System.out.println(driver);
			System.out.println(locator);
			msg=elementPresent(locator,locatorName, pageName);
			if(msg==null) {
				locator.sendKeys(Keys.chord(Keys.CONTROL,"a"),value);
				//locator.findElement(driver).sendKeys(Keys.chord(Keys.CONTROL,"a"),value);
			}else {
				System.out.println(msg);
			}
		}
		//click
		public void button_menu_click(WebElement locator, String locatorName, String pageName) {
			System.out.println(driver);
			System.out.println(locator);
			msg = elementPresent(locator, locatorName, pageName);
			if(msg==null) {
				locator.click();
			}else {
				System.out.println(msg);
			}
		}
		//dropdown
		public void dropdown_select(WebElement locator, String locatorName, String pageName,int value ) {
			System.out.println(driver);
			System.out.println(locator);
			msg = elementPresent(locator, locatorName, pageName);
			if(msg==null) {
				locator.click();
				combobox_Value=new Select (locator);
				combobox_Value.selectByIndex(value);
			}else {
				System.out.println(msg);
			}

		}

	
	
	
	
}
