package controleur;

public class Client 
{
	private int idclient; 
	private String nom, prenom, email, mdp, role, adresse, numero_telephone ;
	
	public Client(int idclient, String nom, String prenom, String email, String mdp, String role, String adresse, String numero_telephone ) {
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.role = role;
		this.adresse = adresse;
		this.numero_telephone = numero_telephone;
	}
	
	public Client(String nom, String prenom, String email, String mdp, String role, String adresse, String numero_telephone) {
		this.idclient = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.role = role;
		this.adresse = adresse;
		this.numero_telephone = numero_telephone;
	}
	
	public Client() {
		this.idclient = 0;
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.mdp = "";
		this.role = "";
		this.adresse = "";
		this.numero_telephone = "";
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumero_telephone() {
		return numero_telephone;
	}

	public void setNumero_telephone(String numero_telephone) {
		this.numero_telephone = numero_telephone;
	}
	
}
