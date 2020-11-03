package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import static java.time.temporal.ChronoUnit.DAYS;

public class AffichListeClientSanct_Controller implements Initializable {
    @FXML
    javafx.scene.control.TableView tableView;
    @FXML javafx.scene.control.TableColumn<Client,String> cin;
    @FXML javafx.scene.control.TableColumn<Client,String> nom;
    @FXML javafx.scene.control.TableColumn<Client,String> adres;
    @FXML javafx.scene.control.TableColumn<Client,Integer> gsm;
    @FXML javafx.scene.control.Button regler;
    ObservableList<Client> list= FXCollections.observableArrayList();
    ObservableList<Contrat> listC= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cin.setCellValueFactory(new PropertyValueFactory<Client,String>("cin"));
        nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom_prenom"));
        adres.setCellValueFactory(new PropertyValueFactory<Client,String>("adresse"));
        gsm.setCellValueFactory(new PropertyValueFactory<Client,Integer>("gsm"));
        utilisateur utls=new utilisateur();
        listC=utls.afficher_list_contrat();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        for (int i=0;i<listC.size();i++){
            Contrat contrat=listC.get(i);
            Reservation reservation=utls.chercher_reservation(contrat.getN_contrat());
            try {
                Date dateR = simpleDateFormat.parse(reservation.getDate_retour());
                LocalDateTime ldtR = LocalDateTime.ofInstant(dateR.toInstant(),ZoneId.systemDefault());
                long noOfDaysBetween = DAYS.between(ldtR,ldt);
                if (noOfDaysBetween>0){
                    Client client=utls.chercher_client(contrat.getCin());
                    list.add(client);
                }
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null,"la liste des clients sanctionés est vide!!");
                e.printStackTrace();
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,"la liste des clients sanctionés est vide!!");
            }
        }
        tableView.setItems(list);
    }

    public void regler_sanction(javafx.event.ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("affich_list_reserv_Sanction.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage=new Stage();
        primaryStage.setTitle("vehicle allowance");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 773, 341));
        primaryStage.show();
    }
}
