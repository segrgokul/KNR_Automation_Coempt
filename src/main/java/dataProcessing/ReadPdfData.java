package dataProcessing;


	import java.io.IOException;



	public class ReadPdfData {

	    
	    	static String userDirectory= System.getProperty("user.dir");
	    	
	     static	String fileName ="MDSMarkStatementPart2-21.pdf";
	    	
	    static	String path = "D:\\Coempt_Automation\\coempt_automation\\src\\test\\resources\\dataSheets\\";
	    	
	    	
	    	
		    public static void readPdfData() throws IOException {
	    	
	    	String pdfFile = userDirectory + path +fileName;
	    	
	    	
	    
		    
		    
		    
		    
		    
		    
		    
		    
		    }
//	        String downloadsFolder = System.getProperty("user.home") + "/Downloads";
//
//	        try {
//	            // Find the latest PDF file in the Downloads folder
//	            File latestPDF = getLatestPDF();
//	            System.out.println("Downloads folder: " + downloadsFolder);
//	           
//	       
//	            if (latestPDF != null) {
//	                System.out.println("Latest PDF file found: " + latestPDF.getName());
//
//	                // Validate the PDF
//	                boolean isValid = validatePDF(latestPDF);
//	                if (isValid) {
//	                    System.out.println("The PDF is valid.");
//	                } else {
//	                    System.out.println("The PDF is invalid or corrupt.");
//	                }
//	            } else {
//	            	
//	            	File folder = new File(downloadsFolder);
//	            	if (!folder.exists() || !folder.isDirectory()) {
//	            	    System.out.println("Downloads folder does not exist or is not a directory.");
//	            	}
//	                System.out.println("No PDF files found in the Downloads folder.");
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	    // Find the latest PDF file in the given folder
//	    public static File getLatestPDF() {
//	        	 String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
//	             
//	             File latestPDF = getLatestPDF();
//	             
//	             if (latestPDF != null) {
//	                 System.out.println("Latest PDF file: " + latestPDF.getName());
//	             } else {
//	                 System.out.println("No PDF files found.");
//	             }
//				return latestPDF;
//	        }
//
//	    // Get the last modified time of a file
//	    private static FileTime getLastModifiedTime(Path path) {
//	        try {
//	            return Files.getLastModifiedTime(path);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            return FileTime.fromMillis(0);
//	        }
//	    }
//
//	    // Validate the PDF
//	    public static boolean validatePDF(File file) {
//	        try (PDDocument document = PDDocument.load(file)) {
//	            return !document.isEncrypted(); // Example validation: check if the PDF is not encrypted
//	        } catch (IOException e) {
//	            System.out.println("Error validating PDF: " + e.getMessage());
//	            return false;
//	        }
//	    }
	    
	    
	}


