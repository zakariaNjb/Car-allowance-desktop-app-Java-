package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Mdf_cmpteAdmistrateur_Controller {
    @FXML javafx.scene.control.TextField full_name;
    @FXML javafx.scene.control.PasswordField new_password;
    @FXML javafx.scene.control.PasswordField old_password;
    @FXML javafx.scene.control.Button modifier;

    public void mdf_compte_administrateur(ActionEvent event) {
        Administrateur administrateur=new Administrateur();
        String fullname=full_name.getText();
        String newpassword=new_password.getText();
        String oldpassword=old_password.getText();
        if(!fullname.isBlank() && !newpassword.isBlank() && !oldpassword.isBlank()){
            String oldpass=administrateur.getPassword();
            if(oldpassword.equals(administrateur.getPassword())) {
                administrateur.setFullname(fullname);
                administrateur.setPassword(newpassword);
                JOptionPane.showMessageDialog(null,"Opération effectué!!!");
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
                primaryStage.show();
            }else if (oldpass!=null) JOptionPane.showMessageDialog(null,"Mode pass uncorrect!!!");
        }else if (fullname.isBlank()) JOptionPane.showMessageDialog(null,"Saisire votre nom et prenom!!!");
        else if(newpassword.isBlank()) JOptionPane.showMessageDialog(null,"Saisir votre nouveau mode pass!!!");
        else JOptionPane.showMessageDialog(null,"Saisir votre ancien mode pass!!!");
    }
}
