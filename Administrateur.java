package sample;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrateur extends utilisateur{

    private String fullname;/**the initiale accounte of the administrateur***/
    private String password;/**the initiale accounte of the administrateur***/
    //getters and setters
    public String getFullname() {
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select nom_prenom from administrateur where id=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,"1");
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    this.fullname=resultSet.getString("nom_prenom");
                    preparedStatement.close();
                    resultSet.close();
                    return  this.fullname;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de données n'est pas effectué!!");
        return this.fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection. isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="update administrateur set nom_prenom=? where id=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,fullname);
                preparedStatement.setString(2,"1");
                preparedStatement.execute();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public String getPassword() {
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="select PASSWORD from administrateur where id=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,"1");
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    this.password=resultSet.getString("PASSWORD");
                    preparedStatement.close();
                    resultSet.close();
                    return  this.password;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de données n'est pas effectué!!");
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection. isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="update administrateur set PASSWORD=? where id=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,password);
                preparedStatement.setString(2,"1");
                preparedStatement.execute();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    //cherecher un utilisateur dans la base de donnee
    public boolean chercher_utilisateur(String CIN){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            String query="Select * from utilisateur where CIN=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,CIN);
                resultSet=preparedStatement.executeQuery();
                if(resultSet.next()) {
                    resultSet.close();
                    preparedStatement.close();
                    return true;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnée n'est pas effectuée!!!");
        return false;
    }
    //Ajouter un utilisateur au base ded donne
    public boolean ajouter_utilisateur(utilisateur utls){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            if(!chercher_utilisateur(utls.getCIN())){
                PreparedStatement preparedStatement=null;
                ResultSet resultSet=null;
                String query="insert into utilisateur(nom_prenom,CIN,salaire) values(?,?,?)";
                try {
                    preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                    preparedStatement.setString(1,utls.getFullname());
                    preparedStatement.setString(2,utls.getCIN());
                    preparedStatement.setString(3,String.valueOf(utls.getSalaire()));
                    preparedStatement.execute();
                    preparedStatement.close();
                    return true;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(null,"Ce utilisateur est déja exist!!! ");
                return false;
            }
        }else JOptionPane.showMessageDialog(null,"la connection avec la base de donnes n'est pas effectué!!!");
        return false;
    }
    //Supprimer un utilisateur dans la base donnee
    public boolean supprimer_utilisateur(utilisateur utls){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="delete from utilisateur where CIN=? and nom_prenom=?";
            if(chercher_utilisateur(utls.getCIN())){
                try {
                    preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                    preparedStatement.setString(1,utls.getCIN());
                    preparedStatement.setString(2,utls.getFullname());
                    preparedStatement.execute();
                    preparedStatement.close();
                    return true;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    return false;
                }
            }else JOptionPane.showMessageDialog(null,"Ce utilisateur n'est exist pas!!!");
        }else JOptionPane.showConfirmDialog(null,"la connection avec la base de donnees n'est pas effectuée!!");
        return false;
    }
    //modifier un utilisateur dans la base donnee
    public boolean modifier_utilisateur(utilisateur utls){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="update utilisateur set salaire=? where CIN=?";
            if(chercher_utilisateur(utls.getCIN())){
                try {
                    preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                    preparedStatement.setString(1,String.valueOf(utls.getSalaire()));
                    preparedStatement.setString(2,utls.getCIN());
                    preparedStatement.execute();
                    preparedStatement.close();
                    return true;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    return false;
                }
            }else JOptionPane.showMessageDialog(null,"Ce utilisateur n'est exist pas!!!");
        }else JOptionPane.showConfirmDialog(null,"la connection avec la base de donnees n'est pas effectuée!!");
        return false;
    }
    //suspendre un utilisateur
    public boolean suspendre_utilisateur(utilisateur utls){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="update utilisateur set compte=? where CIN=?";
            if(chercher_utilisateur(utls.getCIN())){
                try {
                    preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                    preparedStatement.setString(1,"non activé");
                    preparedStatement.setString(2,utls.getCIN());
                    preparedStatement.execute();
                    preparedStatement.close();
                    return true;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    return false;
                }
            }else JOptionPane.showMessageDialog(null,"Ce utilisateur n'est exist pas!!!");
        }else JOptionPane.showConfirmDialog(null,"la connection avec la base de donnees n'est pas effectuée!!");
        return false;
    }
    //activer le compte d'un utilisateur
    public boolean activer_compte_utilisateur(utilisateur utls){
        Sqlconnection sqlconnection=new Sqlconnection();
        if(sqlconnection.isDBconnected()){
            PreparedStatement preparedStatement=null;
            String query="update utilisateur set compte=? where CIN=?";
            try {
                preparedStatement=sqlconnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1,"activé");
                preparedStatement.setString(2,utls.getCIN());
                preparedStatement.execute();
                preparedStatement.close();
                return true;
                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(null,"Ce utilisateur n'est exist pas!!!");
                    //throwables.printStackTrace();
                    return false;
                }
        }else JOptionPane.showConfirmDialog(null,"la connection avec la base de donnees n'est pas effectuée!!");
        return false;
    }
}
