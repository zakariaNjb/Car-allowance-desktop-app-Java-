package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController{
    @FXML javafx.scene.control.Button log;
    @FXML javafx.scene.control.TextField username;
    @FXML javafx.scene.control.PasswordField passwordField;
    public void entrer(javafx.event.ActionEvent event) {
        if (!username.getText().isBlank() && !passwordField.getText().isBlank()){
            Sqlconnection sqlconnection=new Sqlconnection();
            if (sqlconnection.isDBconnected()){
                PreparedStatement preparedStatement=null;
                ResultSet resultSet=null;
                String quer="select * from utilisateur where nom_prenom=? and CIN=? and compte=?";
                try {
                    preparedStatement=sqlconnection.getConnection().prepareStatement(quer);
                    preparedStatement.setString(1,username.getText());
                    preparedStatement.setString(2,passwordField.getText());
                    preparedStatement.setString(3,"activé");
                    resultSet=preparedStatement.executeQuery();
                    Administrateur administrateur=new Administrateur();
                    if (resultSet.next() || administrateur.getPassword().equals(passwordField.getText())){
                        ((Node)event.getSource()).getScene().getWindow().hide();
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage primaryStage=new Stage();
                        primaryStage.setTitle("vehicle allowance");
                        primaryStage.setScene(new Scene(root, 890, 364));
                        primaryStage.setResizable(false);
                        primaryStage.show();
                    }else JOptionPane.showMessageDialog(null,"Compte uncorrect,Essayer encore!!");
                    preparedStatement.close();
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }else JOptionPane.showMessageDialog(null,"la connection avec la base de donné n'est pas effectuée!!");
        }else if(username.getText().isBlank()) JOptionPane.showMessageDialog(null,"Saisi Votre nom complet!!");
        else if (passwordField.getText().isBlank()) JOptionPane.showMessageDialog(null,"Saisi le mode pass!!");
    }
}
