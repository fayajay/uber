
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
        
        JS Closure : p120
        
        Instructions : - écouter "Svinkels - Bricolage" en lisant le js
                       - obligatoirement(je crois) passer par un objet position comme suit : {lat: x, lng: y} pour les fonctions
        
        A faire : - un vrai fichier js + nettoyage/opti
                  - un fichier css pour resizer la map
                  - la gestion des marqueurs comme il faut
                  - actualiser la position du marqueur a chaque déplacement
                  - completer la fenetre du marqueur
                  - tout
        -->

        <h1>MAP</h1>

        <p> LA MAP DOIT APPARAITRE SUR CETTE PAGE PAR EXEMPLE ET ELLE LE FAIT EN PLUS !</p>
        <a href="homePage.jsp">Accueil</a>
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

                //bouton de centrage
                var centerControlDiv = document.createElement('div');
                btCentrage(centerControlDiv, map, maPosition);

                centerControlDiv.index = 1;
                map.controls[google.maps.ControlPosition.TOP_CENTER].push(centerControlDiv);

                chauffeurBidon();
                //afficherChauffeurs();
            }

            function afficherChauffeurs() {
                console.log("afficher chauffeurs");
                for (var i = 0; i < "${lchauffeur}"; i++) {
                    console.log(i);
                    i++;

                }
            }
            ;

            function chauffeurBidon() {
                //récupération du chauffeur depuis le servlet
                var ch = {
                    login: "${chauffeur1.loginConducteur}",
                    mail: "${chauffeur1.mailConducteur}",
                    tel: "${chauffeur1.telConducteur}",
                    immatriculation: "${chauffeur1.immatriculation}",
                    nbPlaces: ${chauffeur1.nbPlaces},
                    type: "${chauffeur1.typeVehicule}",
                    lat: ${chauffeur1.latitude},
                    lng: ${chauffeur1.longitude}
                };


                var posch = {
                    lat: ch.lat,
                    lng: ch.lng
                };

                console.log(ch);

                //placement du marqueur
                var marqueurChauffeur = new google.maps.Marker({
                    position: posch,
                    map: map,
                    title: 'Chauffeur 1'
                });

                //fenetre info
                var infowindow = new google.maps.InfoWindow({
                    content: ch.login + "\n" + ch.type + "\n" + ch.nbPlaces
                });


                marqueurChauffeur.addListener('click', function () {
                    infowindow.open(map, marqueurChauffeur);
                });
            }

            function success(pos) {
                var crd = pos.coords;

                clongitude = crd.longitude;
                clatitude = crd.latitude;

                maPosition.lat = clatitude;
                maPosition.lng = clongitude;


                map.setCenter(maPosition);
                map.setZoom(16);

                //placement du marqueur
                var marqueur = new google.maps.Marker({
                    position: maPosition,
                    map: map,
                    draggable: true,
                    title: 'Ma position'
                });
                marqueur.addListener('dragend', actualiserCoords);

                //fenetre info
                var infowindow = new google.maps.InfoWindow({
                    content: maPosition.lat + " " + maPosition.lng
                });


                marqueur.addListener('click', function () {
                    infowindow.open(map, marqueur);
                    console.log(maPosition);

                });



                console.log('Your current position is:');
                console.log('Latitude : ' + crd.latitude);
                console.log('Longitude: ' + crd.longitude);
                console.log('More or less ' + crd.accuracy + ' meters.');
            }

            function error(err) {
                console.warn('ERROR(' + err.code + '): ' + err.message);
            }

            function actualiserCoords() {
                console.log("Votre nouvelle position est : " + maPosition.lat + " " + maPosition.lng);
            }

            function btCentrage(controlDiv, map, pos) {
                // Set CSS for the control border.
                var controlUI = document.createElement('div');
                controlUI.style.backgroundColor = '#fff';
                controlUI.style.border = '2px solid #fff';
                controlUI.style.borderRadius = '3px';
                controlUI.style.boxShadow = '0 2px 6px rgba(0,0,0,.3)';
                controlUI.style.cursor = 'pointer';
                controlUI.style.marginBottom = '22px';
                controlUI.style.textAlign = 'center';
                controlUI.title = 'Click to recenter the map';

                controlDiv.appendChild(controlUI);

                // Set CSS for the control interior.
                var controlText = document.createElement('div');
                controlText.style.color = 'rgb(25,25,25)';
                controlText.style.fontFamily = 'Roboto,Arial,sans-serif';
                controlText.style.fontSize = '16px';
                controlText.style.lineHeight = '38px';
                controlText.style.paddingLeft = '5px';
                controlText.style.paddingRight = '5px';
                controlText.innerHTML = 'Ma position';
                controlUI.appendChild(controlText);


                // centrer quand on clique
                controlUI.addEventListener('click', function () {
                    map.setCenter(pos);
                    map.setZoom(16);
                });


            }


        </script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDfugp2TKrikmxteh7sn9bdi1XPZvAFtDA&callback=initMap">
        </script>
    </body>
</html>
