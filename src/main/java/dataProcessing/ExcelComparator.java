package dataProcessing;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelComparator {

    @DataProvider(name = "excelComparison")
    public static Object[][] provideExcelData() throws IOException {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(input);
        }

        // Get file paths and sheet names from config
        String filePath1 = prop.getProperty("file1.path");
        String sheetName1 = prop.getProperty("file1.sheet");
        String filePath2 = prop.getProperty("file2.path");
        String sheetName2 = prop.getProperty("file2.sheet");

        if (filePath1 == null || sheetName1 == null || filePath2 == null || sheetName2 == null) {
            throw new IllegalArgumentException("Invalid file or sheet key in config file.");
        }

        // Read data from both Excel files (skipping the first row)
        Object[][] data1 = readExcelData(filePath1, sheetName1);
        Object[][] data2 = readExcelData(filePath2, sheetName2);

        // Compare the two datasets
        return compareData(data1, data2);
    }

    private static Object[][] readExcelData(String filePath, String sheetName) throws IOException {
        try (FileInputStream excelFile = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(excelFile)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) throw new IllegalArgumentException("Sheet not found: " + sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            if (rowCount <= 1) return new Object[0][0]; // No data rows

            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

            // Prepare an Object array to store the data, skipping the first row
            Object[][] data = new Object[rowCount - 1][columnCount];

            for (int i = 1; i < rowCount; i++) { // Start from index 1 to skip header row
                Row row = sheet.getRow(i);
                for (int j = 0; j < columnCount; j++) {
                    data[i - 1][j] = getCellValue(row.getCell(j)); // Store data, adjusting index
                }
            }
            return data;
        }
    }

   
    
    private static Object[][] compareData(Object[][] data1, Object[][] data2) {
    
    	
    	int maxRows = Math.max(data1.length, data2.length);
        int maxCols = Math.max(data1[0].length, data2[0].length);

        Object[][] comparisonResults = new Object[maxRows][maxCols];

        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                String value1 = (i < data1.length && j < data1[i].length) ? String.valueOf(data1[i][j]) : "MISSING";
                String value2 = (i < data2.length && j < data2[i].length) ? String.valueOf(data2[i][j]) : "MISSING";

                if (!value1.equals(value2)) {
                    comparisonResults[i][j] = "Mismatch: " + value1 + " != " + value2;
                } else {
                    comparisonResults[i][j] = "Match: " + value1;
                }
            }
        }
        return comparisonResults;
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "EMPTY";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return cell.getNumericCellValue() == (int) cell.getNumericCellValue()
                        ? String.valueOf((int) cell.getNumericCellValue())
                        : String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "EMPTY";
        }
    }
}
