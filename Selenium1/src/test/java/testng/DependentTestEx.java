package testng;

import org.testng.annotations.Test;

public class DependentTestEx {

	@Test(dependsOnMethods = {"testmethod1"})
	public void testmethod() {
		System.out.println("I m in test method");
	}
	
	@Test
	public void testmethod1() {
		System.out.println("I m in test method1");
	}
	
	
	
	
	
}
