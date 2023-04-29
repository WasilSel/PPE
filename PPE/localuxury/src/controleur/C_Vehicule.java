package controleur;

import java.util.ArrayList;

import modele.ModeleVehicule;

public class C_Vehicule {
	
	public static void insertVehicule(Vehicule unVehicule)
	{
		ModeleVehicule.insertVehicule(unVehicule);
	}
	public static ArrayList<Vehicule> selectAllVehicules ()
	{
		return ModeleVehicule.selectAllVehicule();
	}
	public static void deleteVehicule (int idVehicule)
	{
		ModeleVehicule.deleteVehicule(idVehicule);
	}
	public static void updateVehicule(Vehicule unVehicule)
	{
		ModeleVehicule.updateVehicule(unVehicule);
	}
	public static Vehicule selectWhereVehicule(int idVehicule)
	{
		return ModeleVehicule.selectWhereVehicule(idVehicule);
	}
	public static Vehicule selectWhereVehicule(String modele)
	{
		return ModeleVehicule.selectWhereVehicule(modele);
	}
}
