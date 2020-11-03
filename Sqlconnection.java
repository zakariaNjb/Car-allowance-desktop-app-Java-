package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlconnection {
    private Connection connection;
    public Connection getConnection() { return connection; }
    public Sqlconnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection= DriverManager.getConnection("jdbc:sqlite:alocation_vehicule.db");
        } catch (ClassNotFoundException | SQLException e) {
            //e.printStackTrace();
        }
    }
    public boolean isDBconnected(){
        if(connection==null) return false;
        else return true;
    }
}
