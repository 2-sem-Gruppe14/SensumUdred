package business.caseOpening;



public class CaseOpening implements IcaseOpening{
    public String declarationOfConsent;
    public boolean consentRecieved;
    public boolean citizenAcceptance;
    public boolean citizenWithdrawn;
    public int caseProgress;
    public int caseBenefit;
    public int caseOffer;

    public CaseOpening(String declarationOfConsent, boolean consentRecieved, boolean citizenAcceptance, boolean citizenWithdrawn, int caseProgress, int caseBenefit, int caseOffer) {
        this.declarationOfConsent = declarationOfConsent;
        this.consentRecieved = consentRecieved;
        this.citizenAcceptance = citizenAcceptance;
        this.citizenWithdrawn = citizenWithdrawn;
        this.caseProgress = caseProgress;
        this.caseBenefit = caseBenefit;
        this.caseOffer = caseOffer;
    }

    
    
}
