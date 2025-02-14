package pageModules;

import base.BasicFunctions;
import pageObjMod.pom;
import webElement.SettingsAssignCoursePageXpaths;

public class SettingsAssingCoursePage extends BasicFunctions {

	
	
		public void check() {
			
			scroll(pom.getInstanceAssignCourseXP().settingsOption);
			
			implicitWait(30);	
			fluentWait(pom.getInstanceAssignCourseXP().loginTags,30);		
	
		if (pom.getInstanceAssignCourseXP().loginTags.isDisplayed()) {
			
			implicitWait(30);	
	   		explicitWait(pom.getInstanceAssignCourseXP().loginTags,30);
			
	   		scroll(pom.getInstanceAssignCourseXP().settingsOption);
		
		}
		
			implicitWait(30);	
	   		explicitWait(pom.getInstanceAssignCourseXP().settingsOption,30);
	   		click(pom.getInstanceAssignCourseXP().settingsOption);
	   		
	   		
		
	   		implicitWait(30);	
	   		explicitWait(pom.getInstanceAssignCourseXP().assignCourse,30);
			
    		scroll(pom.getInstanceAssignCourseXP().assignCourse);
    		implicitWait(30);	
    		fluentWait(pom.getInstanceAssignCourseXP().assignCourse,30);
	   		click(pom.getInstanceAssignCourseXP().assignCourse);
	   		
	   		if(pom.getInstanceAssignCourseXP().entriesDropDown.isDisplayed()||pom.getInstanceAssignCourseXP().assignCourseBtns.get(0).isDisplayed()) {
	   			
	   			for (int i=0;i<=4;i++) {
	   				
	   				implicitWait(30);	
	   				fluentWait(pom.getInstanceAssignCourseXP().assignCourseBtns.get(i),30);
	   				pom.getInstanceAssignCourseXP().assignCourseBtns.get(i).click();
	   			}
	   			
	   			for (int i=0;i<=3;i++) {
	   				
	   				implicitWait(30);	
		    		fluentWait(pom.getInstanceAssignCourseXP().nextPageNavigation,30);
			   		click(pom.getInstanceAssignCourseXP().nextPageNavigation);
	   			}
	   			
	   			
	   			
	   		}
}}
