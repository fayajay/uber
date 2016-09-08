/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#finir").hide();
    $("#confirmer").hide();
    $("#refuser").hide();

    appeljajax();

});

function appeljajax() {
    $.ajax({
        method: "POST",
        url: "attente",
        data: {"param":"rechercher"},
        dataType: "html",
        success: function (data) {
            afficher(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            setTimeout(
                    function ()
                    {
                        //do something special
                        appeljajax();
                    }, 5000);
        }
    });
}

function afficher(data) {
    var dpars = JSON.parse(data);

    $("#confirmer").show();
    $("#refuser").show();

    //texte
    $("#zone1").html(dpars.nom + " vous demande un trajet de : " + dpars.adrDep + " à : " + dpars.adrArr);

    $("#confirmer").click(function () {
        $("#finir").show();
        $("#confirmer").hide();
        $("#refuser").hide();

    });
    $("#refuser").click(function () {
        supprimerCourse();
        location.reload();
    });

    $("#finir").click(function () {
        supprimerCourse();
        location.reload();
    });

}

function supprimerCourse(){
    $.ajax({
        method: "POST",
        url: "attente",
        data: {"param":"annuler"},
        dataType: "html",
        success: function (data) {
            console.log("suppr")
        },
        error: function (jqXHR, textStatus, errorThrown) {
            
        }
    });
}