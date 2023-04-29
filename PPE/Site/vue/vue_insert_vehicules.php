<h3> Ajout des vehicules</h3>
<form method="post">
	<table>
		<tr>
			<td> id </td>
			<td> <input type="text" name="id" 
				value="<?= ($lesClients != null) ? $lesClients['id']:'' ?>"
				></td>
		</tr>
		<tr>
			<td> marque</td>
			<td> <input type="text" name="marque"
				value="<?= ($lesClients != null) ? $lesClients['prenom']:'' ?>"
				></td>
		</tr>
		<tr>
			<td> modèle </td>
			<td> <input type="text" name="modèle"
				value="<?= ($lesClients != null) ? $lesClients['email']:'' ?>"
				></td>
		</tr>
		<tr>

		<tr>
			<td> année </td>
			<td> <input type="text" name="modèle"
				value="<?= ($lesClients != null) ? $lesClients['email']:'' ?>"
				></td>
		</tr>
			<td> Classe des vehicules </td>
			<td> 
				<select name="idclient">
					<?php
					foreach ($lesClients as $unClient) {
					if ($lesClients!=null){
						if($lesClients['id'] == $unClient['id']){
							echo "<option value='".$unClient['id']."' selected >"; 
						}else {
						echo "<option value='".$unClient['idclient']."'>"; 
						}
					}else {
						echo "<option value='".$unClient['idclient']."'>"; 
						}
					
					echo $unClient['id']; 
					echo "</option>";
					}
					?>
				</select>
			</td>
		</tr>
		<tr>
			<td> <input type="reset" name="Annuler" value="Annuler"></td>
			<td> <input type="submit" 
				<?= ($lesClients != null) ? 'name="Modifier" value="Modifier"' : 
						'name="Valider" value="Valider"' ?>

				></td>
		</tr>
	<?= ($lesClients != null) ? '<input type="hidden" name="lesClients" value="'.$lesClients['id'].'">' : '' ?>
	</table>
</form>