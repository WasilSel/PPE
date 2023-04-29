<h3> Ajout d'une location</h3>
<form method="post">
	<table>
		<tr>
			<td> id </td>
			<td><input type="text" name="matiere"></td>
		</tr>
		<tr>
			<td> vehicule_id</td>
			<td> <input type="text" name="nbheures"></td>
		</tr>
		<tr>
			<td>client_id</td>
			<td> <input type="text" name="caution"></td>
		</tr>
		<tr>
			<td>date_debut</td>
			<td> <input type="text" name="caution"></td>
		</tr>
		<tr>
			<td>date_fin</td>
			<td> <input type="text" name="caution"></td>
		</tr>
		<tr>
			<td>prix_total</td>
			<td> <input type="text" name="caution"></td>
		</tr>
		<tr>
			<td>reduction</td>
			<td> <input type="text" name="caution"></td>
		</tr>
		<tr>
			<td>mode_paiement</td>
			<td> <input type="text" name="caution"></td>
		</tr>
		<tr>
			<td>caution</td>
			<td> <input type="text" name="caution"></td>
		</tr>
		<tr>
			<td> location</td>
			<td> 
				<select name="idlocation">
					<?php
					foreach ($lesLocations as $uneLocation) {
					echo "<option value='".$uneLocation['idlocation']."'>"; 
					echo $unClient['location']; 
					echo "</option>";
					}
					?>
				</select>
			</td>
		</tr>
		<tr>
			<td> reservation </td>
			<td> 
				<select name="idlocation">
					<?php
					foreach ($lesreservations as $uneReservation) {
					echo "<option value='".$uneLocation['idlocation']."'>"; 
					echo $uneLocation['nom']; 
					echo "</option>";
					}
					?>
				</select>
			</td>
		</tr>
		<tr>
			<td> <input type="reset" name="Annuler" value="Annuler"></td>
			<td> <input type="submit" name="Valider" value="Valider"></td>
		</tr>
	</table>
</form>