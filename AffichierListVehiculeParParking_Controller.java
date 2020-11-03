package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AffichierListVehiculeParParking_Controller implements Initializable {
    @FXML
    javafx.scene.control.TableView<Vehicule> tableV;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> n_matr;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> marq;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> t;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> carb;
    @FXML javafx.scene.control.TableColumn<Vehicule,Double> comptr;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> date;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> cmt;
    ObservableList<Vehicule> list= FXCollections.observableArrayList();
    @FXML javafx.scene.control.Button afficher;
    @FXML javafx.scene.control.TextField lb;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        n_matr.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("n_matricule"));
        marq.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("marque"));
        t.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("type"));
        carb.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("carburant"));
        comptr.setCellValueFactory(new PropertyValueFactory<Vehicule,Double>("compteur_km"));
        date.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("date_mise_encirculation"));
        cmt.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("comment"));
    }
    public void afficher_list_vehiculeP_P(ActionEvent event){
        String afc=lb.getText();
        if (!afc.isBlank()){
            utilisateur uts=new utilisateur();
            Parking parking=uts.chercher_parking(afc);
            if (parking!=null){
                  utilisateur utls=new utilisateur();
                  list=utls.afficher_list_vehicule_parking(afc);
                  if(list!=null) tableV.setItems(list);
            }else JOptionPane.showMessageDialog(null,"Ce parking n'exist pas!!");
        }else JOptionPane.showMessageDialog(null,"Saisi le numéro de parking!!");
    }
}
