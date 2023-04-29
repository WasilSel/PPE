<?php
	//exécuter des requetes d'extraction / injection des données.
	class Modele {
		private $unPDO ; //instance de la classe PDO : PHP DATA Object 

		public function __construct($serveur, $bdd, $user, $mdp){
			$this->unPDO = null; 
			try{
				$url = "mysql:host=".$serveur.";dbname=".$bdd;
				//instanciation de la classe PDO 
				$this->unPDO = new PDO($url, $user, $mdp); 
			}
			catch(PDOException $exp){
				echo "<br/> Erreur de connexion à la BDD !";
				echo $exp->getMessage(); 
			}
		}
		/********************* LES CLIENTS **************************/
		public function selectAllClients ()
		{
			if($this->unPDO != null){
				$requete ="select * from client ;";
				//preparation de la requete 
				$select = $this->unPDO->prepare ($requete);
				//execution de la requete
				$select->execute (); 
				//extraction des données classes 
				$lesClasses = $select->fetchAll(); 
				return $lesClients; 
			}else{
				return null; 
			}
		}
		public function insertClient($tab)
		{
			if($this->unPDO != null){
			$requete ="insert into classe values (null, :id, 
			:Nom, :adresse, :numero_telephone); ";
			$donnees = array(":id"=>$tab['id'],
							 ":Nom"=>$tab['Nom'], 
							 ":adresse"=>$tab['adresse'],
							 ":numero_telephone"=>$tab['numero_telephone']); 
			$insert = $this->unPDO->prepare($requete); 
			$insert->execute($donnees);
			}
		}
		public function selectLikeClients ($mot)
		{
			if($this->unPDO != null){
				$requete ="select * from classe where nom like :mot 
				  or salle like :mot or diplome like :mot ;";
				$donnees = array(":mot"=>"%".$mot."%"); 

				//preparation de la requete 
				$select = $this->unPDO->prepare ($requete);
				//execution de la requete
				$select->execute ($donnees); 
				//extraction des données classes 
				$lesClasses = $select->fetchAll(); 
				return $lesClients; 
			}else{
				return null; 
			}
		}
		public function deleteClients($idclients)
		{
			if($this->unPDO != null){
			$requete ="delete from classe where idclasse = :idclasse; ";
			$donnees = array(":idclasse"=>$idclasse); 
			$delete = $this->unPDO->prepare($requete); 
			$delete->execute($donnees);
			}
		}
		public function selectWhereClients($idclients)
		{
			if($this->unPDO != null){
			$requete ="select * from classe where idclient = :id; ";
			$donnees = array(":id"=>$idclient); 
			$select = $this->unPDO->prepare($requete); 
			$select->execute($donnees);
			$uneClasse = $select->fetch(); //un seul résultat
			return $unClient;
			}
		}

		public function updateClient($tab)
		{
			if($this->unPDO != null){
			$requete ="update classe set id =:id, 
			Nom = :Nom, adresse, numero_telephone = :numero_telephone where idclient = :idclient; ";

			$donnees = array(":id"=>$tab['id'],
							 ":nom"=>$tab['nom'], 
							 ":adresse"=>$tab['adresse'], 
							 ":numero_telephone"=>$tab['numero_telephone']); 
			$update = $this->unPDO->prepare($requete); 
			$update->execute($donnees);
			}
		}
		/****************** Les Historiques **********************/
		public function selectAllHistoriques ()
		{
			if($this->unPDO != null){
				$requete ="select * from historique ;";
				//preparation de la requete 
				$select = $this->unPDO->prepare ($requete);
				//execution de la requete
				$select->execute (); 
				//extraction des données classes 
				$lesHistoriques = $select->fetchAll(); 
				return $lesHistoriques; 
			}else{
				return null; 
			}
		}
		public function selectHistoriquesWhere($id)
		{
			if($this->unPDO != null){
				$requete ="select * from historique where vehicule_id =:vehicule_id ;";
				$donnees = array(":vehicule_id"=>$vehicule_id); 
				//preparation de la requete 
				$select = $this->unPDO->prepare ($requete);
				//execution de la requete
				$select->execute ($donnees); 
				//extraction des données classes 
				$lesHistoriques = $select->fetchAll(); 
				return $lesHistoriques; 
			}else{
				return null; 
			}
		}
		public function insertHistorique($tab)
		{
			if($this->unPDO != null){
			$requete ="insert into historique values (null, :id, 
			:vehicule_id, :client_id, :date_debut, :date_fin, :prix_total, :reduction, :mode_paiement, :caution); ";
			$donnees = array(":id"=>$tab['id'],
							 ":vehicule_id"=>$tab['vehicule_id'], 
							 ":date_debut"=>$tab['date_debut'], 
							 ":date_fin"=>$tab['date_fin'],
							 ":prix_total"=>$tab['prix_total'],
							 ":reduction"=>$tab['reduction'],
							 ":mode_paiement"=>$tab['mode_paiement'], 
							 ":caution"=>$tab['caution']); 
			$insert = $this->unPDO->prepare($requete); 
			$insert->execute($donnees);
			}
		}
		public function selectLikeHistorique ($mot)
		{
			if($this->unPDO != null){
				$requete ="select * from historique where nom like :mot 
				  or prenom like :mot or email like :mot ;";
				$donnees = array(":mot"=>"%".$mot."%"); 

				//preparation de la requete 
				$select = $this->unPDO->prepare ($requete);
				//execution de la requete
				$select->execute ($donnees); 
				//extraction des données lesEtudiants 
				$lesHistoriques = $select->fetchAll(); 
				return $lesHistoriques; 
			}else{
				return null; 
			}
		}
		public function deleteHistoriques($client_id)
		{
			if($this->unPDO != null){
			$requete ="delete from historique where vehicule_id = :vehicule_id; ";
			$donnees = array(":vehicule_id"=>$vehicule_id); 
			$delete = $this->unPDO->prepare($requete); 
			$delete->execute($donnees);
			}
		}
		public function selectWhereHistorique($vehicule_id)
		{
			if($this->unPDO != null){
			$requete ="select * from historique where historique = :client_id; ";
			$donnees = array(":client_id"=>$client_id); 
			$select = $this->unPDO->prepare($requete); 
			$select->execute($donnees);
			$unEtudiant = $select->fetch(); //un seul résultat
			return $unHistorique;
			}
		}

		public function updateHistorique($tab)
		{
			if($this->unPDO != null){
			$requete ="update historique set id =:id, 
			vehicule_id = :date_debut,  = :date_debut, date_fin =:date_fin, :prix_total where  = :vehicule_id; ";

			$donnees = array(":id"=>$tab['id'],
			":vehicule_id"=>$tab['vehicule_id'], 
			":date_debut"=>$tab['date_debut'], 
			":date_fin"=>$tab['date_fin'],
			":prix_total"=>$tab['prix_total'],
			":reduction"=>$tab['reduction'],
			":mode_paiement"=>$tab['mode_paiement'], 
			":caution"=>$tab['caution']);
			$update = $this->unPDO->prepare($requete); 
			$update->execute($donnees);
			}
		}

		/****************** Les Professeurs **********************/
		public function selectAllProfesseurs ()
		{
			if($this->unPDO != null){
				$requete ="select * from professeur ;";
				//preparation de la requete 
				$select = $this->unPDO->prepare ($requete);
				//execution de la requete
				$select->execute (); 
				//extraction des données classes 
				$lesProfesseurs = $select->fetchAll(); 
				return $lesProfesseurs; 
			}else{
				return null; 
			}
		}
		public function insertProfesseur($tab)
		{
			if($this->unPDO != null){
			$requete ="insert into professeur values (null, :nom, 
			:prenom, :diplome); ";
			$donnees = array(":nom"=>$tab['nom'],
							 ":prenom"=>$tab['prenom'], 
							 ":diplome"=>$tab['diplome']); 
			$insert = $this->unPDO->prepare($requete); 
			$insert->execute($donnees);
			}
		}

		/****************** Les Enseignements **********************/
		public function selectAllEnseignements ()
		{
			if($this->unPDO != null){
				$requete ="select * from enseignement ;";
				//preparation de la requete 
				$select = $this->unPDO->prepare ($requete);
				//execution de la requete
				$select->execute (); 
				//extraction des données classes 
				$lesEnseignements = $select->fetchAll(); 
				return $lesEnseignements; 
			}else{
				return null; 
			}
		}
		public function insertEnseignement($tab)
		{
			if($this->unPDO != null){
			$requete ="insert into enseignement values (null, :matiere,:nbheures, :coeff, :idclasse, :idprofesseur); ";
			$donnees = array(":matiere"=>$tab['matiere'],
							 ":nbheures"=>$tab['nbheures'], 
							 ":coeff"=>$tab['coeff'], 
							 ":idclasse"=>$tab['idclasse'], 
							 ":idprofesseur"=>$tab['idprofesseur']); 
			$insert = $this->unPDO->prepare($requete); 
			$insert->execute($donnees);
			}
		}
		/****************** USER ***********************/
		public function verifConnexion ($email, $mdp)
		{
			if($this->unPDO != null){
				$requete ="select * from user where email =:email and 
				mdp = :mdp ;";
				$donnees=array(":email"=>$email, ":mdp"=>$mdp); 
				$select = $this->unPDO->prepare($requete); 
				$select->execute ($donnees); 
				$unUser = $select->fetch(); 
				return $unUser; 
			}else {
				return null; 
			}
		}
		/********************* Autres methodes *************/
		public function count ($table)
		{
			if($this->unPDO != null){
				$requete ="select count(*) as nb from ".$table;
				$select = $this->unPDO->prepare($requete); 
				$select->execute (); 
				$unResultat = $select->fetch(); 
				return $unResultat; 
			}
			else{
				return null; 
			}
		}
		public function selectAllVue ()
		{
			if($this->unPDO != null){
				$requete ="select * from classesEtudiants ;";
				//preparation de la requete 
				$select = $this->unPDO->prepare ($requete);
				//execution de la requete
				$select->execute (); 
				//extraction des données classes 
				$lesResultats  = $select->fetchAll(); 
				return $lesResultats; 
			}else{
				return null; 
			}
		}
	}
?>








