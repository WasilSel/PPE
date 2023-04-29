package controleur;

import java.util.ArrayList;

import modele.ModeleClient;

public class C_Client {

	public static void insertClient(Client unClient)
	{
		ModeleClient.insertClient(unClient);
	}
	public static ArrayList<Client> selectAllClients ()
	{
		return ModeleClient.selectAllClient();
	}
	public static void deleteClient (int idClient)
	{
		ModeleClient.deleteClient(idClient);
	}
	public static void updateClient(Client unClient)
	{
		ModeleClient.updateClient(unClient);
	}
	public static Client selectWhereClient(int idClient)
	{
		return ModeleClient.selectWhereClient(idClient);
	}
	public static Client selectWhereClient(String email, String mdp)
	{
		return ModeleClient.selectWhereClient(email, mdp);
	}
}

