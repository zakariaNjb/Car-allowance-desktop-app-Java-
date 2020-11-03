package sample;

public class Contrat {
    private String N_contrat;
    private String date_contrat;
    private String date_echeance;
    private String cin;
    //constructor
    public Contrat(String n_contrat,String cin,String date_contrat,String date_echeance){
        this.N_contrat=n_contrat;
        this.date_contrat=date_contrat;
        this.date_echeance=date_echeance;
        this.cin=cin;
    }
    public Contrat(){}
    //getters and setters
    public String getN_contrat() {
        return N_contrat;
    }
    public void setN_contrat(String n_contrat) {
        N_contrat = n_contrat;
    }
    public String getDate_contrat() {
        return date_contrat;
    }
    public void setDate_contrat(String date_contrat) {
        this.date_contrat = date_contrat;
    }
    public String getDate_echeance() {
        return date_echeance;
    }
    public void setDate_echeance(String date_echeance) {
        this.date_echeance = date_echeance;
    }
    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
}
