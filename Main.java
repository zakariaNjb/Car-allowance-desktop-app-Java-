package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("vehicle allowance");
        primaryStage.setScene(new Scene(root, 890, 350));
        primaryStage.setResizable(false);
        primaryStage.show();
        annuler_reservation_2j();
    }
    public static void main(String[] args) { launch(args); }

    public void annuler_reservation_2j(){
        utilisateur utls=new utilisateur();
        ObservableList<Reservation> list= utls.afficher_list_reservation_NV();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());
        for (int i=0;i<list.size();i++){
            Reservation reservation=list.get(i);
            try {
                Date dateP = simpleDateFormat.parse(reservation.getDate_depart());
                LocalDateTime ldtP = LocalDateTime.ofInstant(dateP.toInstant(),ZoneId.systemDefault());
                long noOfDaysBetween = DAYS.between(ldt,ldtP);
                if (noOfDaysBetween==2){
                     Vehicule vehicule=utls.chercher_vehicule(reservation.getMatricule());
                     reservation.setCommentaire("Réservation_annulée");
                     vehicule.setComment("Non_réservé/Deposé");
                     utls.modifier_reservation(reservation);
                     utls.modifier_vehicule(vehicule);
                }else continue;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}
