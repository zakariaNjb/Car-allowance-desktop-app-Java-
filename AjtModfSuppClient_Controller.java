package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AjtModfSuppClient_Controller {
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
    @FXML javafx.scene.control.Button select;
    @FXML javafx.scene.control.Button voirResv;
    @FXML javafx.scene.control.Label comfir_label;/************comfirmation label**************************/

    @FXML javafx.scene.control.TextField cin;
    @FXML javafx.scene.control.TextField nom;
    @FXML javafx.scene.control.TextField adres;
    @FXML javafx.scene.control.TextField gsm;
    @FXML javafx.scene.control.Label lb;
    @FXML javafx.scene.image.ImageView imageView=new ImageView();

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
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 890, 364));
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
    public void selectfile(ActionEvent event){
        FileChooser chooser=new FileChooser();
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG","*.jpg"),
                new FileChooser.ExtensionFilter("JPEG","*.jpeg"),
                new FileChooser.ExtensionFilter("GIF","*.gif"),
                new FileChooser.ExtensionFilter("PNG","*.png"),
                new FileChooser.ExtensionFilter("TIFF","*.TIFF")
                );
        try {
            File f= chooser.showOpenDialog(null);
            if (f!=null){
                lb.setText(f.getAbsolutePath());
                FileInputStream fileInputStream=new FileInputStream(f.getAbsolutePath());
                Image image=new Image(fileInputStream);
                imageView.setImage(image);
            }else JOptionPane.showMessageDialog(null, "Selection une image de permis!!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Selection une image de permis!!");
        }
    }
    //function:"ajouter client" ajouter Button
    public void ajt_client(ActionEvent event){
        String cn=cin.getText();
        String name=nom.getText();
        String adrs=adres.getText();
        String nr=gsm.getText();
        if (!cn.isBlank() && !name.isBlank() && !adrs.isBlank() && !nr.isBlank() && !lb.getText().equals("Image_de_permis")){
            try{
                Client client=new Client(cn,name,adrs,Integer.parseInt(nr),lb.getText());
                utilisateur utls=new utilisateur();
                boolean test=utls.ajouter_client(client);
                if (test){
                    JOptionPane.showMessageDialog(null,"Opération effectuéé!!");
                    cin.setText("");
                    nom.setText("");
                    adres.setText("");
                    gsm.setText("");
                    lb.setText("Image_de_permis");
                }
                else JOptionPane.showMessageDialog(null,"Opération n'est pas effectuée!!");
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Saisi le Nr gsm en format numérique!!");
            }
        }else if (cn.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le CIN de client!!");
        else if (name.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le nom du client!!");
        else if (adrs.isBlank()) JOptionPane.showMessageDialog(null,"Saisi l'adresse du client!!");
        else if (nr.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le Nr GSM du client!!");
        else if (lb.getText().equals("Image_de_permis")) JOptionPane.showMessageDialog(null,"selectioner l'image de permis!!");
    }
    //function:"chercher un clinet" chercher Button
    public void cher_client(ActionEvent event){
        String name=nom.getText();
        String cn=cin.getText();
        if (!name.isBlank() && !cn.isBlank()){
            utilisateur utls=new utilisateur();
            Client client=utls.chercher_client(cn);
            if (client!=null){
                cin.setText(client.getCin());
                nom.setText(client.getNom_prenom());
                adres.setText(client.getAdresse());
                gsm.setText(String.valueOf(client.getGsm()));
                lb.setText(client.getImage());
                try {
                    FileInputStream fileInputStream=new FileInputStream(client.getImage());
                    Image image=new Image(fileInputStream);
                    imageView.setImage(image);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }else JOptionPane.showMessageDialog(null,"Ce client n'exist pas!!");
        }else if (name.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le nom complet de client que vous cherchez!!");
        else if (cn.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le CIN du client pour assurer la recherche!!");
    }
    //function:Modifier un client modifier Button
    public void modf_client(ActionEvent event){
        String name=nom.getText();
        String cn=cin.getText();
        if (!name.isBlank() && !cn.isBlank()){
            utilisateur utls=new utilisateur();
            Client client=utls.chercher_client(cn);
            if (client!=null){
                if (!cin.getText().isBlank()) client.setCin(cin.getText());
                if (!adres.getText().isBlank()) client.setAdresse(adres.getText());
                if (!gsm.getText().isBlank()) client.setGsm(Integer.parseInt(gsm.getText()));
                if (!lb.getText().equals("Image_de_permis")) client.setImage(lb.getText());
                boolean test=utls.modifier_client(client);
                if (test){
                    JOptionPane.showMessageDialog(null,"Opération effectué!!!");
                    JOptionPane.showMessageDialog(null,"N'oubliez pas de supprimer l'ancienne photo de permis si vous avez la changer!!");
                }
                else JOptionPane.showMessageDialog(null,"Opération n'est pas effectué!!");
            }else JOptionPane.showMessageDialog(null,"Ce client n'exist pas!!");
        }else if (name.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le nom complet du client que vous voullez modifier ses informations!!");
        else if (cn.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le CIN du client pour assurer la modification !!");
    }
    //function:supprimer un client supprimer Button
    public void supp_client(ActionEvent event){
        String name=nom.getText();
        String cn=cin.getText();
        if (!name.isBlank() && !cn.isBlank()){
            utilisateur utls=new utilisateur();
            Client client=utls.chercher_client(cn);
            if (client!=null){
                if (name.equals(client.getNom_prenom())){
                    ObservableList<Contrat> list= utls.afficher_list_contrat();//cette opération est faite pour supprimer tous les réservation de ce client
                    for (int i=0;i<list.size();i++){
                        Contrat contrat=list.get(i);
                        if (contrat.getCin().equals(cn)){
                            utls.supprimer_contrat(contrat.getN_contrat());
                            utls.supprimer_reservation(contrat.getN_contrat());
                            utls.supprimer_facture(contrat.getN_contrat());
                            Vehicule vehicule=utls.chercher_vehicule(contrat.getN_contrat());
                            vehicule.setComment("Non_réservé/Deposé");
                            utls.modifier_vehicule(vehicule);
                        }else continue;
                    }
                    boolean test=utls.supprimer_client(cn);
                    if (test) {
                        JOptionPane.showMessageDialog(null,"Opération effectué!!!");
                        JOptionPane.showMessageDialog(null,"N'oubliez pas de supprimer l'ancienne photo de permis de client que vous avez supprimer!!");
                        cin.setText("");
                        nom.setText("");
                        adres.setText("");
                        gsm.setText("");
                        lb.setText("Image_de_permis");
                    }else JOptionPane.showMessageDialog(null,"Opération n'est pas effectué!!");
                }else JOptionPane.showMessageDialog(null,"le CIN ne correspond pas à le nom que vous avez saisi!!");
            }else JOptionPane.showMessageDialog(null,"Ce client n'exist pas!!");
        }else if (name.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le nom complet de client que vous voullez supprimer!!");
        else if (cn.isBlank()) JOptionPane.showMessageDialog(null,"Saisi le CIN du client pour assurer la suppresion !!");
    }
    //function:afficher les reservation dun client
    public void afficher_reservation_client(ActionEvent event){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("affich_resv_dunclient.fxml"));
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
