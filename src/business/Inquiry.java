package business;


import java.util.Date;

public class Inquiry {
    
    public Date inquiryDate;
    public String inquiryDescription;
    public boolean citizenAgreed;

    public Inquiry(Date inquiryDate, String inquiryDescription, boolean citizenAgreed) {
        this.inquiryDate = inquiryDate;
        this.inquiryDescription = inquiryDescription;
        this.citizenAgreed = citizenAgreed;
    }
    
    
    
}
