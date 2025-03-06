package webElement;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Scte_VtXpaths {
public static WebDriver driver;




@FindBy(xpath = "(//a[@class='btn btn-sm btn-primary'])[2]")
public WebElement fivethSemResult;

@FindBy(xpath = "//input[@id='rollno']")
public WebElement rollNoTB;


@FindBy(xpath = "//input[@id='dob']")
public WebElement dobTB;

@FindBy(xpath = "(//tr/th[@class='prev'])[3]")
public WebElement dobPrev;


@FindBy(xpath = "//tr/td[@colspan='7']/span[@class='year' and text()='1990']")
public WebElement dobPrevYear;

@FindBy(xpath = "//tr/td[@colspan='7']/span[@class='month' and text()='Jan']")
public WebElement dobPrevMonth;

@FindBy(xpath = "//tr/td[@class='day' and text()='15']")
public WebElement dobPrevDate;


@FindBy(id = "btnViewStudentReselts")
  public WebElement btnViewStudentResults;  







public Scte_VtXpaths(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this); // Initialize elements
}}
