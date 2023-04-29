package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.localuxury;

public class VueGenerale extends JFrame implements ActionListener{

	private JPanel panelMenu = new JPanel ();
	private JButton btProfil = new JButton("Profil");
	private JButton btVehicules = new JButton("Vehicules");
	private JButton btClients = new JButton("Clients");
	private JButton btLocations = new JButton("Locations");
	private JButton btStats = new JButton("Statistiques");
	private JButton btQuitter = new JButton("Quitter");
	
	// Liste des Panels
	private PanelProfil unPanelProfil = new PanelProfil();
	private PanelVehicules unPanelVehicules = new PanelVehicules();
	private PanelClients unPanelClients = new PanelClients();
	private PanelLocations unPanelLocations = new PanelLocations();
	private PanelStats unPanelStats = new PanelStats();
	
	public VueGenerale ()
	{
		this.setTitle("Gestion des Locations localuxury");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(100, 100, 900, 500);
		this.getContentPane().setBackground(new Color(234,176,69));
		this.setLayout(null);
		
		// Installation  du Panel Menu
		this.panelMenu.setBounds(50, 20, 800, 30);
		this.panelMenu.setBackground(new Color (243, 176, 69));
		this.panelMenu.setLayout(new GridLayout(1,6));
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btVehicules);
		this.panelMenu.add(this.btClients);
		this.panelMenu.add(this.btLocations);
		this.panelMenu.add(this.btStats);
		this.panelMenu.add(this.btQuitter);
		
		this.add(this.panelMenu);
		
		// Rendre les boutons écoutables
		this.btVehicules.addActionListener(this);
		this.btLocations.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btStats.addActionListener(this);
		this.btProfil.addActionListener(this);
		this.btQuitter.addActionListener(this);
				
		// Ajout des Panels dans la fenêtre
		this.add(this.unPanelProfil);
		this.add(this.unPanelVehicules);
		this.add(this.unPanelClients);
		this.add(this.unPanelLocations);
		this.add(this.unPanelStats);
				
		this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btQuitter)
		{
			int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application Orange ?", 
					"Quitter l'application", JOptionPane.YES_NO_OPTION);
			if (retour == 0) {
				localuxury.rendreVisibleVueGenerale(false);
				localuxury.rendreVisibleVueConnexion(true);
			}
		}
		else if (e.getSource() == this.btProfil)
		{
			this.afficherPanel(1);
		}
		else if (e.getSource() == this.btVehicules)
		{
			this.afficherPanel(2);
		}
		else if (e.getSource() == this.btClients)
		{
			this.afficherPanel(3);
		}
		else if (e.getSource() == this.btLocations)
		{
			this.afficherPanel(4);
		}
		else if (e.getSource() == this.btStats)
		{
			this.afficherPanel(5);
		}	
	}
	
	public void afficherPanel (int numero)
	{
		this.unPanelProfil.setVisible(false);
		this.unPanelVehicules.setVisible(false);
		this.unPanelClients.setVisible(false);
		this.unPanelLocations.setVisible(false);
		this.unPanelStats.setVisible(false);
		
		switch (numero) 
		{
		case 1 :
			this.unPanelProfil.setVisible(true);break;
		case 2 :
			this.unPanelVehicules.setVisible(true);break;
		case 3 :
			this.unPanelClients.setVisible(true);break;
		case 4 :
			this.unPanelLocations.setVisible(true);break;
		case 5 :
			this.unPanelStats.setVisible(true);break;
		}
	}
}
