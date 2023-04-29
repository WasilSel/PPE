<h3> Liste des clients </h3>
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
		<td>nom </td>
		<td>adresse</td>
		<td>numero_telephone</td>
		</tr>
	<?php
	foreach ($lesClients as $unClient) {
	echo "<tr>";
	echo "<td>".$unClient['id']."</td>"; 
	echo "<td>".$unClient['nom']."</td>"; 
	echo "<td>".$unClient['adresse']."</td>"; 
	echo "<td>".$unClient['numero_telephone']."</td>"; 
	echo "</tr>";
	}
	?>
</table>










