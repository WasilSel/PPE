<?php

$username = "Daniel"; // remplacez ceci par les informations de l'utilisateur qui se connecte
$_SESSION["username"] = $username;
?>

<!DOCTYPE html>
<html>
<head>
  <title>Mon compte</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
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
      <h1>Mon compte</h1>
      <p>Bienvenue <?php echo $_SESSION["username"]; ?> !</p>
      <a href="logout.php">Déconnexion</a>
    </div>
  </main>

  <footer>
    <div class="container">
      <p>Copyright © Localuxury</p>
    </div>
  </footer>
</body>
</html>
