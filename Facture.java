package sample;

public class Facture {
    private String n_matricule;
    private  String cin;
    private double m_paye;
    private String date_facture;
    private String comment;
    //constructor
    public Facture(String n_matricule,String cin,double m_paye,String date_facture,String comment) throws NumberFormatException{
        this.n_matricule=n_matricule;
        this.cin=cin;
        this.m_paye=m_paye;
        this.date_facture=date_facture;
        this.comment=comment;
    }
    public Facture(){}
    //getters and setters
    public String getN_matricule() {
        return n_matricule;
    }
    public void setN_matricule(String n_matricule) {
        this.n_matricule = n_matricule;
    }
    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public double getM_paye() {
        return m_paye;
    }
    public void setM_paye(double m_paye) {
        this.m_paye = m_paye;
    }
    public String getDate_facture() {
        return date_facture;
    }
    public void setDate_facture(String date_facture) {
        this.date_facture = date_facture;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
