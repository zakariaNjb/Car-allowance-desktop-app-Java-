package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class affich_resv_dunclient_Controller implements Initializable {
    @FXML
    javafx.scene.control.TableView<Reservation> tableV;
    @FXML javafx.scene.control.TableColumn<Reservation,String> n_matr;
    @FXML javafx.scene.control.TableColumn<Reservation,String> datep;
    @FXML javafx.scene.control.TableColumn<Reservation,String> dater;
    @FXML javafx.scene.control.TableColumn<Reservation,String> cmt;
    @FXML javafx.scene.control.TableColumn<Reservation,String> date_rsv;
    @FXML javafx.scene.control.Button afficher;
    @FXML javafx.scene.control.TextField cin;
    ObservableList<Reservation> list= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        n_matr.setCellValueFactory(new PropertyValueFactory<Reservation,String>("matricule"));
        datep.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_depart"));
        dater.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_retour"));
        cmt.setCellValueFactory(new PropertyValueFactory<Reservation,String>("commentaire"));
        date_rsv.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_reservation"));
    }

    public void aff_list_reservationClt(javafx.event.ActionEvent event) {
        if (!cin.getText().isBlank()){
            utilisateur ults=new utilisateur();
            Client client=ults.chercher_client(cin.getText());
            if (client!=null){
                list=ults.reservations_corrs_clt(cin.getText());
                if (list!=null) tableV.setItems(list);
                else JOptionPane.showMessageDialog(null,"Ce client n'a aucune réservation!!");
            }else JOptionPane.showMessageDialog(null,"Ce client n'exist pas!!");
        }else JOptionPane.showMessageDialog(null,"Saisi le CIN de client!!");
    }
}
