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
 
 A faire : - nettoyage/opti
 - un fichier css pour resizer la map
 - modifier les marqueurs
 - tout
 */


$(document).ready(function () {

    $.ajax({
        method: "POST",
        url: "map",
        data: "",
        dataType: "html",
        success: function (data) {
            console.log("données reçues");
            console.log(data);
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
    //chauffeurBidon();
    //afficherChauffeurs();
}
;
function afficherChauffeurs(data) {
    var dpars = JSON.parse(data);
    console.log("données parsées :");
    console.log(dpars);

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
            content: dpars[index].nom  + ' ' + dpars[index].vehicule + ' ' + dpars[index].nbplaces +
                   '<br><a class="lien_map" href="prise_en_charge?idConducteur=' + dpars[index].id + '">Demande</a>' 
                   
        });
        
        //évenement : affichage de la fenetre d'info quand on clique sur le marqueur
        marqueurChauffeur.addListener('click', function () {
            infowindow.open(map, marqueurChauffeur);
        });

    });
}
;

function success(pos) {
    var crd = pos.coords;
    maPosition.lat = crd.latitude;
    maPosition.lng = crd.longitude;
    map.setCenter(maPosition);
    map.setZoom(16);
    //placement du marqueur
    var marqueur = new google.maps.Marker({
        position: maPosition,
        map: map,
        draggable: true,
        title: 'Ma position'
    });
    marqueur.addListener('dragend', function () {
        maPosition.lat = marqueur.getPosition().lat();
        maPosition.lng = marqueur.getPosition().lng();
        console.log("Nouvelle position : " + maPosition.lat + " " + maPosition.lng);
    });
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



