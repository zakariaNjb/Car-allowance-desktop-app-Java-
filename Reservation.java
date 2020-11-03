package sample;

public class Reservation {
    private String matricule;
    private String date_reservation;
    private String date_depart;
    private String date_retour;
    private String cin;
    private String commentaire;
    //constructor
    public Reservation(String matricule,String cin,String date_depart,String date_retour,String date_reservation){
        this.matricule=matricule;
        this.cin=cin;
        this.date_depart=date_depart;
        this.date_retour=date_retour;
        this.date_reservation=date_reservation;
    }
    public Reservation(){}
    //functions:getters and setters
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getDate_reservation() {
        return date_reservation;
    }
    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }
    public String getDate_depart() {
        return date_depart;
    }
    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }
    public String getDate_retour() {
        return date_retour;
    }
    public void setDate_retour(String date_retour) {
        this.date_retour = date_retour;
    }
    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public String getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

}
