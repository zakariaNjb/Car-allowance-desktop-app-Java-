package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class affciher_list_vehicule_Controller implements Initializable {

    @FXML javafx.scene.control.TableView<Vehicule> tableV;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> n_matr;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> marq;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> t;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> carb;
    @FXML javafx.scene.control.TableColumn<Vehicule,Double> comptr;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> date;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> npark;
    @FXML javafx.scene.control.TableColumn<Vehicule,String> cmt;
    ObservableList<Vehicule> list= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        n_matr.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("n_matricule"));
        marq.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("marque"));
        t.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("type"));
        carb.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("carburant"));
        comptr.setCellValueFactory(new PropertyValueFactory<Vehicule,Double>("compteur_km"));
        date.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("date_mise_encirculation"));
        npark.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("n_parking"));
        cmt.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("comment"));
        utilisateur utls=new utilisateur();
        list=utls.affciher_list_vehicule();
        if(list!=null) tableV.setItems(list);
    }
}
