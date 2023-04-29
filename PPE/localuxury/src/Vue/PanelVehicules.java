package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import controleur.Vehicule;
import controleur.Tableau;

public class PanelVehicules extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel();
	
	private JTextField txtMarque = new JTextField();
	private JTextField txtModele = new JTextField();
	private JTextField txtAnnee = new JTextField();
	private JTextField txtCaracteristique = new JTextField();
	private JTextField txtPrix_journalier = new JTextField();
	private JTextField txtCaution = new JTextField();
	private JTextField txtPuissance = new JTextField();
	private JTextField txtNb_places = new JTextField();
    private JComboBox<String> cbStatut = new JComboBox<String>();


	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	private JTable tableVehicules;
	private Tableau unTableau;
	
	public PanelVehicules ()
	{
		super();
		this.titre.setText("_____ Gestion des Vehicules _____");
		
		// Contruction du Panel Form
		this.panelForm.setBounds(20, 40, 350, 250);
		this.panelForm.setBackground(new Color (234, 176, 69));
		this.panelForm.setLayout(new GridLayout(10,2));
		this.panelForm.add(new JLabel("modele vehicule :"));
		this.panelForm.add(this.txtModele);
		this.panelForm.add(new JLabel("Marque vehicule :"));
		this.panelForm.add(this.txtMarque);
		this.panelForm.add(new JLabel("annee vehicule :"));
		this.panelForm.add(this.txtAnnee);
		this.panelForm.add(new JLabel("Caracteristique :"));
		this.panelForm.add(this.txtCaracteristique);
		this.panelForm.add(new JLabel("Prix_journalier  :"));
		this.panelForm.add(this.txtPrix_journalier);
		this.panelForm.add(new JLabel("caution  :"));
		this.panelForm.add(this.txtCaution);
		this.panelForm.add(new JLabel("puissance  :"));
		this.panelForm.add(this.txtPuissance);
		this.panelForm.add(new JLabel("nb_places  :"));
		this.panelForm.add(this.txtNb_places);
		this.panelForm.add(new JLabel("statut  :"));
		this.panelForm.add(this.cbStatut);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		
		// Ajout du panelForm à au panelVehicules
		this.add(this.panelForm);
		
		
		
		this.cbStatut.addItem("disponible"); 
		this.cbStatut.addItem("indisponible"); 

		// Construction de la JTable
		String entetes [] = {"Idvehicule", "modele", "marque", "annee", "caracteristique", "prix_journalier", "caution", "puissance", "nb_places", "statut"};
		Object [][] donnees = this.getDonnees ();
		
		this.unTableau = new Tableau(donnees, entetes);
		this.tableVehicules = new JTable(this.unTableau);
		
		JScrollPane uneScroll = new JScrollPane(this.tableVehicules);
		uneScroll.setBounds(380, 80, 450, 210);
		this.add(uneScroll);
		
		// Implémenter de la suppression // Modification d'une ligne Vehicule
		this.tableVehicules.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int numLigne = tableVehicules.getSelectedRow();
				int idVehicule = Integer.parseInt(tableVehicules.getValueAt(numLigne, 0).toString());
				if(e.getClickCount() >=2)
				{
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce Vehicule ?", "Suppression Vehicule", JOptionPane.YES_NO_OPTION);
					if(retour == 0 ) 
					{
						C_Vehicule.deleteVehicule(idVehicule);
						unTableau.deleteLigne(numLigne);
						JOptionPane.showMessageDialog(null, "Suppression effectuée avec succès !");
					}
				}
				else if (e.getClickCount() == 1)
				{
					// On remplie les champs pour la modification
					txtModele.setText(tableVehicules.getValueAt(numLigne, 1).toString());
					txtMarque.setText(tableVehicules.getValueAt(numLigne, 2).toString());
					txtAnnee.setText(tableVehicules.getValueAt(numLigne, 3).toString());
					txtCaracteristique.setText(tableVehicules.getValueAt(numLigne, 4).toString());
					txtPrix_journalier.setText(tableVehicules.getValueAt(numLigne, 5).toString());
					txtCaution.setText(tableVehicules.getValueAt(numLigne, 6).toString());
					//cbPuissance.setText(tableVehicules.getValueAt(numLigne, 7).toString());
					txtNb_places.setText(tableVehicules.getValueAt(numLigne, 8).toString());
					//cbStatut.setText(tableVehicules.getValueAt(numLigne, 9).toString());


					btEnregistrer.setText("Modifier");
				}
				
			}
		});
		
		// Rendre les boutons écoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
				
	}
	
	public Object [][] getDonnees ()
	{
		ArrayList<Vehicule> lesVehicules = C_Vehicule.selectAllVehicules();
		Object [][] matrice = new Object [lesVehicules.size()][10];
		int i=0;
		for (Vehicule unVehicule : lesVehicules)
		{
			matrice[i][0] = unVehicule.getIdvehicule();
			matrice[i][1] = unVehicule.getMarque();
			matrice[i][2] = unVehicule.getModele();
			matrice[i][3] = unVehicule.getAnnee();
			matrice[i][4] = unVehicule.getCaracteristique();
			matrice[i][5] = unVehicule.getPrix_journalier();
			matrice[i][6] = unVehicule.getCaution();
			matrice[i][7] = unVehicule.getPuissance();
			matrice[i][8] = unVehicule.getNb_places();
			matrice[i][9] = unVehicule.getStatut();


			i++;
		}
		return matrice;
	}
	
	public void viderChamps ()
	{
		this.txtMarque.setText("");
		this.txtModele.setText("");
		this.txtAnnee.setText("");
		this.txtCaracteristique.setText("");
		this.txtPrix_journalier.setText("");

		this.txtCaution.setText("");
		//this.txtPuissance.setText("");
		this.txtNb_places.setText("");
		//this.txtStatut.setText("");

		this.btEnregistrer.setText("Modifier");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps();
		}
		else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer"))
		{
			String modele = this.txtModele.getText();
			String marque = this.txtMarque.getText();
			String annee = this.txtAnnee.getText();
			String caracteristique = this.txtCaracteristique.getText();
			String prix_journalier = this.txtPrix_journalier.getText();
			String caution = this.txtCaution.getText();
			String puissance = this.txtPuissance.getText();
			String nb_places = this.txtNb_places.getText();
			String statut = this.cbStatut.getSelectedItem().toString() ;


			
			// Instancier un Vehicule
			Vehicule unVehicule = new Vehicule(marque, modele, annee, caracteristique, prix_journalier, caution, puissance,  nb_places, statut);
			// On l'enregistre dans la base de données
			C_Vehicule.insertVehicule(unVehicule);
			// Récupération de l'id Vehicule à partir de la BDD
			unVehicule = C_Vehicule.selectWhereVehicule(modele);
			// Ajout du Vehicule dans le tableau
			Object ligne[] = {unVehicule.getIdvehicule(), unVehicule.getModele(), unVehicule.getMarque(), unVehicule.getAnnee(), unVehicule.getCaracteristique(), unVehicule.getCaution(), unVehicule.getPuissance(),  unVehicule.getNb_places(), unVehicule.getStatut(),};
			this.unTableau.insertLigne(ligne);
			
			JOptionPane.showMessageDialog(this, "Vehicule inséré avec succès !");
			this.viderChamps();
		}
		else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier"))
		{
			String modele = this.txtModele.getText();
			String marque = this.txtMarque.getText();
			String annee = this.txtAnnee.getText();
			String caracteristique = this.txtCaracteristique.getText();
			String prix_journalier = this.txtPrix_journalier.getText();
			String caution = this.txtCaution.getText();
			String puissance = this.txtPuissance.getText();
			String nb_places = this.txtNb_places.getText();
			String statut = this.cbStatut.getSelectedItem().toString() ;

			
			int numLigne = this.tableVehicules.getSelectedRow();
			int Idvehicule = Integer.parseInt(this.tableVehicules.getValueAt(numLigne, 0).toString());
			
			// Instancier un Vehicule
			Vehicule unVehicule = new Vehicule(Idvehicule, marque, modele, annee, caracteristique, caution, prix_journalier,  puissance, nb_places, statut);
			// On modifie dans la base de données
			C_Vehicule.updateVehicule(unVehicule);
			// On modifie le Vehicule dans le tableau
			Object ligne[] = {unVehicule.getIdvehicule(), unVehicule.getModele(), unVehicule.getMarque(), unVehicule.getAnnee(), unVehicule.getCaracteristique(), unVehicule.getCaution(), unVehicule.getPuissance(), unVehicule.getNb_places(), unVehicule.getStatut(),};
			this.unTableau.updateLigne(numLigne, ligne);
			
			JOptionPane.showMessageDialog(this, "Vehicule modifié avec succès !");
			this.viderChamps();
		}
	}
}
