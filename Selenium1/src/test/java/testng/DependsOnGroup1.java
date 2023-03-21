package testng;

import org.testng.annotations.Test;

public class DependsOnGroup1 {

	@Test(groups= {"TestGroup1"})
	public void method1() {
		System.out.println("i m in method1");
	}
	
	@Test(groups= {"TestGroup1"})
	public void method2() {
		System.out.println("im in method2");
	}
	
	@Test(groups= {"TestGroup2","TestGroup3"})
	public void method3() {
		System.out.println("i m in method3");
	}
	
	@Test(groups= {"TestGroup2"})
	public void method4() {
		System.out.println("i m in method4");
	}
	
	@Test(groups= {"TestGroup3"})
	public void method5() {
		System.out.println("i m in method5");
	}
}
