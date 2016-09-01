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
        <blockquote id="slogan_home">
            "Libérez vos pieds...<br>
            Libérez vos idées... <br>  
            Laissez nous vous guider...<br> 
            Nous vous offrons la liberté..."<br>
        </blockquote>
        <center id="image">         
            <img id="img" src="css/images_2/tracteur.png" width="150px" alt="150px" />
            <img id="img" src="css/images_2/caddie.png" width="150px" alt="150px" />
            <img id="img" src="css/images_2/fusee.png" width="150px" alt="150px" />
        </center>
        <div class="menu">
        <div id="lien">
            <c:choose>
                <c:when test="${utilConnecteP.loginPassager==null}">
                    <a href="connexion_passager">Passager</a>                    
                </c:when>
                <c:otherwise>
                    <a href="deconnexionPassager">Déconnexion</a>
                    <a class="lienMap" href="map">Map</a>
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
        </div>
    </body>
</html>
