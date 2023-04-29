package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.C_Client;
import controleur.Client;

public class PanelProfil extends PanelPrincipal implements ActionListener
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
	
	// textArea : pour les infos du Client
	private JTextArea txtInfos = new JTextArea();
	
	private JButton btModifier = new JButton("Modifier");
	private Client unT;
	
	public PanelProfil () 
	{
		super();
		this.titre.setText("_____ MON PROFIL _____");
		
		// Contruction du Panel Form
		this.panelForm.setBounds(450, 40, 350, 250);
		this.panelForm.setBackground(new Color (234, 176, 69));
		this.panelForm.setLayout(new GridLayout(8, 2));
		this.panelForm.add(new JLabel("Nom client :"));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Prénom client :"));
		this.panelForm.add(this.txtPrenom);
		this.panelForm.add(new JLabel("Email client :"));
		this.panelForm.add(this.txtEmail);
		this.panelForm.add(new JLabel("Mot de passe :"));
		this.panelForm.add(this.txtMdp);
		this.panelForm.add(new JLabel("role :"));
		this.panelForm.add(this.txtRole);
		this.panelForm.add(new JLabel(" Adresse :"));
		this.panelForm.add(this.txtAdresse);
		this.panelForm.add(new JLabel("numero_telephone :"));
		this.panelForm.add(this.txtNumero_telephone);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		
		// Ajout du panelForm à au panelClients
		this.add(this.panelForm);
		this.panelForm.setVisible(false);
		
		// Installation du TextArea
		this.txtInfos.setBounds(50, 40, 350, 200);
		this.txtInfos.setBackground(new Color(255, 176, 69));
		 this.unT = VueConnexion.getClient();
		
		this.txtInfos.setText("_____ INFOS PERSONNELLES _____\n"
				+ "NOM             : "+unT.getNom()+"\n"
				+ "PRENOM          : "+unT.getPrenom()+"\n"
				+ "EMAIL           : "+unT.getEmail()+"\n"
				+ "role            : "+unT.getRole()+"\n"
				+ "adresse         : "+unT.getAdresse()+"\n"
				+ "numero_telephone   : "+unT.getNumero_telephone()+"\n"

				);
		
		this.add(this.txtInfos);
		
		// Remplir les informations dans le formulaire 
		this.txtNom.setText(this.unT.getNom());
		this.txtPrenom.setText(this.unT.getPrenom());
		this.txtEmail.setText(this.unT.getEmail());
		this.txtRole.setText(this.unT.getRole());
		this.txtAdresse.setText(this.unT.getAdresse());
		this.txtNumero_telephone.setText(this.unT.getNumero_telephone());


		
		this.btModifier.setBounds(100, 280, 200, 20);
		this.add(this.btModifier);
		
		// Rendre les boutons écoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btModifier.addActionListener(this);
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
		if(e.getSource() == this.btModifier)
		{
			if(this.panelForm.isVisible())
			{
				this.panelForm.setVisible(false);
			} else {
				this.panelForm.setVisible(true);
			}
		}
		
		else if (e.getSource() == this.btAnnuler)
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
			this.unT = new Client(unT.getIdclient(), nom, prenom, email, mdp, role, adresse, numero_telephone);
			// On l'enregistre dans la base de données
			C_Client.updateClient(this.unT);
			
			JOptionPane.showMessageDialog(this, "Modification de votre profil effectuée avec succès !");
			
			this.txtInfos.setText("___________ INFOS PERSONNELLES _________\n\n"
                    + "NOM           : "+unT.getNom()  +"\n\n"
                    + "PRENOM        : "+unT.getPrenom() +"\n\n"
                    + "EMAIL         : "+unT.getEmail() + "\n"
                    + "role : "+unT.getRole() +"\n\n"
                    + "adresse : "+unT.getAdresse() +"\n\n"
                    + "numero_telephone : "+unT.getNumero_telephone() +"\n\n"

                    );
		}
	}
		
	}

