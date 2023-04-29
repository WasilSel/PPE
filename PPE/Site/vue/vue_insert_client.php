<h3> AJout d'un client</h3>
<form method="post">
	<table>
		<tr>
			<td> id </td>
			<td> <input type="text" name="id" 
				value="<?= ($laClasse != null) ? $laClasse['nom']:'' ?>" 
				></td>
		</tr>
		<tr>
			<td> nom </td>
			<td> <input type="text" name="nom"
				value="<?= ($laClasse != null) ? $laClasse['nom']:'' ?>" 
				></td>
		</tr>
		<tr>
			<td> adresse</td>
			<td> <input type="text" name="adresse"
				value="<?= ($laClasse != null) ? $laClasse['adresse']:'' ?>" 
				></td>
		</tr>
		<tr>
			<td> numero_telephone</td>
			<td> <input type="text" name="numero_telephone"
				value="<?= ($laClasse != null) ? $laClasse['numero_telephone']:'' ?>" 
				></td>
		</tr>
			<td> <input type="reset" name="Annuler" value="Annuler"></td>
			<td> <input type="submit" 
				<?= ($laClasse != null) ? 'name="Modifier" value="Modifier"' : 
						'name="Valider" value="Valider"' ?>

				></td>
		</tr>
	<?= ($laClasse != null) ? '<input type="hidden" name="idclient" value="'.$laClasse['idclient'].'">' : '' ?>

	</table>
</form>










