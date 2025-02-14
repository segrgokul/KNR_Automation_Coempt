package webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPageXpaths {

	
	  @FindBy(xpath = "//span[@class='nk-menu-text' and text()='Master']")
	    public WebElement masterBtn;
	    
	  @FindBy(xpath = "//span[@class='nk-menu-text' and text()='College Master']")
	    public WebElement CollegeMasterOption;
	  
	  @FindBy(xpath = "//span[@class='nk-menu-text' and text()='Course Master']")
	    public WebElement CourseMasterOption;
	       
	    
	  

	    public MasterPageXpaths(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }
	        
	    
	    }
	

