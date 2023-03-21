package seleniumscript;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumByClass {
	
	WebDriver driver;
	
	
	@Test
	public void loginmethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.eschool360.in/index.php");
		
		By userName=By.id("auth_user_name");		
		By password=By.id("auth_password");		
		By school=By.id("auth_school");		
		By LoginButton=By.name("Login");	
		//Exam
		By Exam =By.xpath("//span[contains(text(),'EXAMS')]");
		By MarksEntriesButton=By.xpath("//a[contains(text(),'Marks Entries')]");
		By classnamedropdown =By.id("class_name");
		By section_id=By.id("section_id");
		By exam_main_type=By.id("exam_main_type_id_for_exam_name_combo");
		By exam_id=By.id("exam_type_id_for_exam_type_combo");
		By exam_type_master=By.xpath("//a[contains(text(),'Exam Type Master')]");
		//expenses 
		By expensestab=By.xpath("//span[contains(text(),'EXPENSES')]");

		
		userName.findElement(driver).sendKeys("admin");
		password.findElement(driver).sendKeys("admin");
		school.findElement(driver).sendKeys("1");
		LoginButton.findElement(driver).click();
		     	
		Thread.sleep(3000);
		
					
		//By classnamedropdown =By.id("class_name");
		
		Exam.findElement(driver).click();
		MarksEntriesButton.findElement(driver).click();
		Thread.sleep(3000);
		driver.switchTo().frame(1);
		
		Select combobox_Exam;
		classnamedropdown.findElement(driver).click();
		combobox_Exam=new Select(classnamedropdown.findElement(driver));
		combobox_Exam.selectByIndex(3);
		
		section_id.findElement(driver).click();
		combobox_Exam=new Select(section_id.findElement(driver));
		combobox_Exam.selectByIndex(1);
		
		exam_main_type.findElement(driver).click();
		combobox_Exam=new Select(exam_main_type.findElement(driver));
		combobox_Exam.selectByIndex(1);
		
		exam_id.findElement(driver).click();
		combobox_Exam=new Select(exam_id.findElement(driver));
		combobox_Exam.selectByIndex(1);
		
		WebElement student_marks_element ;
		for(int student = 1;student <= 10;student ++) {
			for(int marks = 2; marks <= 7; marks++) {
				student_marks_element = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
				student_marks_element.clear();
				student_marks_element.sendKeys("90");			
	}
			
		}
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		exam_type_master.findElement(driver).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		expensestab.findElement(driver).click();
		driver.switchTo().defaultContent();
	}
	
}	
