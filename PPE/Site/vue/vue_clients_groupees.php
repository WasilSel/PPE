<table border="1">
	<tr>
		<td> Nom du client</td>
		<td> Salle de cours</td>
		<td> Nb Etudiants</td>
		
		</tr>
	<?php
	foreach ($lesResultats as $unResultat) {
	echo "<tr>";
	echo "<td>".$unResultat['nom']."</td>"; 
	echo "<td>".$unResultat['salle']."</td>"; 
	echo "<td>".$unResultat['nb']."</td>"; 
	echo "</tr>";
	}
	?>
</table>










