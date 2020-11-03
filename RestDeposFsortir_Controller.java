package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.swing.*;

public class RestDeposFsortir_Controller {
    @FXML javafx.scene.control.TextField N_matricule;
    @FXML javafx.scene.control.TextField N_parking;

    @FXML javafx.scene.control.Button restituer;
    @FXML javafx.scene.control.Button deposer;
    @FXML javafx.scene.control.Button sortir;

    public void sortir_vehicule(ActionEvent event){
        String nmatricule=N_matricule.getText();
        if(!nmatricule.isBlank()){
            utilisateur utls=new utilisateur();
            Vehicule vehicule=utls.chercher_vehicule(nmatricule);
            if(vehicule!=null){
                if(vehicule.getN_parking()==null) JOptionPane.showMessageDialog(null,"Ce véhicule n'appartient a auncun parking:vous douvez lui affecter à un parking!!");
                else{
                    if(vehicule.getComment().equals("Non_réservé/Sorti") || vehicule.getComment().equals("Réservé/sorti")) JOptionPane.showMessageDialog(null,"Ce véhicule déja sorti!!");
                    else {
                        boolean test=utls.faire_sortir_véhicule(vehicule);
                        if (test) JOptionPane.showMessageDialog(null,"Opération effectué!!");
                        else JOptionPane.showMessageDialog(null,"Opération n'est pas effectué!!");
                    }
                }
            }else JOptionPane.showMessageDialog(null,"Ce véhicule n'exist pas!!");
        }else JOptionPane.showMessageDialog(null,"Saisi le Nr matricule de véhicule que vous voulez sortir!!");
    }
    public void deposer_vehicule(ActionEvent event){
        String nmatricule=N_matricule.getText();
        String nparking=N_parking.getText();
        if(!nmatricule.isBlank() && !nparking.isBlank()){
            utilisateur utls=new utilisateur();
            Vehicule vehicule=utls.chercher_vehicule(nmatricule);
            Parking parking=utls.chercher_parking(nparking);
            if(vehicule!=null && parking!=null){
                if ( (vehicule.getComment().equals("Non_réservé/Sorti") || vehicule.getComment().equals("Réservé/sorti"))){
                    if (parking.getNbr_place_vides()>0){
                        vehicule.setN_parking(nparking);
                        if (vehicule.getComment().equals("Non_réservé/Sorti")) vehicule.setComment("Non_réservé/Deposé");
                        if (vehicule.getComment().equals("Réservé/Sorti")) vehicule.setComment("Réservé/Deposé");
                        parking.setNbr_place_vides(parking.getNbr_place_vides()-1);
                        boolean test=utls.deposer_vehicule(vehicule,parking);
                        if (test) JOptionPane.showMessageDialog(null,"Opération effectué!!");
                        else JOptionPane.showMessageDialog(null,"Opération n'est pas effectué!!");
                    }else JOptionPane.showMessageDialog(null,"Ce parking est rempli!!");
                }else JOptionPane.showMessageDialog(null,"Essayer de sortir ce vehicule tout d'abord,Ce véhicule déja exist dans un autre parking!!");
            }else if (vehicule==null) JOptionPane.showMessageDialog(null,"Ce vehicule n'exist pas!!");
            else if (parking==null) JOptionPane.showMessageDialog(null,"Ce parking n'exist pas!!!");
        }else if (nmatricule.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le Nr matricule de véhicule!!");
        else  if(nparking.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le Nr de parking où vous voulez deposer ce véhicule!!");
    }
    public void restituer_vehicule(ActionEvent event){
        String  n_matricule=N_matricule.getText();
        if(!n_matricule.isBlank()){
            utilisateur utls=new utilisateur();
            Vehicule vehicule=utls.chercher_vehicule(n_matricule);
            if (vehicule!=null){
                if (vehicule.getN_parking()!=null){
                    boolean test=utls.restituer_vehicule(vehicule);
                    if (test){
                        JOptionPane.showMessageDialog(null,"Opération effectué!!");
                        JOptionPane.showMessageDialog(null,"N'oubliez pas de supprimer la réservation correspondante à cette véhicule,si elle a été réstituée par un client!!");
                    }else JOptionPane.showMessageDialog(null,"Opération n'est pas effectué!!");
                }else JOptionPane.showMessageDialog(null,"Ce véhicule n'appartient à aucun parking!!");
            }else JOptionPane.showMessageDialog(null,"Ce véhicule n'appartient pas au l'agence!!");
        }else JOptionPane.showMessageDialog(null,"Saisi le Nr de matricule de véhicule!!");
    }
}
