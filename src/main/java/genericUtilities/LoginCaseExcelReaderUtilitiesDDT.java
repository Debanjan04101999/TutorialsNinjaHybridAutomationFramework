package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginCaseExcelReaderUtilitiesDDT {

	static Workbook workbook;
	static Sheet sheet;

	public static Object[][] getExcelData(String filePath, String sheetName) {
		

		    Object[][] data = null;

		    try {
		        FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheet(sheetName);

		        int rowCount = sheet.getLastRowNum();        // 4 rows (excluding header)
		        int colCount = sheet.getRow(0).getLastCellNum(); // 3 columns

		        data = new Object[rowCount][colCount];

		        for (int i = 1; i <= rowCount; i++) {   // start from row 1 (skip header)
		            for (int j = 0; j < colCount; j++) {
		                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
		            }
		        }

		        workbook.close();
		        fis.close();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return data;
		}}
