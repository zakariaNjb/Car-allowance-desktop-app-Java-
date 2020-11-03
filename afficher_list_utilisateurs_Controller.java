package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class afficher_list_utilisateurs_Controller implements Initializable {

    @FXML javafx.scene.control.TableView<utilisateur> list_utilisateurs;
    @FXML javafx.scene.control.TableColumn<utilisateur,String> nom_prenom;
    @FXML javafx.scene.control.TableColumn<utilisateur,String> CIN;
    @FXML javafx.scene.control.TableColumn<utilisateur,Double> salaire;
    @FXML javafx.scene.control.TableColumn<utilisateur,String> compte;
    @FXML javafx.scene.control.PasswordField password;
    @FXML javafx.scene.control.Button afficher;
    ObservableList<utilisateur> list= FXCollections.observableArrayList();

    public void afficher_utilisateurs(ActionEvent event){
        list_utilisateurs.getItems().clear();
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            if(!password.getText().isBlank()){
                Administrateur administrateur=new Administrateur();
                if(administrateur.getPassword().equals(password.getText())){
                    PreparedStatement preparedStatement=null;
                    ResultSet resultSet=null;
                    String query="select * from utilisateur";
                    try {
                        preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                        resultSet=preparedStatement.executeQuery();
                        while (resultSet.next()){
                            utilisateur utls=new utilisateur();
                            utls.setFullname(resultSet.getString("nom_prenom"));
                            utls.setCIN(resultSet.getString("CIN"));
                            utls.setSalaire(Double.parseDouble(resultSet.getString("salaire")));
                            utls.setCompte_comment(resultSet.getString("compte"));
                            list.add(utls);
                        }
                        list_utilisateurs.setItems(list);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }else JOptionPane.showMessageDialog(null,"Mode pass est uncorrect!!!");
            }else JOptionPane.showMessageDialog(null,"Saisir Votre mode pass!!!");
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de données effcetuée!!!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nom_prenom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("fullname"));
        CIN.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("CIN"));
        salaire.setCellValueFactory(new PropertyValueFactory<utilisateur,Double>("salaire"));
        compte.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("compte_comment"));
    }
}
