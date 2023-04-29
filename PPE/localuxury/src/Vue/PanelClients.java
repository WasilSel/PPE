package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.C_Vehicule;
import controleur.C_Client;
import controleur.Vehicule;
import controleur.Tableau;
import controleur.Client;

public class PanelClients extends PanelPrincipal implements ActionListener
{
private JPanel panelForm = new JPanel();
	
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JTextField txtRole = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtNumero_telephone = new JTextField();
	
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	private JTable tableClients;
	private Tableau unTableau;
	
	public PanelClients ()
	{
		super();
		this.titre.setText("_____ Gestion des Clients _____");
		
		// Contruction du Panel Form
				this.panelForm.setBounds(20, 40, 350, 250);
				this.panelForm.setBackground(new Color (234, 176, 69));
				this.panelForm.setLayout(new GridLayout(8, 2));
				this.panelForm.add(new JLabel("Nom Client :"));
				this.panelForm.add(this.txtNom);
				this.panelForm.add(new JLabel("Prénom Client :"));
				this.panelForm.add(this.txtPrenom);
				this.panelForm.add(new JLabel("Email Client :"));
				this.panelForm.add(this.txtEmail);
				this.panelForm.add(new JLabel("Mot de passe :"));
				this.panelForm.add(this.txtMdp);
				this.panelForm.add(new JLabel("role Client :"));
				this.panelForm.add(this.txtRole);
				this.panelForm.add(new JLabel("Adresse Client :"));
				this.panelForm.add(this.txtAdresse);
				this.panelForm.add(new JLabel("numero Client :"));
				this.panelForm.add(this.txtNumero_telephone);
				this.panelForm.add(this.btAnnuler);
				this.panelForm.add(this.btEnregistrer);
				
				// Ajout du panelForm à au panelClients
				this.add(this.panelForm);
				
				// Construction de la JTable
				String entetes [] = {"ID Client", "Nom", "Prénom",  "Email", "Mdp", "Role", "Adresse", "Numero_telephone",};
				Object [][] donnees = this.getDonnees ();
				
				this.unTableau = new Tableau(donnees, entetes);
				this.tableClients = new JTable(this.unTableau);
				
				JScrollPane uneScroll = new JScrollPane(this.tableClients);
				uneScroll.setBounds(380, 80, 450, 210);
				this.add(uneScroll);
				
				// Rendre les boutons écoutables
				this.btAnnuler.addActionListener(this);
				this.btEnregistrer.addActionListener(this);
						
			}
	
	public Object [][] getDonnees ()
	{
		ArrayList<Client> lesClients = C_Client.selectAllClients();
		Object [][] matrice = new Object [lesClients.size()][8];
		int i=0;
		for (Client unClient : lesClients)
		{
			matrice[i][0] = unClient.getIdclient();
			matrice[i][1] = unClient.getNom();
			matrice[i][2] = unClient.getPrenom();
			matrice[i][3] = unClient.getEmail();
			matrice[i][4] = unClient.getMdp();
			matrice[i][5] = unClient.getRole();
			matrice[i][6] = unClient.getAdresse();
			matrice[i][7] = unClient.getNumero_telephone();

			i++;
		}
		return matrice;
	}
			
			public void viderChamps ()
			{
				this.txtNom.setText("");
				this.txtPrenom.setText("");
				this.txtEmail.setText("");
				this.txtMdp.setText("");
				this.txtRole.setText("");
				this.txtAdresse.setText("");
				this.txtNumero_telephone.setText("");

				
			}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps();
		}
		else if (e.getSource() == this.btEnregistrer)
		{
			String nom = this.txtNom.getText();
			String prenom = this.txtPrenom.getText();
			String email = this.txtEmail.getText();
			String mdp = new String(this.txtMdp.getPassword());
			String role = this.txtRole.getText();
			String adresse = this.txtAdresse.getText();
			String numero_telephone = this.txtNumero_telephone.getText();

			
			// Instancier un client
			Client unClient = new Client(nom, prenom, email, mdp, role, adresse, numero_telephone);
			// On l'enregistre dans la base de données
			C_Client.insertClient(unClient);
			// Récupération de l'id client à partir de la BDD
			unClient = C_Client.selectWhereClient(email, mdp);
			// Ajout du client dans le tableau
			Object ligne[] = {unClient.getIdclient(), unClient.getNom(), unClient.getPrenom(),
					 unClient.getEmail(), unClient.getMdp(), unClient.getRole(), unClient.getNumero_telephone(), unClient.getAdresse()};
			this.unTableau.insertLigne(ligne);
			
			JOptionPane.showMessageDialog(this, "Client inséré avec succès !");
			this.viderChamps();
		}
	}
}
