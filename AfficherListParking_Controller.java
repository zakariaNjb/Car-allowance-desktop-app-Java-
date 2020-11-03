package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AfficherListParking_Controller implements Initializable {
    @FXML javafx.scene.control.TableView<Parking> tbv;
    @FXML javafx.scene.control.TableColumn<Parking,String> n_parking;
    @FXML javafx.scene.control.TableColumn<Parking,String> rue;
    @FXML javafx.scene.control.TableColumn<Parking,String> arrond;
    @FXML javafx.scene.control.TableColumn<Parking,Integer> capt;
    @FXML javafx.scene.control.TableColumn<Parking,Integer> nbr_p_vides;
    ObservableList<Parking> list= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        n_parking.setCellValueFactory(new PropertyValueFactory<Parking,String>("n_parking"));
        rue.setCellValueFactory(new PropertyValueFactory<Parking,String>("rue"));
        arrond.setCellValueFactory(new PropertyValueFactory<Parking,String>("arrondissement"));
        capt.setCellValueFactory(new PropertyValueFactory<Parking,Integer>("capacity"));
        nbr_p_vides.setCellValueFactory(new PropertyValueFactory<Parking,Integer>("nbr_place_vides"));
        utilisateur utls=new utilisateur();
        list=utls.affciher_list_parking();
        if (list!=null) tbv.setItems(list);
    }
}
