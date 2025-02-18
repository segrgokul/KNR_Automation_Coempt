package dataProcessing;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPdfData {

    static String downloadsFolder = System.getProperty("user.home") + "/Downloads";

    public static void readPdfData() throws IOException {
        try {
            // Find the latest PDF file in the Downloads folder
            File latestPDF = getLatestPDF();
            System.out.println("Downloads folder: " + downloadsFolder);

            if (latestPDF != null) {
                System.out.println("Latest PDF file found: " + latestPDF.getName());

                // Validate the PDF
                boolean isValid = validatePDF(latestPDF);
                if (isValid) {
                    System.out.println("The PDF is valid.");

                    // Extract and print text from PDF
                    String text = extractTextFromPDF(latestPDF);
                    System.out.println("PDF Content:\n" + text);
                    
                    String regex = "Reg No : (\\d{10})";
                    
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(text);
                    
                    if (matcher.find()) {
                        String regNo = matcher.group(1); // Extracts the Reg No value
                        System.out.println("Extracted Reg No: " + regNo);
                    } else {
                        System.out.println("No match found.");
                    }
                
                    
                    
                } else {
                    System.out.println("The PDF is invalid or corrupt.");
                }
            } else {
                System.out.println("No PDF files found in the Downloads folder.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Find the latest PDF file in the given folder
    public static File getLatestPDF() {
        File folder = new File(downloadsFolder);
        if (!folder.exists() || !folder.isDirectory()) {
            return null;
        }

        File[] pdfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

        if (pdfFiles == null || pdfFiles.length == 0) {
            return null;
        }

        // Sort files by last modified time (latest first)
        return Arrays.stream(pdfFiles)
                .max(Comparator.comparingLong(File::lastModified))
                .orElse(null);
    }

    // Validate the PDF
    public static boolean validatePDF(File file) {
        try (PDDocument document = PDDocument.load(file)) {
            return !document.isEncrypted(); // Example validation: check if the PDF is not encrypted
        } catch (IOException e) {
            System.out.println("Error validating PDF: " + e.getMessage());
            return false;
        }
    }

    // Extract text from the PDF
    public static String extractTextFromPDF(File file) {
        try (PDDocument document = PDDocument.load(file)) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        } catch (IOException e) {
            System.out.println("Error extracting text from PDF: " + e.getMessage());
            return "";
        }
    }
}
