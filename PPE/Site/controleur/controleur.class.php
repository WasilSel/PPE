<?php
	//controle des données avant injection ou après extraction.
	require_once ("../modele/modele.class.php");

	class Controleur {
		private $unModele ; //instance de la classe Modele 

		public function  __construct($serveur, $bdd, $user, $mdp){
			//instanciation de la classe Modele 
			$this->unModele= new Modele($serveur, $bdd, $user, $mdp);
		}
		/************************** Les Clients *****************/
		public function selectAllClients ()
		{
			//récupération des classes 
			$lesClasses = $this->unModele->selectAllClients(); 
			//je réalise des traitements : controle des données 

			//je retourne mes résultats 
			return $lesClients;
		}
		public function insertClients($tab)
		{
			//controle les donnees avant insertion 

			//insertion des données via le modele 
			$this->unModele->insertClients ($tab);
		}
		public function selectLikeClients ($mot)
		{
			$lesClients = $this->unModele->selectLikeClients($mot); 
			return $lesClients;
		}
		public function deleteClients($idclients)
		{
			$this->unModele->deleteClients($idclients);
		}

		public function selectWhereClients ($idclients)
		{
			return $this->unModele->selectWhereClients($idclients);
		}
		public function updateClients($tab)
		{
			$this->unModele->updateClients ($tab);
		}
		/****************** Les vehicules **********************/
		public function selectAllVehicules ()
		{
			//récupération des vehicules 
			$lesEtudiants = $this->unModele->selectAllVehicules(); 
			//je réalise des traitements : controle des données 

			//je retourne mes résultats 
			return $lesVehicules;
		}
		public function selectVehiculesVehicules ($idvehicules)
		{
			//récupération des 
			$lesVehicules = $this->unModele->selectVehicules($idclasse); 
			//je retourne mes résultats 
			return $lesVehicules;
		}
		public function insertVehicules($tab)
		{
			//controle les donnees avant insertion 

			//insertion des données via le modele 
			$this->unModele->insertVehicules ($tab);
		}
			public function selectLikeVehicules ($mot)
		{
			$lesClasses = $this->unModele->selectLikevehicules($mot); 
			return $lesClasses;
		}
		public function deleteVehicules($idvehicules)
		{
			$this->unModele->deleteVehicules($idvehicules);
		}

		public function selectWherevehicules ($idvehicules)
		{
			return $this->unModele->selectWherevehicules($idvehicules);
		}
		public function updateVehicules($tab)
		{
			$this->unModele->updateVehicules($tab);
		}
		/****************** Les Réservations **********************/
		public function selectAllReservation ()
		{
			//récupération des réservations 
			$lesReservations = $this->unModele->selectAllReservations(); 
			//je réalise des traitements : controle des données 

			//je retourne mes résultats 
			return $lesReservations;
		}
		public function insertReservation($tab)
		{
			//controle les donnees avant insertion 

			//insertion des données via le modele 
			$this->unModele->insertReservation ($tab);
		}
	
		/****************** Les contacts **********************/
		public function selectAllContacts ()
		{
			//récupération des Enseignements 
			$lescontacts= $this->unModele->selectAllContacts(); 
			//je réalise des traitements : controle des données 

			//je retourne mes résultats 
			return $lescontacts;
		}
		public function insertContacts($tab)
		{
			//controle les donnees avant insertion 

			//insertion des données via le modele 
			$this->unModele->insertContacts ($tab);
		}
		/******************* USER *******************/
		public function verifConnexion ($email, $mdp)
		{
			return $this->unModele->verifConnexion($email, $mdp); 
		}

		/********************* Autres methodes *************/
		public function count ($table)
		{
			return $this->unModele->count($table);
		}
		public function selectAllVue ()
		{
			return $this->unModele->selectAllVue();
		}
	}
?>










