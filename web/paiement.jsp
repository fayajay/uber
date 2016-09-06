<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Faster+One|Annie+Use+Your+Telescope' rel='stylesheet' type='text/css'>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Paiement</title>
    </head>
    <body>
        <img id="img_velo" src="css/images_2/velo.png" width="150px" alt="150px" />
        <img id="img_voit" src="css/images_2/vv.png" width="150px" alt="150px" />
        <h1>Cousin Huber</h1>
        <h2>Bienvenue</h2>
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
        <div class="lien1">
            <a href="home">Home Page</a>
            <c:choose>
                <c:when test="${utilConnecteP.loginPassager!=null}">
                    <a class="right" href="deconnexionPassager">Déconnexion</a>
                </c:when>
                    <c:otherwise>
                        <a href="#"></a>
                    </c:otherwise>
                </c:choose>
            <a class="lienMap" href="map">Map</a>
            <div class="clear"></div>
        </div>
        </div>
        <form method="POST">
                Choisissez votre mode de paiement : <select>
                                                        <option value="CB">CB</option>
                                                        <option value="VISA">VISA</option>
                                                        <option value="AMEX">AMERICAN EXPRESS</option>
                                                        <option value="MASTERCARD">MASTER CARD</option>
                                                        <option value="PAYPAL">PAYPAL</option>
                                                        <option value="CASH">CASH</option>
                                                        <option value="NATURE">NATURE</option>
                                                        <option value="TROC">TROC</option>
                                                    </select><br>
                <input class="button_connexion" type="submit" value="paiement"/>
                <input class="button_reset" type="reset" value="annuler"/>
        </form>
        <center id="image">         
            <img id="img" src="css/images_2/tracteur.png" width="150px" alt="150px" />
            <img id="img" src="css/images_2/caddie.png" width="150px" alt="150px" />
            <img id="img" src="css/images_2/fusee.png" width="150px" alt="150px" />
        </center>
    </body>
</html>
