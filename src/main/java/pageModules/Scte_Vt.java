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
		      	 
		      
	
		      	
		      	 WebElement uiElement = driver.findElement(By.xpath("//h6[@id='result-st']"));
		         // Fetch UI backlog result
	      	    

		     	explicitWait(uiElement,50);
		      	 
		      	 String resultText = uiElement.getText();

		      	String[] parts = resultText.split("\\s*:\\s*");
		      	
		      	
		      	
		      	if (parts.length > 1) {
		      	    System.out.println("UI result: "+parts[1].trim()); 
		      	    
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
		      	                System.out.println(subjectDetails + " : Absent");
		      	                testCaseScenario.log(Status.FAIL, subjectDetails + " : Absent");
		      	            } else {
		      	                int passMarks = Integer.parseInt(passMarksText);
		      	                int totalSubjectMarks;

		      	              if (subjectCode.contains("PR")) {
		      	                // Practical subject: Compare PR marks directly with pass marks
		      	                totalSubjectMarks = Integer.parseInt(marksTotalText);
		      	                if (totalSubjectMarks < passMarks) {  // **Ensure failed practicals are marked as backlog**
		      	                    hasBacklog = true;
		      	                    backlogSubjects.append(subjectCode).append(",");
		      	                    System.out.println(subjectDetails + " : Failed with Total Marks " + totalSubjectMarks);
		      	                    testCaseScenario.log(Status.FAIL, subjectDetails + " : Failed with Total Marks " + totalSubjectMarks);
		      	                } else {
		      	                    System.out.println(subjectDetails + " : Passed with Total Marks " + totalSubjectMarks);
		      	                    testCaseScenario.log(Status.PASS, subjectDetails + " : Passed with Total Marks " + totalSubjectMarks);
		      	                }}
		      	            else {					
		      	              // Theory subject: Compare (TH + IA) with pass marks
		      	              int subjectMarksTH = Integer.parseInt(marksTHText);
		      	              int subjectMarksIA = Integer.parseInt(marksIAText);
		      	              totalSubjectMarks = subjectMarksTH + subjectMarksIA;
		      	                if (subjectMarksTH < 28 ||totalSubjectMarks < passMarks) {
		      	                    hasBacklog = true;
		      	                    backlogSubjects.append(subjectCode).append(",");
		      	                    System.out.println(subjectDetails + " : Failed with Total Marks " + totalSubjectMarks);
		      	                    testCaseScenario.log(Status.FAIL, subjectDetails + " : Failed with Total Marks " + totalSubjectMarks);
		      	                } else {
		      	                    System.out.println(subjectDetails + " : Passed with Total Marks " + totalSubjectMarks);
		      	                    testCaseScenario.log(Status.PASS, subjectDetails + " : Passed with Total Marks " + totalSubjectMarks);
		      	                }
		      	            }}
		      	        }
		      	    }

		      	    // **Ensure correct backlog formatting**
		      	    String formattedScriptBacklog = backlogSubjects.toString().trim().replaceAll(", $", "");
		      	    if (!formattedScriptBacklog.isEmpty()) {
		      	        String[] subjects = formattedScriptBacklog.split(",");

		      	        // Apply "Back-" only to the first subject if it doesn't already have it
		      	        if (!subjects[0].startsWith("Back-")) {
		      	            subjects[0] = "Back-" + subjects[0].trim();
		      	        }

		      	        // Ensure no extra "Back-" is added to the remaining subjects
		      	        for (int i = 1; i < subjects.length; i++) {
		      	            subjects[i] = subjects[i].replace("Back-", "").trim();
		      	        }

		      	        formattedScriptBacklog = String.join(",", subjects);
		      	    }

		      	    // **Handle Pass/Fail conditions**
		      	    if (formattedScriptBacklog.isEmpty()) {
		      	        formattedScriptBacklog = "Pass";
		      	    }

		      	    if (totalMark < 300) {
		      	        formattedScriptBacklog = "Fail"; // If total marks < 300, student fails automatically
		      	    }

		      	    // **Compare with UI**
		      	    if (formattedScriptBacklog.equals(uiBacklog)) {
		      	        System.out.println("Backlog comparison PASS: Script - " + formattedScriptBacklog + " | UI - " + uiBacklog);
		      	        testCaseScenario.log(Status.PASS, "Backlog comparison PASS: Script - " + formattedScriptBacklog + " | UI - " + uiBacklog);
		      	    } else {
		      	        System.out.println("Backlog comparison FAILED: Script - " + formattedScriptBacklog + " | UI - " + uiBacklog);
		      	        testCaseScenario.log(Status.FAIL, "Backlog comparison FAILED: Script - " + formattedScriptBacklog + " | UI - " + uiBacklog);
		      	    }

		      	    // **Final decision**
		      	    if (totalMark >= 300) {
		      	        if (hasBacklog) {
		      	            System.out.println("The student has FAILED with total marks: " + totalMark + " since they have backlogs: " + formattedScriptBacklog);
		      	            testCaseScenario.log(Status.FAIL, "The student has FAILED with total marks: " + totalMark + " since they have backlogs: " + formattedScriptBacklog);
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
