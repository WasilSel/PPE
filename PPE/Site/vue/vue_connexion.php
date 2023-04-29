<!DOCTYPE html>
<html>
<head>
  <title>Localuxury - Connexion</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
  <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
  <link rel="icon" type="image/png" sizes="16x16" href="favicon.png">
  <style>
    body{
      background-image: url('voiture.gif');
      background-repeat: no-repeat;
      background-size: cover;
    }
  </style>
</head>
<body>
  <header>
    <div class="container">
      <a href="#">
        <img src="logo.png" alt="Localuxury" class="logo">
      </a>
    </div>
  </header>
  <main>
    <div class="container">
      <h1>Connexion à Localuxury</h1>
      <form method="post">
        <table>
          <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
          </tr>
          <tr>
            <td>Mot de passe</td>
            <td><input type="password" name="mdp"></td>
          </tr>
          <tr>
            <td><input type="reset" name="Annuler" value="Annuler"></td>
            <td><input type="submit" name="seConnecter" value="Se connecter"></td>
          </tr>
        </table>
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
