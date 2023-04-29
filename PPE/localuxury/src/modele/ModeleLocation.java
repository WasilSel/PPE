package modele;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Location;

public class ModeleLocation {
    private static Bdd uneBdd = new Bdd("localhost:8889", "localuxury", "root", "root");

    public static void insertLocation(Location uneLocation) {
        String requete = "INSERT INTO Location VALUES ( null,'"
                + uneLocation.getDate_debut() + "','"
                + uneLocation.getDate_fin() + "','"
                + uneLocation.getPrix_total() + "','"
                + uneLocation.getReduction() + "','"
                + uneLocation.getMode_paiement() + "','"
                + uneLocation.getCaution() + "','"
                + uneLocation.getIdvehicule() + "','"
                + uneLocation.getIdclient() + "')";
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

    public static void updateLocation(Location uneLocation) {
        String requete = "UPDATE Location SET"
                + " date_debut = '" + uneLocation.getDate_debut() + "',"
                + " date_fin = '" + uneLocation.getDate_fin() + "',"
                + " prix_total = '" + uneLocation.getPrix_total() + "',"
                + " reduction = '" + uneLocation.getReduction() + "',"
                + " mode_paiement = '" + uneLocation.getMode_paiement() + "',"
                + " caution = '" + uneLocation.getCaution() + "',"
                + " idvehicule = '" + uneLocation.getIdvehicule() + "',"
                + " idclient = '" + uneLocation.getIdclient() + "'"
                + " WHERE idlocation = " + uneLocation.getIdlocation() + ";";
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

    public static void deleteLocation(int idLocation) {
        String requete = "DELETE FROM Location WHERE idinter = " + idLocation + ";";
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

    public static ArrayList<Location> selectAllLocations() {
        ArrayList<Location> lesLocations = new ArrayList<Location>();
        String requete = "SELECT * FROM Location;";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation des Locations
            java.sql.ResultSet desResultats = unStat.executeQuery(requete);
            // on parcours les resultats et on instancie les Locations
            while (desResultats.next()) {
                Location uneLocation = new Location(
                        desResultats.getInt("idlocation"),
                        desResultats.getString("date_debut"),
                        desResultats.getString("date_fin"),
                        desResultats.getString("prix_total"),
                        desResultats.getString("reduction"),
                        desResultats.getString("mode_paiement"),
                        desResultats.getString("caution"),
                        desResultats.getInt("vehicule_id"),
                        desResultats.getInt("client_id"));
                // on ajoute l'Location dans l'ArrayList
                lesLocations.add(uneLocation);
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return lesLocations;
    }

    public static Location selectWhereLocation(int idLocation) {
        Location uneLocation = new Location();
        String requete = "SELECT * FROM Location WHERE idinter = " + idLocation + ";";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation une seul Location
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un resultat
            if (unResultat.next()) {
                uneLocation = new Location(
                        unResultat.getInt("idlocation"),
                        unResultat.getString("date_debut"),
                        unResultat.getString("date_fin"),
                        unResultat.getString("prix_total"),
                        unResultat.getString("reduction"),
                        unResultat.getString("mode_paiement"),
                        unResultat.getString("caution"),
                        unResultat.getInt("vehicule_id"),
                        unResultat.getInt("client_id"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return uneLocation;
    }
    
    public static Location selectWhereLocation(String materiel) {
        Location uneLocation = new Location();
        String requete = "SELECT * FROM Location WHERE materiel ='"+materiel+"';";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation une seul Location
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un resultat
            if (unResultat.next()) {
                uneLocation = new Location(
                        unResultat.getInt("idlocation"),
                        unResultat.getString("date_debut"),
                        unResultat.getString("date_fin"),
                        unResultat.getString("prix_total"),
                        unResultat.getString("reduction"),
                        unResultat.getString("mode_paiement"),
                        unResultat.getString("caution"),
                        unResultat.getInt("vehicule_id"),
                        unResultat.getInt("client_id"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return uneLocation;
    }
}