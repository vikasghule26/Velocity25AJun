package Utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {
	
	public static String readPropertyFile(String value) throws Exception
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Dell\\eclipse-"
				+ "workspace\\Frame1\\TestData\\Config.property");
		prop.load(file);
		return prop.getProperty(value);
	}
	
	public static String readExcelFile(int rowNum,int colNum) throws Exception
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace"
				+ "\\Frame1\\TestData\\TestDataFile.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excel.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
		
		
	}

}
