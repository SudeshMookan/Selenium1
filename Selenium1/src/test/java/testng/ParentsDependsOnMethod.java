package testng;

import org.testng.annotations.Test;

public class ParentsDependsOnMethod {
	
	@Test(dependsOnMethods = {"parentmethod1"})
	public void parentmethod() {
		System.out.println("I m in Parent method");
	}
	
	@Test
	public void parentmethod1() {
		System.out.println("I m in Parent method1");
	}
	
	
	
	
	

}
