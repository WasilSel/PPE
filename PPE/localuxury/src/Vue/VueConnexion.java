package Vue;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.C_Client;
import controleur.localuxury;
import controleur.Client;

public class VueConnexion extends JFrame implements ActionListener, KeyListener{
	
	private JTextField txtEmail = new JTextField("william.leite@gmail.com");
	private JPasswordField txtMdp = new JPasswordField("000");
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btSeConnecter = new JButton("Se Connecter");
	private JPanel panelConnexion = new JPanel();
	
	// Client connecter en static 
	private static Client unClientConnecte = null;
	
	public static Client getClient ()
	{
		return unClientConnecte;
	}
	
	public VueConnexion ()
	{
		this.setTitle("Gestion des localuxury");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(100, 100, 600, 300);
		this.getContentPane().setBackground(new Color(234,176,69));
		this.setLayout(null);
		
		// Installation de l'image
		ImageIcon uneImage = new ImageIcon("src/images/logo.png");
		JLabel unLabel =  new JLabel(uneImage);
		unLabel.setBounds(20, 40, 200, 200);
		this.add(unLabel);
		
		// Installation du panel connexion
		this.panelConnexion.setBounds(260, 40, 280, 200);
		this.panelConnexion.setBackground(new Color(234,176,69));
		this.panelConnexion.setLayout(new GridLayout(3,2)); // 3 lignes, 2 colonnes
		this.panelConnexion.add(new JLabel("Email :"));
		this.panelConnexion.add(this.txtEmail);
		this.panelConnexion.add(new JLabel("Mot de passe :"));
		this.panelConnexion.add(this.txtMdp);
		this.panelConnexion.add(this.btAnnuler);
		this.panelConnexion.add(this.btSeConnecter);
		this.add(this.panelConnexion);
		
		// Rendre les boutons cliquables
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		// Rendre les txt écoutables
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btAnnuler)
		{
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		} else if (e.getSource() == this.btSeConnecter)
		{
			this.traitement();
		}
	}
	
	public void traitement () 
	{
		String email = this.txtEmail.getText();
		String mdp = new String (this.txtMdp.getPassword());
		// Vérification dans la base de données
		unClientConnecte = C_Client.selectWhereClient(email, mdp);
		if (unClientConnecte == null)
		{
			JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants");
		} else {
			JOptionPane.showMessageDialog(this, "Bienvenue "+unClientConnecte.getNom() + " " + unClientConnecte.getPrenom());
			
			// Ouverture de la JFrame Générale
			localuxury.rendreVisibleVueConnexion(false);
			localuxury.rendreVisibleVueGenerale(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Gestion de la frappe de touche
		if (e.getKeyCode() == KeyEvent.VK_ENTER) // Touche entrée
		{
			this.traitement();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
