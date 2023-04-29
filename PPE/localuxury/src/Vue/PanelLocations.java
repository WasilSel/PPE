package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



import controleur.C_Vehicule;
import controleur.C_Location;
import controleur.C_Client;
import controleur.Location;
import controleur.Tableau;
import controleur.Client;
import controleur.Vehicule;

public class PanelLocations extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel ();
	
	private JTextField txtDate_debut = new JTextField();
	private JTextField txtDate_fin = new JTextField();
	private JTextField txtPrix_total = new JTextField();
	private JTextField txtReduction = new JTextField();
	private JTextField txtMode_paiement = new JTextField();
	private JTextField txtCaution = new JTextField();
	private JComboBox<String> cbxIdvehicule = new JComboBox<String>();
	private JComboBox<String> cbxIdclient = new JComboBox<String>();
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	private JTable tableLocations;
	private Tableau unTableau;
	
	
	public PanelLocations ()
	{
		super();
		this.titre.setText("_____ Gestion des Locations _____");
		
		this.panelForm.setBounds(20, 40, 300, 250);
		this.panelForm.setBackground(new Color (234, 176, 69));
		this.panelForm.setLayout(new GridLayout(9, 2));
		this.panelForm.add(new JLabel("date_debut :"));
		this.panelForm.add(this.txtDate_debut);
		this.panelForm.add(new JLabel("date_fin :"));
		this.panelForm.add(this.txtDate_fin);
		this.panelForm.add(new JLabel("prix_total :"));
		this.panelForm.add(this.txtPrix_total);
		this.panelForm.add(new JLabel("reduction :"));
		this.panelForm.add(this.txtReduction);
		this.panelForm.add(new JLabel("mode_paiement :"));
		this.panelForm.add(this.txtMode_paiement); 
		this.panelForm.add(new JLabel("caution :"));
		this.panelForm.add(this.txtCaution); 
		this.panelForm.add(new JLabel("Le Vehicule :"));
		this.panelForm.add(this.cbxIdvehicule);
		this.panelForm.add(new JLabel("Le Client :"));
		this.panelForm.add(this.cbxIdclient);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		
		// Ajout du panelForm à au panelVehicules
		this.add(this.panelForm);
		
		// Remplir les CBX IdVehicules et IdClient
		this.remplirCBX ();
		
		// Construction de la JTable
		String entetes [] = {"Idlocation","date_debut", "date_fin", "prix_total", "reduction", "mode_paiement", "caution","vehicule", "client"};
		Object [][] donnees = this.getDonnees ();
		
		this.unTableau = new Tableau(donnees, entetes);
		this.tableLocations = new JTable(this.unTableau);
					
		JScrollPane uneScroll = new JScrollPane(this.tableLocations);
		uneScroll.setBounds(380, 80, 450, 210);
		this.add(uneScroll);

// Rendre les boutons écoutables
this.btAnnuler.addActionListener(this);
this.btEnregistrer.addActionListener(this);
				
	}
	
	public Object [][] getDonnees ()
	{
		ArrayList<Location> lesLocations = C_Location.selectAllLocations();
		Object [][] matrice = new Object [lesLocations.size()][9];
		int i=0;
		for (Location uneLocation : lesLocations)
		{
			matrice[i][0] = uneLocation.getIdlocation();
			matrice[i][1] = uneLocation.getDate_debut();
			matrice[i][2] = uneLocation.getDate_fin();
			matrice[i][3] = uneLocation.getPrix_total();
			matrice[i][4] = uneLocation.getReduction();
			matrice[i][5] = uneLocation.getMode_paiement();
			matrice[i][6] = uneLocation.getCaution();
			matrice[i][7] = uneLocation.getIdvehicule();
			matrice[i][8] = uneLocation.getIdclient();
			i++;
		}
		return matrice;
	}
	
	public void remplirCBX ()
	{
		
		// Supprimer ou vider le CBX idvehicule
		this.cbxIdvehicule.removeAllItems();
		// Récupérer de la base de données tous les vehicules
		ArrayList<Vehicule> lesVehicules = C_Vehicule.selectAllVehicules();
		// Parcourir lesClients et remplir le CBX
		for(Vehicule unVehicule : lesVehicules)
		{
			this.cbxIdvehicule.addItem(unVehicule.getIdvehicule() +"-"+unVehicule.getMarque() +"-"+unVehicule.getMarque());
		}
		
		// Supprimer ou vider le CBX idclient
		this.cbxIdclient.removeAllItems();
		// Récupérer de la base de données tous les clients
		ArrayList<Client> lesClients = C_Client.selectAllClients();
		// Parcourir lesClients et remplir le CBX
		for(Client unClient : lesClients)
		{
			this.cbxIdclient.addItem(unClient.getIdclient() +"-"+unClient.getNom() +"-"+unClient.getPrenom());
		}
	}
	
	public void viderChamps ()
	{
		this.txtDate_debut.setText("");
		this.txtDate_fin.setText("");
		this.txtPrix_total.setText("");
		this.txtReduction.setText("");
		this.txtMode_paiement.setText("");
		this.txtCaution.setText("");
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps();
		}
		else if (e.getSource() == this.btEnregistrer)
		{
			String date_debut = this.txtDate_debut.getText();
			String date_fin = this.txtDate_fin.getText();
			String prix_total = this.txtPrix_total.getText();
			String reduction = this.txtReduction.getText();
			String mode_paiement = this.txtMode_paiement.getText();
			String caution = this.txtCaution.getText();

			// Récupérer les id client et vehicule
			String chaine = this.cbxIdvehicule.getSelectedItem().toString();
			String tab [] = chaine.split("-"); // Explode de PHP
			int idvehicule = Integer.parseInt(tab[0]);
			
			chaine = this.cbxIdclient.getSelectedItem().toString();
			tab = chaine.split("-"); // Explode de PHP
			int idclient = Integer.parseInt(tab[0]);
			
			// Instancier un client
			Location uneLocation = new Location(date_debut, date_fin, prix_total, reduction, mode_paiement, caution,  idvehicule, idclient);
			// On l'enregistre dans la base de données
			C_Location.insertLocation(uneLocation);
			
			// Récupération de l'id vehicule à partir de la BDD
			uneLocation = C_Location.selectWhereLocation(date_debut);
			
			// Ajout du vehicule dans le tableau
			Object ligne[] = { uneLocation.getIdlocation(), uneLocation.getDate_debut(), uneLocation.getDate_fin(), uneLocation.getPrix_total(),
					uneLocation.getReduction(), uneLocation.getMode_paiement(), uneLocation.getCaution(), uneLocation.getIdvehicule(), uneLocation.getIdclient()};
			this.unTableau.insertLigne(ligne);
			
			JOptionPane.showMessageDialog(this, "Location insérée avec succès !");
			this.viderChamps();
		}
	}
}
