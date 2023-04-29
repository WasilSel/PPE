<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "localuxury";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT id, marque, modèle, année, caractéristiques, prix_journalier, caution, puissance FROM Vehicule";
$result = $conn->query($sql);

$query = "SELECT * FROM Vehicule";
$result = mysqli_query($conn, $query);
// while ($row = mysqli_fetch_assoc($result)) {
//     var_dump($row);
// }



?>
<!DOCTYPE html>
<html>

<head>
    <title>Localuxury - Location de voitures de luxe</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon.png">
</head>

<body>
    <header>
        <div class="container">
            <a href="#">
                <img src="logo.png" alt="Localuxury" class="logo">
            </a>
            <nav>
                <ul>
                    <li><a href="accueil.php">Accueil</a></li>
                    <li><a href="vehicules.php">Nos véhicules</a></li>
                    <li><a href="reservation.php">Réservation</a></li>
                    <li><a href="moncompte.php">Mon compte</a></li>
                    <li><a href="contact.php">Contact</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <main>
        <div class="container">
            <h1>Nos véhicules</h1>
            <ul>
    <?php if ($result->num_rows > 0) : 
        while($row = $result->fetch_assoc()) : ?>
            <li>
                <img src="../Site/Vehicule/<?php echo $row["image"]; ?>" alt="<?php echo $row["marque"] . " " . $row["modele"]; ?>">
                <h2><?php echo $row["marque"] . " " . $row["modele"]; ?></h2>
                <p>Année : <?php echo $row["annee"]; ?></p>
                <p>Caractéristiques : <?php echo utf8_encode($row["caracteristiques"]); ?></p>
                <p>Prix journalier : <?php echo $row["prix_journalier"]; ?>€</p>
                <p>Caution : <?php echo $row["caution"]; ?>€</p>
                <p>Puissance : <?php echo $row["puissance"]; ?> chevaux</p>
            </li>
    <?php endwhile; ?>
    <?php else : ?>
        <p>Aucun véhicule disponible.</p>
    <?php endif; ?>
</ul>

<?php $conn->close(); ?>
</div>
</main>
<footer>
    <div class="container">
        <p>Copyright © Localuxury</p>
        <div class="social-media">
            <a href="#"><img src="facebook.png" alt="Facebook"></a>
            <a href="#"><img src="instagram.png" alt="Instagram"></a>
            <a href="#"><img src="twitter.png" alt="Twitter"></a>
        </div>
    </div>
</footer>
</body>
</html>



