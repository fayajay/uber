
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Map</title>
        <style type="text/css">
            html, body { height: 100%; margin: 0; padding: 0; }
            #map { height: 100%; }
        </style>
    </head>
    <body>
        

        <h1>MAP</h1>

        <p> LA MAP DOIT APPARAITRE SUR CETTE PAGE PAR EXEMPLE ET ELLE LE FAIT EN PLUS !</p>
        <a href="homePage.jsp">Accueil</a>
        <div id="map"></div>
        
        
        <!--<script type="text/javascript" src="js/jquery.min.js"></script>-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
        <script type="text/javascript" src="js/carte.js"></script>        
        <script type="text/javascript" async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDfugp2TKrikmxteh7sn9bdi1XPZvAFtDA&callback=initMap">
        </script>
    </body>
</html>
