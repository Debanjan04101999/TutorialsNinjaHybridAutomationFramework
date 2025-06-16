package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtilitiesUsingIteratorRahulShetty {

	@Test
	public void readExcelFile() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumFrameworkUdemy\\src\\test\\resources\\Excel_Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		System.out.println("Number of sheets: " + sheets);

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("testdate")) {

				XSSFSheet sheet = workbook.getSheetAt(i);
				System.out.println("Name of sheet: " + sheet.getSheetName());
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();// Accessting first row
				System.out.println("First row: " + firstrow.getRowNum());
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {

						coloumn = k;

					}
					k++;
				}
				System.out.println("Column index for TestCases: " + coloumn);

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Purchase")) {
						Iterator<Cell> cv = r.cellIterator();
						
					
						System.out.println(cv.next().getStringCellValue());
					}
				}
			}

		}

	}
}
