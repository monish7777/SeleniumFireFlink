package org.automation.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {

	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/Testdata.properties");

		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
	}

	public String getDataFromExcel(String sheetname, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/excel1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		return sh.getRow(rowNum).getCell(cellNum).toString();
	}

	public static Object[][] multipleData(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/excel1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);

		int lastRowNum = sh.getPhysicalNumberOfRows();
		int lastCellData = sh.getRow(0).getPhysicalNumberOfCells();

		Object [][] arr=new Object[lastRowNum-1][lastCellData];
		for (int i = 1; i < lastRowNum; i++) {

			for (int j = 0; j < lastCellData; j++) {

				arr[i-1][j]=sh.getRow(i).getCell(j).toString();

			}
			
		}
		return arr;		

	}

}
