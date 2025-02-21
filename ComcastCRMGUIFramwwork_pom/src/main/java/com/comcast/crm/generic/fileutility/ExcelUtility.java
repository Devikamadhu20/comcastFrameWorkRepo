package com.comcast.crm.generic.fileutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class ExcelUtility {
	   public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {
	      FileInputStream fis = new FileInputStream("./testData/testscriptdata1.xlsx");
	      Workbook wb = WorkbookFactory.create(fis);
          String data= wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
	
	     wb.close();
	     return data;
	   }
	   
	   public int getRowCount(String sheetName) throws Throwable {
		   FileInputStream fis = new FileInputStream("./testData/testscriptdata1.xlsx");
		      Workbook wb = WorkbookFactory.create(fis);
		      int rowCount=wb.getSheet(sheetName).getLastRowNum();
		      wb.close();
		      return rowCount;
		   
	   }
	   public void setDataIntoExcel(String sheetName, int rowNum, int celNum,String data) throws Throwable {
		      FileInputStream fis = new FileInputStream("./testData/testscriptdata1.xlsx");
		      Workbook wb = WorkbookFactory.create(fis);
	           Cell cel = wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
	           cel.setCellValue(data);
	           FileOutputStream fos=new FileOutputStream("./testData/testscriptdata1.xlsx");
	           wb.write(fos);
		       wb.close();
		     
		   }
	   
}
			   
			   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   




