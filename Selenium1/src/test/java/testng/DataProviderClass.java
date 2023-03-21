package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
	
	@DataProvider
	public Object[][] dataMethod(){
		return new Object[][] {{"ab","cd","ef"},{"gh","ij","kl"},{"mn","op","qr"}};
	}
	
	@DataProvider
	public Object[][] dataMethod2(){
		return new Object[][] {{"ab1","cd1","ef1"},{"gh2","ij2","kl2"},{"mn3","op3","qr3"}};
	}
	
	
	
	
	@Test(dataProvider="dataMethod")
	public void testmethod1(String param1, String param2, String param3) {
		System.out.println("test method1 param1: "+param1);
		System.out.println("test method1 param2: "+param2);
		System.out.println("test method1 param3: "+param3);
	}
	
	
	@Test(dataProvider="dataMethod2")
	public void testmethod2(String param4, String param5, String param6) {
		System.out.println("test method2 param4: "+param4);
		System.out.println("test method2 param5: "+param5);
		System.out.println("test method2 param6: "+param6);
	}
	
	
	

}
