package dataProcessing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReadPdfDataFiles {

    static String downloadsFolder = System.getProperty("user.home") + "/Downloads";

    String studentSemester;
    boolean isSemester1 = false;
    boolean isSemester2 = false;
    
    public void readPdfData(ExtentTest testCaseName) throws IOException {
        try {
        	 ExtentTest testCaseScenario = testCaseName
 		            .createNode("Read PDF write Excel Test case has started running");

        	
        	// Find the latest PDF file
            File latestPDF = getLatestPDF();
            System.out.println("Downloads folder: " + downloadsFolder);
            testCaseScenario.log(Status.PASS, "Latest PDF file is loaded successfully");

            
            //checks the latest page is not null
            if (latestPDF != null) {
       
            	//to load the latestfile
        			try (PDDocument document = PDDocument.load(latestPDF)) {
        				PDFTextStripper stripper = new PDFTextStripper();
        				int totalPages = document.getNumberOfPages();
        				System.out.println("Total Pages: " + totalPages);
        				System.out.println("---------------------------------------------------");

        				// Iterate through all pages and extract text
        		//		for (int page = 1; page <= totalPages; page++) {
        	
        
        	int semIndex=1;
        	int regIndex=1;
            int rowIndex = 1;
            
            //for pages
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
             	String regno = "(?m)^\\d{10}"; //regno pattern

                  Pattern regnoPattern = Pattern.compile(regno);
                  Matcher regnoMatcher = regnoPattern.matcher(text);
                   // Updated regex pattern
                  if(regnoMatcher.find()) {
                  	
                	String studentRegno = regnoMatcher.group(0);
                 	System.out.println("=================");
                  	
                  	System.out.println("studentRegno :"+studentRegno);

                 
//subjects and marks pattern                
String subjectAndMarks = "(\\d+)"                          // (1) Course Number
+ "\\s+([A-Za-z&\\s/\\-]+[A-Za-z])"      // (2) Subject Name
+ "\\s+([A-Z0-9]+(?:\\s+[A-Z0-9]+)?)"    // (3) Subject Code (simplified)
+ "\\s+(\\d+)"                          // (4) Credit Hours
+ "\\s+([TP])"                          // (5) Subject Type
+ "\\s+(\\d+|-)"                        // (6) Internal Marks 1
+ "\\s+(\\d+|-)"                        // (7) Internal Marks 2
+ "\\s+(\\d+|-)"                        // (8) Internal Marks 3
+ "\\s+(\\d+|-)"                        // (9) Internal Marks 4
+ "(?:\\s+(-|\\d+))?"                   // (10) Optional Field 1
+ "(?:\\s+(-|\\d+))?"                   // (11) Optional Field 2
+ "(?:\\s+(-|\\d+))?"                   // (12) Optional Field 3
+ "(?:\\s+(-|\\d+))?"                   // (13) Optional Field 4
+ "\\s+(\\d+|-)"                        // (14) Final Marks 1
+ "(?:\\s+(-|\\d+))?"                   // (15) Final Marks 2
+ "\\s+(\\d+)"                          // (16) Final Marks 3
+ "\\s+(\\d+)"                          // (17) Total Marks
+ "\\s+([A-Z])";                        // (18) Grade

Pattern subjectAndMarkspattern = Pattern.compile(subjectAndMarks, Pattern.DOTALL);
Matcher subjectAndMarksmatcher = subjectAndMarkspattern.matcher(text);

String currentSemester = null;  // Stores the actual semester name

Pattern semPattern = Pattern.compile("Semester\\s*[IVXLCDM]+");
Matcher semMatcher = semPattern.matcher(text);

// Store semester positions in the text
Map<Integer, String> semesterPositions = new TreeMap<>();
while (semMatcher.find()) {
    semesterPositions.put(semMatcher.start(), semMatcher.group());
}

// Start processing subjects
while (subjectAndMarksmatcher.find()) {
    int matchStart = subjectAndMarksmatcher.start(); // Get the start position of the current match

    // Assign semester dynamically based on subject position
    for (Map.Entry<Integer, String> entry : semesterPositions.entrySet()) {
        if (matchStart >= entry.getKey()) {
            currentSemester = entry.getValue();  // Update semester
        } else {
            break;
        }
    }

    // Ensure we always have a valid semester
    if (currentSemester == null) {
        continue;  // Skip this subject if no semester was detected before it
    }
    
    String serialNo = subjectAndMarksmatcher.group(1);
    String subjectNames = subjectAndMarksmatcher.group(2).trim();
    String subjectCode = subjectAndMarksmatcher.group(3);
    
   // String extraSubjectCode = subjectAndMarksmatcher.group();
    String credit = subjectAndMarksmatcher.group(4);
    String type = subjectAndMarksmatcher.group(5);
    String st = subjectAndMarksmatcher.group(6);
    String qt = subjectAndMarksmatcher.group(7);
    String as = subjectAndMarksmatcher.group(8);
    String mte = subjectAndMarksmatcher.group(9);
    String emptyColumn1 = subjectAndMarksmatcher.group(10) != null ? subjectAndMarksmatcher.group(10) : "N/A";
    String emptyColumn2 = subjectAndMarksmatcher.group(11) != null ? subjectAndMarksmatcher.group(11) : "N/A";
    String emptyColumn3 = subjectAndMarksmatcher.group(12) != null ? subjectAndMarksmatcher.group(12) : "N/A";
    String to40 = subjectAndMarksmatcher.group(13);
    String endSemExam = subjectAndMarksmatcher.group(14); //15 skipped due to pattern
    String to100 = subjectAndMarksmatcher.group(16);
    String totalMarks = subjectAndMarksmatcher.group(17);
    String grade = subjectAndMarksmatcher.group(18);

    System.out.println("=================");

    System.out.println("studentRegno: " + studentRegno);
    System.out.println("studentSemester: " + currentSemester);  // Correct Semester Name
    System.out.println("Serial No: " + serialNo);
    System.out.println("Subject Name: " + subjectNames);
    System.out.println("Subject Code: " + subjectCode);
//    System.out.println("Extra Subject Code: " + extraSubjectCode);
    System.out.println("Cr: " + credit);
    System.out.println("Type (T/P): " + type);
    System.out.println("ST (5): " + st);
    System.out.println("QT (5): " + qt);
    System.out.println("AS (5): " + as);
    System.out.println("MTE (25): " + mte);
    System.out.println("Empty Column1: " + emptyColumn1);
    System.out.println("Empty Column2: " + emptyColumn2);
    System.out.println("Empty Column3: " + emptyColumn3);
    System.out.println("TO (40): " + to40);
    System.out.println("End Sem Exam (60): " + endSemExam);
    System.out.println("TO (100): " + to100);
    System.out.println("Total Marks: " + totalMarks);
    System.out.println("Grade: " + grade);
    System.out.println("----------------------------------------------------");

    // Writing data to Excel
    CreateAndWriteExcel.writeExcelData(
        rowIndex, studentRegno, currentSemester, serialNo, subjectNames, subjectCode, credit, type, 
        st, qt, as, mte, emptyColumn1, emptyColumn2, emptyColumn3, to40, endSemExam, to100, totalMarks, grade
    );

    rowIndex++;
}//subjects and marks pattern while loop ends
         
} //regno if patttern ends   
            
}//for loop ends for page
  
}	//load the latestfile end
                   
} //checks the latest page is not null ends
            
            else {
                System.out.println("No PDF files found in the Downloads folder.");
            }
        }//tryEnds
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
    
    
    }//tryEnds
       

        
    

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
