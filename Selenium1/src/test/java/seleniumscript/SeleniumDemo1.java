package seleniumscript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumDemo1 {

	WebDriver driver;

	@Test
	public void loginmethod() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Automation training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.eschool360.in/index.php");
		driver.findElement(By.id("auth_user_name")).sendKeys("admin");
		driver.findElement(By.id("auth_password")).sendKeys("admin");
		driver.findElement(By.id("auth_school")).sendKeys("1");
		driver.findElement(By.name("Login")).click();
		driver.manage().window().maximize();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Marks Entries')]")).click();

		Thread.sleep(3000);

		//frame 1.index 2. frame name 3. x-path
		driver.switchTo().frame(1);
		//driver.switchTo().frame("//iframe[contains(@id,'main')]");

		Select combobox_Exam;

		//Exam
		WebElement mark_entries=driver.findElement(By.id("class_name"));
		mark_entries.click();
		combobox_Exam=new Select(mark_entries);
		combobox_Exam.selectByIndex(3);
		Thread.sleep(3000);

		WebElement mark_entries2=driver.findElement(By.id("section_id"));
		mark_entries2.click();
		combobox_Exam=new Select(mark_entries2);
		combobox_Exam.selectByVisibleText("Section A");

		WebElement mark_entries3=driver.findElement(By.id("exam_main_type_id_for_exam_name_combo"));
		mark_entries3.click();
		combobox_Exam=new Select(mark_entries3);
		combobox_Exam.selectByIndex(1);

		WebElement mark_entries4=driver.findElement(By.id("exam_type_id_for_exam_type_combo"));
		mark_entries4.click();
		combobox_Exam=new Select(mark_entries4);
		combobox_Exam.selectByIndex(1);

		WebElement student_marks_element ;
		for(int student = 1;student <= 5;student ++) {
			for(int marks = 2; marks <= 7; marks++) {
				student_marks_element = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
				//student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"95");
				//student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"95");
				student_marks_element.clear();
				student_marks_element.sendKeys("90");
			}
		}



		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//a[contains(text(),'Exam Type Master')]")).click();




	}




}
