/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 Toi qui lis ceci abandonnes tout espoir de propreté du code. Oublie les standards du web. Oublie l'élegance.
 
 JS Closure : p120
 
 Instructions : - écouter "Svinkels - Bricolage" en lisant le js
 - obligatoirement(je crois) passer par un objet position comme suit : {lat: x, lng: y} pour les fonctions
 
 A faire : 
 - modifier les marqueurs
 */


$(document).ready(function () {

    $.ajax({
        method: "POST",
        url: "map",
        data: "",
        dataType: "html",
        success: function (data) {
            //console.log("données reçues");
            //console.log(data);
            afficherChauffeurs(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown.toString());
        }
    });
});

var map;
var maPosition = {
    lat: "",
    lng: ""
};

var distance = 0; //en metres
var adrDep, adrArr;

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

    //bouton d'arrivée
    var centerControlDiv2 = document.createElement('div');
    btArrivee(centerControlDiv2, map);
    centerControlDiv2.index = 2;
    map.controls[google.maps.ControlPosition.TOP_RIGHT].push(centerControlDiv2);
}
;

function afficherChauffeurs(data) {
    var dpars = JSON.parse(data);
    //console.log("données parsées :");
    //console.log(dpars);

    $.each(dpars, function (index, value) {

        //création de la position du chauffeur
        var posch = {
            lat: parseFloat(dpars[index].lat),
            lng: parseFloat(dpars[index].lng)
        };

        //placement du marqueur
        var marqueurChauffeur = new google.maps.Marker({
            position: posch,
            map: map,
            title: dpars[index].nom + ""
        });
        //fenetre info
        var infowindow = new google.maps.InfoWindow({
            content: dpars[index].nom + ' ' + dpars[index].vehicule + ' ' + dpars[index].nbplaces + " places " + dpars[index].tarif + " €/km" +
                    '<br><a class="lien_map" href="prise_en_charge?idConducteur=' + dpars[index].id + '">Demande</a>'
        });

        //évenement : affichage de la fenetre d'info quand on clique sur le marqueur + envoi des infos
        marqueurChauffeur.addListener('click', function () {
            infowindow.open(map, marqueurChauffeur);

            //envoie a une servlet les adresses de départ et arrivée car on ne peut le faire (proprement)en cookie
            $.ajax({
                method: "POST",
                url: "adresse",
                data: {"adrDep": adrDep, "adrArr": adrArr, "distance": distance},
                dataType: "html",
                success: function (data) {
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(errorThrown.toString());
                }
            });
        });
    });
}
;

function success(pos) {
    maPosition.lat = pos.coords.latitude;
    maPosition.lng = pos.coords.longitude;
    map.setCenter(maPosition);
    map.setZoom(16);

    var img ={
                url: "css/images_2/drapeau_vert.png", // url
                scaledSize: new google.maps.Size(50, 50), // scaled size
                origin: new google.maps.Point(0, 0), // origin
                anchor: new google.maps.Point(46, 50) // anchor
            };

    //placement du marqueur
    var marqueur = new google.maps.Marker({
        position: maPosition,
        map: map,
        draggable: true,
        title: 'Ma position',
        icon: img
    });

    setAdresseFromCoords(maPosition, "d");

    marqueur.addListener('dragend', function () {
        maPosition.lat = marqueur.getPosition().lat();
        maPosition.lng = marqueur.getPosition().lng();
        setAdresseFromCoords(maPosition, "d");
        //console.log("Nouvelle position : " + maPosition.lat + " " + maPosition.lng);
    });
    //fenetre info
    var infowindow = new google.maps.InfoWindow({
        content: "Ma position"
    });
    marqueur.addListener('click', function () {
        infowindow.open(map, marqueur);
        //console.log(maPosition);
    });

}

function error(err) {
    console.warn('ERROR(' + err.code + '): ' + err.message);
}

function btArrivee(controlDiv, map) {
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
    controlText.innerHTML = 'Placer point d arrivée';
    controlUI.appendChild(controlText);

    // placer un marqueur d'arrivée au centre de la map quand on clique
    controlUI.addEventListener('click', function () {
        controlUI.hidden = true;//caché le bouton pour éviter l'ajout de multiples marqueurs de fin
        
        var img ={
                url: "css/images_2/drapeau_rose.png", // url
                scaledSize: new google.maps.Size(50, 50), // scaled size
                origin: new google.maps.Point(0, 0), // origin
                anchor: new google.maps.Point(46, 50) // anchor
            };

        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer({suppressMarkers : true});

        var marqueur = new google.maps.Marker({
            position: map.getCenter(),
            map: map,
            draggable: true,
            title: 'arrivee',
            icon: img
        });
        var infowindow = new google.maps.InfoWindow();

        calculEtAffichage();

        function calculEtAffichage() {
            directionsService.route({
                origin: maPosition,
                destination: marqueur.getPosition(),
                travelMode: google.maps.TravelMode.DRIVING
            }, function (response, status) {
                if (status === google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(response);
                    directionsDisplay.setMap(map);

                    distance = response.routes[0].legs[0].distance.value;
                    //fenetre info
                    infowindow.setContent(distance / 1000 + " km");

                    marqueur.addListener('click', function () {
                        infowindow.open(map, marqueur);
                    });
                    infowindow.open(map, marqueur); // ouverture par défaut de la fenetre d'info

                } else {
                    window.alert('Directions request failed due to ' + status);
                }
            });
            setAdresseFromCoords(marqueur.getPosition(), "a");
        }

        //calculer et afficher le trajet quand on glisse le marqueur
        marqueur.addListener('dragend', function () {
            calculEtAffichage();

        });
    });
}
;

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
;

//récupérer l'adresse depuis les coordonnées. 'a' pour l'adresse d'arrivée, 'd' pour celle de départ
function setAdresseFromCoords(coords, depArr) {
    var geocoder = new google.maps.Geocoder;
    var adr;
    geocoder.geocode({'location': coords}, function (results, status) {
        if (status === google.maps.GeocoderStatus.OK) {
            if (results[1]) {
                adr = results[0].address_components[0].long_name + " " + results[0].address_components[1].long_name + " " + results[0].address_components[2].long_name;

                if (depArr == "d") {
                    adrDep = adr;
                } else if (depArr == "a") {
                    adrArr = adr;
                }

            } else {
                window.alert('No results found');
            }
        } else {
            window.alert('Geocoder failed due to: ' + status);
        }
    });
}
;


