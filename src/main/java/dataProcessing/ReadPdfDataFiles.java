package dataProcessing;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadPdfDataFiles {

    static String downloadsFolder = System.getProperty("user.home") + "/Downloads";

 

    
    public void readPdfData() throws IOException {
        try {
            // Find the latest PDF file
            File latestPDF = getLatestPDF();
            System.out.println("Downloads folder: " + downloadsFolder);

            if (latestPDF != null) {
       
        			try (PDDocument document = PDDocument.load(latestPDF)) {
        				PDFTextStripper stripper = new PDFTextStripper();
        				int totalPages = document.getNumberOfPages();
        				System.out.println("Total Pages: " + totalPages);
        				System.out.println("---------------------------------------------------");

        				// Iterate through all pages and extract text
        		//		for (int page = 1; page <= totalPages; page++) {
        	int page =1;
        	int rowIndex = 1;
        	while(page<=totalPages) {
        			
        					
        		  if(page ==4) {
                  	
                      break;
                  	
                  }				
        					stripper.setStartPage(page);
        					stripper.setEndPage(page);

        					
        					
        					//TO print the text
        					
        					String text = stripper.getText(document).replaceAll("[\r\n]+", "\n");
        		//			System.out.println(text);
        					
        					System.out.println("Page " + page + ":");
        					System.out.println("---------------------------------------------------");
        					// Extract registration number
      
        					
            	System.out.println("Latest PDF file found: " + latestPDF.getName());

//            	String regno = "(?m)^\\d{10}Reg\\s+No\\s*:$";
             	String regno = "(?m)^\\d{10}";

                  Pattern regnoPattern = Pattern.compile(regno);
                  Matcher regnoMatcher = regnoPattern.matcher(text);
                   // Updated regex pattern
                  if(regnoMatcher.find()) {
                  	
                  	String studentRegno = regnoMatcher.group();
                  	System.out.println("=================");
                  	
                  	System.out.println("studentRegno :"+studentRegno);
                  	
                  	
                  }

                  	
                
              	System.out.println("=================");                	
                
                
              	String sem = "Semester\\s*[IVXLCDM]+";
              

                Pattern semPattern = Pattern.compile(sem);
                Matcher semMatcher = semPattern.matcher(text);

              //  List<String> studentSemesters = new ArrayList<>();

                System.out.println("=================");

                while (semMatcher.find()) {  // Loop through all matches
                  
//                    studentSemesters.add(studentSemester);
                 
                
                  String regex = "(\\d+)"                          // (1) Course Number
                		  
                		+  "\\s+([A-Za-z&\\s/\\-]+[A-Za-z])" //(2) subject name

//correct code 

 +"\\s+([A-Z0-9]+(?:\\s+([CE]\\d{3}))?|\\d{2}[A-Z]+\\d+\\s*\\R?\\s*SI\\d{3}|\\d{2}BTCSEPP(?:\\s*\\R\\s*SI\\d{3})+|\\bSI\\d{3}\\b)" // (3) Subject Code
  
                		
                          + "\\s+(\\d+)"                      // (4) Credit Hours
                          + "\\s+([TP])"                      // (5) Subject Type
                          + "\\s+(\\d+|-)"                      // (6) Internal Marks 1
                          + "\\s+(\\d+|-)"                      // (7) Internal Marks 2
                          + "\\s+(\\d+|-)"                      // (8) Internal Marks 3
                          + "\\s+(\\d+|-)"                    // (9) Internal Marks 4
                          + "(?:\\s+(-|\\d+))?"               // (10) Optional Field 1
                          + "(?:\\s+(-|\\d+))?"               // (11) Optional Field 2
                          + "(?:\\s+(-|\\d+))?"               // (12) Optional Field 3
                          + "(?:\\s+(-|\\d+))?"               // (13) Optional Field 4
                          + "\\s+(\\d+|-)"                    // (14) Final Marks 1
                          + "(?:\\s+(-|\\d+))?"               // (15) Final Marks 2
                          + "\\s+(\\d+)"                      // (16) Final Marks 3
                          + "\\s+(\\d+)"                      // (17) Total Marks
                          + "\\s+([A-Z])";                    // (18) Grade

                 

            	Pattern pattern = Pattern.compile(regex,Pattern.DOTALL);
                Matcher matcher = pattern.matcher(text);

             
       
              
                
                // Start from row 1 (row 0 is header)  
                while (matcher.find()) {
                	
                String studentSemester = semMatcher.group();	
                String	serialNo = matcher.group(1);
                String     subjectNames = matcher.group(2).trim();
          
         
              	
              	
                String      subjectCode = matcher.group(3);
                String 		extraSubjectCode = matcher.group(4);
                String      credit =matcher.group(5); 
                String       type = matcher.group(6);
                String       st = matcher.group(7);
                String       qt = matcher.group(8);
                String       as = matcher.group(9);
                String       mte = matcher.group(10);
                String       emptyColumn1 = matcher.group(11) != null ? matcher.group(11) : "N/A";
                String       emptyColumn2 = matcher.group(12) != null ? matcher.group(12) : "N/A";
                String       emptyColumn3 = matcher.group(13) != null ? matcher.group(13) : "N/A";
                String       to40 = matcher.group(14);
                String       endSemExam = matcher.group(15);
                String       to100 = matcher.group(17);
                String       totalMarks = matcher.group(18);
                String       grade = matcher.group(19);
                      
                	
                	
                	
                	
                	
                	
                	
                	
                
//                System.out.println("studentRegno: " + studentRegno);
//                System.out.println("studentSemester: " + studentSemester);	
               
                System.out.println("Student sem: " + studentSemester);
       
                    System.out.println("Serial No: " + serialNo);
                    System.out.println("Subject Name: " + subjectNames);
                
                 
                    
                   
                    System.out.println("Subject Code: " + subjectCode);
                    
                    System.out.println("Extra Subject Code: " + extraSubjectCode);
                    
                    System.out.println("Cr: " + credit);
                    System.out.println("Type (T/P): " + type);
                    System.out.println("ST (5): " + st);

                    System.out.println("QT (5): " + qt);
                    System.out.println("AS (5): " + as);
                    System.out.println("MTE (25): " + mte);
                    System.out.println("Empty Column1: "+emptyColumn1);
                    System.out.println("Empty Column2: "+emptyColumn2);
                    System.out.println("Empty Column3: "+emptyColumn3);
                    
                    System.out.println("TO (40): " + to40);
                    System.out.println("End Sem Exam (60): " + endSemExam);
                    System.out.println("TO (100): " +to100);
                    System.out.println("Total Marks: " + totalMarks);
                    System.out.println("Grade: " + grade);
               
                    
                    
               
                                  
                    
                    System.out.println("----------------------------------------------------");
                  
                    CreateAndWriteExcel.writeExcelData(rowIndex,serialNo,subjectNames,subjectCode,extraSubjectCode,credit,type,st,qt,as,mte,emptyColumn1,emptyColumn2,emptyColumn3,to40,endSemExam,to100,totalMarks,grade);
                    
                    System.out.println("Processing rowIndex: " + rowIndex);

                    System.out.println("----------------------------------------------------");
                
                    
                    
                    
                    
               
                    
                  
                    
                    
                    
                    rowIndex++;
                  
                    System.out.println("Page wise no:" +page);
                }
              
               
                page++;
                

        				}
                  
        	 }
                        	/*
				 * boolean isValid = validatePDF(latestPDF);
				 * 
				 * try (InputStream ip = new BufferedInputStream(new
				 * FileInputStream(latestPDF)); PDDocument pdDocument = PDDocument.load(ip)) {
				 * 
				 * int pageCount = pdDocument.getNumberOfPages();
				 * System.out.println("Page count: " + pageCount);
				 * 
				 * System.out.println("-------------------------------");
				 * 
				 * PDFTextStripper pdfStripper = new PDFTextStripper(); String pdfText =
				 * pdfStripper.getText(pdDocument); System.out.println(pdfText);
				 * 
				 * System.out.println("-----------------------------------");
				 * 
				 * if (isValid) { System.out.println("The PDF is valid.");
				 * 
				 * 
				 * 
				 * 
				 * 
				 * // Extract and print text from PDF String text1 = pdfText; // Avoid reopening
				 * the PDF
				 * 
				 * // Regex extraction String regex =
				 * "(\\d+)\\s+Reg\\s+No\\s*:\\s*(\\d+)\\s*College\\s+Name\\s*:\\s*(.*?)\\s*Name\\s+of\\s+the\\s+Student\\s*:\\s*(.*?)\\s*Course\\s+(.*?)\\s*GITA\\s+AUTONOMOUS\\s+COLLEGE,\\s+BHUBANESWAR\\s*\\(Affiliated\\s+to\\s+Biju\\s+Pattnaik\\s+University\\s+of\\s+Technology,\\s+Odisha\\)\\s*Final\\s+Tabulation\\s+Register\\s+\\(Student\\s+wise\\)\\s+for\\s+passing\\s+out\\s+year\\s+(\\d{4}-\\d{2})\\s*GITA\\s+Autonomous\\s+College,\\s+Bhubaneswar\r\n";
				 * Pattern pattern = Pattern.compile(regex); Matcher matcher =
				 * pattern.matcher(text1);
				 * 
				 * if (matcher.find()) { String regNo = matcher.group(1);
				 * System.out.println("Extracted Reg No: " + regNo); } else {
				 * System.out.println("No match found."); } } else {
				 * System.out.println("The PDF is invalid or corrupt."); } }
				 */
        				 }} else {
                System.out.println("No PDF files found in the Downloads folder.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }}
       

        
    

    // Find the latest PDF file
    public File getLatestPDF() {
        File folder = new File(downloadsFolder);
        if (!folder.exists() || !folder.isDirectory()) {
            return null;
        }

        File[] pdfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

        if (pdfFiles == null || pdfFiles.length == 0) {
            return null;
        }

        return Arrays.stream(pdfFiles)
                .max(Comparator.comparingLong(File::lastModified))
                .orElse(null);
    }

    // Validate the PDF
    public boolean validatePDF(File file) {
        try (PDDocument document = PDDocument.load(file)) {
            return !document.isEncrypted();
        } catch (IOException e) {
            System.out.println("Error validating PDF: " + e.getMessage());
            return false;
        }
    }
}
