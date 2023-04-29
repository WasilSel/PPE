package controleur;

public class Location {
	private int idlocation;
	private String date_debut, date_fin, prix_total, reduction, mode_paiement, caution;
	private int idvehicule, idclient;
	
	public Location(int idLocation, String date_debut, String date_fin, String prix_total, String reduction, String mode_paiement, String caution, int idvehicule,
			int idclient) {
		
		this.idlocation = idLocation;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.prix_total = prix_total;
		this.reduction = reduction;
		this.mode_paiement = mode_paiement;
		this.caution = caution;
		this.idvehicule = idvehicule;
		this.idclient = idclient;
	}
	
	public Location (String date_debut, String date_fin, String prix_total, String reduction, String mode_paiement, String caution, int idvehicule,
			int idclient) {
		
		this.idlocation = 0;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.prix_total = prix_total;
		this.reduction = reduction;
		this.mode_paiement = mode_paiement;
		this.caution = caution;
		this.idvehicule = idvehicule;
		this.idclient = idclient;
	}
	
	public Location() {
		
		this.idlocation = 0;
		this.date_debut = "";
		this.date_fin = "";
		this.prix_total = "";
		this.reduction = "";
		this.mode_paiement = "";
		this.caution = "";
		this.idvehicule = 0;
		this.idclient = 0;
	}

	public int getIdlocation() {
		return idlocation;
	}

	public void setIdlocation(int idlocation) {
		this.idlocation = idlocation;
	}

	public String getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	public String getPrix_total() {
		return prix_total;
	}

	public void setPrix_total(String prix_total) {
		this.prix_total = prix_total;
	}

	public String getReduction() {
		return reduction;
	}

	public void setReduction(String reduction) {
		this.reduction = reduction;
	}
	
	public String getMode_paiement() {
		return mode_paiement;
	}

	public void setMode_paiement(String mode_paiement) {
		this.mode_paiement = mode_paiement;
	}
	
	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}
	

	public int getIdvehicule() {
		return idvehicule;
	}

	public void setIdvehicule(int idvehicule) {
		this.idvehicule = idvehicule;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	
	
	
	
}
