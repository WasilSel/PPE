<!DOCTYPE html>
<html>

<head>
    <title>Localuxury - Réservation</title>
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
            <h1>Réservez votre véhicule de prestige</h1>
            <form action="submit-reservation.php" method="post">
    <label for="vehicule">Sélectionnez un véhicule:</label>
    <select id="vehicule" name="vehicule">
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
    $sql = "SELECT id, marque, modèle, année, caractéristiques, image FROM Vehicule";
    $result = $conn->query($sql);
    if ($result->num_rows > 0) {
        // output data of each row
        while($row = $result->fetch_assoc()) {
            echo "<option value='" . $row["id"]. "'> " . $row["marque"]. " " . $row["modèle"]."</option>";
            echo "<img src='" . $row["image"] . "' alt='Image de " . $row["marque"] . " " . $row["modèle"] . "'>";
        }
    } else {
        echo "0 results";
    }
    $conn->close();
    ?>
    </select>
    <label for="start-date">Date de départ:</label>
    <input type="date" id="start-date" name="start-date" required>
    <label for="end-date">Date de retour:</label>
    <input type="date" id="end-date" name="end-date" required>
    <label for="name">Nom:</label>
    <input type="text" id="name" name="name" required>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>
    <input type="submit" value="Réserver">
</form>


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

