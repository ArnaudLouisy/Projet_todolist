package appli;

import java.sql.*;

public class Employe {
    private String nom;
    private String prenom;
    private String username;
    private String service;
    private String fonction;
    private String mot_de_passe;
    private boolean estConnecte = false;

    public Employe(String nom, String prenom, String username, String service, String fonction, String mot_de_passe) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.service = service;
        this.fonction = fonction;
        this.mot_de_passe = mot_de_passe;
    }

    public void connexion() throws SQLException, SQLException {

        Connection cnx = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/todo_list?serverTimezone=UTC",
                "root",
                ""
        );

        PreparedStatement maRequete = cnx.prepareStatement("Select * from employe where username=? and mot_de_passe=? ");
        maRequete.setString(1,username);
        maRequete.setString(2,mot_de_passe);

        ResultSet mesResultas = maRequete.executeQuery();

        while (estConnecte=false) {
            if (mesResultas.next()) {
                System.out.println("Vous etes connecté");
                estConnecte = true;
            } else {
                System.out.println("loging ou mot de passe incorrecte veillez ");
                estConnecte = false;
            }
        }
    }

    public void inscrire() throws SQLException {

        Connection cnx = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/todo_list?serverTimezone=UTC",
                "root",
                ""
        );

        PreparedStatement maRequeteVerifie = cnx.prepareStatement("Select * from employe where username=? and mot_de_passe=? ");
        maRequeteVerifie.setString(1,username);
        maRequeteVerifie.setString(2,mot_de_passe);

        ResultSet mesResultas = maRequeteVerifie.executeQuery();

        if (mesResultas.next()){
            System.out.println("Un compte existe déjà au nom de : "+this.nom+" "+this.prenom+".");
        }

        else {
            PreparedStatement maRequete = cnx.prepareStatement("Insert into employe (nom,prenom,username,service,fonction,mot_de_passe) VALUES (?,?,?,?,?,?)");
            maRequete.setString(1,this.nom);
            maRequete.setString(2,this.prenom);
            maRequete.setString(3,this.username);
            maRequete.setString(4,this.service);
            maRequete.setString(5,this.fonction);
            maRequete.setString(6,this.mot_de_passe);

            maRequete.executeUpdate();
        }
    }

    public void modifier() throws SQLException {
        Connection cnx = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/todo_list?serverTimezone=UTC",
                "root",
                ""
        );

        PreparedStatement maRequete = cnx.prepareStatement("update employe set nom = ?,prenom = ?,username = ?,service = ?,fonction = ?,mot_de_passe = ?");

        maRequete.setString(1,this.nom);
        maRequete.setString(2,this.prenom);
        maRequete.setString(3,this.username);
        maRequete.setString(4,this.service);
        maRequete.setString(5,this.fonction);
        maRequete.setString(6,this.mot_de_passe);

        maRequete.executeUpdate();
    }

    public void suprimer() throws SQLException {
        Connection cnx = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/todo_list?serverTimezone=UTC",
                "root",
                ""
        );

        PreparedStatement maRequete = cnx.prepareStatement("delete from employe where nom=? and prenom=?");
        maRequete.setString(1,this.nom);
        maRequete.setString(2,this.prenom);

        maRequete.executeUpdate();
    }
}


