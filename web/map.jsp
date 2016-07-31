
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
        <!--
        Toi qui lis ceci abandonnes tout espoir de propreté du code. Oublie les standards du web. Oublie l'élegance.
        
        Instructions : - écouter "Svinkels - Bricolage" en lisant le js
                       - obligatoirement(je crois) passer par un objet position comme suit : {lat: x, lng: y} pour les fonctions
        
        A faire : - un vrai fichier js + nettoyage/opti
                  - un fichier css pour resizer la map
                  - la gestion des marqueurs comme il faut
                  - tout
        -->

        <h1>MAP</h1>

        <p> LA MAP DOIT APPARAITRE SUR CETTE PAGE PAR EXEMPLE ET ELLE LE FAIT EN PLUS !</p>
        <div id="map"></div>
        <script type="text/javascript">

            var map, clatitude, clongitude;
            var maPosition = {
                lat: clatitude,
                lng: clongitude
            };

            var options = {
                enableHighAccuracy: true,
                timeout: 5000,
                maximumAge: 0
            };

            function initMap() {
                //création de la map
                map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: 0, lng: 0},
                    zoom: 8
                });

                //géolocalisation et ajustement de la map
                var pos = navigator.geolocation.getCurrentPosition(success, error, options);
                
            }

            function success(pos) {
                var crd = pos.coords;

                clongitude = crd.longitude;
                clatitude = crd.latitude;

                maPosition.lat = clatitude;
                maPosition.lng = clongitude;


                map.setCenter(maPosition);
                map.setZoom(13);

                //placement du marqueur
                var marqueur = new google.maps.Marker({
                    position: maPosition,
                    map: map,
                    draggable: true,
                    title: 'Ma position'
                });
                marqueur.addListener('dragend', actualiserCoords);


                console.log('Your current position is:');
                console.log('Latitude : ' + crd.latitude);
                console.log('Longitude: ' + crd.longitude);
                console.log('More or less ' + crd.accuracy + ' meters.');
            }            

            function error(err) {
                console.warn('ERROR(' + err.code + '): ' + err.message);
            }        
            
            function actualiserCoords(){
                console.log("Votre nouvelle position est : tadaaam");
            }


        </script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDfugp2TKrikmxteh7sn9bdi1XPZvAFtDA&callback=initMap">
        </script>
    </body>
</html>
