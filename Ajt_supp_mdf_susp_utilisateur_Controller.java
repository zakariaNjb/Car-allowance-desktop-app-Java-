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

public class Ajt_supp_mdf_susp_utilisateur_Controller {

    /**********************************variables for menu items******************************/
    /**********************************variables for menu items******************************/

    @FXML javafx.scene.control.MenuItem Ajt_Utls;//ajouter utilisateur
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
    @FXML javafx.scene.control.MenuItem Dashboard;//retour au menu principale

    @FXML javafx.scene.control.TextField fullname;
    @FXML javafx.scene.control.TextField CIN;
    @FXML javafx.scene.control.TextField salary;
    @FXML javafx.scene.control.PasswordField password;

    @FXML javafx.scene.control.Button ajouter;
    @FXML javafx.scene.control.Button supprimer;
    @FXML javafx.scene.control.Button modifier;
    @FXML javafx.scene.control.Button suspendre;
    @FXML javafx.scene.control.Button compte;

    @FXML javafx.scene.control.Button move;
    @FXML javafx.scene.control.Label comfir_label;


    /**************fuctions for menu items**************************************************************/
    /**************fuctions for menu items**************************************************************/

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
        if(comfir_label.getText().equals(Dashboard.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            show_window("Menu.fxml");
        }
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
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Ajt_supp_mdf_reservation.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 890, 364));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Modf_Resv.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Ajt_supp_mdf_reservation.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 890, 364));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Supp_Resv.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Ajt_supp_mdf_reservation.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 890, 364));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        if (comfir_label.getText().equals(Rch_Resv.getText())){
            ((Node)event.getSource()).getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Ajt_supp_mdf_reservation.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage=new Stage();
            primaryStage.setTitle("vehicle allowance");
            primaryStage.setScene(new Scene(root, 890, 364));
            primaryStage.setResizable(false);
            primaryStage.show();
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
    //function:"ajouter un utilisateur" of "ajouter" button
    public void ajt_utilisateur(ActionEvent event) {
        String fname=fullname.getText();
        String cin=CIN.getText();
        String slry=salary.getText();
        String passwd=password.getText();
        if(!fname.isBlank() && !cin.isBlank() && !slry.isBlank() && !passwd.isBlank()){
            Administrateur administrateur=new Administrateur();
            String pasw=administrateur.getPassword();
            try{
                if (passwd.equals(pasw)){
                    utilisateur utls=new utilisateur(cin,fname,Double.parseDouble(slry));
                    boolean test=administrateur.ajouter_utilisateur(utls);
                    if(test) {
                        JOptionPane.showMessageDialog(null,"Opération effectuée!!!");
                        fullname.setText("");
                        CIN.setText("");
                        salary.setText("");
                        password.setText("");
                    }else JOptionPane.showMessageDialog(null,"Opération n'est pas effectuée!!");
                }else {
                    if(pasw!=null) JOptionPane.showMessageDialog(null,"Mode pass est uncorrect!!!");
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Saisir le salaire au format numérique!!!");
            }
        }else if(fname.isBlank()) JOptionPane.showMessageDialog(null,"Saisir le nom et prenom de l'utilisateur!!!!");
        else if(cin.isBlank()) JOptionPane.showMessageDialog(null,"Saisir le CIN de l'utilisateur!!");
        else if(slry.isBlank()) JOptionPane.showMessageDialog(null,"Saisir un salaire pour l'utilisateur!!");
        else if(passwd.isBlank()) JOptionPane.showMessageDialog(null,"Saisir votre mode pass!!!");
    }
    //function:"supprimer un utilisateur" of "supprimer" button
    public void supp_utilisateur(ActionEvent event){
        String fname=fullname.getText();
        String cin=CIN.getText();
        String passwd=password.getText();
        if (!fname.isBlank() && !cin.isBlank() && !passwd.isBlank()){
            Administrateur administrateur=new Administrateur();
            String pasw=administrateur.getPassword();
            if(passwd.equals(pasw)){
                utilisateur utls=new utilisateur(cin,fname,0);
                boolean test=administrateur.supprimer_utilisateur(utls);
                if(test) {
                    JOptionPane.showMessageDialog(null,"Opération effectuéé!!!");
                    fullname.setText("");
                    CIN.setText("");
                    salary.setText("");
                    password.setText("");
                }else JOptionPane.showMessageDialog(null,"Opération n'est pas effectuéé!!!");
            }else if(pasw!=null) JOptionPane.showMessageDialog(null,"Mode pass est uncorrect!!!");
        }else if(fname.isBlank()) JOptionPane.showMessageDialog(null,"Saisir le nom et prenom de l'utilisateur!!");
        else if(cin.isBlank()) JOptionPane.showMessageDialog(null,"Saisir le CIN de l'utilisateur!!");
        else if(passwd.isBlank()) JOptionPane.showMessageDialog(null,"Saisir votre mode pass!!!");
    }
    //function:"modifier un utilisateur" of "modifier" button
    public void mdf_utilisateur(ActionEvent event){
        String fname=fullname.getText();
        String cin=CIN.getText();
        String slry=salary.getText();
        String passwd=password.getText();
        if(!fname.isBlank() && !cin.isBlank() && !slry.isBlank() && !passwd.isBlank()){
            Administrateur administrateur=new Administrateur();
            String pasw=administrateur.getPassword();
            try{
                if (passwd.equals(pasw)){
                    utilisateur utls=new utilisateur(cin,fname,Double.parseDouble(slry));
                    boolean test=administrateur.modifier_utilisateur(utls);
                    if(test) {
                        JOptionPane.showMessageDialog(null,"Opération effectuée!!!");
                        fullname.setText("");
                        CIN.setText("");
                        salary.setText("");
                        password.setText("");
                    }else JOptionPane.showMessageDialog(null,"Opération n'est pas effectuée!!");
                }else if(pasw!=null) JOptionPane.showMessageDialog(null,"Mode pass est uncorrect!!!");
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Saisir le salaire au format numérique!!!");
            }
        }else if(fname.isBlank()) JOptionPane.showMessageDialog(null,"Saisir le nom et prenom de l'utilisateur!!!!");
        else if(cin.isBlank()) JOptionPane.showMessageDialog(null,"Saisir le CIN de l'utilisateur!!");
        else if(slry.isBlank()) JOptionPane.showMessageDialog(null,"Saisir un salaire pour l'utilisateur!!");
        else if(passwd.isBlank()) JOptionPane.showMessageDialog(null,"Saisir votre mode pass!!!");
    }
    //function:"suspendre un utilisateur " of "suspendre" button
    public void susp_utilisateur(ActionEvent event){
        String fname=fullname.getText();
        String cin=CIN.getText();
        String passwd=password.getText();
        if (!fname.isBlank() && !cin.isBlank() && !passwd.isBlank()){
            Administrateur administrateur=new Administrateur();
            String pasw=administrateur.getPassword();
            if(passwd.equals(pasw)){
                utilisateur utls=new utilisateur(cin,fname,0);
                boolean test=administrateur.suspendre_utilisateur(utls);
                if(test) {
                    JOptionPane.showMessageDialog(null,"Opération effectuéé!!!");
                    fullname.setText("");
                    CIN.setText("");
                    salary.setText("");
                    password.setText("");
                }else JOptionPane.showMessageDialog(null,"Opération n'est pas effectuéé!!!");
            }else if(pasw!=null) JOptionPane.showMessageDialog(null,"Mode pass est uncorrect!!!");
        }else if(fname.isBlank()) JOptionPane.showMessageDialog(null,"Saisir le nom et prenom de l'utilisateur!!");
        else if(cin.isBlank()) JOptionPane.showMessageDialog(null,"Saisir le CIN de l'utilisateur!!");
        else if(passwd.isBlank()) JOptionPane.showMessageDialog(null,"Saisir votre mode pass!!!");
    }
    //function:"activer compte d'un utilisateur" of "activer_compte" button
    public void actv_compte(ActionEvent event){
        String fname=fullname.getText();
        String cin=CIN.getText();
        String passwd=password.getText();
        if (!fname.isBlank() && !cin.isBlank() && !passwd.isBlank()){
            Administrateur administrateur=new Administrateur();
            String pasw=administrateur.getPassword();
            if(passwd.equals(pasw)){
                utilisateur utls=new utilisateur(cin,fname,0);
                boolean verify=administrateur.chercher_utilisateur(cin);
                if (verify){
                    boolean test=administrateur.activer_compte_utilisateur(utls);
                    if(test) {
                        JOptionPane.showMessageDialog(null,"Opération effectuéé!!!");
                        fullname.setText("");
                        CIN.setText("");
                        salary.setText("");
                        password.setText("");
                    }else JOptionPane.showMessageDialog(null,"Opération n'est pas effectuéé!!!");
                }else JOptionPane.showMessageDialog(null,"Ce utilisateur n'exist pas!!");
            }else if(pasw!=null) JOptionPane.showMessageDialog(null,"Mode pass est uncorrect!!!");
        }else if(fname.isBlank()) JOptionPane.showMessageDialog(null,"Saisir le nom et prenom de l'utilisateur!!");
        else if(cin.isBlank()) JOptionPane.showMessageDialog(null,"Saisir le CIN de l'utilisateur!!");
        else if(passwd.isBlank()) JOptionPane.showMessageDialog(null,"Saisir votre mode pass!!!");
    }
}
