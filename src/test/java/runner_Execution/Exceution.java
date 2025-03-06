package runner_Execution;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import browsers.BrowserManager;
import dataProcessing.ReadPdfData;
import dataProcessing.ReadPdfDataFiles;
import pageModules.AttendanceTheoryPage;
import pageModules.DashboardPage;
import pageModules.LoginPage;
import pageModules.MasterPage;
import pageModules.ReportCoursePage;
import pageModules.ReportEnrollmentPage;
import pageModules.ReportEnrollmentPageForGrade;
import pageModules.ReprortEnrollmentPageForAddtionalParameter;
import pageModules.ResultTRDataPage;
import pageModules.Scte_Vt;
import pageModules.SettingsAssingCoursePage;

public class Exceution extends BrowserManager {

public Object[][] data1;
public Object[][] data2;

//Declare a static flag outside for the stop print the same word in report again and again

private static boolean isTestCaseCourseSet = false;
private static boolean isTestCaseEnrollSet1 = false;
	// private ExtentReports extent;
	

	 ExtentReports extentReport ;
	 ExtentSparkReporter report ;
	 ExtentTest testCaseName;

	 ReadPdfDataFiles ReadPdf = new ReadPdfDataFiles();
	 
	 
	LoginPage login = new LoginPage();
	DashboardPage Dashboard = new DashboardPage();
	MasterPage Master = new MasterPage();
	ReportEnrollmentPage Enrollment = new  ReportEnrollmentPage();
	ReportEnrollmentPageForGrade EnrollmentPageForGrade = new ReportEnrollmentPageForGrade();
	ReprortEnrollmentPageForAddtionalParameter EnrollmentPageForAdditionalParameter = new ReprortEnrollmentPageForAddtionalParameter();
	ReportCoursePage Coursewise = new  ReportCoursePage();
	SettingsAssingCoursePage SetAssignCourse = new SettingsAssingCoursePage();
	ResultTRDataPage TRData = new ResultTRDataPage();
	AttendanceTheoryPage Therory = new AttendanceTheoryPage();
	ReadPdfData PDF = new ReadPdfData();
	Scte_Vt ScteVt = new Scte_Vt();
	@DataProvider(name ="excel")
	public Object[][]ReadExcelEnroll() throws IOException,InvalidFormatException {
		
//		Object[][] data = dataProcessing.ReadExcelFiles.readExcel("file1","file1");
	
		data1 = dataProcessing.ReadExcelFiles.readExcel("excel.file1", "excel.file1");

		
		
//	System.out.println("Data size: " + data.length);
for (Object[] row : data1) {
//    System.out.println(Arrays.toString(row));
}
return data1;
	} 
	
	
	@DataProvider(name ="course")
	public Object[][]ReadExcelCourse() throws IOException,InvalidFormatException {
		
//		Object[][] data = dataProcessing.ReadExcelFiles.readExcel("file1","file1");
	
	

		data2= dataProcessing.ReadExcelFiles.readExcel("excel.file2", "excel.file2");
		
//	System.out.println("Data size: " + data.length);
for (Object[] row : data2) {
//    System.out.println(Arrays.toString(row));
}
return data2;	
	}	
	
	@Test(priority = 1, enabled = true,dataProvider = "excel")	
	public void testCase11(Object regno, Object subjectName,Object finalMark) throws InterruptedException, IOException {

		 if (testCaseName == null) {
			 testCaseName = extentReport.createTest("Sevt Actions");
				
		    }
		 
		
		System.out.println("This is a Normal Test Case1");
		
	   

	  
	    // Perform LoginPage Actions
		ScteVt.DirectSignIn(regno, subjectName,finalMark,testCaseName);
		    
	}

	
//General login and logout
@Test(priority = 1, enabled = false)
public void testCase1() throws InterruptedException, IOException {
	testCaseName = extentReport.createTest("Login Page Actions");
	
	System.out.println("This is a Normal Test Case1");

   

  
    // Perform LoginPage Actions
	    login.DirectSignIn();
	    login.DirectPassEntry();
	    login.DirectUserEntry();

 	    // Validate Login Failures and Success
	    login.LoginInFail();
	   	login.Login();

//	    SetAssignCourse.check();
	    // Perform Logout and Re-login
	
//	    
//	    Therory.AttendanceMarkNavigation();
//	    Therory.TheroryAttendanceNavigation();
//	    Therory.TheroryAttendanceBrowse();
//	    TRData.ResultDeliverablesNavigation();
//	    TRData.ResultDeliverablesTRDataClgWiseNavigation();

	}	
	


//General login and logout
@Test(priority = 2, enabled = false)
public void testCase2() throws InterruptedException, IOException {
	
	testCaseName = extentReport.createTest("DashBoard Page Actions");
 System.out.println("This is a Normal Test Case1");

 ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
 ExtentReports extent = new ExtentReports();
 extent.attachReporter(sparkReporter);
 

 ExtentTest test = extent.createTest("Sample Test", "This is a test description");
 test.pass("Test passed successfully");
 
  // Perform DashBoardPage Actions

	    login.Login();
//	    Dashboard.EntriesPerPage();
//	    Dashboard.DashBoardColumn();
//	    Dashboard.DashBoardSearch();
//	    Dashboard.PageNavigation(); 
//	    Master.MasterNavigation();
//	    Master.CollegeMasterNavigation();
//	    Master.CollegeMasterEntriesPerPage();
//	    Master.CollegeMasterColumn();
//	    Master.CollegeMasterSearch();
//	    Master.CollegeMasterPageNavigation();
	    Master.MasterNavigation();
	    Master.CourseMasterNavigation();
	    Master.CourseMasterEntriesPerPage();
	    Master.CourseMasterColumn();
	    Master.CourseMasterSearch();
	    Master.CollegeMasterPageNavigation();

	    test.pass("Test passed successfully done");
	}	
	



//for navigating to the report card to avoid the loop for the dataproviders
@Test(priority = 3, enabled = false)
public void testCase3() throws InterruptedException, IOException {
   System.out.println("This is a Normal Test Case2");
 
	
	 if (testCaseName == null) {
	        testCaseName = extentReport.createTest("Report card course-wise page");
	    }
    // Navigate to Course Report Card

    Coursewise.ReportCardNavigation(testCaseName);
   
   
}
	

@Test(priority = 4, enabled = false, dataProvider = "course")
public void testCase4(Object clgCode,Object examdate, Object awardName,Object regulation,Object semester , Object examType,Object programcourse) throws IOException, InterruptedException, InvalidFormatException {
	
	
	  // Set the test case name only once
	 
    
	   
    if(!isTestCaseCourseSet) {
    testCaseName = extentReport.createTest("Report Card Course wise Page Actions");
    
    isTestCaseCourseSet = true;   // Mark it as set
    	
    } 
	
    System.out.println("Starting testCase4 execution for the following clg code: " + clgCode);
	

    Coursewise.ReportCardCourseNavigation(testCaseName);

    // Handle College Code
    Coursewise.handleCollegeCode(clgCode,testCaseName);

    // Process other details dynamically

	Coursewise.handleOtherParameters(examdate, awardName,regulation,semester,examType,testCaseName);
  
	Coursewise.handleProgramCourse(programcourse,testCaseName);
	
	Enrollment.submitButton(testCaseName);
	
//	Enrollment.downloadPdfReportValidation(testCaseName);
	
	
	System.out.println("Reached end of testCase4 execution for the following clg code: " + clgCode);
//	PDF.validatePDF(null);
}
	
	
	
// if the excel has no paper 1 and paper 2 columns	
@Test(priority = 5, enabled = false, dataProvider = "excel")
public void testCase6(Object Regno, Object examdate, Object awardName, Object semester, 
                      Object regulation, Object examType, Object paper1, 
                      Object paper2, Object paper3, Object theroryExam, 
                      Object praticalExam, Object examTotal,String subjectToFind) 
                      throws InterruptedException, IOException {
    // Set the test case name only once
 
    
   

	 if(!isTestCaseEnrollSet1) { testCaseName =
	  extentReport.createTest("Report Card Enrollment Page Actions");
	  
	  isTestCaseEnrollSet1 = true; // Mark it as set
	  
	  


	  }
	 
	
//	testCaseName = extentReport.createTest("Enrollment Page Actions");
	System.out.println("=========================");
	
	System.out.println("This is a Normal Test Case5");
    System.out.println("Starting testCase5 execution for the reg: " + Regno +" for the Subject: " + subjectToFind);
    System.out.println("=========================");
 
    
	  // Navigate to the Enrollment Page
	  Enrollment.ReportCardEnrollNavigation(testCaseName);
	  
	  
	  //For validation the final rocess score and scoe files
	 /*  Enrollment.checkValidationResult(Regno, examdate, awardName, semester, 
	            regulation, examType,  paper1, 
	             paper2,  paper3,  theroryExam, 
	            praticalExam, examTotal,subjectToFind,testCaseName); */
	           
	             
	
	
	  Enrollment.EnrollmentRegNo(Regno,testCaseName);
	  Enrollment.EnrollmentExamDate(examdate,testCaseName);
	  Enrollment.EnrollmentAwardName(awardName,testCaseName);
	  Enrollment.EnrollmentSemester(semester,testCaseName);
	  Enrollment.EnrollmentRegulation(regulation,testCaseName);
	  Enrollment.EnrollmentExamType(examType,testCaseName);
	 Enrollment.submitButton(testCaseName);
	  Enrollment.downloadPdfReportValidation(testCaseName,Regno,
	  paper1,paper2,paper3,praticalExam,theroryExam,examTotal,subjectToFind);
	 


//Need to Create the separte methos in one class for the below ones exam,awardName,etcc

    // Handle other details like exam date, award name, semester, etc.
 //   Enrollment.processOtherDetails(examdate, awardName, semester, regulation, examType);

    // Validate paper results and scores
 //  Enrollment.validatePaperResults(Regno, paper1, paper2, paper3, praticalExam, theroryExam, examTotal);

	System.out.println("=====================");
    System.out.println("Reached end of testCase5 execution for: " + Regno +" and subject: "+ subjectToFind );
    // **Stop execution if any cell is null or empty**
    if (Regno == null || Regno.toString().trim().isEmpty()) {
        System.out.println("Execution stopped: Found a null or empty cell in Excel.");
        System.exit(0); // **Stops the program immediately**
    }
}


//For bsc nuring sem one and other grade type patterns
@Test(priority = 6, enabled = false, dataProvider = "excel")
public void testCaseGrade(Object Regno, Object examdate, Object awardName, Object semester, 
                      Object regulation, Object examType, Object paper1, 
                      Object paper2, Object paper3, Object theroryExam, 
                      Object praticalExam, Object examTotal,String subjectToFind,Object gradeSecured,Object gradeLetter,Object gradePoint) 
                      throws InterruptedException, IOException {
    // Set the test case name only once
 
    
   

	 if(!isTestCaseEnrollSet1) { testCaseName =
	  extentReport.createTest("Report Card Enrollment Page Actions");
	  
	  isTestCaseEnrollSet1 = true; // Mark it as set
	  
	  


	  }
	 
	
//	testCaseName = extentReport.createTest("Enrollment Page Actions");
	System.out.println("=========================");
	
	System.out.println("This is a Normal Test Case5");
    System.out.println("Starting testCase5 execution for the reg: " + Regno +" for the Subject: " + subjectToFind);
    System.out.println("=========================");
 
    
	  // Navigate to the Enrollment Page
    EnrollmentPageForGrade.ReportCardEnrollNavigation(testCaseName);
	  
	  
	  //For validation the final rocess score and scoe files
	 /*  Enrollment.checkValidationResult(Regno, examdate, awardName, semester, 
	            regulation, examType,  paper1, 
	             paper2,  paper3,  theroryExam, 
	            praticalExam, examTotal,subjectToFind,testCaseName); */
	           
	             
	
	
    EnrollmentPageForGrade.EnrollmentRegNo(Regno,testCaseName);
    EnrollmentPageForGrade.EnrollmentExamDate(examdate,testCaseName);
    EnrollmentPageForGrade.EnrollmentAwardName(awardName,testCaseName);
    EnrollmentPageForGrade.EnrollmentSemester(semester,testCaseName);
    EnrollmentPageForGrade.EnrollmentRegulation(regulation,testCaseName);
    EnrollmentPageForGrade.EnrollmentExamType(examType,testCaseName);
    EnrollmentPageForGrade.submitButton(testCaseName);
    EnrollmentPageForGrade.downloadPdfReportValidation(testCaseName,Regno,
	  paper1,paper2,paper3,praticalExam,theroryExam,examTotal,subjectToFind,gradeSecured,gradeLetter,gradePoint);
	 


//Need to Create the separte methos in one class for the below ones exam,awardName,etcc

    // Handle other details like exam date, award name, semester, etc.
 //   Enrollment.processOtherDetails(examdate, awardName, semester, regulation, examType);

    // Validate paper results and scores
 //  Enrollment.validatePaperResults(Regno, paper1, paper2, paper3, praticalExam, theroryExam, examTotal);

	System.out.println("=====================");
    System.out.println("Reached end of testCase5 execution for: " + Regno +" and subject: "+ subjectToFind );
    // **Stop execution if any cell is null or empty**
    if (Regno == null || Regno.toString().trim().isEmpty()) {
        System.out.println("Execution stopped: Found a null or empty cell in Excel.");
        System.exit(0); // **Stops the program immediately**
    }
}

@Test(priority = 7, enabled = false, dataProvider = "excel")
public void testCasePaperMark(Object Regno, Object examdate, Object awardName, Object semester, 
                      Object regulation, Object examType, Object paper1, 
                      Object paper2, Object paper3, Object theroryExam, 
                      Object praticalExam, Object examTotal,String subjectToFind,Object theoryInt,Object theoryTh,Object praticalInt,Object praticalPractical, Object praticalViva) 
                      throws InterruptedException, IOException {
    // Set the test case name only once
 
    
   

	 if(!isTestCaseEnrollSet1) { testCaseName =
	  extentReport.createTest("Report Card Enrollment Page Actions");
	  
	  isTestCaseEnrollSet1 = true; // Mark it as set
	  
	  


	  }
	 
	
//	testCaseName = extentReport.createTest("Enrollment Page Actions");
	System.out.println("=========================");
	
	System.out.println("This is a Normal Test Case5");
    System.out.println("Starting testCase5 execution for the reg: " + Regno +" for the Subject: " + subjectToFind);
    System.out.println("=========================");
 
    
	  // Navigate to the Enrollment Page
    EnrollmentPageForAdditionalParameter.ReportCardEnrollNavigation(testCaseName);
	  
	  
	  //For validation the final rocess score and scoe files
	 /*  Enrollment.checkValidationResult(Regno, examdate, awardName, semester, 
	            regulation, examType,  paper1, 
	             paper2,  paper3,  theroryExam, 
	            praticalExam, examTotal,subjectToFind,testCaseName); */
	           
	             
	
	
    EnrollmentPageForAdditionalParameter.EnrollmentRegNo(Regno,testCaseName);
    EnrollmentPageForAdditionalParameter.EnrollmentExamDate(examdate,testCaseName);
    EnrollmentPageForAdditionalParameter.EnrollmentAwardName(awardName,testCaseName);
    EnrollmentPageForAdditionalParameter.EnrollmentSemester(semester,testCaseName);
    EnrollmentPageForAdditionalParameter.EnrollmentRegulation(regulation,testCaseName);
    EnrollmentPageForAdditionalParameter.EnrollmentExamType(examType,testCaseName);
    EnrollmentPageForAdditionalParameter.submitButton(testCaseName);
    EnrollmentPageForAdditionalParameter.downloadPdfReportValidation(testCaseName,Regno,
	  paper1,paper2,paper3,praticalExam,theroryExam,examTotal,subjectToFind,theoryInt,theoryTh,praticalInt,praticalPractical,praticalViva);
	 


//Need to Create the separte methos in one class for the below ones exam,awardName,etcc

    // Handle other details like exam date, award name, semester, etc.
 //   Enrollment.processOtherDetails(examdate, awardName, semester, regulation, examType);

    // Validate paper results and scores
 //  Enrollment.validatePaperResults(Regno, paper1, paper2, paper3, praticalExam, theroryExam, examTotal);

	System.out.println("=====================");
    System.out.println("Reached end of testCase5 execution for: " + Regno +" and subject: "+ subjectToFind );
    // **Stop execution if any cell is null or empty**
    if (Regno == null || Regno.toString().trim().isEmpty()) {
        System.out.println("Execution stopped: Found a null or empty cell in Excel.");
        System.exit(0); // **Stops the program immediately**
    }
}


//readpdf write excel
@Test(priority = 8, enabled = false)

public void testReadPdfDataWriteExcel() {

	        try {
	        	
	        	
	            System.out.println("Starting PDF Data Read Test...");
	       //     ReadPdfData.readPdfData();
	           
			/*
			 * if(!isTestCaseEnrollSet1) { testCaseName =
			 * extentReport.createTest("Read PDF write Excel");
			 * 
			 * isTestCaseEnrollSet1 = true; // Mark it as set
			 * 
			 * }
			 */
	            
	            
	            
	            
	            System.out.println("=====================");
	            
	            ReadPdf.readPdfData(testCaseName);
	            
	            
	            System.out.println("PDF Data Read Test Completed.");
	        } catch (IOException e) {
	            System.err.println("Error during PDF Data Read Test: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	


@Test(priority = 4, enabled = false, dataProvider = "excelComparison", dataProviderClass = dataProcessing.ExcelComparator.class)

public void compareExcelData(String regno, String subjectCode, String theoryMark) {
   
	 if (testCaseName == null) {
         testCaseName = extentReport.createTest("Excel Data Comparision");
     }
	// Creating a sub-node in the Extent Report
    ExtentTest testCaseScenario = testCaseName.createNode("Final Process Score and Scrore File Comparison for Regno: " + regno + " Subject Code: " + subjectCode + " -> "  + theoryMark);

    
    
    // Print to Console
    System.out.println("rowName: " + regno);
    System.out.println("columnName: " + subjectCode);
    System.out.println("Theory Mark " + theoryMark);
    System.out.println("Regno: " + regno + ", Subject Code: " + subjectCode + " -> " + theoryMark);

    try {
    	
    	
    if (regno.contains("Match")){
    	
    
    	 testCaseScenario.log(Status.PASS, "Regno: " + regno);
    }
    
    else if (regno.contains("Mismatch")) {
   	 testCaseScenario.log(Status.FAIL, "Regno: " + regno);    	
    }
    else {
    	testCaseScenario.log(Status.WARNING,"Regno: " + regno + ", Subject Code: " + subjectCode + " -> Unexpected Theory Mark " + theoryMark);
    }
    }
    catch(Exception e) {
    	testCaseScenario.log(Status.WARNING,e.getMessage());
    }
    
    
    
    try {
    	
    	
        if (subjectCode.contains("Match")){
        	
        
        	 testCaseScenario.log(Status.PASS, "Subject Code: " + subjectCode);
        }
        
        else if (subjectCode.contains("Mismatch")) {
       	 testCaseScenario.log(Status.FAIL, "Subject Code: " + subjectCode);    	
        }
        else {
        	testCaseScenario.log(Status.WARNING,"Regno: " + regno + ", Subject Code: " + subjectCode + " -> Unexpected Theory Mark " + theoryMark);
        }
        }
        catch(Exception e) {
        	testCaseScenario.log(Status.WARNING,e.getMessage());
        }
    
    
 try {
    	
    	
        if (theoryMark.contains("Match")){
        	
        
        	 testCaseScenario.log(Status.PASS, "Comparison Passed: " + theoryMark);
        }
        
        else if (theoryMark.contains("Mismatch")) {
       	 testCaseScenario.log(Status.FAIL, "Comparison Passed: " + theoryMark);    	
        }
        else {
        	testCaseScenario.log(Status.WARNING,"Regno: " + regno + ", Subject Code: " + subjectCode + " -> Unexpected Theory Mark " + theoryMark);
        }
        }
        catch(Exception e) {
        	testCaseScenario.log(Status.WARNING,e.getMessage());
        }
    
 
    
    
    
    
    
    
}


	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		System.out.println("This will execute foruth before every Method and after the before class");
//		ReadExcelData.ExcelReader(C:\\Users\\User\\Downloads\\DumpScore.xlsx,"mds");
	//	ReadExcelData.getColumnData()
		
	
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This will execute after every Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("This will execute third before the Class and after the befortest");
		  // Set up ExtentReports
     
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This will execute after the Class");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("This will execute second before the Test and after the before test suite");
	  // Check if the driver is not already initialized
			
		
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("This will execute after the Test");
		
			  // Ensure the browser is closed after the test
		
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This will execute first before the Test Suite");
//		report = new 

	extentReport =new ExtentReports(); 
	
	
	 report = new ExtentSparkReporter("D:\\Coempt_Automation\\coempt_automation\\src\\test\\resources\\reports\\ExtendReport1.html");
	

	 

	 report.config().setTheme(Theme.STANDARD); // Set theme to DARK or STANDARD
	 report.config().setDocumentTitle("Test Automation Report");
	 report.config().setReportName("Automation Test Results");
	 extentReport.attachReporter(report);
	 Browser_Launch();
	  
	  	
	}

	@AfterSuite
	public void afterSuite() throws IOException, URISyntaxException {
		System.out.println("This will execute after the Test Suite");
		extentReport.flush();
		
		try {
		String path = "D:/Coempt_Automation/coempt_automation/src/test/resources/reports/ExtendReport.html";
		
		  // Open the report in default browser
       Desktop.getDesktop().browse(new URI("file:///D:/Coempt_Automation/coempt_automation/src/test/resources/reports/ExtendReport1.html")); 

        //Use File to Create URI
		
		File file = new File(path);
        
		Desktop.getDesktop().browse(file.toURI());
        
		
		
	//	driver.quit();
	}
		catch(Exception e) {
			e.printStackTrace();
			
			driver.quit();	
			
		}
}}
