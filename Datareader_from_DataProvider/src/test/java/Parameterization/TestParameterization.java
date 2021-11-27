package Parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

	
	@Test(dataProvider="getData")
	public void Test_01(String uswername,String Password) {
		System.out.println(uswername+"---"+Password);
		
	}
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		
		data[0][0] ="krishjlld.com";
		data[0][1]="krish";
		
		data[1][0]="khushisbk.com";
		data[1][1]="khushi";
		
		data[2][0]="vanshksoohd.com";
		data[2][1]="vansh";
		
				
		
		return data;
	}
	
	
}
