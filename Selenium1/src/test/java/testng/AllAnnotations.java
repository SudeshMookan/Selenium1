package testng;

import org.testng.annotations.*;

public class AllAnnotations {

	@BeforeSuite
	public void beforesuite() {
		System.out.println("I 'm in beforesuite");
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("I 'm in aftersuite");

	}
	@BeforeClass
	public void beforeclass() {
		System.out.println("I 'm in beforeclass");

	}
	@AfterClass
	public void afterclass() {
		System.out.println("I 'm in afterclass");

	}
	@BeforeTest
	public void beforetest() {
		System.out.println("I 'm in beforetest");

	}
	@AfterTest
	public void aftertest() {
		System.out.println("I 'm in aftertest");

	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("I 'm in beforemethod");

	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("I 'm in aftermethod");

	}
	@Test
	public void testmethod() {
		System.out.println("I 'm in testmethod");
	}
	
	@Test(enabled=false)
	public void testmethod1() {
		System.out.println("I 'm in testmethod1");
	}
	@Test(invocationCount=7)
	public void testmethod2() {
		System.out.println("I 'm in testmethod2");
	}
	@Test
	public void testmethod3() {
		System.out.println("I 'm in testmethod3");
	}
	@Test
	public void testmethod4() {
		System.out.println("I 'm in testmethod4");
	}
	
	
	
	
	
	
	
}

