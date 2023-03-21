package seleniumscript;

import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class FluentWaitpgm extends ExtentClassReport{

	WebDriver driver;
	public String  msg =null;
	Select combobox_Value;


	@Test

	public void loginMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		test = extent.createTest("loginMethod");
		driver.get("https://demo.eschool360.in/index.php");

		By userName=By.id("auth_user_name");
		By passWord=By.id("auth_password");
		By schoolId=By.id("auth_school");
		By loginButton=By.name("Login");

		//SETUP
		By setupButton=By.xpath("//span[contains(text(),'SETUP')]");
		By classSectionSubjects=By.xpath("//a[contains(text(),'Class Section Subjects')]");

		//dropdown
		By class_subjects=By.id("cmb_classname");
		By section_subjects=By.id("cmb_section");

		//subject master
		By subject_master=By.xpath("//a[contains(text(),'Subject Master')]");
		By subjectMaster_SearchButton=By.name("txt_Search");
		By subjectMaster_SearchClick=By.xpath("//a[contains(text(),'Search')]");

		//Exams
		By examsButton=By.xpath("//span[contains(text(),'EXAMS')]");
		By exams_marksEntries=By.xpath("//a[contains(text(),'Marks Entries')]");
		
		editBox_Util(userName, "User Name", "Login Page", "admin");
		editBox_Util(passWord, "Password","Login Page","admin");		
		editBox_Util(schoolId, "School Id","Login Page","1");		
		button_menu_click(loginButton, "Login Button", "Login Page");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		test = extent.createTest("HomePage");

		//SETUP

		button_menu_click(setupButton,"setup Button ", " Menu Page ");		
		button_menu_click(classSectionSubjects, "Class Section Subjects", "Setup Menu Page");		
		Thread.sleep(3000);
		driver.switchTo().frame(1);


		//dropdown-Select combobox_Subjects;
		dropdown_select(class_subjects, "Class Subjects", "Subject Master Page Under Setup", 4);
		dropdown_select(section_subjects, "Sectios Subjects", "Subject Master Page Under Setup", 1);
	

		driver.switchTo().defaultContent();

		/*subject_master.findElement(driver).click();
		driver.switchTo().frame(1);
		subjectMaster_SearchButton.findElement(driver).sendKeys("Social");
		subjectMaster_SearchClick.findElement(driver).click();*/

		driver.switchTo().defaultContent();

		//exams
		button_menu_click(examsButton,"Exam Button","Menu Page");
		button_menu_click(exams_marksEntries,"Marks Entries","Exam Menu Page");
		driver.switchTo().frame(1);
	
		
		
		driver.switchTo().defaultContent();		          		

	}


	public  String elementPresent(By locator, String locatorName, String pageName) {
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		//WebElement element =(WebElement) locator;
		try {

			Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver)

					//new FluentWait<WebDriver>(driver)

					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class);

			//.ignoring(StaleElementReferenceException.class);

			//.until(ExpectedConditions.visibilityOfElementLocated(By.id("auth_user_name")));

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
	//edit
	public void editBox_Util(By locator, String locatorName, String pageName, String value) {
	 
		System.out.println(driver);
		System.out.println(locator);
		msg = elementPresent(locator, locatorName, pageName);
		if(msg==null) {		 
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

	public void dropdown_select(By locator, String locatorName, String pageName,int value ) {
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

