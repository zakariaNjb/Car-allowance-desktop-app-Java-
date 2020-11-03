package sample;
public class Vehicule {
    private String n_matricule;
    private String marque;
    private String type;
    private String carburant;
    private double compteur_km;
    private String date_mise_encirculation;
    private String comment;
    private String n_parking;
    private String r_d_f;

    //constructors
    public Vehicule(String n_matricule,String marque,String type,String carburant,double compteur_km,String date_mise_encirculation){
        this.n_matricule=n_matricule;
        this.marque=marque;
        this.type=type;
        this.carburant=carburant;
        this.compteur_km=compteur_km;
        this.date_mise_encirculation=date_mise_encirculation;
    }
    public Vehicule(){}
    //functions:getters and setters
    public String getN_matricule() {
        return n_matricule;
    }
    public void setN_matricule(String n_matricule) {
        this.n_matricule = n_matricule;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCarburant() {
        return carburant;
    }
    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }
    public double getCompteur_km() {
        return compteur_km;
    }
    public void setCompteur_km(double compteur_km) {
        this.compteur_km = compteur_km;
    }
    public String getDate_mise_encirculation() {
        return date_mise_encirculation;
    }
    public void setDate_mise_encirculation(String date_mise_encirculation) {
        this.date_mise_encirculation = date_mise_encirculation;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getN_parking() {
        return n_parking;
    }
    public void setN_parking(String n_parking) {
        this.n_parking = n_parking;
    }
    public String getR_d_f() {
        return r_d_f;
    }
    public void setR_d_f(String r_d_f) {
        this.r_d_f = r_d_f;
    }
}
