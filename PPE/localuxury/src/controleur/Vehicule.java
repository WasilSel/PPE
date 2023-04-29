package controleur;

public class Vehicule {
	private int idvehicule;
	private String marque, modele, annee, caracteristique, statut, prix_journalier, caution, puissance, nb_places;


	public Vehicule(int idvehicule, String marque, String modele, String annee, String caracteristique, String prix_journalier, String caution, String puissance, String nb_places, String statut) {
		this.idvehicule = idvehicule;
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.caracteristique = caracteristique;
		this.prix_journalier = prix_journalier;
		this.caution = caution;
		this.puissance = puissance;
		this.nb_places = nb_places;
		this.statut = statut;

		
}

	public Vehicule(String marque, String modele, String annee, String caracteristique, String prix_journalier, String caution, String puissance, String nb_places, String statut) {
		this.idvehicule = 0;
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.caracteristique = caracteristique;
		this.prix_journalier = prix_journalier;
		this.caution = caution;
		this.puissance = puissance;
		this.nb_places = nb_places;
		this.statut = statut;

		
}

	public Vehicule() {
		this.idvehicule = 0;
		this.marque = "";
		this.modele = "";
		this.annee = "";
		this.caracteristique = "";
		this.prix_journalier = "";
		this.caution = "";
		this.puissance = "";
		this.nb_places = "";
		this.statut = "";

		
}


	public int getIdvehicule() {
		return idvehicule;
	}

	public void setIdvehicule(int idvehicule) {
		this.idvehicule = idvehicule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}
	
	public String getPrix_journalier() {
		return prix_journalier;
	}

	public void setPrix_journalier(String prix_journalier) {
		this.prix_journalier = prix_journalier;
	}
	
	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}
	
	public String getPuissance() {
		return puissance;
	}

	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}
	
	
	public String getNb_places() {
		return nb_places;
	}

	public void setNb_places(String nb_places) {
		this.nb_places = nb_places;
	}
	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
}
