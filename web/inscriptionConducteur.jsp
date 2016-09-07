
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Faster+One|Annie+Use+Your+Telescope' rel='stylesheet' type='text/css'>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Inscription Passager</title>
    </head>
    <body>
        <img id="img_velo" src="css/images_2/velo.png" width="150px" alt="150px" />
        <img id="img_voit" src="css/images_2/vv.png" width="150px" alt="150px" />
        <h1>Cousin Huber</h1>
        <h2>Inscription Conducteur</h2>
        <center>
            <img id="img_scoot" src="css/images_2/scooter.png" width="150px" alt="150px" />
        </center>
        <marquee scrollamount="15">
		<figure>
                    <img id="img_ovni" src="css/images_2/ovni.png" width="150px" alt="150px" />	
                </figure>
        </marquee>
        <blockquote class="slogan">"Libérez vos pieds...Libérez vos idées...Laissez nous vous guider...Nous vous offrons la liberté..."</blockquote>
        <div class="menu">
        <a href="home">Home Page</a>
        </div>
        
            <form method="POST">
                Identifiant : <input type="text" name="loginConducteur"/><br/>
                Mot de Passe : <input type="password" name="mdpConducteur"/><br/>
                Email : <input type="text" name="emailConducteur"/><br/>
                Tel : <input type="text" name="telConducteur"/></br>
                Immatriculation : <input type="text" name="immatConducteur"/></br>
                Tarif au km : <input type="text" name="prixAuKm" /><br>
                Type de véhicule :  <select name="vehicule">
                                        <option value="Voiture">Voiture</option>
                                        <option value="JetPack">JetPack</option>
                                        <option value="Poney">Poney</option>
                                        <option value="Caddie">Caddie</option>
                                        <option value="2 Roues écolo">2 Roues écolo</option>
                                        <option value="2 Roues poluant--------">2 Roues poluant</option>
                                        <option value="Tracteur">Tracteur</option>
                                        <option value="Soucoupe Volante">Soucoupe Volante</option>
                                    </select>
                Nombre de places :  <select name="nbPlaces">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                    </select><br>
                <input class="button_connexion" type="submit" value="Inscription"/>
                <input class="button_reset" type="reset" value="Annuler"/>
            </form>
        <center id="image">         
            <img id="img" src="css/images_2/tracteur.png" width="150px" alt="150px" />
            <img id="img" src="css/images_2/caddie.png" width="150px" alt="150px" />
            <img id="img" src="css/images_2/fusee.png" width="150px" alt="150px" />
        </center>
    </body>
</html>
