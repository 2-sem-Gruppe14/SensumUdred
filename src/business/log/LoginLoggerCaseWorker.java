package business.log;


import java.util.Date;

public class LoginLoggerCaseWorker {
    
    public int userID;
    public int time;
    public Date date;
    public int caseLastEdited;

    public LoginLoggerCaseWorker(int userID, int time, Date date, int caseLastEdited) {
        this.userID = userID;
        this.time = time;
        this.date = date;
        this.caseLastEdited = caseLastEdited;
    }
    
    
    
}
