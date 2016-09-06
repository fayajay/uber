<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h2>Inscription Passager</h2>
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
        
            <form class="form" method="POST">
                Identifiant : <input type="text" name="loginPassager"/><br/>
                Mot de Passe : <input type="password" name="mdpPassager"/><br/>
                Email : <input type="text" name="emailPassager"/><br/>
                Tel : <input type="text" name="telPassager"/></br>
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
