package pageModules;

import java.io.IOException;

import base.BasicFunctions;
import pageObjMod.pom;

public class MasterPage extends BasicFunctions {

	DashboardPage dashBoard = new DashboardPage();
	public void MasterNavigation() throws IOException {
		
		try {
			
		
		implicitWait( 30);
		explicitWait( pom.getInstanceCourseXP().loginTags, 30);

		if (pom.getInstanceCourseXP().loginTags.isDisplayed()) {

			implicitWait( 30);
			explicitWait( pom.getInstanceCourseXP().loginTags, 30);

		//	scroll( pom.getInstanceMasterXP().masterBtn);

			implicitWait( 30);
			explicitWait( pom.getInstanceMasterXP().masterBtn, 30);
			click(pom.getInstanceMasterXP().masterBtn);
	//		
		}	
		}
		catch(Exception e){
			e.printStackTrace();
			capture(driver);
		}

	   
		}
		
	public static void CollegeMasterNavigation() {
		
		try {
			
			
		implicitWait( 30);
		explicitWait( pom.getInstanceMasterXP().CollegeMasterOption, 30);

		if (pom.getInstanceMasterXP().CollegeMasterOption.isDisplayed()) {

			implicitWait( 30);
			explicitWait( pom.getInstanceMasterXP().CollegeMasterOption, 30);

			

			implicitWait( 30);
			explicitWait( pom.getInstanceMasterXP().CollegeMasterOption, 30);
			click(pom.getInstanceMasterXP().CollegeMasterOption);
			System.out.println("College Master Page is navigating sucessfully");
			
		}	
		}
		catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	

	public static void CollegeMasterEntriesPerPage() {
		DashboardPage.EntriesPerPage();
}
	
	public static void  CollegeMasterColumn() {

		DashboardPage.DashBoardColumn();
	}
	public  void CollegeMasterSearch() {
		
	
	
		dashBoard.DashBoardSearch();
		
	}
	
	public  void CollegeMasterPageNavigation() throws InterruptedException {
		dashBoard.PageNavigation(); 
		
	}
	
	
	public void CourseMasterNavigation() {
		try {
			
			
			implicitWait( 30);
			explicitWait( pom.getInstanceMasterXP().CourseMasterOption, 30);

			if (pom.getInstanceMasterXP().CourseMasterOption.isDisplayed()) {

				implicitWait( 30);
				explicitWait( pom.getInstanceMasterXP().CourseMasterOption, 30);

				

				implicitWait( 30);
				explicitWait( pom.getInstanceMasterXP().CourseMasterOption, 30);
				click(pom.getInstanceMasterXP().CourseMasterOption);
				System.out.println("Course master Page is navigating sucessfully");
				
			}	
			}
			catch(Exception e){
				e.printStackTrace();
			}	
	}
	
	
	public static void CourseMasterEntriesPerPage() {

		DashboardPage.EntriesPerPage();
}
	
	public static void  CourseMasterColumn() {

		DashboardPage.DashBoardColumn();
	}
	public  void CourseMasterSearch() {
	
		dashBoard.DashBoardSearch();
		
	}
	
	public  void CourseMasterPageNavigation() throws InterruptedException {
		dashBoard.PageNavigation(); 
		
	}
	

}
