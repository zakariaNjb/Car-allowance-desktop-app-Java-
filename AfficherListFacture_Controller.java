package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AfficherListFacture_Controller implements Initializable {
    @FXML javafx.scene.control.TableView<Facture> tableView;
    @FXML javafx.scene.control.TableColumn<Facture,String> nmtrcl;
    @FXML javafx.scene.control.TableColumn<Facture,String> cn;
    @FXML javafx.scene.control.TableColumn<Facture,Double> mp;
    @FXML javafx.scene.control.TableColumn<Facture,String> date_f;
    @FXML javafx.scene.control.TableColumn<Facture,String> cmt;
    ObservableList<Facture> list= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nmtrcl.setCellValueFactory(new PropertyValueFactory<Facture,String>("n_matricule"));
        cn.setCellValueFactory(new PropertyValueFactory<Facture,String>("cin"));
        mp.setCellValueFactory(new PropertyValueFactory<Facture,Double>("m_paye"));
        date_f.setCellValueFactory(new PropertyValueFactory<Facture,String>("date_facture"));
        cmt.setCellValueFactory(new PropertyValueFactory<Facture,String>("comment"));
        utilisateur utls=new utilisateur();
        list=utls.afficher_list_facture();
        if (list!=null) tableView.setItems(list);
    }
}
