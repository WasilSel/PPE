package controleur;

import java.util.ArrayList;

import modele.ModeleLocation;

public class C_Location {

	public static void insertLocation(Location uneLocation)
	{
		ModeleLocation.insertLocation(uneLocation);
	}
	public static ArrayList<Location> selectAllLocations ()
	{
		return ModeleLocation.selectAllLocations();
	}
	public static void deleteLocation (int idLocation)
	{
		ModeleLocation.deleteLocation(idLocation);
	}
	public static void updateLocation(Location uneLocation)
	{
		ModeleLocation.updateLocation(uneLocation);
	}
	public static Location selectWhereLocation(int idLocation)
	{
		return ModeleLocation.selectWhereLocation(idLocation);
	}
	public static Location selectWhereLocation(String date_debut)
	{
		return ModeleLocation.selectWhereLocation(date_debut);
	}
}
