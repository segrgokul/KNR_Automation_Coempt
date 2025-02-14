package pageModules;

import base.BasicFunctions;
import pageObjMod.pom;

public class ResultTRDataPage extends BasicFunctions {

	public void ResultDeliverablesNavigation() {
		

		
		implicitWait( 30);
		explicitWait(pom.getInstanceEnrollXP().loginTags, 30);

		if (pom.getInstanceEnrollXP().loginTags.isDisplayed()) {

			implicitWait( 30);
			explicitWait( pom.getInstanceEnrollXP().loginTags, 30);

			scroll( pom.getInstanceTRDataXP().resultDeliverables);

			implicitWait( 30);
			explicitWait( pom.getInstanceTRDataXP().resultDeliverables, 30);
			click( pom.getInstanceTRDataXP().resultDeliverables);
		}
	}
	
	
	public void ResultDeliverablesTRDataClgWiseNavigation() {
		implicitWait( 30);
		explicitWait(pom.getInstanceTRDataXP().trDataClgWise, 30);

		if (pom.getInstanceTRDataXP().trDataClgWise.isDisplayed()) {

			implicitWait( 30);
			explicitWait( pom.getInstanceTRDataXP().trDataClgWise, 30);

			scroll( pom.getInstanceTRDataXP().trDataClgWise);

			implicitWait( 30);
			explicitWait( pom.getInstanceTRDataXP().trDataClgWise, 30);
			click( pom.getInstanceTRDataXP().trDataClgWise);
		}
}
}