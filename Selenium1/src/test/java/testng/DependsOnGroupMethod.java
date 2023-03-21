package testng;

import org.testng.annotations.Test;

public class DependsOnGroupMethod {
	
	@Test(groups = {"Group1"})
	public void method1() {
		System.out.println("i m in method1");
	}
	
	@Test(groups = {"Group1"})
	public void method2() {
		System.out.println("i m in method2");
	}
	
	@Test(groups = {"Group2"})
	public void method3() {
		System.out.println("i m in method3");
	}
	
	@Test(groups = {"Group2"})
	public void method4() {
		System.out.println("i m in method4");
	}
	
	
	
	
	
	
	
	
	
	
	

}
