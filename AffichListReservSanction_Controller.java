package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import static java.time.temporal.ChronoUnit.DAYS;

public class AffichListReservSanction_Controller implements Initializable {
    @FXML
    javafx.scene.control.TableView<Reservation> tableV;
    @FXML javafx.scene.control.TableColumn<Reservation,String> n_matr;
    @FXML javafx.scene.control.TableColumn<Reservation,String> datep;
    @FXML javafx.scene.control.TableColumn<Reservation,String> dater;
    @FXML javafx.scene.control.TableColumn<Reservation,String> cmt;
    @FXML javafx.scene.control.TableColumn<Reservation,String> date_rsv;
    @FXML javafx.scene.control.TableColumn<Reservation,String> cn;
    @FXML javafx.scene.control.Button regler;
    ObservableList<Reservation> list= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        n_matr.setCellValueFactory(new PropertyValueFactory<Reservation,String>("matricule"));
        cn.setCellValueFactory(new PropertyValueFactory<Reservation,String>("cin"));
        datep.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_depart"));
        dater.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_retour"));
        cmt.setCellValueFactory(new PropertyValueFactory<Reservation,String>("commentaire"));
        date_rsv.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_reservation"));
        utilisateur utls=new utilisateur();
        ObservableList<Contrat> listC=utls.afficher_list_contrat();
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
                    list.add(reservation);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        tableV.setItems(list);
    }
    public void regler(ActionEvent event){
        Reservation reservation=(Reservation) tableV.getSelectionModel().getSelectedItem();
        if (reservation!=null){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
            try {
                Date dateR = simpleDateFormat.parse(reservation.getDate_retour());
                LocalDateTime ldtR = LocalDateTime.ofInstant(dateR.toInstant(),ZoneId.systemDefault());
                long noOfDaysBetween = DAYS.between(ldtR,ldt);
                if (noOfDaysBetween>0){
                    utilisateur utls=new utilisateur();
                    Facture facture=utls.chercher_facture(reservation.getMatricule());
                    facture.setM_paye((Double)(facture.getM_paye()+noOfDaysBetween*2000));
                    utls.modifier_facture(facture);
                    list.remove(reservation);
                    JOptionPane.showMessageDialog(null,"Opération effectué:N'oublliez pas de supprimer ou modifier la date de retour de cette réservation!!");
                    JOptionPane.showMessageDialog(null,"Si vous voulez changer la date de retour de cette réservation faire attention à la date du contrat!!");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }else JOptionPane.showMessageDialog(null,"Selectionez une réservation!!");
    }
}
