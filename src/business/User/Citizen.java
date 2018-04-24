package business.User;




public class Citizen extends User implements ICitizen{
    
    private String name;
    private int CPR;
    private String citizenAdress;

    public Citizen(String name, int CPR, String citizenAdress) {
        this.name = name;
        this.CPR = CPR;
        this.citizenAdress = citizenAdress;
    }
    
    
    
}
