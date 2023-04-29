package modele;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

import controleur.Vehicule;

public class ModeleVehicule
{	
	private static Bdd uneBdd =  new Bdd("localhost:8889","localuxury","root","root");
	
	public static void insertVehicule(Vehicule unVehicule)
	{
	       String requete = "INSERT INTO Vehicule VALUES ( null,'"
	                + unVehicule.getMarque() + "', '"
	                + unVehicule.getModele() + "', '"
	                + unVehicule.getAnnee() + "', '"
	                + unVehicule.getCaracteristique() + "', '"
	                + unVehicule.getPrix_journalier() + "', '" 
	                + unVehicule.getCaution() + "', '"
	                + unVehicule.getPuissance() + "', '"
	                + unVehicule.getNb_places() + "', '" 
	                + unVehicule.getStatut() + "');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			uneBdd.seDeconnecter();
		}
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
		}
	}
	public static void deleteVehicule (int idVehicule)
	{
		String requete = "delete from Vehicule where idVehicule="+idVehicule+";";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			uneBdd.seDeconnecter();
		}
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
		}
	}
	public static void updateVehicule(Vehicule unVehicule)
	{
        String requete = "UPDATE Vehicule SET "
                + " marque = '" + unVehicule.getMarque() + "', "
                + " modele = '" + unVehicule.getModele() + "', "
                + " annee = '" + unVehicule.getAnnee() + "', "
                + " caracteristique = '" + unVehicule.getCaracteristique() + "', "
                + " prix_journalier = '" + unVehicule.getPrix_journalier() + "', "
                + " caution = '" + unVehicule.getCaution() + "', "
                + " nb_places = '" + unVehicule.getNb_places() + "', "
                + " statut = '" + unVehicule.getStatut() + "', "

               
                + " WHERE idvehicule = " + unVehicule.getIdvehicule() + ";";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			uneBdd.seDeconnecter();
		}
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
		}
	}
	public static ArrayList<Vehicule> selectAllVehicule ()
	{
		String requete = "SELECT * FROM Vehicule;";
		ArrayList<Vehicule> lesVehicules = new ArrayList<Vehicule>();
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation des Vehicules resultats
			ResultSet desResultats = unStat.executeQuery(requete);
			// on parcours les resultats et on instancie les Vehicules et enfin on les ajoute dans l'ArrayList
			while (desResultats.next())
			{
                Vehicule unVehicule = new Vehicule(
                        desResultats.getInt("idvehicule"),
                        desResultats.getString("marque"),
                        desResultats.getString("modele"),
                        desResultats.getString("annee"),
                        desResultats.getString("caracteristiques"),
                        desResultats.getString("prix_journalier"),
                        desResultats.getString("caution"),
                        desResultats.getString("puissance"),
                        desResultats.getString("nb_places"),
                        desResultats.getString("statut"));


                // on ajoute le Vehicule dans l'ArrayList
                lesVehicules.add(unVehicule);
				
		// on ajoute le Vehicule dans l'ArrayList
				lesVehicules.add(unVehicule);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
		}
		return lesVehicules;
	}
	public static Vehicule selectWhereVehicule(int idVehicule)
	{
		String requete = "select * from Vehicule where idVehicule="+idVehicule+";";
		Vehicule unVehicule = null;
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation un seul Vehicule resultat
			ResultSet unResultat = unStat.executeQuery(requete);
			// on teste si on a un seul resultat 
			if (unResultat.next())
			{
                unVehicule = new Vehicule(
                        unResultat.getInt("idvehicule"),
                        unResultat.getString("marque"),
                        unResultat.getString("Modele"),
                        unResultat.getString("annee"),
                        unResultat.getString("caracteristique"),
                        unResultat.getString("prix_journalier"),
                        unResultat.getString("caution"),
                        unResultat.getString("puissance"),
                        unResultat.getString("nb_places"),
                        unResultat.getString("statut"));
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
		}
		return unVehicule;
	}
	public static Vehicule selectWhereVehicule(String modele)
	{
		String requete = "select * from Vehicule where modele='"+modele+"';";
		Vehicule unVehicule = null;
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation un seul Vehicule resultat
			ResultSet unResultat = unStat.executeQuery(requete);
			// on teste si on a un seul resultat 
			if (unResultat.next())
			{
                unVehicule = new Vehicule(
                        unResultat.getInt("idvehicule"),
                        unResultat.getString("marque"),
                        unResultat.getString("Modele"),
                        unResultat.getString("annee"),
                        unResultat.getString("caracteristique"),
                        unResultat.getString("prix_journalier"),
                        unResultat.getString("caution"),
                        unResultat.getString("puissance"),
                        unResultat.getString("nb_places"),
                        unResultat.getString("statut"));
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
		}
		return unVehicule;
	}
}
