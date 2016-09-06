<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Faster+One|Annie+Use+Your+Telescope' rel='stylesheet' type='text/css'>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Prise en Charge</title>
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
        <h3>Chauffeur n° : ${idConducteur} </h3>
        <form method="POST">
                Adresse de Départ : <input type="text" name="depart"/><br/>
                Adresse d'Arrivée : <input type="text" name="arrivee"/><br/>
                Nombre de passager : <select>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                     </select><br>
                Email : <input type="text" name="emailConducteur" value="${utilConnecteP.mailPassager}"/><br/>
                Tel : <input type="text" name="telConducteur" value="${utilConnecteP.telPassager}"/></br>
                Prix de la courses : <input type="text" name="prix"/><br/>
                
                <input class="button_connexion" type="submit" value="Demande"/>
                <input class="button_reset" type="reset" value="Annuler"/>
        </form>
        <center id="image">         
            <img id="img" src="css/images_2/tracteur.png" width="150px" alt="150px" />
            <img id="img" src="css/images_2/caddie.png" width="150px" alt="150px" />
            <img id="img" src="css/images_2/fusee.png" width="150px" alt="150px" />
        </center>
    </body>
</html>
