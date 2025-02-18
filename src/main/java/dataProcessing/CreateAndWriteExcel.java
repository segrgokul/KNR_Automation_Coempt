package dataProcessing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateAndWriteExcel {

	
    public static void writeExcelData(String serialNo,String subjectNames,String subjectCode,String credit,String type,String st,String qt,String mte,String emptyColumn1,String emptyColumn2,String emptyColumn3,String to40,String endSemExam,
    	String	to100,String totalMarks,String grade) throws IOException {
        
		   XSSFWorkbook workbook = new XSSFWorkbook();

	        // Get the sheet by name
	        XSSFSheet sheet = workbook.createSheet();
	   
	      

			/*
			 * // Find the first empty column in the row int colNum = row.getLastCellNum();
			 * // Get the last used column if (colNum == -1) { colNum = 0; // If no cells
			 * exist, start from 0 }
			 * 
			 * // Loop through subject names and insert them in empty columns for (String
			 * subject : subjectNames) { // Move to the next available empty column while
			 * (colNum < row.getLastCellNum() && row.getCell(colNum) != null &&
			 * row.getCell(colNum).getCellType() != CellType.BLANK) { colNum++; // Skip
			 * occupied columns } row.createCell(colNum).setCellValue(subject); // Set
			 * subject in the first empty column colNum++; // Move to the next column for
			 * the next subject }
			 */
	      
	  // Find the last cell in the row
		/*
		 * int lastCellNum = row.getLastCellNum(); // Returns -1 if no cells exist int
		 * cellIndex = (lastCellNum == -1) ? 0 : lastCellNum; // Start from 0 if empty
		 * 
		 * // Create and set value in the next available cell XSSFCell cell =
		 * row.createCell(cellIndex); cell.setCellValue("");
		 */
	        
	   //For heading
	     XSSFRow firstrow = sheet.getRow(0);
	      if (firstrow == null) {
	          firstrow = sheet.createRow(0); // Create a new row
	      }
	        
		
		  firstrow.createCell(0).setCellValue("serialNo");
		  firstrow.createCell(1).setCellValue("subjectNames");
		  firstrow.createCell(2).setCellValue("subjectCode");
		  firstrow.createCell(3).setCellValue("credit");
		  firstrow.createCell(4).setCellValue("type"); 
		  firstrow.createCell(5).setCellValue("st");
		  firstrow.createCell(6).setCellValue("qt"); 
		  firstrow.createCell(7).setCellValue("mte");
		  firstrow.createCell(8).setCellValue("emptyColumn1");
		  firstrow.createCell(9).setCellValue("emptyColumn2");
		  firstrow.createCell(10).setCellValue("emptyColumn3");
		  firstrow.createCell(11).setCellValue("to40");
		  firstrow.createCell(12).setCellValue("endSemExam");
		  firstrow.createCell(13).setCellValue("to100");
		  firstrow.createCell(14).setCellValue("totalMarks");
		  firstrow.createCell(15).setCellValue("grade");
		// Assuming 'sheet' is an instance of XSSFSheet or HSSFSheet
		  //   CreateAndWriteExcel.writeExcelData(serialNo,subjectNames,subjectCode,credit,type,st,qt,mte,emptyColumn1,emptyColumn2,emptyColumn3
		//  ,to40,endSemExam,to100,totalMarks,grade);

		  // Creating the second row (index 1)
		  XSSFRow secondRow = sheet.createRow(1);

			/*
			 * // Adding data to the second row
			 * secondRow.createCell(0).setCellValue(serialNo);
			 * secondRow.createCell(1).setCellValue(subjectNames);
			 * secondRow.createCell(2).setCellValue(subjectCode);
			 * secondRow.createCell(3).setCellValue(credit);
			 * secondRow.createCell(4).setCellValue(type);
			 * secondRow.createCell(5).setCellValue(st);
			 * secondRow.createCell(6).setCellValue(qt);
			 * secondRow.createCell(7).setCellValue(mte);
			 * secondRow.createCell(8).setCellValue(emptyColumn1);
			 * secondRow.createCell(9).setCellValue(emptyColumn2);
			 * secondRow.createCell(10).setCellValue(emptyColumn3);
			 * secondRow.createCell(11).setCellValue(to40);
			 * secondRow.createCell(12).setCellValue(endSemExam);
			 * secondRow.createCell(13).setCellValue(to100);
			 * secondRow.createCell(14).setCellValue(totalMarks);
			 * secondRow.createCell(15).setCellValue(grade);
			 */

		// Sample data for multiple rows
		  List<Object> rowData = Arrays.asList(
		      new Object[]{serialNo, subjectNames, subjectCode, credit, type, st, qt, mte, emptyColumn1, emptyColumn2, emptyColumn3, to40, endSemExam, to100, totalMarks, grade}
		      
		      
		      
		      // Add more rows here if needed
		  );

		  // Loop to create rows dynamically
		  for (int i = 0; i < rowData.size(); i++) {
		      XSSFRow row = sheet.createRow(i + 1); // Start from row index 1

		      Object[] rowValues = (Object[]) rowData.get(i);
		      for (int j = 0; j < rowValues.length; j++) {
		          XSSFCell cell = row.createCell(j);

		          // Check data type and set value accordingly
		          if (rowValues[j] instanceof Integer) {
		              cell.setCellValue((Integer) rowValues[j]);
		          } else if (rowValues[j] instanceof Double) {
		              cell.setCellValue((Double) rowValues[j]);
		          } else if (rowValues[j] instanceof Boolean) {
		              cell.setCellValue((Boolean) rowValues[j]);
		          } else {
		              cell.setCellValue(rowValues[j] != null ? rowValues[j].toString() : ""); // Handle nulls
		          }
		      }
		  }

		  
		  // Not adding anything to columns 8, 9, and 10 (they remain empty)

		        
	   
	     
	  //   CreateAndWriteExcel.writeExcelData(serialNo,subjectNames,subjectCode,credit,type,st,qt,mte,emptyColumn1,emptyColumn2,emptyColumn3,to40,endSemExam,to100,totalMarks,grade);
 

	        

		/*
		 * // Get the row and column count int rowCount =
		 * sheet.getPhysicalNumberOfRows(); int columnCount =
		 * sheet.getRow(0).getPhysicalNumberOfCells();
		 */

	        
	        FileOutputStream excelfile = new FileOutputStream("C:\\Users\\Admin\\git\\KNR_Automation_Coempt\\src\\test\\resources\\ExcelFiles\\Test.xlsx");
	        
	        workbook.write(excelfile);
		
	        workbook.close();
	}
    
	
}
