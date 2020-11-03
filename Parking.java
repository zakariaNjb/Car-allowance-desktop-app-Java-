package sample;

public class Parking {
    private String n_parking;
    private String rue;
    private String arrondissement;
    private int capacity;
    private int nbr_place_vides;
    private int nbr_vehicule_p;

    public Parking(String n_parking,String rue,String arrondissement,int capacity,int nbr_place_vides){
        this.n_parking=n_parking;
        this.rue=rue;
        this.arrondissement=arrondissement;
        this.capacity=capacity;
        this.nbr_place_vides=nbr_place_vides;
    }
    public Parking(){}
    public String getN_parking() {
        return n_parking;
    }
    public void setN_parking(String n_parking) {
        this.n_parking = n_parking;
    }
    public String getRue() {
        return rue;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }
    public String getArrondissement() {
        return arrondissement;
    }
    public void setArrondissement(String arrondissement) {
        this.arrondissement = arrondissement;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getNbr_place_vides() {
        return nbr_place_vides;
    }
    public void setNbr_place_vides(int nbr_place_vides) {
        this.nbr_place_vides = nbr_place_vides;
    }
    public int getNbr_vehicule_p() {
        return nbr_vehicule_p;
    }
    public void setNbr_vehicule_p(int nbr_vehicule_p) {
        this.nbr_vehicule_p = nbr_vehicule_p;
    }


}
