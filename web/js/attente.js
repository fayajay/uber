/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    appeljajax();

});

function appeljajax() {
    $.ajax({
        method: "POST",
        url: "attente",
        data: "",
        dataType: "html",
        success: function (data) {
            var millisecondsToWait = 500;
            setTimeout(function () {
                // Whatever you want to do after the wait
            }, millisecondsToWait);
            $("#zone1").html(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown.toString());
        }
    });
}