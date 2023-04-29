<h3> Liste des vehicules </h3>
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
		<td>marque</td>
		<td>modele</td>
		<td>année</td>
		 
		</tr>
	<?php
	foreach ($lesVehicules as $unVehicule) {
	echo "<tr>";
	echo "<td>".$unVehicule['id']."</td>"; 
	echo "<td>".$unVehicule['marque']."</td>"; 
	echo "<td>".$unVehicule['modele']."</td>"; 
	echo "<td>".$unVehicule['année']."</td>"; 
	 
	echo "</tr>";
	}
	?>
</table>










