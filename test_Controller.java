package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test_Controller {
    @FXML javafx.scene.control.Button btn;
    @FXML javafx.scene.control.Label lb;
    @FXML javafx.scene.image.ImageView imgv=new ImageView();


    public void show_file(ActionEvent event){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select * from image";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    lb.setText(resultSet.getString("img"));
                    FileInputStream fileInputStream=new FileInputStream(resultSet.getString("img"));
                    javafx.scene.image.Image img=new Image(fileInputStream);
                    imgv.setImage(img);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else JOptionPane.showMessageDialog(null,"sorry there is something wrong!!!");
    }
}
