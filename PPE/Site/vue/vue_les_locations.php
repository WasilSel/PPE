<h3> Liste des locations </h3>
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
		<td>vehicule_id </td>
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
	foreach ($lesLocations as $uneLocation) {
	echo "<tr>";
	echo "<td>".$uneLocation['id']."</td>"; 
	echo "<td>".$uneLocation['client_id]."</td>"; 
	echo "<td>".$uneLocation['date_debut']."</td>"; 
	echo "<td>".$uneLocation['date_fin']."</td>"; 
	echo "<td>".$uneLocation['prix_total']."</td>";
	echo "<td>".$uneLocation['reduction']."</td>"; 
	echo "<td>".$uneLocation['mode_paiement']."</td>"; 
	echo "<td>".$uneLocation['caution']."</td>";

	if( isset($_SESSION['role']) && $_SESSION['role'] == 'admin'){
	echo "<td>
		<a href='index.php?page=2&action=sup&idetudiant=".$unelocation['id']."'> 
		<img src='images/sup.png' height ='40' width='40'> </a>
		
		<a href='index.php?page=2&action=edit&idetudiant=".$unelocation['client_id']."'> 
		<img src='images/edit.png' height ='40' width='40'> </a>

		</td>";
	}
	echo "</tr>";
	}
	?>
</table>










