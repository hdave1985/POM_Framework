package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{

	//DataProvider 1
//	VIMP
//	Created separate class and call it to test case TC002_LoginDDT.java
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException  // 2 dim array
	{
//		get the excel sheet
		String path=".\\testData\\aiana_LoginData.xlsx";//taking xl file from testData
		
//		instantiate the excelutility
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
//		get total rows
		int totalrows=xlutil.getRowCount("Sheet1");
//		get total columns
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
//		create 2 dimensions arrays to hold rows and columns
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
//		loop thru the excel sheet row and columns
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2 for other test case e.g., search products
	
	//DataProvider 3 for other test cases 
	
	//DataProvider 4
}
