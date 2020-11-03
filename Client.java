package sample;

public class Client {
    private String cin;
    private String nom_prenom;
    private String adresse;
    private int gsm;
    private String image;
    //constructors
    public Client(String cin,String nom_prenom,String adresse,int gsm,String image){
        this.cin=cin;
        this.nom_prenom=nom_prenom;
        this.adresse=adresse;
        this.gsm=gsm;
        this.image=image;
    }
    public Client(){ }
    //getters & setters
    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public String getNom_prenom() {
        return nom_prenom;
    }
    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public int getGsm() {
        return gsm;
    }
    public void setGsm(int gsm) {
        this.gsm = gsm;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
