package webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttendanceTheroryXpaths {

	public static WebDriver driver;
	

    @FindBy(xpath = "//span[@class='nk-menu-text' and text()='Attendance/Mark Back Capture']")
    public WebElement attendanceMark;

    @FindBy(xpath = "//span[@class='nk-menu-text' and text()='Theory Attendance ']")
    public WebElement theoryAttendanceOption;

    @FindBy(xpath = "//label[@class='form-file-label']")
    public WebElement uplodadFiles;
    
  
	
	
	


    public AttendanceTheroryXpaths(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements
    }}
	

