package pageObjMod;

	import org.openqa.selenium.WebDriver;

import browsers.BrowserManager;
import webElement.AttendanceTheroryXpaths;
import webElement.DashboardPageXpaths;
import webElement.LoginPageXPaths;
import webElement.MasterPageXpaths;
import webElement.ReportCoursePageXpaths;
import webElement.ReportEnrollmentPageXpaths;
import webElement.ResultTRDataXpaths;
import webElement.Scte_VtXpaths;
import webElement.SettingsAssignCoursePageXpaths;


	public class pom  extends BrowserManager{

				private static pom instance; // Singleton instance
				public static LoginPageXPaths loginXP ;
				private static ReportCoursePageXpaths CourseXP;
				private static ReportEnrollmentPageXpaths EnrollmentXP;
				private static ResultTRDataXpaths TRDataXP;
				private static SettingsAssignCoursePageXpaths AssignCourseXP;
				private static AttendanceTheroryXpaths TheroryXP;
				private static DashboardPageXpaths DashboardXP;
				private static MasterPageXpaths MasterXP;
				private static Scte_VtXpaths Scte_VtXP;
				
				// Use a different name for the static instance
		
				// Constructor to initialize the WebDriver when the class is instantiated
   public pom(WebDriver driver) {
						// Initialize the driver when the class is instantiated
						this.driver = driver;
		    }

	    // Method to get the instance of LoginPageXPath
	    public static LoginPageXPaths getInstanceLoginXP() {
	        // If the instance is null, create a new instance
	    	if (loginXP == null) {
	        	loginXP = new LoginPageXPaths(driver);
	        	return loginXP;
	        }
	        
	        return loginXP; // Return the instance
	    }
	    
	    public static DashboardPageXpaths getInstanceDashboardXP() {
	        // If the instance is null, create a new instance
	    	if (DashboardXP == null) {
	    		DashboardXP = new DashboardPageXpaths(driver);
	        	return DashboardXP;
	        }
	        
	        return DashboardXP; // Return the instance
	    }
	    
	 
	    public static MasterPageXpaths getInstanceMasterXP() {
	        // If the instance is null, create a new instance
	    	if (MasterXP == null) {
	    		MasterXP = new MasterPageXpaths(driver);
	        	return MasterXP;
	        }
	        
	        return MasterXP; // Return the instance
	    }
	    
	    public static AttendanceTheroryXpaths getInstanceTheroryXP() {
			
			if (TheroryXP == null) {
				TheroryXP = new AttendanceTheroryXpaths(driver);
				return TheroryXP;
			}	
		return TheroryXP;
		}
	    
	    
		public static ReportCoursePageXpaths getInstanceCourseXP() {
		
			if (CourseXP == null) {
				CourseXP = new ReportCoursePageXpaths(driver);
				return CourseXP;
			}	
		return CourseXP;
		}
		public static ReportEnrollmentPageXpaths getInstanceEnrollXP() {
		
					if (EnrollmentXP == null) {
						EnrollmentXP = new ReportEnrollmentPageXpaths(driver);
						return EnrollmentXP;

					}	
			return EnrollmentXP;
		}
	
		public static ResultTRDataXpaths getInstanceTRDataXP() {
			
			if (TRDataXP == null) {
				TRDataXP = new ResultTRDataXpaths(driver);
				return TRDataXP;

			}	
	return TRDataXP;
}
		
		public static SettingsAssignCoursePageXpaths getInstanceAssignCourseXP() {
			
			if (AssignCourseXP == null) {
				AssignCourseXP = new SettingsAssignCoursePageXpaths(driver);
				return AssignCourseXP;

			}	
	return AssignCourseXP;

	
		}	
		
	
	public static Scte_VtXpaths getInstanceScte_VtXpaths() {
			
			if (Scte_VtXP == null) {
				Scte_VtXP = new Scte_VtXpaths(driver);
				return Scte_VtXP;

			}	
	return Scte_VtXP;

	
		}
	
	
	
	
	}
	
