<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Faster+One|Annie+Use+Your+Telescope' rel='stylesheet' type='text/css'>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Home Page</title>
    </head>
    <body>
        <h1>Cousin Huber</h1>
        <h2>Bienvenue</h2>
        <blockquote id="slogan_home">
            "Libérez vos pieds...<br>
            Libérez vos idées... <br>
            Laissez nous vous guider...<br> 
            Nous vous offrons la liberté..."<br>
        </blockquote>
        <div id="lien">
            <c:choose>
                <c:when test="${utilConnecteP.loginPassager==null}">
                    <a href="connexion_passager">Passager</a>
                </c:when>
                <c:otherwise>
                    <a href="deconnexionPassager">Déconnexion</a>
                    <a href="map">Map</a>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${utilConnecteC.loginConducteur==null}">
                    <a href="connexion_conducteur">Conducteur</a>
                </c:when>
                <c:otherwise>
                    <a href="deconnexionConducteur">Déconnexion</a>
                    <a href="map">Map</a>
                </c:otherwise>
            </c:choose>              
        </div>
        <div id="image"> 
            <img src="css/images/icon_tracteur.png" width="150px" alt="150px" />
            <img src="css/images/icon_caddie.jpg" width="150px" alt="150px" />
            <img src="css/images/icon_jetpack.png" width="150px" alt="150px" />
            <img src="css/images/icon_moto3.jpeg" width="150px" alt="150px" />
            <img src="css/images/icon_poney.png" width="150px" alt="150px" />
            <img src="css/images/icon_velo.png" width="150px" alt="150px" />
            <img src="css/images/icon_voit.png" width="150px" alt="150px" />
        </div>
    </body>
</html>
