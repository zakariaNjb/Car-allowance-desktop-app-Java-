package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AfficherListeClient_Controller implements Initializable {
    @FXML javafx.scene.control.TableView tableView;
    @FXML javafx.scene.control.TableColumn<Client,String> cin;
    @FXML javafx.scene.control.TableColumn<Client,String> nom;
    @FXML javafx.scene.control.TableColumn<Client,String> adres;
    @FXML javafx.scene.control.TableColumn<Client,Integer> gsm;
    ObservableList<Client> list= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cin.setCellValueFactory(new PropertyValueFactory<Client,String>("cin"));
        nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom_prenom"));
        adres.setCellValueFactory(new PropertyValueFactory<Client,String>("adresse"));
        gsm.setCellValueFactory(new PropertyValueFactory<Client,Integer>("gsm"));
        utilisateur utls=new utilisateur();
        list=utls.afficher_liste_client();
        if (list!=null) tableView.setItems(list);
    }
}
