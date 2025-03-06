package pageModules;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; // Set a higher limit

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasicFunctions;
import pageObjMod.pom;

public class Scte_Vt  extends BasicFunctions {
	
    String status;
	
	  public void DirectSignIn(Object regno, Object subjectName,Object finalMark,ExtentTest testCaseName) throws InterruptedException, IOException {
	    	
//			ExtentReports report = new ExtentReports("D:\\Coempt_Automation\\coempt_automation\\src\\test\\resources\\reports\\report.html",true);
	//
//			ExtentTest test = report.startTest("ReportCardNavigation");	
//			
			
			ExtentTest testCaseScenario = testCaseName
					.createNode( regno + " Validation Test case has started running");

	
	    	try {
	    	
	    		implicitWait(30);	
				explicitWait(pom.getInstanceScte_VtXpaths().fivethSemResult,30);
				click(pom.getInstanceScte_VtXpaths().fivethSemResult);
			
				
				Thread.sleep(15000);

				// Switch to the second window (new tab)
				ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());	
				
				driver.switchTo().window(windowHandles.get(1));

				// Validate PDF URL
				implicitWait(60);
				
				  Robot robot = new Robot();
				
				  robot.keyPress(KeyEvent.VK_TAB);
					 robot.keyRelease(KeyEvent.VK_TAB);
					 
				  	 sendKeys(pom.getInstanceScte_VtXpaths().rollNoTB,regno);
						
				 click(pom.getInstanceScte_VtXpaths().rollNoTB);
				
			
				
			
				
				//  Press TAB key 
				  
				 
			
			
				
				
				 System.out.println(pom.getInstanceScte_VtXpaths().dobTB.isDisplayed());
					
				 pom.getInstanceScte_VtXpaths().dobTB.click();
				if (pom.getInstanceScte_VtXpaths().dobTB.isDisplayed()) {

		//			test.log(LogStatus.PASS, "User is unable to enter with direct signin button ");
					 
				
				 
				
		      	
		     	 click(pom.getInstanceScte_VtXpaths().dobTB);
		      	
		      	 implicitWait(30);
		      	 
		     	 click(pom.getInstanceScte_VtXpaths().dobPrev);
		      	 
		      	
		     	 implicitWait(30);
		      	 
		     	 click(pom.getInstanceScte_VtXpaths().dobPrev);
		     	 implicitWait(30);
		      	 
		     	 click(pom.getInstanceScte_VtXpaths().dobPrev);
		  	 
		     	 	implicitWait(30);
		      	 
		     	 click(pom.getInstanceScte_VtXpaths().dobPrevYear);
		      	implicitWait(30);
		      	 click(pom.getInstanceScte_VtXpaths().dobPrevMonth);
		      	 
		      	implicitWait(30);
		      	 click(pom.getInstanceScte_VtXpaths().dobPrevDate);
		      	 
		     	implicitWait(30);
		      	 click(pom.getInstanceScte_VtXpaths().btnViewStudentResults);
		    	 
			    
		      	 
		      	 implicitWait(1000);
		      	 
		      
	
		      	
		      	 WebElement results = driver.findElement(By.xpath("//h6[@id='result-st']"));

		     	explicitWait(results,50);
		      	 
		      	 String resultText = results.getText();
		      	System.out.println("fhjsfdj" + resultText );

		      	 
		      	 
		      	String[] parts = resultText.split("\\s*:\\s*");
		      	
		      	
		      	
		      	if (parts.length > 1) {
		      	    System.out.println("fdsdfsdfsdfs"+parts[1].trim()); 
		      	    
		      	    String resultsTexts =parts[1];
		      	    
		      	    // Print "Pass" after trimming spaces
		      	
		      	 
		   	 Thread.sleep(15000);
	      	 
		    	scrollTillEnd(driver);
		      	 
		      	 
		
	//	      	List<WebElement> cells = driver.findElements(By.xpath("//div[@class='card card-preview']//tbody/tr"));

		        // Find all rows in the table
		        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tbl-results-marks']//tbody/tr	"));

		        StringBuilder result = new StringBuilder("Result: ");
		        boolean hasBacklog1 = false;
		      	List<WebElement> thCells = driver.findElements(By.xpath("//table[@id='tbl-results-marks']//tbody/tr/td[7]"));
		      	List<WebElement> subjectCells = driver.findElements(By.xpath("//table[@id='tbl-results-marks']//tbody/tr/td[2]"));
		      	List <WebElement> subjectCodeAndThCells = driver.findElements(By.xpath("//table[@id='tbl-results-marks']//tbody/tr[td[1] and td[7]]"));
		      	
		          // Find all rows in the table

		      	        int count = 0; // Counter to track rows processed

						/*
						 * // Loop through each row for (WebElement row : rows) { try { // Get the
						 * subject code (first <td> in the row) WebElement subjectElement =
						 * row.findElement(By.xpath("./td[1]")); String subjectCode =
						 * subjectElement.getText().trim();
						 * 
						 * 
						 * WebElement subjectNamesElement = row.findElement(By.xpath("./td[2]")); String
						 * subjectNames = subjectNamesElement.getText().trim();
						 * 
						 * 
						 * // Get the corresponding marks (adjust column index as needed) WebElement
						 * marksElement = row.findElement(By.xpath("./td[7	]")); // Change index if
						 * needed String marks = marksElement.getText().trim(); // Process the text
						 * (Pass, Fail, or Absent) status = processText(marks);
						 * 
						 * System.out.println("jhdsgfjhgs" + marks);
						 * 
						 * 
						 * // If status is "A" (Absent) or "Fail", it's a backlog if (status.equals("A")
						 * || status.equals("Fail")) { result.append(" Back-").append( subjectCode );
						 * 
						 * 
						 * hasBacklog1 = true; }
						 * 
						 * 
						 * System.out.print("Subject Name: " + subjectNames + "Subject Code: " +
						 * subjectCode + " subjectMarks: "+ status );
						 * 
						 * testCaseScenario.log(Status.PASS, "Subject Name: " + subjectNames +
						 * "Subject Code: " + subjectCode + " subjectMarks: "+status);
						 * 
						 * 
						 * 
						 * // Check if the student is absent or has marks below the pass mark
						 * 
						 * String finalResult = hasBacklog1 ? result.toString() : "Result : Pass";
						 * 
						 * testCaseScenario.log(Status.PASS,finalResult);
						 * 
						 * 
						 * System.out.println(finalResult);
						 * 
						 * count++; // Stop the loop after processing 5 rows if (count == 5) { //
						 * System.out.println("Stopping after 5 rows."); break; }
						 * 
						 * }//try
						 * 
						 * 
						 * catch (Exception e) { System.out.println("Skipping row - Missing data"); }
						 * 
						 * 
						 * }
						 */
		      	      try {
		      	        // Locate the total marks element
		      	        WebElement totalMarks = driver.findElement(By.xpath("//table[@id='tbl-results-marks']//tbody/tr[last()]/td[last()]"));
		      	        
		      	        // Wait until results are loaded
		      	        explicitWait(results, 50);
		      	        
		      	        // Extract and parse total marks
		      	        String totalText = totalMarks.getText().trim();
		      	        int totalMark = Integer.parseInt(totalText);

		      	        System.out.println("Total Marks: " + totalMark);
		      	        
		      	        // Check if any subject is failed or absent
		      	        List<WebElement> subjectRows = driver.findElements(By.xpath("//table[@id='tbl-results-marks']//tbody/tr"));
		      	        boolean hasBacklog = false;
		      	        StringBuilder backlogSubjects = new StringBuilder();

		      	        for (WebElement row : subjectRows) {
		      	            String subjectCode = row.findElement(By.xpath("./td[1]")).getText().trim(); // Assuming subject code is in first column
		      	            String marksText = row.findElement(By.xpath("./td[last()]")).getText().trim(); // Assuming marks are in the last column
		      	            
		      	            if (!marksText.isEmpty()) {
		      	                if (marksText.equalsIgnoreCase("A")) {  
		      	                    hasBacklog = true;
		      	                    backlogSubjects.append("Back-").append(subjectCode).append(" (Absent) ");
		      	                    System.out.println(subjectCode + " : Absent");
		      	                    testCaseScenario.log(Status.FAIL, subjectCode + " : Absent");
		      	                } else {
		      	                    int subjectMarks = Integer.parseInt(marksText);
		      	                    if (subjectMarks < 35) {
		      	                        hasBacklog = true;
		      	                        backlogSubjects.append("Back-").append(subjectCode).append(" ");
		      	                        System.out.println(subjectCode + " : Failed (" + subjectMarks + ")");
		      	                        testCaseScenario.log(Status.FAIL, subjectCode + " : Failed with marks " + subjectMarks);
		      	                    } else {
		      	                        System.out.println(subjectCode + " : Passed (" + subjectMarks + ")");
		      	                        testCaseScenario.log(Status.PASS, subjectCode + " : Passed with marks " + subjectMarks);
		      	                    }
		      	                }
		      	            }
		      	            
		      	          count++;
	      	                // Stop the loop after processing 5 rows
	      	                if (subjectCode.equals("Sessional")) {
	      	                 //   System.out.println("Stopping after 5 rows.");
	      	                    break;
	      	                }

	      	         
		      	            
		      	            
		      	        }

		      	        // Final Result Decision
		      	        if (totalMark >= 300) {
		      	            if (hasBacklog) {
		      	                System.out.println("The student has FAILED since he has backlogs in: " + backlogSubjects);
		      	                testCaseScenario.log(Status.FAIL, "The student has FAILED since he has backlogs in: " + backlogSubjects);
		      	            } else {
		      	                System.out.println("The student has PASSED with total marks: " + totalMark);
		      	                testCaseScenario.log(Status.PASS, "The student has PASSED with total marks: " + totalMark);
		      	            }
		      	        } else {
		      	            System.out.println("The student has FAILED with total marks: " + totalMark);
		      	            testCaseScenario.log(Status.FAIL, "The student has FAILED with total marks: " + totalMark);
		      	        }

		      	    } catch (Exception e) {
		      	        System.out.println("An error occurred: " + e.getMessage());
		      	        testCaseScenario.log(Status.FAIL, "Error occurred while fetching total marks: " + e.getMessage());
		      	    }
		      	      
	   	    	   
		      
	   	    	   
		      	
		      	
		
		 }
		      	
		      	}    	
		    	driver.close();

				// Switch back to the parent window (index 0 in the list)
				driver.switchTo().window(windowHandles.get(0));
	    	}
	    	 	
	    	catch(Exception e){
	    		e.printStackTrace();
	    		capture(driver);
	   	}
	  }
	  public String processText(String thText) {
		    // Trim the text to remove extra spaces
		    String trimmedText = thText.trim();
		    
		    // Check for exact match for "A" (Absent)
		    if (trimmedText.equalsIgnoreCase("A")) {
		        return "A"; // Mark as absent
		    }

		    // Extract digits (marks) from the text
		    String number = trimmedText.replaceAll("\\D", "");
		    
		    // Extract subject code (assuming it's the first non-numeric word)
		    String subjectCode = trimmedText.replaceAll("\\d", "").trim();

		    if (!number.isEmpty()) {
		        int num = Integer.parseInt(number);
		        // If number is greater than or equal to 28, it's a Pass, otherwise "Back-" + subjectCode
		        return (num >= 28) ? "Pass" : "Back-" + subjectCode;
		    }

		    return "Unknown"; // Default case if no valid number is found
		}
	  

	    	
	    	
}
