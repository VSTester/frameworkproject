package Parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TestNGParameterizationExcel {
public static Xls_Excel reader = null;
	
	
	@Test(dataProvider ="getData")
	public void Test_01(String uswername,String Password,String  is_correct,String state) {
		System.out.println(uswername+"---"+Password+"--"+is_correct+"---"+state);
	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		
		//if (reader==null) {
			reader=new Xls_Excel("C:\\Users\\Rinku PC\\krish workspace\\Datareader_from_DataProvider\\files\\Book123.xlsx");
		//}
		String sheetName = "Sheet1";
		int rows =reader.getRowCount(sheetName);
		int cols = reader.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][cols];
		for (int rownum = 2; rownum <= rows; rownum++) {
			
			for (int colnum = 0; colnum < cols; colnum++) {
				data[rownum-2][colnum] = reader.getCellData(sheetName, colnum, rownum);
			}
			
		}
		
		return data;
	}
	
	
}
