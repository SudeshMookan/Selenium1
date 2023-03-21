package testng;

import org.testng.annotations.Test;

public class ChildDependsOnMethod extends ParentsDependsOnMethod {

	@Test(dependsOnMethods = {"parentmethod1"})

	public void childmethod1() {
		System.out.println("I m in child method1");
	}
	
	
	@Test
	public void childmethod2() {
		System.out.println("I m in child method2");
	}
	
	
	
	
	
}
