<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Faster+One|Annie+Use+Your+Telescope' rel='stylesheet' type='text/css'>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Map</title>
        <style type="text/css">
            html, body { height: 100%; margin: 0; padding: 0; }
            #map { height: 100%; }
        </style>
    </head>
    <body>
        <div class="header">
            <h1>Cousin Huber</h1>
            <h2>MAP</h2>
            <blockquote class="slogan">"Libérez vos pieds...Libérez vos idées...Laissez nous vous guider...Nous vous offrons la liberté..."</blockquote>
        </div>
        <div class="menu">
            <div class="lien1">
                <a href="home">Home Page</a>
                <c:choose>
                <c:when test="${utilConnecteP.loginPassager!=null}">
                    <a class="right" href="deconnexionPassager">Déconnexion</a>
                    <a class="modifier_profil" href="modifier_profil">Modifier Profil</a>
                </c:when>
                <c:when test="${utilConnecteC.loginConducteur!=null}">
                    <a class="modifier_profil_conducteur" href="modifier_profil_conducteur">Modifier Profil</a>
                </c:when>
                    <c:otherwise>
                        <a href="#"></a>
                    </c:otherwise>
                </c:choose>   
                <div class="clear"></div>
            </div>
        </div> 
            <div id="map">
                <script type="text/javascript" src="js/jquery.min.js"></script>
                <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.0.min.js"></script>

                <script type="text/javascript" async defer
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDfugp2TKrikmxteh7sn9bdi1XPZvAFtDA&callback=initMap">
                </script>
                <script type="text/javascript" src="js/carte.js"></script>
            </div>
        <div class="footer"></div>
    </body>
</html>
