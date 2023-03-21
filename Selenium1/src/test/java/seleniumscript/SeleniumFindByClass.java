package seleniumscript;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumFindByClass {
	
WebDriver driver;
	@FindBy(id="auth_user_name") WebElement userName;
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
	
	//Fees
	@FindBy(xpath="//span[contains(text(),'FEES')]") WebElement Fees;
	@FindBy(xpath="//a[contains(text(),'Fee Master')]") WebElement Fees_Master;
	
	@FindBy(xpath="//span[contains(text(),'EXPENSES')]") WebElement expenses;
	
	@Test
	public void loginmethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		driver.get("https://demo.eschool360.in/index.php");
		userName.sendKeys("admin");
		password.sendKeys("admin");
		school.sendKeys("1");
		LoginButton.click();
		driver.manage().window().maximize();
		
		Exam.click();
		MarksEntries.click();
		driver.switchTo().frame(1);
		//dropdown
		Select combobox_Exam;
		
		class_name.click();
		combobox_Exam=new Select(class_name);
		combobox_Exam.selectByIndex(3);
		
		section_id.click();
		Select sectionid=new Select(section_id);
		sectionid.selectByIndex(1);
		
		exam_id.click();
		Select exammaintype=new Select(exam_id);
		exammaintype.selectByIndex(1);
		
		exam_type.click();
		Select examtype=new Select(exam_type);
		examtype.selectByIndex(1);
		
		WebElement student_marks_element;
			for(int student=1;student<=2;student++) {
				for(int marks=2;marks<=7;marks++) {
					student_marks_element = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
					student_marks_element.clear();
					student_marks_element.sendKeys("90");		
					
				}
				
			}
		
			driver.switchTo().defaultContent();
			
			exam_master.click();
			
			//Select exam_type_master=new Select(exam_master);
			driver.switchTo().defaultContent();
			Exam.click();
			
			
			
			Fees.click();
			Fees_Master.click();
			driver.switchTo().defaultContent();;
			
			expenses.click();
			driver.switchTo().defaultContent();
	
	
	}	

}
