package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class utilisateur {
    private String CIN;
    private String fullname;
    private double salaire;
    private String compte_comment;
    public utilisateur(){}
    public utilisateur(String CIN,String fullname,double salaire){
        this.CIN=CIN;
        this.fullname=fullname;
        this.salaire=salaire;
    }
    //getters and setters
    public String getCIN() {
        return CIN;
    }
    public void setCIN(String CIN) {
        this.CIN = CIN;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public double getSalaire() {
        return salaire;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    public String getCompte_comment() {
        return compte_comment;
    }
    public void setCompte_comment(String compte_comment) {
        this.compte_comment = compte_comment;
    }
    //fucntion:ajouter vehicule
    public boolean ajouter_vehicule(Vehicule vhcl){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="insert into vehicule(N_matricule,marque,type,carburant,compteur_km,date_mise_encirculation) values(?,?,?,?,?,?)";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,vhcl.getN_matricule());
                preparedStatement.setString(2,vhcl.getMarque());
                preparedStatement.setString(3,vhcl.getType());
                preparedStatement.setString(4,vhcl.getCarburant());
                preparedStatement.setString(5,String.valueOf(vhcl.getCompteur_km()));
                preparedStatement.setString(6,vhcl.getDate_mise_encirculation());
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return false;
    }
    //function:chercher un véhicule
    public Vehicule chercher_vehicule(String n_matricule){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from vehicule where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,n_matricule);
                resultSet=preparedStatement.executeQuery();
                if(resultSet.next()) {
                    String nmatricule=resultSet.getString("N_matricule");
                    String marque=resultSet.getString("marque");
                    String type=resultSet.getString("type");
                    String carburant=resultSet.getString("carburant");
                    String cpt=resultSet.getString("compteur_km");
                    String date_mis=resultSet.getString("date_mise_encirculation");
                    Vehicule vehicule=new Vehicule(nmatricule,marque,type,carburant,Double.valueOf(cpt),date_mis);
                    vehicule.setComment(resultSet.getString("commentaire"));
                    vehicule.setN_parking(resultSet.getString("N_parking"));
                    preparedStatement.close();
                    resultSet.close();
                    return vehicule;
                }else return null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return null;
    }
    //function:supprimer un véhicule
   public boolean supprimer_vahicule(String n_matricule){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="delete from vehicule where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,n_matricule);
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return false;
   }
   //function:modifier un véhicule
   public boolean modifier_vehicule(Vehicule vehicule){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="update vehicule set marque=? ,type=? ,carburant=? ,compteur_km=?,N_parking=?,commentaire=? where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,vehicule.getMarque());
                preparedStatement.setString(2,vehicule.getType());
                preparedStatement.setString(3,vehicule.getCarburant());
                preparedStatement.setString(4,String.valueOf(vehicule.getCompteur_km()));
                preparedStatement.setString(5,vehicule.getN_parking());
                preparedStatement.setString(6,vehicule.getComment());
                preparedStatement.setString(7,vehicule.getN_matricule());
                preparedStatement.execute();
                preparedStatement.close();
                return  true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return  false;
   }
   //function:afficher_list_vehicule
   public ObservableList<Vehicule> affciher_list_vehicule(){
        Sqlconnection sqlconnection=new Sqlconnection();
        ObservableList<Vehicule> list= FXCollections.observableArrayList();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from vehicule";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Vehicule vehicule=new Vehicule();
                    vehicule.setN_matricule(resultSet.getString("N_matricule"));
                    vehicule.setMarque(resultSet.getString("marque"));
                    vehicule.setType(resultSet.getString("type"));
                    vehicule.setCarburant(resultSet.getString("carburant"));
                    vehicule.setCompteur_km(Double.valueOf(resultSet.getString("compteur_km")));
                    vehicule.setDate_mise_encirculation(resultSet.getString("date_mise_encirculation"));
                    vehicule.setComment(resultSet.getString("commentaire"));
                    vehicule.setN_parking(resultSet.getString("N_parking"));
                    list.add(vehicule);
                }
                preparedStatement.close();
                resultSet.close();
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return  null;
   }
   //function:afficher_list_parking
   public ObservableList<Parking> affciher_list_parking(){
       Sqlconnection sqlconnection=new Sqlconnection();
       ObservableList<Parking> list= FXCollections.observableArrayList();
       if (sqlconnection.isDBconnected()){
           PreparedStatement preparedStatement=null;
           ResultSet resultSet=null;
           String query="select * from parkings";
           try {
               preparedStatement=sqlconnection.getConnection().prepareStatement(query);
               resultSet=preparedStatement.executeQuery();
               while (resultSet.next()){
                   Parking parking=new Parking();
                   parking.setN_parking(resultSet.getString("NR_parking"));
                   parking.setRue(resultSet.getString("rue"));
                   parking.setArrondissement(resultSet.getString("arrondissement"));
                   parking.setCapacity(Integer.parseInt(resultSet.getString("capacite")));
                   parking.setNbr_place_vides(Integer.parseInt(resultSet.getString("nbr_place_vides")));
                   list.add(parking);
               }
               preparedStatement.close();
               resultSet.close();
               return list;
           } catch (SQLException throwables) {
               throwables.printStackTrace();
               return null;
           }
       }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
       return  null;
   }
   //function:ajouter parking
    public boolean ajouter_parking(Parking parking){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="insert into parkings values(?,?,?,?,?)";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,parking.getN_parking());
                preparedStatement.setString(2,parking.getRue());
                preparedStatement.setString(3,parking.getArrondissement());
                preparedStatement.setString(4,String.valueOf(parking.getCapacity()));
                preparedStatement.setString(5,String.valueOf(parking.getNbr_place_vides()));
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,"Ce parking est déja exist!!");
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return  false;
    }
    //function:chercher parking
    public Parking chercher_parking(String n_parking){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from parkings where NR_parking=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,n_parking);
                resultSet=preparedStatement.executeQuery();
                if(resultSet.next()) {
                    String n_prk=resultSet.getString("NR_parking");
                    String rue=resultSet.getString("rue");
                    String arrond=resultSet.getString("arrondissement");
                    String capacite=resultSet.getString("capacite");
                    String nbr_place_vides=resultSet.getString("nbr_place_vides");
                    Parking parking=new Parking(n_prk,rue,arrond,Integer.parseInt(capacite),Integer.parseInt(nbr_place_vides));
                    preparedStatement.close();
                    resultSet.close();
                    return parking;
                }else return null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return null;
    }
    //function:supprimer parking
    public boolean supprimer_parking(String n_parking){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="delete from parkings where NR_parking=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,n_parking);
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return false;
    }
    //function: modifier parking
    public boolean modifier_parking(Parking parking){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="update parkings set rue=?,arrondissement=?, capacite=?,nbr_place_vides=? where NR_parking=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,parking.getRue());
                preparedStatement.setString(2,parking.getArrondissement());
                preparedStatement.setString(3,String.valueOf(parking.getCapacity()));
                preparedStatement.setString(4,String.valueOf(parking.getNbr_place_vides()));
                preparedStatement.setString(5,parking.getN_parking());
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return false;
    }
    //function:faire_sortir_véhicule
    public boolean faire_sortir_véhicule(Vehicule vehicule){
        if (vehicule.getComment().equals("Non_réservé/Deposé")) vehicule.setComment("Non_réservé/Sorti");
        else if (vehicule.getComment().equals("Réservé/Deposé")) vehicule.setComment("Réservé/Sorti");
        else if (vehicule.getComment().equals("Réservé")) vehicule.setComment("Réservé/Sorti");
        else if (vehicule.getComment().equals("Non_réservé")) vehicule.setComment("Non_réservé/Sorti");
        boolean test=modifier_vehicule(vehicule);
        Parking parking=chercher_parking(vehicule.getN_parking());
        parking.setNbr_place_vides(parking.getNbr_place_vides()+1);
        boolean verify=modifier_parking(parking);
        if (test && verify) return true;
        return false;
    }
    //function:deposer_vehicule
    public boolean deposer_vehicule(Vehicule vehicule,Parking parking){
        boolean test=modifier_vehicule(vehicule);
        boolean verify=modifier_parking(parking);
        if (test && verify) return true;
        return  false;
    }
    //function:restituer vehicule
    public boolean restituer_vehicule(Vehicule vehicule){
        if (vehicule.getComment().equals("Non_réservé/Sorti")) vehicule.setComment("Non_réservé/Deposé");
        else if (vehicule.getComment().equals("Réservé/Sorti")) vehicule.setComment("Réservé/Deposé");
        else {
            JOptionPane.showMessageDialog(null,"Ce véhicule est déja exist!!");
            return false;
        }
        boolean test=modifier_vehicule(vehicule);
        Parking parking=chercher_parking(vehicule.getN_parking());
        if (parking.getNbr_place_vides()>0) parking.setNbr_place_vides(parking.getNbr_place_vides()-1);
        else {
            JOptionPane.showMessageDialog(null,"Ce parking est rempli!!");
            return false;
        }
        boolean verify=modifier_parking(parking);
        return verify;
    }//function:afficher la list de véhicule par parking
    public ObservableList<Vehicule> afficher_list_vehicule_parking(String n_parking){
        Sqlconnection sqlconnection=new Sqlconnection();
        ObservableList<Vehicule> list= FXCollections.observableArrayList();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from vehicule where N_parking=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,n_parking);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Vehicule vehicule=new Vehicule();
                    vehicule.setN_matricule(resultSet.getString("N_matricule"));
                    vehicule.setMarque(resultSet.getString("marque"));
                    vehicule.setType(resultSet.getString("type"));
                    vehicule.setCarburant(resultSet.getString("carburant"));
                    vehicule.setCompteur_km(Double.valueOf(resultSet.getString("compteur_km")));
                    vehicule.setDate_mise_encirculation(resultSet.getString("date_mise_encirculation"));
                    vehicule.setComment(resultSet.getString("commentaire"));
                    list.add(vehicule);
                }
                preparedStatement.close();
                resultSet.close();
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return  null;
    }
    //function:ajouter reservation
    public boolean ajouter_reservation(Reservation reservation){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="insert into reservation(N_matricule,CIN,Date_depart,Date_retour,Date_reservation) values(?,?,?,?,?)";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,reservation.getMatricule());
                preparedStatement.setString(2,reservation.getCin());
                preparedStatement.setString(3,reservation.getDate_depart());
                preparedStatement.setString(4,reservation.getDate_retour());
                preparedStatement.setString(5,reservation.getDate_reservation());
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,"Ce véhicule est déja réservé!!");
                //throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donneé n'est pas effectuée!!!");
        return  false;
    }
    //function:chercher reservation
    public Reservation chercher_reservation(String nmatricule){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from reservation where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,nmatricule);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Reservation reservation=new Reservation();
                    reservation.setMatricule(resultSet.getString("N_matricule"));
                    reservation.setCin(resultSet.getString("CIN"));
                    reservation.setDate_depart(resultSet.getString("Date_depart"));
                    reservation.setDate_retour(resultSet.getString("Date_retour"));
                    reservation.setCommentaire(resultSet.getString("commentaire"));
                    reservation.setDate_reservation(resultSet.getString("Date_reservation"));
                    preparedStatement.close();
                    resultSet.close();
                    return reservation;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectuée!!");
        return null;
    }
    //function:supprimer reservation

    //function:modififer une reservation
    public boolean modifier_reservation(Reservation reservation){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="update reservation set CIN=?,Date_depart=?,Date_retour=?,commentaire=? where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,reservation.getCin());
                preparedStatement.setString(2,reservation.getDate_depart());
                preparedStatement.setString(3,reservation.getDate_retour());
                preparedStatement.setString(4,reservation.getCommentaire());
                preparedStatement.setString(5,reservation.getMatricule());
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return false;
    }
    //function:supprimer une réservation
    public boolean supprimer_reservation(String nmatricule){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="delete from reservation where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,nmatricule);
                preparedStatement.execute();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return false;
    }
    //function afficher la liste des reservation
    public ObservableList<Reservation> afficher_list_reservation(){
        Sqlconnection sqlconnection=new Sqlconnection();
        ObservableList<Reservation> list= FXCollections.observableArrayList();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from reservation";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Reservation reservation=new Reservation();
                    reservation.setMatricule(resultSet.getString("N_matricule"));
                    reservation.setCin(resultSet.getString("CIN"));
                    reservation.setDate_depart(resultSet.getString("Date_depart"));
                    reservation.setDate_retour(resultSet.getString("Date_retour"));
                    reservation.setCommentaire(resultSet.getString("commentaire"));
                    reservation.setDate_reservation(resultSet.getString("Date_reservation"));
                    list.add(reservation);
                }
                preparedStatement.close();
                resultSet.close();
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return  null;
    }
    //function:afficher la list des reservation non validé
    public ObservableList<Reservation> afficher_list_reservation_NV(){
        Sqlconnection sqlconnection=new Sqlconnection();
        ObservableList<Reservation> list= FXCollections.observableArrayList();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from reservation where commentaire=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,"Réservation_non_validée");
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Reservation reservation=new Reservation();
                    reservation.setMatricule(resultSet.getString("N_matricule"));
                    reservation.setCin(resultSet.getString("CIN"));
                    reservation.setDate_depart(resultSet.getString("Date_depart"));
                    reservation.setDate_retour(resultSet.getString("Date_retour"));
                    reservation.setCommentaire(resultSet.getString("commentaire"));
                    reservation.setDate_reservation(resultSet.getString("Date_reservation"));
                    list.add(reservation);
                }
                preparedStatement.close();
                resultSet.close();
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return  null;
    }
    //function:afficher la liste des reservation validé
    public ObservableList<Reservation> afficher_list_reservation_V(){
        Sqlconnection sqlconnection=new Sqlconnection();
        ObservableList<Reservation> list= FXCollections.observableArrayList();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from reservation where commentaire=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,"Réservation_validée");
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Reservation reservation=new Reservation();
                    reservation.setMatricule(resultSet.getString("N_matricule"));
                    reservation.setCin(resultSet.getString("CIN"));
                    reservation.setDate_depart(resultSet.getString("Date_depart"));
                    reservation.setDate_retour(resultSet.getString("Date_retour"));
                    reservation.setCommentaire(resultSet.getString("commentaire"));
                    reservation.setDate_reservation(resultSet.getString("Date_reservation"));
                    list.add(reservation);
                }
                preparedStatement.close();
                resultSet.close();
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return  null;
    }
    //function:afficher la list des reservation annulées
    public ObservableList<Reservation> afficher_list_reservation_A(){
        Sqlconnection sqlconnection=new Sqlconnection();
        ObservableList<Reservation> list= FXCollections.observableArrayList();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from reservation where commentaire=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,"Réservation_annulée");
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Reservation reservation=new Reservation();
                    reservation.setMatricule(resultSet.getString("N_matricule"));
                    reservation.setCin(resultSet.getString("CIN"));
                    reservation.setDate_depart(resultSet.getString("Date_depart"));
                    reservation.setDate_retour(resultSet.getString("Date_retour"));
                    reservation.setCommentaire(resultSet.getString("commentaire"));
                    reservation.setDate_reservation(resultSet.getString("Date_reservation"));
                    list.add(reservation);
                }
                preparedStatement.close();
                resultSet.close();
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return  null;
    }
    //function: "ajouter une fatcure "
    public boolean ajouter_facture(Facture facture){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="insert into facture(N_matricule,CIN,Montant,Date_facture,commentaire) values(?,?,?,?,?)";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,facture.getN_matricule());
                preparedStatement.setString(2,facture.getCin());
                preparedStatement.setString(3,String.valueOf(facture.getM_paye()));
                preparedStatement.setString(4,facture.getDate_facture());
                preparedStatement.setString(5,facture.getComment());
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,"Cette facture est déja exist!!");
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return false;
    }
    //function "chercher une facture"
    public Facture chercher_facture(String n_matricule){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from facture where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,n_matricule);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Facture facture=new Facture();
                    facture.setN_matricule(resultSet.getString("N_matricule"));
                    facture.setCin(resultSet.getString("CIN"));
                    facture.setM_paye(Double.valueOf(resultSet.getString("Montant")));
                    facture.setDate_facture(resultSet.getString("Date_facture"));
                    facture.setComment(resultSet.getString("commentaire"));
                    preparedStatement.close();
                    resultSet.close();
                    return facture;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return null;
    }
    //function "supprimer une facture"
    public boolean supprimer_facture(String n_matricule){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="delete from facture where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,n_matricule);
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return  false;
    }
    //function:modifier une facture
    public boolean modifier_facture(Facture facture){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="update facture set CIN=?,Montant=?,Date_facture=?,commentaire=? where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,facture.getCin());
                preparedStatement.setString(2,String.valueOf(facture.getM_paye()));
                preparedStatement.setString(3,facture.getDate_facture());
                preparedStatement.setString(4,facture.getComment());
                preparedStatement.setString(5,facture.getN_matricule());
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return false;
    }
    //function:afficher la list des facture
    public ObservableList<Facture> afficher_list_facture(){
        Sqlconnection sqlconnection=new Sqlconnection();
        ObservableList<Facture> list= FXCollections.observableArrayList();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from facture";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Facture facture=new Facture();
                    facture.setN_matricule(resultSet.getString("N_matricule"));
                    facture.setCin(resultSet.getString("CIN"));
                    facture.setM_paye(Double.valueOf(resultSet.getString("Montant")));
                    facture.setDate_facture(resultSet.getString("Date_facture"));
                    facture.setComment(resultSet.getString("commentaire"));
                    list.add(facture);
                }
                preparedStatement.close();
                resultSet.close();
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectué!!");
        return  null;
    }
    //function:ajouter une contrat
    public boolean ajouter_contrat(Contrat contrat){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="insert into contrat(N_matricule,CIN,Date_contrat,Date_echeance) values(?,?,?,?)";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,contrat.getN_contrat());
                preparedStatement.setString(2,contrat.getCin());
                preparedStatement.setString(3,contrat.getDate_contrat());
                preparedStatement.setString(4,contrat.getDate_echeance());
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,"Cette contrat déja exist!!");
                //throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return  false;
    }
    //function:chercher une contrat
    public Contrat chercher_contrat(String n_contrat){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from contrat where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,n_contrat);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Contrat contrat=new Contrat();
                    contrat.setN_contrat(resultSet.getString("N_matricule"));
                    contrat.setCin(resultSet.getString("CIN"));
                    contrat.setDate_contrat(resultSet.getString("Date_contrat"));
                    contrat.setDate_echeance(resultSet.getString("Date_echeance"));
                    preparedStatement.close();
                    resultSet.close();
                    return contrat;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return null;
    }
    //function:"modifier contrat"
    public boolean modifier_contrat(Contrat contrat){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="update contrat set CIN=?,Date_contrat=?,Date_echeance=? where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,contrat.getCin());
                preparedStatement.setString(2,contrat.getDate_contrat());
                preparedStatement.setString(3,contrat.getDate_echeance());
                preparedStatement.setString(4,contrat.getN_contrat());
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné rn'est pas effectué!!");
        return false;
    }
    //function:"supprimer réservation"
    public boolean supprimer_contrat(String nmatricule){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="delete from contrat where N_matricule=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,nmatricule);
                preparedStatement.execute();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return false;
    }
    //function:"afficher la liste des contrats"
    public ObservableList<Contrat> afficher_list_contrat(){
        Sqlconnection sqlconnection=new Sqlconnection();
        ObservableList<Contrat> list=FXCollections.observableArrayList();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from contrat";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Contrat contrat=new Contrat();
                    contrat.setN_contrat(resultSet.getString("N_matricule"));
                    contrat.setDate_contrat(resultSet.getString("Date_contrat"));
                    contrat.setDate_echeance(resultSet.getString("Date_echeance"));
                    contrat.setCin(resultSet.getString("CIN"));
                    list.add(contrat);
                }
                preparedStatement.close();
                resultSet.close();
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return null;
    }
    //function:ajouter un client
    public boolean ajouter_client(Client client){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="insert into client(CIN,nom_prenom,adresse,GSM,image_permis) values(?,?,?,?,?)";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,client.getCin());
                preparedStatement.setString(2,client.getNom_prenom());
                preparedStatement.setString(3,client.getAdresse());
                preparedStatement.setString(4,String.valueOf(client.getGsm()));
                preparedStatement.setString(5,client.getImage());
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,"Ce client est déja exist!!");
                //throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return false;
    }
    //function:chercher client
    public Client chercher_client(String cin){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from client where CIN=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,cin);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Client client=new Client();
                    client.setCin(resultSet.getString("CIN"));
                    client.setNom_prenom(resultSet.getString("nom_prenom"));
                    client.setAdresse(resultSet.getString("adresse"));
                    client.setGsm(Integer.parseInt(resultSet.getString("GSM")));
                    client.setImage(resultSet.getString("image_permis"));
                    preparedStatement.close();
                    resultSet.close();
                    return  client;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return null;
    }
    //function modifier client
    public boolean modifier_client(Client client){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="update client set CIN=?,adresse=?,GSM=?,image_permis=? where nom_prenom=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,client.getCin());
                preparedStatement.setString(2,client.getAdresse());
                preparedStatement.setString(3,String.valueOf(client.getGsm()));
                preparedStatement.setString(4,client.getImage());
                preparedStatement.setString(5,client.getNom_prenom());
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effecruée!!");
        return false;
    }
    //function supprimer un client
    public boolean supprimer_client(String cin){
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="delete from client where CIN=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,cin);
                preparedStatement.execute();
                preparedStatement.close();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectué!!");
        return false;
    }
    //function afficher la liste des clients
    public ObservableList<Client> afficher_liste_client(){
        Sqlconnection sqlconnection=new Sqlconnection();
        ObservableList<Client> list=FXCollections.observableArrayList();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from client";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Client client=new Client();
                    client.setCin(resultSet.getString("CIN"));
                    client.setNom_prenom(resultSet.getString("nom_prenom"));
                    client.setAdresse(resultSet.getString("adresse"));
                    client.setGsm(Integer.parseInt(resultSet.getString("GSM")));
                    list.add(client);
                }
                preparedStatement.close();
                resultSet.close();
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectuée!!");
        return null;
    }
    public ObservableList<Reservation> reservations_corrs_clt(String cin){
        ObservableList<Reservation> list=FXCollections.observableArrayList();
        Sqlconnection sqlconnection=new Sqlconnection();
        if (sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from reservation where CIN=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,cin);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    Reservation reservation=new Reservation();
                    reservation.setMatricule(resultSet.getString("N_matricule"));
                    reservation.setCin(resultSet.getString("CIN"));
                    reservation.setDate_depart(resultSet.getString("Date_depart"));
                    reservation.setDate_retour(resultSet.getString("Date_retour"));
                    reservation.setCommentaire(resultSet.getString("commentaire"));
                    reservation.setDate_reservation(resultSet.getString("Date_reservation"));
                    list.add(reservation);
                }
                preparedStatement.close();
                resultSet.close();
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectuée!!");
        return null;
    }
}
