package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	@DataProvider
	public Object[][] datamethod1(){
		return new Object[][] {{"joy1","joy9"},{"joy2","joy88"}};
	}
	
	@DataProvider
	public Object[][] datamethod2(){
		return new Object[][] {{"joy5","joy53"},{"joy7","joy85"}};
	}
	
	@Test(dataProvider="datamethod1")
	public void method1(String param1, String param2) {
		System.out.println("method1 param1: "+param1);
		System.out.println("method1 param2: "+param2);
	}

	@Test(dataProvider="datamethod2")
	public void method2(String param4, String param3) {
		System.out.println("method2 param3: "+param4);
		System.out.println("method2 param4: "+param3);
	}
}
