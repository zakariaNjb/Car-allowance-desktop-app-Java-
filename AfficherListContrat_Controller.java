package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AfficherListContrat_Controller implements Initializable {
    @FXML javafx.scene.control.TableView<Contrat> tableView;
    @FXML javafx.scene.control.TableColumn<Contrat,String> nmatricule;
    @FXML javafx.scene.control.TableColumn<Contrat,String> dat_c;
    @FXML javafx.scene.control.TableColumn<Contrat,String> dat_r;
    @FXML javafx.scene.control.TableColumn<Contrat,String> cn;
    ObservableList<Contrat> list= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nmatricule.setCellValueFactory(new PropertyValueFactory<Contrat,String>("N_contrat"));
        dat_c.setCellValueFactory(new PropertyValueFactory<Contrat,String>("date_contrat"));
        dat_r.setCellValueFactory(new PropertyValueFactory<Contrat,String>("date_echeance"));
        cn.setCellValueFactory(new PropertyValueFactory<Contrat,String>("cin"));
        utilisateur utls=new utilisateur();
        list=utls.afficher_list_contrat();
        if (list!=null) tableView.setItems(list);
    }
}
