<!DOCTYPE html>
<html>

<head>
    <title>Localuxury - Contact</title>
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
            <h1>Contactez-nous</h1>
            <p>Vous avez des questions ou des commentaires? N'hésitez pas à nous contacter.</p>
            <form action="submit-form.php" method="post">
                <label for="name">Nom:</label>
                <input type="text" id="name" name="name" required>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                <label for="message">Message:</label>
                <textarea id="message" name="message" required></textarea>
                <input type="submit" value="Envoyer">
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
