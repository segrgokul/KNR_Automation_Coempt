package dataProcessing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPdfDataFiles {

    static String downloadsFolder = System.getProperty("user.home") + "/Downloads";

    String studentSemester;

    
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
        	
        	int rowIndex = 1;
        	int semIndex=1;
        	int regIndex=1;
        	for (int page = 1;page<=totalPages;page++) {
        			
        					
        		 			
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
                  	
                	String studentRegno = regnoMatcher.group(0);
                 	System.out.println("=================");
                  	
                  	System.out.println("studentRegno :"+studentRegno);
                  	
            //  	CreateAndWriteExcel.writeExcelRegnoData(studentRegno);
                  	
                  

                  	
                
              	System.out.println("=================");                	
                
                
              	String sem = "Semester\\s*[IVXLCDM]+";
//              
//
                Pattern semPattern = Pattern.compile(sem);
                Matcher semMatcher = semPattern.matcher(text);
//              
//
                System.out.println("=================");
                
                List<String> studentSemesterList = new ArrayList<>();
//            
             // Find and collect semesters for the page
         
            if (semMatcher.find()) {  
            	  
                   
            	studentSemester = semMatcher.group();
                studentSemesterList.add(studentSemester);
                 
                System.out.println("studentSemesterList" +studentSemesterList);
            
                System.out.println("-------------------------------");
                
               System.out.println("studentSemesterList" +studentSemester);
               semIndex++;
               
            }
//             
               
// 
//                    studentSemesterList.add(studentSemester);
//                    System.out.println("studentSemesterList:" +studentSemesterList);
//                                      
//                    // You can now add subjects to this list if needed
//                    // Example: studentSemesterList.add("Mathematics");
//
//                    // Print semester
//                    System.out.println("studentSemester:" +studentSemester);
//                
//             }/*
//                	
//                	
              
                
                
//                 }
                 
                
                  String regex = "(\\d+)"                          // (1) Course Number
                		  
                		+  "\\s+([A-Za-z&\\s/\\-]+[A-Za-z])" //(2) subject name

//correct code 
//+"\\s+([A-Z0-9]+(?:\\s+([CE]\\d{3}))?|\\d{2}[A-Z]+\\d+\\r?\\n?\\d*|SI\\d{3}|\\d{2}BTCSEPP|\\bSI\\d{3}\\b)"// (3) Subject Code
  
 +"\\s+([A-Z0-9]+(?:\\s+([CE]\\d{3}))?|\\d{2}[A-Z]+\\d+\\r?\\n?\\d*\\s*\\R?\\s*SI\\d{3}||\\d{2}[A-Z]+\\d+\\s*\\R?\\s*SI\\d{3}|SI\\d{3}\\d{2}BTCSEPP(?:\\s*\\R\\s*SI\\d{3})+|\\bSI\\d{3}\\b|\\d{2}BTCSE[A-Z]{2}\\sSI\\d{3}|\\d{2}BTPMC\\d+|\\b\\d\\b|\\d{2}[A-Z]+\\d+\\r?\\n?\\d*|SI\\d{3})" // (3) Subject Code
 

//+"\\s+([A-Z0-9]+(?:\\s+([CE]\\d{3}))?|\\d{2}[A-Z]+\\d+\\r?\\n?\\d*||\\d{2}[A-Z]+\\d+\\s*\\R?\\s*SI\\d{3}|SI\\d{3}|\\d{2}BTCSEPP|\\bSI\\d{3}\\b)"// (3) Subject Code
   


 //+"\\s+([A-Z0-9]+(?:\\s+([CE]\\d{3}))?|\\d{2}[A-Z]+\\d+\\r?\\n?\\d*\\s*\\R?\\s*SI\\d{3}||\\d{2}[A-Z]+\\d+\\s*\\R?\\s*SI\\d{3}|SI\\d{3}\\d{2}BTCSEPP(?:\\s*\\R\\s*SI\\d{3})+|\\bSI\\d{3}\\b|\\d{2}BTCSE[A-Z]{2}\\sSI\\d{3})"

                		
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

             
       
              // Flag to skip to the next semester
//                int semesterIndex = 0; // Track semester for subjects  
//                for (String studentSemester : studentSemesterList) {
//                    System.out.println("Processing Semester: " + studentSemester);
                
                
                // Start from row 1 (row 0 is header)  
                while (matcher.find()) {
                	
               
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
                      
                	
                	
                	
                	
                	
                	
                	
                	
                
                System.out.println("studentRegno: " + studentRegno);
                 System.out.println("studentSemester: " + studentSemester);	
      
       
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
                  
                    CreateAndWriteExcel.writeExcelData(rowIndex,studentRegno,studentSemester,serialNo,subjectNames,subjectCode,extraSubjectCode,credit,type,st,qt,as,mte,emptyColumn1,emptyColumn2,emptyColumn3,to40,endSemExam,to100,totalMarks,grade);
                    
                    System.out.println("Processing rowIndex: " + rowIndex);

                    System.out.println("----------------------------------------------------");
                 
                
                    
               
                    
                    System.out.println("Page wise no:" +page);
                
                    rowIndex++;
             
                 
                      
                  

          
                }    
            
            }
                
                // Check for the total pattern
                   
                 
             
                
                }//while loop for pattern
              
            
                  
     
               

            }//while loop for page
                   
        	
        	
        				 } else {
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
