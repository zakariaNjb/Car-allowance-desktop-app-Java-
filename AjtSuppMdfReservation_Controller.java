package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AjtSuppMdfReservation_Controller {
    /**********************************variables for menu items******************************/
    /**********************************variables for menu items******************************/

    @FXML
    javafx.scene.control.MenuItem Ajt_Utls;//ajouter utilisateur
    @FXML javafx.scene.control.MenuItem Supp_Utls;//supprimer utilisateur
    @FXML javafx.scene.control.MenuItem Sus_Utls;//suspendre utilisateur
    @FXML javafx.scene.control.MenuItem Ajt_Clt;//ajuter client
    @FXML javafx.scene.control.MenuItem Supp_Ctls;//supprimer client
    @FXML javafx.scene.control.MenuItem Modf_Clts;//modifier client
    @FXML javafx.scene.control.MenuItem Afch_listClt;//afficher la list des client
    @FXML javafx.scene.control.MenuItem Rch_clt;//rechercher client
    @FXML javafx.scene.control.MenuItem Ajt_Resv;//ajouter reservation
    @FXML javafx.scene.control.MenuItem Modf_Resv;//modifier reservation
    @FXML javafx.scene.control.MenuItem Supp_Resv;//supprimer reservation
    @FXML javafx.scene.control.MenuItem Afch_listResv_V;//afficher la liste des reservation validee
    @FXML javafx.scene.control.MenuItem Afch_listResv_NV;//afficher la liste des reservation non validee
    @FXML javafx.scene.control.MenuItem Afch_listResv_AN;//afficher la liste des reservation annulee
    @FXML javafx.scene.control.MenuItem Rch_Resv;//rechercher une reservation
    @FXML javafx.scene.control.MenuItem Ajt_Ctra;//ajouter contrat
    @FXML javafx.scene.control.MenuItem Supp_Ctra;//ajouter contrat
    @FXML javafx.scene.control.MenuItem Modf_Ctra;//modifier client
    @FXML javafx.scene.control.MenuItem Rch_ctra;//rechercher contrat
    @FXML javafx.scene.control.MenuItem Afch_listCtra;//afficher la liste des contrat
    @FXML javafx.scene.control.MenuItem Ajt_Factr;//ajouter facture
    @FXML javafx.scene.control.MenuItem Supp_Factr;//supprimer facture
    @FXML javafx.scene.control.MenuItem Modf_Factr;//modifier client
    @FXML javafx.scene.control.MenuItem Afch_listFactr;//afficher la liste des facture
    @FXML javafx.scene.control.MenuItem Rch_Factr;//rechercher facture
    @FXML javafx.scene.control.MenuItem Ajt_Vhcl;//ajouter vehicule
    @FXML javafx.scene.control.MenuItem Supp_Vhcl;//supprimer vehicule
    @FXML javafx.scene.control.MenuItem Modf_Vhcl;//modifier vehicule
    @FXML javafx.scene.control.MenuItem Afch_listVhcl;//afficher la liste des facture
    @FXML javafx.scene.control.MenuItem Rch_Vhcl;//rechercher facture
    @FXML javafx.scene.control.MenuItem Ajt_Prk;//ajouter parking
    @FXML javafx.scene.control.MenuItem Modf_Prk;//modifier vehicule
    @FXML javafx.scene.control.MenuItem Supp_PrK;//supprimer vehicule
    @FXML javafx.scene.control.MenuItem Afch_listVhcl_Prk;//afficher la liste des vehicule par parking
    @FXML javafx.scene.control.MenuItem Afch_listVhcl_Restituer;//afficher la liste des vehicule restituer
    @FXML javafx.scene.control.MenuItem Afch_listVhcl_Deposer;//afficher la liste des vehicule restituer
    @FXML javafx.scene.control.MenuItem FaireSortir_Vhcl;//faire sortir une vhcl
    @FXML javafx.scene.control.MenuItem Rch_Prk;//rechercher facture
    @FXML javafx.scene.control.MenuItem Rgl_Sanction;//regler les sanction
    @FXML javafx.scene.control.MenuItem Afch_list_clt_Sanction;//Afficher la list des client sanctionner
    @FXML javafx.scene.control.MenuItem Afch_list_utilisateurs;//afficher la list des utilisateur
    @FXML javafx.scene.control.MenuItem Dashboard;//afficher la list des utilisateur

    @FXML javafx.scene.control.Button move;/*************move to another page button BUtoon******************/
    @FXML javafx.scene.control.Button ajouter;
    @FXML javafx.scene.control.Button supprimer;
    @FXML javafx.scene.control.Button modifier;
    @FXML javafx.scene.control.Button chercher;
    @FXML javafx.scene.control.Label comfir_label;/************comfirmation label**************************/

    @FXML javafx.scene.control.TextField n_matricule;
    @FXML javafx.scene.control.TextField cin;
    @FXML javafx.scene.control.DatePicker date_depart;
    @FXML javafx.scene.control.DatePicker date_retour;
    @FXML javafx.scene.control.TextField comment;
    @FXML javafx.scene.control.TextField date_reserv;

    //function called inside "move" function to open a new window
    public void show_window(String fxml_file){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxml_file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage=new Stage();
        primaryStage.setTitle("vehicle allowance");
        primaryStage.setScene(new Scene(root, 890, 364));
        primaryStage.setResizable(false);
        primaryStage.show();
    }//function to display the new window
    public void move(ActionEvent event){
        if(comfir_label.getText().equals(Ajt_Utls.getText())) {
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_susp_utilisateur.fxml");
        }
        if(comfir_label.getText().equals(Supp_Utls.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_susp_utilisateur.fxml");
        }
        if(comfir_label.getText().equals(Sus_Utls.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_susp_utilisateur.fxml");
        }
        if(comfir_label.getText().equals(Afch_list_utilisateurs.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("afficher_list_utilisateurs.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Dashboard.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Menu.fxml");
        }
        if(comfir_label.getText().equals(Ajt_Vhcl.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_vehicule.fxml");
        }
        if (comfir_label.getText().equals(Modf_Vhcl.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_vehicule.fxml");
        }
        if (comfir_label.getText().equals(Supp_Vhcl.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_vehicule.fxml");
        }
        if (comfir_label.getText().equals(Rch_Vhcl.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_vehicule.fxml");
        }
        if(comfir_label.getText().equals(Afch_listVhcl.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("affciher_list_vehicule.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 1089, 409));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Ajt_Prk.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_parking.fxml");
        }
        if (comfir_label.getText().equals(Modf_Prk.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_parking.fxml");
        }
        if (comfir_label.getText().equals(Supp_PrK.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_parking.fxml");
        }
        if (comfir_label.getText().equals(Rch_Prk.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_parking.fxml");
        }
        if(comfir_label.getText().equals(Afch_listVhcl_Restituer.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Rest_depos_fsortir.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 298, 416));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if(comfir_label.getText().equals(Afch_listVhcl_Deposer.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Rest_depos_fsortir.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 298, 416));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if(comfir_label.getText().equals(FaireSortir_Vhcl.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Rest_depos_fsortir.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 298, 416));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Afch_listVhcl_Prk.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("affichier_list_vehicule_par_parking.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 904, 413));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Ajt_Resv.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_reservation.fxml");
        }
        if (comfir_label.getText().equals(Modf_Resv.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_reservation.fxml");
        }
        if (comfir_label.getText().equals(Supp_Resv.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_reservation.fxml");
        }
        if (comfir_label.getText().equals(Rch_Resv.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_reservation.fxml");
        }
        if (comfir_label.getText().equals(Afch_listResv_V.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("afficher_list_reserv_VNVA.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 947, 364));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Afch_listResv_NV.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("afficher_list_reserv_VNVA.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 947, 364));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Afch_listResv_AN.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("afficher_list_reserv_VNVA.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 947, 364));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Ajt_Factr.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_facture.fxml");
        }
        if (comfir_label.getText().equals(Modf_Factr.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_facture.fxml");
        }
        if (comfir_label.getText().equals(Supp_Factr.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_facture.fxml");
        }
        if (comfir_label.getText().equals(Rch_Factr.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_facture.fxml");
        }
        if (comfir_label.getText().equals(Afch_listFactr.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("afficher_list_facture.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 667, 400));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Ajt_Ctra.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_contrat.fxml");
        }
        if (comfir_label.getText().equals(Modf_Ctra.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_contrat.fxml");
        }
        if (comfir_label.getText().equals(Supp_Ctra.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_contrat.fxml");
        }
        if (comfir_label.getText().equals(Rch_ctra.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Ajt_supp_mdf_contrat.fxml");
        }
        if (comfir_label.getText().equals(Afch_listCtra.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("afficher_list_contrat.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 600, 381));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Ajt_Clt.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("AjtModfSuppClient.fxml");
        }
        if (comfir_label.getText().equals(Modf_Clts.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("AjtModfSuppClient.fxml");
        }
        if (comfir_label.getText().equals(Supp_Ctls.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("AjtModfSuppClient.fxml");
        }
        if (comfir_label.getText().equals(Rch_clt.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("AjtModfSuppClient.fxml");
        }
        if (comfir_label.getText().equals(Afch_listClt.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("afficher_liste_client.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 669, 393));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Afch_list_clt_Sanction.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("affich_liste_client_sanct.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Rgl_Sanction.getText())){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("affich_list_reserv_Sanction.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 773, 341));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
    }

    /**************fuctions for menu items**************************************************************/
    /**************fuctions for menu items**************************************************************/
    public void dashboard(ActionEvent event){comfir_label.setText(Dashboard.getText()); }
    public void ajouter_utilisateur(ActionEvent event){ comfir_label.setText(Ajt_Utls.getText());}
    public void supprimer_utilisateur(ActionEvent event){ comfir_label.setText(Supp_Utls.getText()); }
    public void suspendre_utilisateur(ActionEvent event){comfir_label.setText(Sus_Utls.getText()); }
    public void afficher_list_utilisateur(ActionEvent event){comfir_label.setText(Afch_list_utilisateurs.getText());}
    public void ajouter_client(ActionEvent event){ comfir_label.setText(Ajt_Clt.getText());}
    public void supprimer_client(ActionEvent event){
        comfir_label.setText(Supp_Ctls.getText());
    }
    public void modifier_client(ActionEvent event){
        comfir_label.setText(Modf_Clts.getText());
    }
    public void afficher_liste_client(ActionEvent event){
        comfir_label.setText(Afch_listClt.getText());
    }
    public void chercher_client(ActionEvent event){
        comfir_label.setText(Rch_clt.getText());
    }
    public void ajouter_reservation(ActionEvent event){
        comfir_label.setText(Ajt_Resv.getText());
    }
    public void modifier_reservation(ActionEvent event){
        comfir_label.setText(Modf_Resv.getText());
    }
    public void supprimer_reservation(ActionEvent event){
        comfir_label.setText(Supp_Resv.getText());
    }
    public void affich_list_reservation_nv(ActionEvent event){
        comfir_label.setText(Afch_listResv_NV.getText());
    }
    public void affich_list_reservation_v(ActionEvent event){
        comfir_label.setText(Afch_listResv_V.getText());
    }
    public void affich_list_reservation_an(ActionEvent event){
        comfir_label.setText(Afch_listResv_AN.getText());
    }
    public void chercher_reservation(ActionEvent event){
        comfir_label.setText(Rch_Resv.getText());
    }
    public void ajouter_contrat(ActionEvent event){
        comfir_label.setText(Ajt_Ctra.getText());
    }
    public void supprimer_contrat(ActionEvent event){
        comfir_label.setText(Supp_Ctra.getText());
    }
    public void modifier_contrat(ActionEvent event){
        comfir_label.setText(Modf_Ctra.getText());
    }
    public void chercher_contrat(ActionEvent event){
        comfir_label.setText(Rch_ctra.getText());
    }
    public void affich_list_contrat(ActionEvent event){
            comfir_label.setText(Afch_listCtra.getText());
    }
    public void ajouter_facture(ActionEvent event){
        comfir_label.setText(Ajt_Factr.getText());
    }
    public void supprimer_facture(ActionEvent event){
        comfir_label.setText(Supp_Factr.getText());
    }
    public void modifier_facture(ActionEvent event){
        comfir_label.setText(Modf_Factr.getText());
    }
    public void affich_list_facture(ActionEvent event){
        comfir_label.setText(Afch_listFactr.getText());
    }
    public void chercher_facture(ActionEvent event){
        comfir_label.setText(Rch_Factr.getText());
    }
    public void ajouter_vehicule(ActionEvent event){ comfir_label.setText(Ajt_Vhcl.getText());}
    public void supprimer_vehicule(ActionEvent event){ comfir_label.setText(Supp_Vhcl.getText());}
    public void modifier_vehicule(ActionEvent event){ comfir_label.setText(Modf_Vhcl.getText());}
    public void affich_list_vehicule(ActionEvent event){ comfir_label.setText(Afch_listVhcl.getText());}
    public void chercher_vehicule(ActionEvent event){ comfir_label.setText(Rch_Vhcl.getText());}
    public void ajouter_parking(ActionEvent event){ comfir_label.setText(Ajt_Prk.getText()); }
    public void supprimer_parking(ActionEvent event){ comfir_label.setText(Supp_PrK.getText()); }
    public void modifier_parking(ActionEvent event){ comfir_label.setText(Modf_Prk.getText()); }
    public void affich_list_vehicule_parking(ActionEvent event){
        comfir_label.setText(Afch_listVhcl_Prk.getText());
    }
    public void restituer_vehicule(ActionEvent event){
        comfir_label.setText(Afch_listVhcl_Restituer.getText());
    }
    public void deposer_vehicule(ActionEvent event){
        comfir_label.setText(Afch_listVhcl_Deposer.getText());
    }
    public void fair_sortir_vehicule(ActionEvent event){
        comfir_label.setText(FaireSortir_Vhcl.getText());
    }
    public void chercher_parking(ActionEvent event){ comfir_label.setText(Rch_Prk.getText()); }
    public void regler_sanctions(ActionEvent event){
        comfir_label.setText(Rgl_Sanction.getText());
    }
    public void affich_list_client_sonctiones(ActionEvent event){ comfir_label.setText(Afch_list_clt_Sanction.getText()); }
    public void Setting_window(ActionEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("modifier_compte_administrateur.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage=new Stage();
        primaryStage.setTitle("vehicle allowance");
        primaryStage.setScene(new Scene(root, 428, 385));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    //function for "ajouter une reservation":ajouter Button
    public void ajt_reservation(ActionEvent event){
        String nmatricule=n_matricule.getText();
        String cn=cin.getText();
        try{
            String date_dp=date_depart.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String date_rt=date_retour.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if (!nmatricule.isBlank() && !cn.isBlank() && !date_dp.isBlank() && !date_rt.isBlank()){
                utilisateur utls=new utilisateur();
                Vehicule vehicule=utls.chercher_vehicule(nmatricule);
                Reservation reserv=utls.chercher_reservation(nmatricule);
                Client client=utls.chercher_client(cn);
                if (client!=null){
                    if (reserv!=null && reserv.getCommentaire().equals("Réservation_annulée")) utls.supprimer_reservation(nmatricule);
                    if (vehicule!=null){
                        if (vehicule.getComment().equals("Non_réservé/Deposé")){
                            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                            SimpleDateFormat simplDF=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                            Date datp=simpleDateFormat.parse(date_dp);
                            Date datr=simpleDateFormat.parse(date_rt);
                            Date dat_resv=new Date();
                            if (dat_resv.compareTo(datp)<0 || simpleDateFormat.format(dat_resv).equals(date_dp)){
                                if (datp.compareTo(datr)<=0){
                                    Reservation reservation=new Reservation(nmatricule,cn,date_dp,date_rt,simplDF.format(dat_resv));
                                    boolean test=utls.ajouter_reservation(reservation);
                                    if (test ){
                                        if (vehicule.getComment().equals("Non_réservé/Deposé")) vehicule.setComment("Réservé/Deposé");
                                        boolean verify=utls.modifier_vehicule(vehicule);
                                        JOptionPane.showMessageDialog(null,"Opération effectuée!!");
                                        n_matricule.setText("");
                                        cin.setText("");
                                    }else JOptionPane.showMessageDialog(null,"Opération n'est pas effectuée!!");
                                }else JOptionPane.showMessageDialog(null,"Attention:vérifiez les dates!!");
                            }else JOptionPane.showMessageDialog(null,"Vérifier la date départ!!");
                        }else JOptionPane.showMessageDialog(null,"Ce véhicule est déja réservé ou ce véhicule n'est pas déposer!!");
                    }else JOptionPane.showMessageDialog(null,"Ce véhicule n'exist pas!!");
                }else JOptionPane.showMessageDialog(null,"Ce client n'exist pas!!");
            }else if (nmatricule.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le Nr matricule!!");
            else if (cn.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le CIN!!");
            else if (date_dp.isBlank()) JOptionPane.showMessageDialog(null,"Saisi la Date de depart!!");
            else if (date_rt.isBlank()) JOptionPane.showMessageDialog(null,"Saisi la date de retour!!!");
        }catch (Exception e){
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Attention:Saisi les dates correctement!!");
        }
    }
    //funtcion for "chercher une réservation" chercher:Button
    public void cher_reservation(ActionEvent event){
        String nmatricule=n_matricule.getText();
        if (!nmatricule.isBlank()){
            utilisateur utls=new utilisateur();
            Reservation reservation=utls.chercher_reservation(nmatricule);
            if (reservation!=null){
                n_matricule.setText(reservation.getMatricule());
                cin.setText(reservation.getCin());
                date_depart.setValue(LocalDate.parse(reservation.getDate_depart()));
                date_retour.setValue(LocalDate.parse(reservation.getDate_retour()));
                comment.setText(reservation.getCommentaire());
                date_reserv.setText(reservation.getDate_reservation());
            }else JOptionPane.showMessageDialog(null,"Erreur!!");
        }else JOptionPane.showMessageDialog(null,"Saisi Nr matricule correspondant à la réservation que vous cherchez!!");
    }
    //function for "supprimer une reservation" Button
    public void sup_reservation(ActionEvent event){
        String nmatricule=n_matricule.getText();
        if (!nmatricule.isBlank()){
            utilisateur utls=new utilisateur();
            Reservation reservation=utls.chercher_reservation(nmatricule);
            Vehicule vehicule=utls.chercher_vehicule(nmatricule);
            Contrat contrat=utls.chercher_contrat(nmatricule);
            if (reservation!=null){
                if (vehicule!=null){
                    if (vehicule.getComment().equals("Réservé/Deposé") || vehicule.getComment().equals("Réservé/Sorti")){
                        if (vehicule.getComment().equals("Réservé/Deposé")) vehicule.setComment("Non_réservé/Deposé");
                        if (vehicule.getComment().equals("Réservé/Sorti")) vehicule.setComment("Non_réservé/Sorti");
                        reservation.setCommentaire("Réservation_annulée");
                        boolean verify=utls.modifier_vehicule(vehicule);
                        boolean test=utls.modifier_reservation(reservation);
                        if (contrat!=null) utls.supprimer_contrat(nmatricule);
                        if (utls.chercher_facture(nmatricule)!=null) utls.supprimer_facture(nmatricule);
                        if (test && verify) JOptionPane.showMessageDialog(null,"Opération effectué!!");
                        else JOptionPane.showMessageDialog(null,"Opération n'est pas effectué!!");
                    }else JOptionPane.showMessageDialog(null,"Opération n'est pas effectué!!");
                }else JOptionPane.showMessageDialog(null,"Ce véhicule n'exist pas!!");
            }else JOptionPane.showMessageDialog(null,"la réservation correspondant à cette véhicule n'exist pas!!");
        }else JOptionPane.showMessageDialog(null,"Saisi Nr matricule correspondant à la réservation que vous cherchez!!");
    }
    //function for "modifier une reservation" Button
    public void modf_reservation(ActionEvent event) {
        String nmatricule=n_matricule.getText();
        String CIN=cin.getText();
        if (!nmatricule.isBlank()){
            utilisateur utls=new utilisateur();
            Reservation reservation=utls.chercher_reservation(nmatricule);
            Facture facture=utls.chercher_facture(nmatricule);
            if (reservation!=null){
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat simplDF=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                try {
                    Date dat_rsv=simplDF.parse(reservation.getDate_reservation());
                    Date datp=simpleDateFormat.parse(date_depart.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    Date datr=simpleDateFormat.parse(date_retour.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    if ((dat_rsv.compareTo(datp)<=0 || simpleDateFormat.format(dat_rsv).equals(simpleDateFormat.format(datp))) && (datp.compareTo(datr)<=0)){
                        Contrat contrat=utls.chercher_contrat(nmatricule);
                        if (contrat!=null){
                            Date date_contrat=simpleDateFormat.parse(contrat.getDate_contrat());
                            Date date_echeance=simpleDateFormat.parse(contrat.getDate_echeance());
                            if (date_contrat.compareTo(datp)<=0 && datr.compareTo(date_echeance)<=0){
                                reservation.setDate_depart(date_depart.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                                reservation.setDate_retour(date_retour.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                                boolean test=utls.modifier_reservation(reservation);
                                if (test) JOptionPane.showMessageDialog(null,"Opération effectué!!");
                                else JOptionPane.showMessageDialog(null,"Opération n'est pas effectué!!");
                            }else JOptionPane.showMessageDialog(null,"les date de réservation dovent etre compris entre les date de contrat!!");
                        }else {
                            reservation.setDate_depart(date_depart.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                            reservation.setDate_retour(date_retour.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                            boolean test=utls.modifier_reservation(reservation);
                            if (test) JOptionPane.showMessageDialog(null,"Opération effectué!!");
                            else JOptionPane.showMessageDialog(null,"Opération n'est pas effectué!!");
                        }
                    }else JOptionPane.showMessageDialog(null,"Attention:Vérifiez les dates!!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Cette opération nécessite la saisi des deux dates correctement!!");
                    //e.printStackTrace();
                }
            }else JOptionPane.showMessageDialog(null,"Cette réservation n'exist pas!!");
        }else JOptionPane.showMessageDialog(null,"Saisi le Nr de réservation que vous voulez modifier!!");
    }
}
