package business.User;




public class Citizen extends ser implements ICitizen{
    
    public String name;
    public int CPR;
    public String citizenAdress;

    public Citizen(String name, int CPR, String citizenAdress) {
        this.name = name;
        this.CPR = CPR;
        this.citizenAdress = citizenAdress;
    }
    
    
    
}
