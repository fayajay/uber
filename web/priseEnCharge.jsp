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
        <h1>Cousin Huber</h1>
        <h2>Bienvenue</h2>
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
                Adresse de Départ : <input type="text" name="adresseDepart"/><br/>
                Adresse d'Arrivée : <input type="text" name="adresseArrive"/><br/>
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
                Email : <input type="text" name="emailConducteur"/><br/>
                Tel : <input type="text" name="telConducteur"/></br>
                
                <input class="button_connexion" type="submit" value="Demande"/>
                <input class="button_reset" type="reset" value="Annuler"/>
        </form>
    </body>
</html>
