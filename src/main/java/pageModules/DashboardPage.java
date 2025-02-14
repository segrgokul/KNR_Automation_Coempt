package pageModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasicFunctions;
import pageObjMod.pom;

public class DashboardPage extends BasicFunctions {
String  clgCode ="767";
String  clgName ="Indian College of Nursing";
String  clgCourseNo ="7";

	
	public static void DashBoardNavigation() {
		
		implicitWait(30);	
		fluentWait(pom.getInstanceAssignCourseXP().loginTags,30);		

	if (pom.getInstanceDashboardXP().dashboardOption.isDisplayed()) {
		
		implicitWait(30);	
   		explicitWait(pom.getInstanceDashboardXP().dashboardOption,30);
		
   		scroll(pom.getInstanceDashboardXP().dashboardOption);
	
	}
	
		implicitWait(30);	
   		explicitWait(pom.getInstanceDashboardXP().dashboardOption,30);
   		click(pom.getInstanceDashboardXP().dashboardOption);
   		
	}

	
	public static  void EntriesPerPage(){
		
   		
   		if(pom.getInstanceDashboardXP().entriesDropDown.isDisplayed()) {
   			
   			for (int i=0 ; i< pom.getInstanceDashboardXP().entriesDropDownOption.size();i++) {
				implicitWait(30);	
				fluentWait(pom.getInstanceDashboardXP().entriesDropDown,30);
			
				click(pom.getInstanceDashboardXP().entriesDropDown);
   				implicitWait(30);	
   				fluentWait(pom.getInstanceDashboardXP().entriesDropDownOption.get(i),30);
   				
   				String entriesDropDownText =pom.getInstanceDashboardXP().entriesDropDownOption.get(i).getText();
   				
   				click(pom.getInstanceDashboardXP().entriesDropDownOption.get(i));
   				implicitWait(30);	
   				fluentWait(pom.getInstanceDashboardXP().entriesDropDownOption.get(i),30);
   			   int entriesDropDownCount = pom.getInstanceDashboardXP().codeNos.size();
   			
   			 

				boolean allElementCodeDisplayed= true;
				try{
				   for(WebElement CodeNos : pom.getInstanceDashboardXP().codeNos){
					
					
   
					   if(!CodeNos.isDisplayed()){
						allElementCodeDisplayed= false;
					}


					}
				}
				
				catch(Exception e){
					e.printStackTrace();
				}

				finally {
				if (allElementCodeDisplayed){
					System.out.println("Showing 1 to " + entriesDropDownCount +" for the " + entriesDropDownText +" entries per page list");
				

				}}



   			}
   		
		
	}
	
	}
	
	public static void DashBoardColumn(){
		
		if(pom.getInstanceDashboardXP().entriesDropDown.isDisplayed()||pom.getInstanceDashboardXP().entriesDropDownOption.get(0).isDisplayed()) {
   			
   			for (WebElement RowBtn : pom.getInstanceDashboardXP().dashboardBtns) {
   				
   				implicitWait(30);	
   				fluentWait(RowBtn,30);
   				click(RowBtn);
   				
   				
   				implicitWait(30);	
   				fluentWait(RowBtn,30);
   				click(RowBtn);
   				
   				implicitWait(30);	
   				fluentWait(RowBtn,30);
   				click(RowBtn);
   				
   				
  // 				List<WebElement> columnTitle = driver.findElements(By.xpath("//span[@class='dt-column-title']"));
   				
   				int DashBoardCount = pom.getInstanceDashboardXP().dashboardBtns.size();
   				
   				System.out.println(DashBoardCount);
   				
 //  				for(int i=0; i<pom.getInstanceDashboardXP().dashboardBtns.size();i++) {
   				
   				//need to check the ColumnTitles texts
   				System.out.println(RowBtn.getText() +" is Able to click and able to change the "+ RowBtn.getText() +" order ");
   		//		}
   			}
   			
   		
		
		
	}

	}
	
		public  void DashBoardSearch(){
		try {
			
		
   			
   		click(pom.getInstanceDashboardXP().dashboardSearch);
   		implicitWait(30);	
   		
   		sendKeys(pom.getInstanceDashboardXP().dashboardSearch,clgCode);		
   		implicitWait(30);	
   		
   	 WebElement	clgSearchedCode = driver.findElement(By.xpath("	//td[text()='" + clgCode + "']"));
 
   	 
     		System.out.println(clgSearchedCode.getText());
   		
   		if(clgSearchedCode.getText().equals(clgCode)) {
   			
   			System.out.println("Clg code number search " + clgCode + " number matches the result");
   			implicitWait(30);	
   			
   			clear(pom.getInstanceDashboardXP().dashboardSearch);
   			implicitWait(30);	
	  		fluentWait(pom.getInstanceDashboardXP().dashboardOption,30);
			
  		driver.navigate().refresh();
		}}
   		
   		catch(Exception e){
   			e.printStackTrace();
   		}
		
		try {
		
   		implicitWait(30);	
   		fluentWait(pom.getInstanceDashboardXP().dashboardSearch,30);
   		click(pom.getInstanceDashboardXP().dashboardSearch);
   		implicitWait(30);	
  		fluentWait(pom.getInstanceDashboardXP().dashboardSearch,30);
   		sendKeys(pom.getInstanceDashboardXP().dashboardSearch,clgName);		
   		implicitWait(30);	
		
		
		
	   	WebElement clgSearchedName = driver.findElement(By.xpath("	//td[text()='" + clgName + "']"));
	   	 
  		System.out.println(clgSearchedName.getText());
		
		if(clgSearchedName.getText().equals(clgName)) {
			
			System.out.println("Clg Name search " + clgName + " name matches the result");
			implicitWait(30);	
			
			clear(pom.getInstanceDashboardXP().dashboardSearch);
			implicitWait(30);	
	  		fluentWait(pom.getInstanceDashboardXP().dashboardOption,30);
			
	  		driver.navigate().refresh();
		}}
		
		catch(Exception e) {
			e.printStackTrace();


}
		
		try {
			
	   		implicitWait(30);	
	   		fluentWait(pom.getInstanceDashboardXP().dashboardSearch,30);
	   		click(pom.getInstanceDashboardXP().dashboardSearch);
	   		implicitWait(30);	
	  		fluentWait(pom.getInstanceDashboardXP().dashboardSearch,30);
	   		sendKeys(pom.getInstanceDashboardXP().dashboardSearch,clgCourseNo);		
	   		implicitWait(30);	
			
	      	 List<WebElement>	clgSearchedCode = driver.findElements(By.xpath("	//td[@class='row-index text-center small']"));
	      	 
	         

	 		boolean allElementCourseCodeDisplayed= true;
	 		try{
	 		   for(WebElement CourseNos : clgSearchedCode){
	 			
	 			

	 			   if(!CourseNos.isDisplayed()){
	 				   allElementCourseCodeDisplayed= false;
	 			}


	 			}
	 		}
	 		
	 		catch(Exception e){
	 			e.printStackTrace();
	 		}

	 		finally {
	 		if (allElementCourseCodeDisplayed){
	 			System.out.println("All the course based on the clg course number "+ clgCourseNo +" is displaying");
	 		
	 			implicitWait(30);	
		  		fluentWait(pom.getInstanceDashboardXP().dashboardOption,30);
				
		  		driver.navigate().refresh();
	 		}}
	   		
	   		
		}
		
		catch(Exception e) {
		e.printStackTrace();
		
		}
		}
		
		
		public void PageNavigation() throws InterruptedException{
			
		try {
			implicitWait(30);	
	   		fluentWait(pom.getInstanceDashboardXP().dashboardSearch,30);
	   	
	   		Thread.sleep(15000);
	   		scrollTillEnd(driver);
	   	
	   		Thread.sleep(15000);
	   		scrollTillEnd(driver);
	   	
			
			implicitWait(100);	
			scroll(pom.getInstanceDashboardXP().termsAndConditions);

		for (int i=0;i<=2;i++) {
				
				implicitWait(30);	
    		fluentWait(pom.getInstanceDashboardXP().nextPageNavigation,30);
	   		click(pom.getInstanceDashboardXP().nextPageNavigation);
	   		
	
			}
   		System.out.println("Navigating to the next page sucessfully");
		implicitWait(30);	
   		fluentWait(pom.getInstanceDashboardXP().lastPageNavigation,30);
		click(pom.getInstanceDashboardXP().lastPageNavigation);
		
		System.out.println("Navigating to the last page sucessfully");
		
		implicitWait(30);	
		for (int i=2;i>=0;i--) {
			
			implicitWait(30);	
		fluentWait(pom.getInstanceDashboardXP().previousPageNavigation,30);
   		click(pom.getInstanceDashboardXP().previousPageNavigation);
   		
   	
		}
		System.out.println("Navigating to the previous page sucessfully");
		
		implicitWait(30);	
   		fluentWait(pom.getInstanceDashboardXP().firstPageNavigation,30);
		click(pom.getInstanceDashboardXP().firstPageNavigation);
		
		System.out.println("Navigating to the first page sucessfully");
		scrollToTop(driver);
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		





		}
}