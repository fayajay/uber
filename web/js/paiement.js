/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#bt").hide();
    appeljajax();
});

function appeljajax() {
    $.ajax({
        method: "POST",
        url: "",
        data: "",
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

    $("#bt").show();
    
    alert("Trajet accepté");


}

