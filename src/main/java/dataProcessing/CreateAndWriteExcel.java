package dataProcessing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateAndWriteExcel {

	 static XSSFWorkbook workbook = new XSSFWorkbook();

     // Get the sheet by name
     static XSSFSheet sheet = workbook.createSheet();
	
     public static void writeExcelRegnoData(String studentRegno) throws IOException {
    	    XSSFRow firstrow = sheet.getRow(0);
    	    if (firstrow == null) {
    	        firstrow = sheet.createRow(0);
    	    }

    	    // Ensure we do not overwrite existing cell values
    	    XSSFCell regNoHeaderCell = firstrow.getCell(0);
    	    if (regNoHeaderCell == null) {
    	        regNoHeaderCell = firstrow.createCell(0);
    	    }
    	    regNoHeaderCell.setCellValue("Register number");

    	    // Get or create second row
    	    XSSFRow secondRow = sheet.getRow(1);
    	    if (secondRow == null) {
    	        secondRow = sheet.createRow(1);
    	    }

    	    XSSFCell regNoCell = secondRow.getCell(0);
    	    if (regNoCell == null) {
    	        regNoCell = secondRow.createCell(0);
    	    }
    	    regNoCell.setCellValue(studentRegno);

    	    // Ensure changes are written
    	    writeExcelDatas();
    	}

    	public static void writeExcelSemesterData(String studentSemester) throws IOException {
    		
    		
    	  

    	    XSSFRow firstrow = sheet.getRow(0);
    	    
    	    String[] studentSemesters = { studentSemester};
    	    
    	    
    	    if (firstrow == null) {
    	        firstrow = sheet.createRow(0);
    	    }

    	    // Ensure we do not overwrite existing cell values
    	    XSSFCell semesterHeaderCell = firstrow.getCell(1);
    	    if (semesterHeaderCell == null) {
    	        semesterHeaderCell = firstrow.createCell(1);
    	    }
    	    semesterHeaderCell.setCellValue("Semester");

    	    // Get or create second row
    	    XSSFRow secondRow = sheet.getRow(1);
    	    if (secondRow == null) {
    	        secondRow = sheet.createRow(1);
    	    }

    	    XSSFCell semesterCell = secondRow.getCell(1);
    	    if (semesterCell == null) {
    	        semesterCell = secondRow.createCell(1);
    	    }
    	    semesterCell.setCellValue(studentSemester);

    	    // Ensure changes are written
    	    writeExcelDatas();
    	}

    public static void writeExcelData(int rowIndex,String serialNo,String subjectNames,String subjectCode,String extraSubjectCode,String credit,String type,String st,String qt,String as,String mte,String emptyColumn1,String emptyColumn2,String emptyColumn3,String to40,String endSemExam,
    	String	to100,String totalMarks,String grade) throws IOException {
        
    

    	   
    	           
    	                // Create a header row if the file is newly created
    	                Row datasRow = sheet.createRow(0);
    	                String[] datavalues = { serialNo, subjectNames,subjectCode,extraSubjectCode,credit,type,st,qt,as,mte,emptyColumn1,emptyColumn2,emptyColumn3,to40,endSemExam
    	                		,to100,totalMarks,grade};

    	                for (int i = 0; i < datavalues.length; i++) {
    	                	datasRow.createCell(i).setCellValue(datavalues[i]);
    	                }
    	            
    	                XSSFRow firstrow = sheet.getRow(0);
    	        	    if (firstrow == null) {
    	        	        firstrow = sheet.createRow(0);
    	        	    }
    	        	    
    	        	    firstrow.createCell(0).setCellValue("Register Number");
    	        	    firstrow.createCell(1).setCellValue("subjectNames");
    	          
    	        		firstrow.createCell(2).setCellValue("subjectCode");
    	        		firstrow.createCell(3).setCellValue("Dummydata"); 
    	        		
    	        		firstrow.createCell(4).setCellValue("credit");
    	        		 
    	        		 firstrow.createCell(5).setCellValue("type");
    	        		 firstrow.createCell(6).setCellValue("ST(5)");
    	        		  firstrow.createCell(7).setCellValue("QT(5)");
    	        		  firstrow.createCell(8).setCellValue("AS(5)");
    	        		  
    	        		  firstrow.createCell(9).setCellValue("MTE(25)");
    	        		  
    	        		  firstrow.createCell(10).setCellValue("emptyColumn1");
    	        		  firstrow.createCell(11).setCellValue("emptyColumn2");
    	        		  firstrow.createCell(12).setCellValue("emptyColumn3");
    	        		  firstrow.createCell(13).setCellValue("To(40)");
    	        		  firstrow.createCell(14).setCellValue("EndSemExam(60)");
    	        		  firstrow.createCell(15).setCellValue("TO(100)");
    	        		  firstrow.createCell(16).setCellValue("TM");  
    	        		  firstrow.createCell(17).setCellValue("Grade");  
    	                
    	            // Create a new row based on the rowIndex from the loop
    	        		  Row Datarow = sheet.createRow(rowIndex); 

    	            // Write each value in the correct column
    	     //       Datarow.createCell(0).setCellValue(serialNo);
    	      //      Datarow.createCell(1).setCellValue(subjectNames);
    	        		  
    	        		  
    	        System.out.println("-------------------------------------------------------------------------");
    	        		     System.out.println("Written: " + subjectNames + " in row " + rowIndex);		  
//    	            Datarow.createCell(0).setCellValue(studentRegno);
    	        	Datarow.createCell(1).setCellValue(subjectNames);
    	            
    	            Datarow.createCell(2).setCellValue(subjectCode);
    	            Datarow.createCell(3).setCellValue(extraSubjectCode);
    	            Datarow.createCell(4).setCellValue(credit);
    	            Datarow.createCell(5).setCellValue(type);
    	            Datarow.createCell(6).setCellValue(st);
    	            Datarow.createCell(7).setCellValue(qt);
    	            Datarow.createCell(8).setCellValue(as);
    	            Datarow.createCell(9).setCellValue(mte);
    	            Datarow.createCell(10).setCellValue(emptyColumn1);
    	            Datarow.createCell(11).setCellValue(emptyColumn2);
    	            Datarow.createCell(12).setCellValue(emptyColumn3);
    	            Datarow.createCell(13).setCellValue(to40);
    	            Datarow.createCell(14).setCellValue(endSemExam);
    	            Datarow.createCell(15).setCellValue(to100);
    	            Datarow.createCell(16).setCellValue(totalMarks);
    	            Datarow.createCell(17).setCellValue(grade);
        	        System.out.println("-------------------------------------------------------------------------"); 
    	            // Write changes back to file
    	        

    	       

  
			 
			 
			 

				/*
				 * int startRow = 1; // Start writing from row index 1 int startColumn = 2; //
				 * Start writing from column index 2
				 * 
				 * 
				 * // String[] subjectNameList = new String[]{subjectNames};
				 * 
				 * 
				 * System.out.println("subjectNameListsubjectNameListsubjectNameList: "
				 * +subjectNameList);
				 * 
				 * // Get the row at startRow (only one row, since we are writing column-wise)
				 * 
				 * // Loop through each row in the subjectNameList
				 * 
				 * 
				 * // Iterate over row indices to ensure rows exist for (int i = 0; i <
				 * subjectNameList.length; i++) { int currentRowIndex = startRow + i; XSSFRow
				 * row = sheet.getRow(currentRowIndex); if (row == null) { row =
				 * sheet.createRow(currentRowIndex); }
				 * 
				 * 
				 * // Iterate again to process the cells for (int j = 0; j <
				 * subjectNameList.length; j++) { int currentRowIndex1 = startRow + j; XSSFRow
				 * row1 = sheet.getRow(currentRowIndex1); // This will always be non-null now
				 * 
				 * System.out.println("Raw Data: " + subjectNameList[j]);
				 * 
				 * XSSFCell cell = row1.getCell(startColumn); if (cell == null) { cell =
				 * row1.createCell(startColumn); }
				 * 
				 * cell.setCellValue(subjectNameList[j]); }
				 * 
				 * }
				 */

           // Ensure changes are written
           writeExcelDatas();

  	    	
		
	
		 /* firstrow.createCell(2).setCellValue("subjectNames");
		 * firstrow.createCell(3).setCellValue("subjectCode");
		 * firstrow.createCell(4).setCellValue("credit");
		 * firstrow.createCell(5).setCellValue("type");
		 * firstrow.createCell(6).setCellValue("st");
		 * firstrow.createCell(7).setCellValue("qt");
		 * firstrow.createCell(8).setCellValue("as");
		 * 
		 * firstrow.createCell(9).setCellValue("mte");
		 * 
		 * firstrow.createCell(10).setCellValue("emptyColumn1");
		 * firstrow.createCell(11).setCellValue("emptyColumn2");
		 * firstrow.createCell(12).setCellValue("emptyColumn3");
		 * firstrow.createCell(13).setCellValue("to40");
		 * firstrow.createCell(14).setCellValue("endSemExam");
		 * firstrow.createCell(15).setCellValue("to100");
		 * firstrow.createCell(16).setCellValue("totalMarks");
		 * firstrow.createCell(17).setCellValue("grade"); // Assuming 'sheet' is an
		 * instance of XSSFSheet or HSSFSheet //
		 * CreateAndWriteExcel.writeExcelData(serialNo,subjectNames,subjectCode,credit,
		 * type,st,qt,mte,emptyColumn1,emptyColumn2,emptyColumn3 //
		 * ,to40,endSemExam,to100,totalMarks,grade);
		 * 
		 * // Creating the second row (index 1) XSSFRow secondRow = sheet.createRow(1);
		 * 
		 * // Adding data to the second row
		 * 
		 * 
		 * // secondRow.createCell(1).setCellValue(serialNo);
		 * secondRow.createCell(2).setCellValue(subjectNames);
		 * secondRow.createCell(3).setCellValue(subjectCode);
		 * secondRow.createCell(4).setCellValue(credit);
		 * secondRow.createCell(5).setCellValue(type);
		 * secondRow.createCell(6).setCellValue(st);
		 * secondRow.createCell(7).setCellValue(qt);
		 * secondRow.createCell(8).setCellValue(as);
		 * secondRow.createCell(9).setCellValue(mte);
		 * secondRow.createCell(10).setCellValue(emptyColumn1);
		 * secondRow.createCell(11).setCellValue(emptyColumn2);
		 * secondRow.createCell(12).setCellValue(emptyColumn3);
		 * secondRow.createCell(13).setCellValue(to40);
		 * secondRow.createCell(14).setCellValue(endSemExam);
		 * secondRow.createCell(15).setCellValue(to100);
		 * secondRow.createCell(16).setCellValue(totalMarks);
		 * secondRow.createCell(17).setCellValue(grade);
		 * 
		 */
			 
    }
		// Sample data for multiple rows
		/*  List<Object> rowData = Arrays.asList(
		      new Object[]{serialNo, subjectNames, subjectCode, credit, type, st, qt, mte, emptyColumn1, emptyColumn2, emptyColumn3, to40, endSemExam, to100, totalMarks, grade}
		      
		*/      
		      
		      // Add more rows here if needed
		 
		  // Loop to create rows dynamically
			/*
			 for (int i = 0; i < rowData.size(); i++) { XSSFRow row = sheet.createRow(i +
			 1); // Start from row index 1
			 
			 Object[] rowValues = (Object[]) rowData.get(i); for (int j = 0; j <
			  rowValues.length; j++) { XSSFCell cell = row.createCell(j);
			  // Check data type and set value accordingly
			  
			  if (rowValues[j] instanceof
			 Integer) { cell.setCellValue((Integer) rowValues[j]); 
			 
			 } 
			  else if (rowValues[j] 
			 
			  instanceof Double) { cell.setCellValue((Double) rowValues[j]);
			  
			  } 
			  else if (rowValues[j] instanceof Boolean) { cell.setCellValue((Boolean)
			  rowValues[j]); } else { cell.setCellValue(rowValues[j] != null ?
			  rowValues[j].toString() : ""); // Handle nulls
			  }  }}
			 /*
		  
		  // Not adding anything to columns 8, 9, and 10 (they remain empty)

		        
	   
	     
	  //   CreateAndWriteExcel.writeExcelData(serialNo,subjectNames,subjectCode,credit,type,st,qt,mte,emptyColumn1,emptyColumn2,emptyColumn3,to40,endSemExam,to100,totalMarks,grade);
 

	        

		/*
		 * // Get the row and column count int rowCount =
		 * sheet.getPhysicalNumberOfRows(); int columnCount =
		 * sheet.getRow(0).getPhysicalNumberOfCells();
		 */

	        
	public static void writeExcelDatas() throws IOException {		  
			  
	        FileOutputStream excelfile = new FileOutputStream("D:\\Coempt_Automation\\coempt_automation\\src\\test\\resources\\ExcelFiles\\Test2.xlsx");
	        
	        workbook.write(excelfile);
		
	  
	}
	public static void closeExcel() throws IOException {	
	
	      workbook.close();
	}


}
    
    
	
