package pageModules;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;

import base.BasicFunctions;
import pageObjMod.pom;

public class LoginPage extends BasicFunctions {


    public void DirectSignIn() throws InterruptedException, IOException {
    	
//		ExtentReports report = new ExtentReports("D:\\Coempt_Automation\\coempt_automation\\src\\test\\resources\\reports\\report.html",true);
//
//		ExtentTest test = report.startTest("ReportCardNavigation");	
//		
		
    	
    	try {
    	
			implicitWait(30);	
			explicitWait(pom.getInstanceLoginXP().signinBtn,30);
			click(pom.getInstanceLoginXP().signinBtn);
			
			if (pom.getInstanceLoginXP().invaidUserName.isDisplayed()) {

	//			test.log(LogStatus.PASS, "User is unable to enter with direct signin button ");
				 
			 System.out.println("User is unable to enter with direct signin button");
			 pom.getInstanceLoginXP().alertOkBtn.click();
		
	 }
    	}
    	
    	catch(Exception e){
    		e.printStackTrace();
			capture(driver);
   	}
    		
    	
       	
   	 
    		
    	}

	

	public void DirectPassEntry() throws InterruptedException, IOException {
		

      	 implicitWait(30);
		 explicitWait(pom.getInstanceLoginXP().userpass,30);
       	 click(pom.getInstanceLoginXP().userpass);
       	 implicitWait(30);
       	 
       	 sendKeys(pom.getInstanceLoginXP().userpass,"Coempt@bpu");
			    
       	implicitWait(30);	
   		explicitWait(pom.getInstanceLoginXP().signinBtn,30);
       	click(pom.getInstanceLoginXP().signinBtn);
    	implicitWait(30);	
       	
		if (pom.getInstanceLoginXP().invaidUserName.isDisplayed()) {
			
			System.out.println("User is unable to enter with direct userpass");
			implicitWait(30);	
	   		explicitWait(pom.getInstanceLoginXP().alertOkBtn,30);
			pom.getInstanceLoginXP().alertOkBtn.click();
			implicitWait(30);	
			pom.getInstanceLoginXP().userpass.clear();
			
			
	}}
	
	public void DirectUserEntry() throws InterruptedException, IOException {
		

     	 implicitWait(30);
		
     	 explicitWait(pom.getInstanceLoginXP().userName,30);
      	
     	 click(pom.getInstanceLoginXP().userName);
      	
      	 implicitWait(30);
      	 
      	 sendKeys(pom.getInstanceLoginXP().userName,"admin");
			    
      	implicitWait(30);	
  		explicitWait(pom.getInstanceLoginXP().signinBtn,30);
      	click(pom.getInstanceLoginXP().signinBtn);
      	
		if (pom.getInstanceLoginXP().invaidPassword.isDisplayed()) {
			
			System.out.println("User is unable to enter with direct username");
			implicitWait(30);	
	   		explicitWait(pom.getInstanceLoginXP().alertOkBtn,30);
			pom.getInstanceLoginXP().alertOkBtn.click();
			implicitWait(30);	
			pom.getInstanceLoginXP().userName.clear();
			
			
	}}
	
	public void LoginInFail() throws InterruptedException, IOException {
		

    	 implicitWait(30);
		
    	 explicitWait(pom.getInstanceLoginXP().userName,30);
     	
    	 click(pom.getInstanceLoginXP().userName);
     	
     	 implicitWait(30);
     	 
     	 sendKeys(pom.getInstanceLoginXP().userName,RandomStringUtils.randomAlphanumeric(8));
			    
     	 implicitWait(30);
		 explicitWait(pom.getInstanceLoginXP().userpass,30);
       	 click(pom.getInstanceLoginXP().userpass);
       	 implicitWait(30);
       	 
       	 sendKeys(pom.getInstanceLoginXP().userpass,RandomStringUtils.randomAlphanumeric(8));
			    
       	implicitWait(30);	
   		explicitWait(pom.getInstanceLoginXP().signinBtn,30);
       	click(pom.getInstanceLoginXP().signinBtn);
    	implicitWait(30);	
     	
		if (pom.getInstanceLoginXP().loginFail.isDisplayed()) {
			
			System.out.println("User is unable to enter with direct username");
			implicitWait(30);	
	   		explicitWait(pom.getInstanceLoginXP().alertOkBtn,30);
			pom.getInstanceLoginXP().alertOkBtn.click();
			implicitWait(30);	
			pom.getInstanceLoginXP().userName.clear();
			implicitWait(30);
			pom.getInstanceLoginXP().userpass.clear();
			
	}}
	

	public void Login() throws InterruptedException, IOException {
			

    	 implicitWait(30);
		
    	 explicitWait(pom.getInstanceLoginXP().userName,30);
     	
    	 click(pom.getInstanceLoginXP().userName);
     	
     	 implicitWait(30);
     	 
     	 sendKeys(pom.getInstanceLoginXP().userName,"admin");
			    
     	 implicitWait(30);
		 explicitWait(pom.getInstanceLoginXP().userpass,30);
       	 click(pom.getInstanceLoginXP().userpass);
       	 implicitWait(30);
       	 
       	 sendKeys(pom.getInstanceLoginXP().userpass,"Coempt@bpu");
			    
       	implicitWait(30);	
   		explicitWait(pom.getInstanceLoginXP().signinBtn,30);
       	click(pom.getInstanceLoginXP().signinBtn);
    	implicitWait(30);	
    	explicitWait(pom.getInstanceLoginXP().loginTags,30);
		if (pom.getInstanceLoginXP().loginTags.isDisplayed()) {
			
			System.out.println("The Admin Login Page has login and the landing page of KNRUHS is displayed");
			implicitWait(30);	
			
	   		
	}}
	
	
	
	public void Logout() throws IOException {		
		

		implicitWait(30);	
   		explicitWait(pom.getInstanceLoginXP().loginTags,30);		
		
			if (pom.getInstanceLoginXP().loginTags.isDisplayed()) {
				
				implicitWait(30);	
		   		explicitWait(pom.getInstanceLoginXP().loginTags,30);
				
				click(pom.getInstanceLoginXP().loginTags);
				
				implicitWait(30);	
		   		explicitWait(pom.getInstanceLoginXP().signOutBtn,30);
		   		click(pom.getInstanceLoginXP().signOutBtn);
			
				
				
			}
			}
			
	
//	if (invaidUserName.isDisplayed()) {
//		WebElement alertOkBtn = driver.findElement(By.xpath("//button[@type='button' and text()='OK']"));
//		
//		System.out.println("The Admin Login Page has unable to login with invalid userpass");
//		alertOkBtn.click();
//		
//		WebElement signoutBtn = driver.findElement(By.xpath("//span[contains(text(),'Sign out')]")));
//		signoutBtn.click();
//	
//	
//		
//	}
//	
	
//	
//	public void ReportCardCheck(long regno,String examdate,String awardName,String semester,long regulation,String examType) {		
//		
//
//		implicitWait(30);	
//   		explicitWait(pom.getInstanceLoginXP().loginTags,30);		
//		
//			if (pom.getInstanceLoginXP().loginTags.isDisplayed()) {
//				
//				implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().loginTags,30);
//				
//		   		jsScroll(pom.getInstanceLoginXP().reportCardOption);
//			
//				implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().reportCardOption,30);
//		   		click(pom.getInstanceLoginXP().reportCardOption);
//			
//		   		implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().reportCardEnroll,30);
//				
//	    		jsScroll(pom.getInstanceLoginXP().reportCardEnroll);
//				
//				implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().reportCardEnroll,30);
//		   		click(pom.getInstanceLoginXP().reportCardEnroll);
//		
//		   		implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().enrollNo,30);
//        		click(pom.getInstanceLoginXP().enrollNo);
//		   		
//		   		String str = String.valueOf(regno);
//		   		System.out.println(str); 
//		   		implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().enrollNo,30);
//		   		sendKeys(pom.getInstanceLoginXP().enrollNo, str);
//		   		implicitWait(30);	
//////		   		explicitWait(pom.getInstanceLoginXP().submitBtn,30);
//////		   		click(pom.getInstanceLoginXP().submitBtn);
////		   		
//		   		explicitWait(pom.getInstanceLoginXP().examSeries,30);
//		   		click(pom.getInstanceLoginXP().examSeries);
//		   		
//		   		explicitWait(pom.getInstanceLoginXP().examSeries,30);
//		   		click(pom.getInstanceLoginXP().examSeries);
////		   		
//		   		explicitWait(pom.getInstanceLoginXP().examSeries,30);
//		   		click(pom.getInstanceLoginXP().examSeries);
////		   	
////		if(pom.getInstanceLoginXP().alertOk.isDisplayed()) {
////		   		
////		   		implicitWait(30);	
////		   		explicitWait(pom.getInstanceLoginXP().alertOk,30);
////		   		click(pom.getInstanceLoginXP().alertOk);
////			}
//
//		
//		   		
//		   		implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().examSeries,30);
//    	   		click(pom.getInstanceLoginXP().examSeries);
////		   		implicitWait(30);	
////		   		
////		   	//li[contains(@class,'select2-results__option')
//		   		WebElement examDateOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + examdate + "']"));
//		   		explicitWait(examDateOption,30);
//		   		
//		   		click(examDateOption);
//		    	
////		   		dropDownClick(pom.getInstanceLoginXP().examSeriesOption,examdate);
//		   		
//		   		implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().awardName,30);
//		   		click(pom.getInstanceLoginXP().awardName);
////
////		   	//li[contains(@class,'select2-results__option') and text()!='Select']
////		   	// Construct XPath with the dynamic text
//		    	WebElement awardOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + awardName + "']"));
//		    	click(awardOption);
//
////
//		   		implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().yearSession,30);
//		   		click(pom.getInstanceLoginXP().yearSession);
////		   		
////		   		implicitWait(30);	
////		   		
////		   	//li[contains(@class,'select2-results__option')
//		   		WebElement yearSessionOption  = driver.findElement(By.xpath("//li[@role='option' and text()='" + semester + "']"));
//		    	click(yearSessionOption);		    	
////		    	
//		    	implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().regulation,30);
//		   		click(pom.getInstanceLoginXP().regulation);
//		   		implicitWait(30);	
//		    	
//		   		WebElement regulationOption  = driver.findElement(By.xpath("//li[@role='option' and text()='" + regulation + "']"));
//		    	click(regulationOption);		    	
//		    	
//	    	
//		    	implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().examType,30);
//		   		click(pom.getInstanceLoginXP().examType);
//	    		implicitWait(30);	
//		    	
//		   		WebElement examTypeOption  = driver.findElement(By.xpath("//li[@role='option' and text()='" + examType + "']"));
//		    	click(examTypeOption);	
//		    	
//		    	implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().submitBtn,30);
//		   		click(pom.getInstanceLoginXP().submitBtn);
//	    	
//     	   		String str = String.valueOf(regno);
//		   		System.out.println(str); 
//		   		implicitWait(30);	
//		   		explicitWait(pom.getInstanceLoginXP().enrollNo,30);
//		   		sendKeys(pom.getInstanceLoginXP().enrollNo, str );
//	   		
//}}
	
	
//			
	public void SignIn() throws InterruptedException {	
			//input[@id='username']

//	Actions actions = new Actions(driver);
//	actions.moveToElement(pom.getInstanceLoginXP().userName).click().perform();

//
//		WebElement check= driver.findElement(By.xpath("//label[@class='form-label']"));
//		
//		check.getText();
//		System.out.println(check);
		
	//fluentWait(pom.getInstanceLoginXP().userName);
//	
//	
//	
//
//	
//	
//		Thread.sleep(5000);
//    fluentWait(pom.getInstanceLoginXP().userName);
//	click( pom.getInstanceLoginXP().userName);
//	implicitWait( pom.getInstanceLoginXP().userName, 5);
//	sendKeys(pom.getInstanceLoginXP().userName, "admin");
//	
//	
		

			

//	implicitWait( pom.getInstanceLoginXP().userpass, 10);
	
	}
	
	


	
	



  
}

	


    
    

