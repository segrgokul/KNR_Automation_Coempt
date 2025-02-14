package pageModules;

import org.openqa.selenium.interactions.Actions;

import base.BasicFunctions;
import pageObjMod.pom;

public class AttendanceTheoryPage  extends BasicFunctions {

	public void AttendanceMarkNavigation() {
		

		
		implicitWait( 30);
		explicitWait(pom.getInstanceEnrollXP().loginTags, 30);

		if (pom.getInstanceEnrollXP().loginTags.isDisplayed()) {

			implicitWait( 30);
			explicitWait( pom.getInstanceEnrollXP().loginTags, 30);

			scroll( pom.getInstanceTheroryXP().attendanceMark);

			implicitWait( 30);
			explicitWait( pom.getInstanceTheroryXP().attendanceMark, 30);
			click(  pom.getInstanceTheroryXP().attendanceMark);
		}
	}
	
	
	public void TheroryAttendanceNavigation() {
		
		implicitWait( 30);
		explicitWait(pom.getInstanceTheroryXP().attendanceMark, 30);

		if (pom.getInstanceTheroryXP().attendanceMark.isDisplayed()) {

			implicitWait( 30);
			explicitWait( pom.getInstanceTheroryXP().theoryAttendanceOption, 30);

			scroll(pom.getInstanceTheroryXP().theoryAttendanceOption);

			implicitWait( 30);
			explicitWait(pom.getInstanceTheroryXP().theoryAttendanceOption, 30);
			click(pom.getInstanceTheroryXP().theoryAttendanceOption);
		}
}

	public void TheroryAttendanceBrowse() {
		Actions action = new Actions(driver);
		implicitWait( 30);
	//	explicitWait(pom.getInstanceTheroryXP().uplodadFiles, 30);

	//	if (pom.getInstanceTheroryXP().uplodadFiles.get(0).isDisplayed()) {

			implicitWait( 30);
	//		explicitWait( pom.getInstanceTheroryXP().uplodadFiles, 30);

	//		jsScroll(pom.getInstanceTheroryXP().uplodadFiles);

			implicitWait( 30);
	//		explicitWait(pom.getInstanceTheroryXP().uplodadFiles, 30);
			
	action.moveToElement(pom.getInstanceTheroryXP().uplodadFiles).click().perform();
				
		}

	}
