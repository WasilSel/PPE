<!DOCTYPE html>
<html>
<head>
  <title>Connexion</title>
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
      <h1>Connexion</h1>
      <form action="login_verify.php" method="post">
        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="Se connecter">
      </form>
      <?php if (isset($_SESSION["error"])) {
        echo $_SESSION["error"];
        unset($_SESSION["error"]);
      }
      ?>
    </div>
  </main>

  <footer>
    <div class="container">
      <p>Copyright © Localuxury</p>
    </div>
  </footer>
</body>
</html>
