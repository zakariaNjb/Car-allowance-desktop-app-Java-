package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AfficherListReservVNVA_Controller implements Initializable {
    @FXML
    javafx.scene.control.TableView<Reservation> tableV;
    @FXML javafx.scene.control.TableColumn<Reservation,String> n_matr;
    @FXML javafx.scene.control.TableColumn<Reservation,String> cn;
    @FXML javafx.scene.control.TableColumn<Reservation,String> datep;
    @FXML javafx.scene.control.TableColumn<Reservation,String> dater;
    @FXML javafx.scene.control.TableColumn<Reservation,String> cmt;
    @FXML javafx.scene.control.TableColumn<Reservation,String> date_rsv;
    @FXML javafx.scene.control.ComboBox<String> cmbox=new ComboBox<>();
    @FXML javafx.scene.control.Button afficher;
    ObservableList<Reservation> list= FXCollections.observableArrayList();
    ObservableList<String> listcmbx=FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        utilisateur utls=new utilisateur();
        listcmbx.addAll("Réservation validée","Réservation non validée","Réservation annulée","Toutes les réservations");
        n_matr.setCellValueFactory(new PropertyValueFactory<Reservation,String>("matricule"));
        cn.setCellValueFactory(new PropertyValueFactory<Reservation,String>("cin"));
        datep.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_depart"));
        dater.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_retour"));
        cmt.setCellValueFactory(new PropertyValueFactory<Reservation,String>("commentaire"));
        date_rsv.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_reservation"));
        cmbox.setItems(listcmbx);
        list=utls.afficher_list_reservation();
        if (list!=null) tableV.setItems(list);

    }
    public void afficher(ActionEvent event){
        list.clear();
        utilisateur utls=new utilisateur();
        if (cmbox.getSelectionModel().getSelectedItem().equals("Réservation validée")){
            list=utls.afficher_list_reservation_V();
            tableV.setItems(list);
        }
        if (cmbox.getSelectionModel().getSelectedItem().equals("Réservation non validée")){
            list=utls.afficher_list_reservation_NV();
            tableV.setItems(list);
        }
        if (cmbox.getSelectionModel().getSelectedItem().equals("Réservation annulée")){
            list=utls.afficher_list_reservation_A();
            tableV.setItems(list);
        }
        if (cmbox.getSelectionModel().getSelectedItem().equals("Toutes les réservations")){
            list=utls.afficher_list_reservation();
            tableV.setItems(list);
        }
    }
}
