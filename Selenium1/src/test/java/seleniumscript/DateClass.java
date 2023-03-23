package seleniumscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {


	System.setProperty("webdriver.edge.driver", "C:\\Automation training\\edgedriver_win64\\msedgedriver.exe");
	driver = new EdgeDriver();

	driver.get("https://www.path2usa.com/travel-companions");
	Thread.sleep(3000);
	driver.manage().window().maximize();

	driver.findElement(By.id("form-field-travel_comp_date")).click();
	new WebDriverWait(driver, Duration.ofSeconds(5))
	.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("dayContainer")));

	SelectDate("8","July","2023");

	}

	public static void SelectDate(String exDay, String exMonth, String exYear) throws InterruptedException {

	String month = driver.findElement(By.className("flatpickr-month")).getText();
	String[] monthSplit = month.split("[\r\n]+");
	System.out.println(monthSplit[0]);
	//System.out.println(monthSplit[1]);
	String year = driver.findElement(By.xpath("//div[contains(@class, 'numInputWrapper')]/input")).getAttribute("value");

	System.out.println(month);
	System.out.println(year);

	while(!monthSplit[0].equals(exMonth)&& year.equals(exYear)) {
	System.out.println(monthSplit[0].equals(exMonth));
	driver.findElement(By.className("flatpickr-next-month")).click();
	Thread.sleep(3000);
	month = driver.findElement(By.className("flatpickr-month")).getText();
	System.out.println("month inside while loop: "+monthSplit[0]);
	monthSplit = month.split("[\r\n]+");
	System.out.println(monthSplit[0]);
	//System.out.println(monthSplit[1]);
	}
	driver.findElement(By.xpath("//span[text()='"+exDay+"']")).click();
	//driver.close();


	}

}
