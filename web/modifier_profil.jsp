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
        <h1>Cousin Huber</h1>
        <h2>Modifier Profil</h2>
        <blockquote class="slogan">"Libérez vos pieds...Libérez vos idées...Laissez nous vous guider...Nous vous offrons la liberté..."</blockquote>
        <div class="menu">
        <div class="lien1">
            <a href="home">Home Page</a>
            <a class="lienMap" href="map">Map</a>
            <c:choose>
                <c:when test="${utilConnecteP.loginPassager!=null}">
                    <a class="right" href="deconnexionPassager">Déconnexion</a>
                </c:when>
                    <c:otherwise>
                        <a href="#"></a>
                    </c:otherwise>
                </c:choose>  
            <div class="clear"></div>
        </div>
        </div>
        <form method="POST">
            Identifiant : <input type="text" value="${utilConnecteP.loginPassager}" name="login"/><br/>
            Mot de Passe : <input type="password" value="${utilConnecteP.mdpPassager}" name="mdp"/><br/>
            Email : <input type="text" value="${utilConnecteP.mailPassager}" name="email"/><br/>
            Tel : <input type="text" value="${utilConnecteP.telPassager}" name="tel"/></br>
            <input class="button_connexion" type="submit" value="Enregistrer"/>
            <input class="button_reset" type="reset" value="annuler"/>   
        </form>
    </body>
</html>
