package controleur;
import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel
{
    private Object[][]donnees; 
    private String entetes []; 
    
    public Tableau (Object[][]donnees,String entetes [] )
    {
        this.donnees = donnees; 
        this.entetes = entetes;
    }
    @Override
    public int getRowCount() {
        return this.donnees.length;
    }
    @Override
    public int getColumnCount() {
        return this.entetes.length;
    }
    @Override
    public Object getValueAt(int ligne, int colonne) {
        return this.donnees[ligne][colonne];
    }
    @Override
    public String getColumnName(int colonne) {
        return this.entetes[colonne];
    }
    //ajouter une ligne à la matrice des données 
    public void insertLigne(Object ligne[])
    {
        Object matrice [][] = new Object[this.donnees.length +1][this.entetes.length];
        for(int i = 0; i<this.donnees.length; i++)
        {
            matrice[i] = this.donnees[i];
        }
        matrice [this.donnees.length] = ligne;
        this.donnees = matrice ; //recopie de matrices.
        this.fireTableDataChanged(); // mise à jour des données. 
    }
    //supprimer une ligne identifiée par un numero 
    public void deleteLigne (int numLigne)
    {
    	Object matrice [][] = new Object[this.donnees.length - 1][this.entetes.length];
    	int j = 0;
        for(int i = 0; i<this.donnees.length; i++)
        {
            if(i != numLigne)
            	{
            		matrice[j] = this.donnees[i];
            		j++;
            	}
        }
     
        this.donnees = matrice ; //recopie de matrices.
        this.fireTableDataChanged(); // mise à jour des données
    }
    //remplacer une ligne identifiée par un numero avec une nouvelle ligne 
    public void updateLigne(int numLigne, Object[] ligne)
    {
    	Object matrice [][] = new Object[this.donnees.length][this.entetes.length];
        for(int i = 0; i<this.donnees.length; i++)
        {
            if(i != numLigne)
            	{
            		matrice[i] = this.donnees[i];
            	} else {
            		matrice[i] = ligne;
            	}
        }
     
        this.donnees = matrice ; //recopie de matrices.
        this.fireTableDataChanged(); // mise à jour des données
    }
    public void setDonnes (Object donnees[][])
    {
    	this.donnees = donnees;
    	this.fireTableDataChanged();
    }
    
}