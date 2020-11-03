package sample;

import javafx.fxml.FXML;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ReglerSanction_Controller {
    @FXML javafx.scene.control.TextField n_reservation;
    @FXML javafx.scene.control.Button regler;
    public void regler(ActionEvent event){
        String nresev=n_reservation.getText();
        if (n_reservation.getText().isBlank()){

        }else JOptionPane.showMessageDialog(null,"Saisi le Nr de réservation correspondante!!");
    }
}
