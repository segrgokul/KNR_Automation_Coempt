package pageObjMod;

import org.testng.annotations.DataProvider;

public class StudentDetails {
	

    private long regno;
    private String examDate;
    private String awardName;
    private String semester;
    private long regulation;
    private String examType;
    private String paper1;
    private String paper2;
    private String paper3;
    private String theoryExam;
    private long praticalExam;

    
    
    
    public StudentDetails(long regno, String examDate, String awardName, String semester, long regulation, String examType, String paper1, String paper2, String paper3, String theoryExam, long practicalExam) {
    		
    	
    	this.regno = regno;
        this.examDate = examDate;
        this.awardName = awardName;
        this.semester = semester;
        this.regulation = regulation;
        this.examType = examType;
        this.paper1 = paper1;
        this.paper2 = paper2;
        this.paper3 = paper3;
        this.theoryExam = theoryExam;
        this.praticalExam = practicalExam;
    }

    public long getRegno() { 
    	return regno; 
    	}
    public String getExamDate() {
    	return examDate; 
    	}
    public String getAwardName() { 
    	return awardName; 
    	}
    public String getSemester() {
    	return semester; 
    	}
    public long getRegulation() {
    	return regulation; 
    	}
    public String getExamType() {
    	return examType; 
    	}
    public String getPaper1() { 
    	return paper1; 
    	}
    public String getPaper2() { 
    	return paper2; 
    	}
    public String getPaper3() { 
    	return paper3; 
    	}
    public String getTheoryExam() { 
    	return theoryExam; 
    	}
    public long getPraticalExam() { 
    	return praticalExam; 
    	}
    
}
