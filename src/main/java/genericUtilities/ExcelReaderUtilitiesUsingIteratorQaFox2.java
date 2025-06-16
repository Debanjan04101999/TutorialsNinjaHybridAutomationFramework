package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtilitiesUsingIteratorQaFox2 {

	@Test
	public void readExcelFile() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumFrameworkUdemy\\src\\test\\resources\\Excel_Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("testdate");
		System.out.println("Sheet:" + sheet.getSheetName());

		int rows = sheet.getLastRowNum();
		System.out.println("Total Rows: " + rows);
		int cols = sheet.getRow(0).getLastCellNum();
		System.out.println("Total Columns: " + cols);
		Iterator<Row> itrRow = sheet.iterator();

		while (itrRow.hasNext()) {
		    Row row = itrRow.next();

		    // Iterator to iterate over cells in the current row
		    Iterator<Cell> itrCell = row.iterator();

		    while (itrCell.hasNext()) {
		        Cell cell = itrCell.next();

		        // Get cell type
		        CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					System.out.print(cell.getStringCellValue() + " | ");
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue() + " | ");
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue() + " | ");
					break;
				default:
					System.out.print("Unknown Cell Type | ");
				}

			}
			System.out.println();

		}
	}
}
