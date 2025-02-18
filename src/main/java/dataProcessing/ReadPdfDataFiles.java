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
        				for (int page = 1; page <= totalPages; page++) {
        					stripper.setStartPage(page);
        					stripper.setEndPage(page);

        					//TO print the text
        					
        					String text = stripper.getText(document).replaceAll("[\r\n]+", "\n");
        					System.out.println(text);
        					
        					System.out.println("Page " + page + ":");
        					System.out.println("---------------------------------------------------");
        					// Extract registration number
      
        					
            	System.out.println("Latest PDF file found: " + latestPDF.getName());


                // Updated regex pattern
           
            	 // Updated regex pattern
                String regex = "(\\d+)\\s+([A-Za-z\\s-]+)\\s+(\\w+)\\s+(\\d+)\\s+([A-Z])\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(-+|\\d+)?\\s*(-+|\\d+)?\\s*(-+|\\d+)?\\s*(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+([A-Z])";
            	
            	Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(text);

             
                
                
                
                while (matcher.find()) {
                	
                	
                String	serialNo = matcher.group(1);
                String     subjectNames = matcher.group(2).trim();
             
                
                String      subjectCode = matcher.group(3);
                String      credit = matcher.group(4);
                String       type = matcher.group(5);
                String       st = matcher.group(6);
                String       qt = matcher.group(7);
                String       as = matcher.group(8);
                String       mte = matcher.group(9);
                String       emptyColumn1 = matcher.group(10) != null ? matcher.group(10) : "N/A";
                String       emptyColumn2 = matcher.group(11) != null ? matcher.group(11) : "N/A";
                String       emptyColumn3 = matcher.group(12) != null ? matcher.group(12) : "N/A";
                String       to40 = matcher.group(13);
                String       endSemExam = matcher.group(14);
                String       to100 = matcher.group(15);
                String       totalMarks = matcher.group(16);
                String       grade = matcher.group(17);
                      
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                    System.out.println("Serial No: " + serialNo);
                    System.out.println("Subject Name: " + subjectNames);
                 
                    
                    System.out.println("Subject Code: " + subjectCode);
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
                  
       
                    CreateAndWriteExcel.writeExcelData(serialNo,subjectNames,subjectCode,credit,type,st,qt,mte,emptyColumn1,emptyColumn2,emptyColumn3,to40,endSemExam,to100,totalMarks,grade);
                    
                    System.out.println("----------------------------------------------------");
                
                
                
                    
                
                }
                break;    
                
            
            } 
                // Validate the PDF
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
        				} } else {
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
