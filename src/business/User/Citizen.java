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

    @Override
    public void getPersonalCase(int CitizenID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getID() {
      return this.CPR; }
    
    
    
}
