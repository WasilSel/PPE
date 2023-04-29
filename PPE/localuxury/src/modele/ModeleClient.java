package modele;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;

public class ModeleClient {
    private static Bdd uneBdd = new Bdd("localhost:8889", "localuxury", "root", "root");

    public static void insertClient(Client unClient) {
        String requete = "INSERT INTO Client VALUES ( null,'"
                + unClient.getNom() + "', '"
                + unClient.getPrenom() + "', '"
                + unClient.getEmail() + "', '"
                + unClient.getMdp() + "', '"
                + unClient.getRole() + "', '"
                + unClient.getAdresse() + "', '"

                + unClient.getMdp() + "');";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
    }

    public static void updateClient(Client unClient) {
        String requete = "UPDATE Client SET "
                + " nom = '" + unClient.getNom() + "', "
                + " prenom = '" + unClient.getPrenom() + "', "
                + " email = '" + unClient.getEmail() + "', "
                + " mdp = '" + unClient.getMdp() + "', "
                + " role = '" + unClient.getRole() + "' "
                + " adresse = '" + unClient.getAdresse() + "', "
                + " numéro_telephone = '" + unClient.getNumero_telephone() + "', "


                + " WHERE idClient = " + unClient.getIdclient() + ";";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
    }

    public static void deleteClient(int idClient) {
        String requete = "DELETE FROM Client WHERE idClient = " + idClient + ";";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
    }

    public static ArrayList<Client> selectAllClient() {
        ArrayList<Client> lesClients = new ArrayList<Client>();
        String requete = "SELECT * FROM Client;";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation des Clients
            java.sql.ResultSet desResultats = unStat.executeQuery(requete);
            // on parcours les resultats et on instancie les Clients
            while (desResultats.next()) {
                Client unClient = new Client(
                        desResultats.getInt("idClient"),
                        desResultats.getString("nom"),
                        desResultats.getString("prenom"),
                        desResultats.getString("adresse"),
                        desResultats.getString("email"),
                        desResultats.getString("mdp"),
                        desResultats.getString("role"),
                        desResultats.getString("numero_telephone"));
                // on ajoute le Client dans l'ArrayList
                lesClients.add(unClient);
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return lesClients;
    }

    public static Client selectWhereClient(int idClient) {
        Client unClient = null;
        String requete = "SELECT * FROM Client WHERE idClient = " + idClient + ";";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation un seul Client
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un résultat
            if (unResultat.next()) {
                unClient = new Client(
                        unResultat.getInt("idClient"),
                        unResultat.getString("nom"),
                        unResultat.getString("prenom"),
                        unResultat.getString("adresse"),
                        unResultat.getString("email"),
                        unResultat.getString("mdp"),
                        unResultat.getString("role"),
                        unResultat.getString("numero_telephone"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return unClient;
    }
    
    public static Client selectWhereClient(String email, String mdp) {
        String requete = "SELECT * FROM Client WHERE email = '"+email+"' and mdp='"+mdp+"';";
        Client unClient = null;
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation un seul Client
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un résultat
            if (unResultat.next()) {
                unClient = new Client(
                        unResultat.getInt("idClient"),
                        unResultat.getString("nom"),
                        unResultat.getString("prenom"),
                        unResultat.getString("adresse"),
                        unResultat.getString("email"),
                        unResultat.getString("mdp"),
                        unResultat.getString("role"),
                        unResultat.getString("numero_telephone"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return unClient;
    }
}