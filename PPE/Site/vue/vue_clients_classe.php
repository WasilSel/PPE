<table border="1">
	<tr>
		<td> Id clients</td>
		<td> Nom du client </td>
		<td> Prénom du client</td>
		<td> Email</td>
		</tr>
	<?php
	foreach ($lesClients as $unClient) {
		echo "<tr>";
		echo "<td>".$unClient['idclient']."</td>"; 
		echo "<td>".$unClient['nom']."</td>"; 
		echo "<td>".$unClient['prenom']."</td>"; 
		echo "<td>".$unClient['email']."</td>"; 
		echo "</tr>";
	}
	?>
</table>










