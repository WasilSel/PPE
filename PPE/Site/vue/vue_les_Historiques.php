<h3> Liste des Historiques </h3>
<br/>
<form method="post">
	Filtrer par : 
	<input type="text" name="mot">
	<input type="submit" name="Filtrer" value="Filtrer">
</form>
<br/>
<br/>
<table border="1">
	<tr>
		<td>id</td>
		<td>vehicule_id</td>
		<td>client_id</td>
		<td>date_debut</td>
		<td>date_fin</td>
		<td>prix_total</td>
		<td>reduction</td>
		<td>mode_paiement</td>
		<td>caution</td>
		<?php
		if( isset($_SESSION['role']) && $_SESSION['role'] == 'admin'){
			echo " <td> Opérations </td> "; 
		}
		?>
		</tr>
	<?php
	foreach ($lesHistoriques as $unHistorique) {
	echo "<tr>";
	echo "<td>".$unHistorique['id']."</td>"; 
	echo "<td>".$unHistorique['vehicule_id']."</td>"; 
	echo "<td>".$unHistorique['client_id']."</td>"; 
	echo "<td>".$unHistorique['date_debut']."</td>"; 
	echo "<td>".$unHistorique['date_fin']."</td>"; 
	echo "<td>".$unHistorique['prix_total']."</td>"; 
	echo "<td>".$unHistorique['reduction']."</td>"; 
	echo "<td>".$unHistorique['mode_paiement']."</td>"; 
	echo "<td>".$unHistorique['caution']."</td>"; 


	if( isset($_SESSION['role']) && $_SESSION['role'] == 'admin'){
	echo "<td>
		<a href='index.php?page=1&action=sup&idclasse=".$unHistorique['id']."'> 
		<img src='images/sup.png' height ='40' width='40'> </a>
		
		<a href='index.php?page=1&action=edit&idclasse=".$unHistorique['vehicule_id']."'> 
		<img src='images/edit.png' height ='40' width='40'> </a>

		<a href='index.php?page=1&action=voir&idclasse=".$unHistorique['client_id']."'> 
		<img src='images/voir.png' height ='40' width='40'> </a>

		</td>";
	}

	echo "</tr>";
	}
	?>
</table>










