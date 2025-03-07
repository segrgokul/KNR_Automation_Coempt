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
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunctions;
import pageObjMod.pom;

public class Scte_Vt  extends BasicFunctions {
	
    String status;
	
	  public void DirectSignIn(Object regno, Object sycode,Object finalMark,ExtentTest testCaseName) throws InterruptedException, IOException {
	    	
//			ExtentReports report = new ExtentReports("D:\\Coempt_Automation\\coempt_automation\\src\\test\\resources\\reports\\report.html",true);
	//
//			ExtentTest test = report.startTest("ReportCardNavigation");	
//			
			
			
			ExtentTest testCaseScenario = testCaseName
					.createNode( regno + " Validation Test case for "+ sycode +" has started running");

	
	   		

			
	    		
	    		 try { 	
	    		implicitWait(30);	
			
				WebElement btnSemResult = driver.findElement(By.xpath("//tr/td[contains(text(),'" + sycode + "')]/following-sibling::td//a[@class='btn btn-sm btn-primary' and text()='View Result']"));
				//		WebElement btnSemResult = driver.findElement(By.xpath("//tr/td[contains(text(),'5')]/following-sibling::td//a[@class='btn btn-sm btn-primary' and text()='View Result']"));
				
			    
				explicitWait(btnSemResult,30);
				click(btnSemResult);
			
	
				Thread.sleep(15000);
				// Switch to the second window (new tab)
				ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());	
			
				driver.switchTo().window(windowHandles.get(1));

				// Validate PDF URL
				implicitWait(60);
				
				  Robot robot = new Robot();
				
					 
				  	 sendKeys(pom.getInstanceScte_VtXpaths().rollNoTB,regno);
						
				 click(pom.getInstanceScte_VtXpaths().rollNoTB);
				
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
				}//if
	
		      	 implicitWait(1000);
				
	
		      	
		      	 WebElement uiElement = driver.findElement(By.xpath("//h6[@id='result-st']"));
		         // Fetch UI backlog result
	      	    

		     	explicitWait(uiElement,50);
		      	 
		      	 String resultText = uiElement.getText();

		      	String[] parts = resultText.split("\\s*:\\s*");
		      	
		      	
		      	
		      	if (parts.length > 1) {
		      	    System.out.println("UI result:	 "+parts[1].trim()); 
		      	    
		      	    String uiBacklog =parts[1];
		      	    
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
							
		      	      try {
		      	        // Locate total marks element
		      	        WebElement totalMarks = driver.findElement(By.xpath("//table[@id='tbl-results-marks']//tbody/tr[last()]/td[last()]"));

		      	        // Wait for results
		      	        explicitWait(uiElement, 50);

		      	        // Extract and parse total marks
		      	        String totalText = totalMarks.getText().trim();
		      	        int totalMark = Integer.parseInt(totalText);

		      	        System.out.println("Total Marks: " + totalMark);

		      	        // Find subject rows
		      	        List<WebElement> subjectRows = driver.findElements(By.xpath("//table[@id='tbl-results-marks']//tbody/tr"));
		      	        boolean hasBacklog = false;
		      	        StringBuilder backlogSubjects = new StringBuilder();
		      	        int totalSubjects = subjectRows.size();
		      	        int absentCount = 0;
		      	        String formattedScriptBacklog = ""; // Initialize at the beginning
			      	    StringBuilder mpSubjects = new StringBuilder(); // To store subjects with "-"
			      	    int totalMarksSum = 0; // Track total marks
			      	    boolean hasMP = false; // Track if MP condition is met
			      	    boolean comparisonDone = false; // Ensure comparison is done only once

		      	      for (WebElement row : subjectRows) {
		      	        String subjectCode = row.findElement(By.xpath("./td[1]")).getText().trim(); // e.g., TH1 or PR1
		      	        String subjectNames = row.findElement(By.xpath("./td[2]")).getText().trim(); // e.g., Mathematics
		      	        String passMarksText = row.findElement(By.xpath("./td[6]")).getText().trim(); // Passing marks
		      	        String marksTHText = row.findElement(By.xpath("./td[7]")).getText().trim(); // Theory marks
		      	        String marksIAText = row.findElement(By.xpath("./td[8]")).getText().trim(); // Internal Assessment marks
		      	        String marksTotalText = row.findElement(By.xpath("./td[9]")).getText().trim(); // Practical marks

		      	        String subjectDetails = subjectCode + " - " + subjectNames;
		      	

		      	    if (!marksTotalText.isEmpty() && !passMarksText.isEmpty()) {
		      	        if (marksTHText.equalsIgnoreCase("A") || marksIAText.equalsIgnoreCase("A") || marksTotalText.equalsIgnoreCase("A")) {  
		      	            hasBacklog = true;
		      	            absentCount++;
		      	            backlogSubjects.append(subjectCode).append(",");
		      	            System.out.println(subjectDetails + " : Absent with Total Mark " + marksTotalText);
		      	            testCaseScenario.log(Status.PASS, subjectDetails + " : Absent with Total Mark " + marksTotalText);
		      	        } else if (marksTHText.equals("-") || marksIAText.equals("-") || marksTotalText.equals("-")) {
		      	            hasMP = true;
		      	            mpSubjects.append(subjectCode).append(" - ").append(subjectDetails).append(" : -\n");
		      	        } else {
		      	            int passMarks = Integer.parseInt(passMarksText);
		      	            int totalSubjectMarks;
		      	            
		      	            if (subjectCode.contains("PR")) {
		      	            	
		      	               totalSubjectMarks = Integer.parseInt(marksTotalText);
		      	               
		      	                totalMarksSum += totalSubjectMarks;
		      	                
		      	               
		      	                
		      	                if (totalSubjectMarks < passMarks) {
		      	                    hasBacklog = true;
		      	                    backlogSubjects.append(subjectCode).append(",");
		      	                    System.out.println(subjectDetails + " : Failed with Total Marks " + totalSubjectMarks);
		      	                    testCaseScenario.log(Status.PASS, subjectDetails + " : Failed with Total Marks " + totalSubjectMarks);
		      	                } else {
		      	                    System.out.println(subjectDetails + " : Passed with Total Marks " + totalSubjectMarks);
		      	                    testCaseScenario.log(Status.PASS, subjectDetails + " : Passed with Total Marks " + totalSubjectMarks);
		      	                }
		      	            } else {                    
		      	                int subjectMarksTH = Integer.parseInt(marksTHText);
		      	                int subjectMarksIA = Integer.parseInt(marksIAText);
		      	                totalSubjectMarks = subjectMarksTH + subjectMarksIA;
		      	              
		      	                
		      	                if (subjectMarksTH == 0) {
		      	                    if (totalMarksSum > 300 && Integer.parseInt(subjectCode.replaceAll("\\D", "")) > 300) {
		      	                        marksTHText = "DI-" + subjectCode;
		      	                    } else {
		      	                        marksTHText = "Fail";
		      	                        hasBacklog = true;
		      	                        backlogSubjects.append(subjectCode).append(",");
		      	                    }
		      	                    System.out.println(subjectDetails + " : TH mark is 0, updated to " + marksTHText);
		      	                    testCaseScenario.log(Status.PASS, subjectDetails + " : TH mark is 0, updated to " + marksTHText);
		      	                } else if (subjectMarksTH < 28 || totalSubjectMarks < passMarks) {
		      	                    hasBacklog = true;
		      	                    backlogSubjects.append(subjectCode).append(",");
		      	                    System.out.println(subjectDetails + " : Failed with Th mark " + subjectMarksTH + " and Total Marks " + totalSubjectMarks);
		      	                    testCaseScenario.log(Status.PASS, subjectDetails + " : Failed with Th mark " + subjectMarksTH + " and Total Marks " + totalSubjectMarks);
		      	                } else {
		      	                    System.out.println(subjectDetails + " : Passed with Th mark " + subjectMarksTH + " and Total Marks " + totalSubjectMarks);
		      	                    testCaseScenario.log(Status.PASS, subjectDetails + " : Passed with Th mark " + subjectMarksTH + " and Total Marks " + totalSubjectMarks);
		      	                }
		      	            }
		      	        }
		      	    }
		      	      }
		      	    // Process formattedScriptBacklog based on backlogSubjects
		      	    if (formattedScriptBacklog.isEmpty()) {
		      	        formattedScriptBacklog = backlogSubjects.toString().trim().replaceAll(", $", "");
		      	    }

		      	    if (!formattedScriptBacklog.isEmpty() && !formattedScriptBacklog.startsWith("DI")) {
		      	        String[] subjects = formattedScriptBacklog.split(",");
		      	        
		      	        if (!subjects[0].startsWith("Back-")) {
		      	            subjects[0] = "Back-" + subjects[0].trim();
		      	        }
		      	        
		      	        for (int i = 1; i < subjects.length; i++) {
		      	            subjects[i] = subjects[i].replace("Back-", "").trim();
		      	        }
		      	        
		      	        formattedScriptBacklog = String.join(",", subjects);
		      	    }

		      	    if (formattedScriptBacklog.isEmpty()) {
		      	        formattedScriptBacklog = "Pass";
		      	    }

		      	    // Check total marks condition only after processing all subjects
		      	    if (hasMP) {
		      	        formattedScriptBacklog = "MP";
		      	    } else if (totalMark < 300) {
		      	        formattedScriptBacklog = "Fail";
		      	    } else if (formattedScriptBacklog.startsWith("Back-") && totalMarksSum >= 300) {
		      	        formattedScriptBacklog = formattedScriptBacklog.replace("Back-", "");
		      	    }

		      	    // Print subjects with "-" values only once
		      	    if (mpSubjects.length() > 0) {
		      	        System.out.println("Subjects with '-':\n" + mpSubjects.toString().trim());
		      	    }

		      	    // Compare with UI only once
		      	    if (!comparisonDone) {
		      	        if (formattedScriptBacklog.equals(uiBacklog)) {
		      	            System.out.println("Backlog comparison PASS: Script - " + formattedScriptBacklog + " | UI - " + uiBacklog);
		      	            testCaseScenario.log(Status.PASS, "Backlog comparison PASS: Script - " + formattedScriptBacklog + " | UI - " + uiBacklog);
		      	        } else {
		      	            System.out.println("Backlog comparison FAILED: Script - " + formattedScriptBacklog + " | UI - " + uiBacklog);
		      	            testCaseScenario.log(Status.FAIL, "Backlog comparison FAILED: Script - " + formattedScriptBacklog + " | UI - " + uiBacklog);
		      	        }
		      	        comparisonDone = true;
		      	    }
   	      
		      	        
		      	    } catch (Exception e1) {
		      	        System.out.println("An error occurred: " + e1.getMessage());
		      	        testCaseScenario.log(Status.WARNING, "Error occurred while fetching total marks: " + e1.getMessage(),	MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
		      	    }

		
		 
		      	
		      			
		      	
		      	}    	
		    	driver.close();

				// Switch back to the parent window (index 0 in the list)
				driver.switchTo().window(windowHandles.get(0));
				
			
			    
					 }//try
						
						catch(Exception e){
			if(pom.getInstanceScte_VtXpaths().btnAlertOk.isDisplayed()) {

			testCaseScenario.log(Status.SKIP,"Please check the following regno " + regno,	MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
		
			testCaseScenario.log(Status.WARNING,e.getMessage());
			
			driver.navigate().refresh();
			
			}
			
			else {
				testCaseScenario.log(Status.WARNING,e.getMessage());
			}
			
						}//catch
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
