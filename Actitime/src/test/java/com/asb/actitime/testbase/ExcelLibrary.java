package com.asb.actitime.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {

	public String getExcelData(String sheetName, int rowNum, int cellNum) {
		String text=null;
		try {
			FileInputStream fis= new FileInputStream("../Actitime/data/data.xlsx");
		 	Workbook wb= WorkbookFactory.create(fis);
		 	Sheet s= wb.getSheet(sheetName);
		 	Row r= s.getRow(rowNum);
		 	Cell c= r.getCell(cellNum);
		 	DataFormatter df=new DataFormatter();
		 	if(c.getCellType() == CellType.STRING) {
		 		text= c.getStringCellValue();
		 	}else if(c.getCellType() == CellType.NUMERIC) {
		 		text= df.formatCellValue(c);
		 	}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return text;
	}
	public int getLastRowNumber(String sheetName) {
		int rowVal=0;
		try {
			FileInputStream fis= new FileInputStream("../Actitime/data/data.xlsx");
		 	Workbook wb= WorkbookFactory.create(fis);
		 	Sheet s= wb.getSheet(sheetName);
		 	rowVal= s.getLastRowNum();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowVal;
	}

}
