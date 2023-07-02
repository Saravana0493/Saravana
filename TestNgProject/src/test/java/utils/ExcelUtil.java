package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelUtil {
	
	public String testcaseFilename;
	public String testCaseName;

	public static Object[][] ExcelRead(String fileName, String testCaseName)
			throws IOException {

		// Create an object of File class to open xlsx file

		File file = new File("./Resources/"+ fileName +".xlsx");

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook wbook = new XSSFWorkbook(inputStream);
		XSSFSheet xsheet = wbook.getSheetAt(0);

		int rowNum = xsheet.getLastRowNum();
		short cellNum = xsheet.getRow(0).getLastCellNum();

		DataFormatter formatter = new DataFormatter();

		Map<String, String> exceldata = new HashMap<>();

		for (int row = 1; row <= rowNum; row++) {
			
			if (formatter.formatCellValue(xsheet.getRow(row).getCell(1)).equalsIgnoreCase(testCaseName)) {
				for (int cell = 0; cell < cellNum; cell++) {
					exceldata.put(formatter.formatCellValue(xsheet.getRow(0).getCell(cell)),
							formatter.formatCellValue(xsheet.getRow(row).getCell(cell)));
				}
				break;
			}
		}

		return new Object[][] { new Object[] { exceldata } };
	}

}
