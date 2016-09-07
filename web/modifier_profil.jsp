<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Faster+One|Annie+Use+Your+Telescope' rel='stylesheet' type='text/css'>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Paiement</title>
    </head>
    <body>
        <img id="img_velo" src="css/images_2/velo.png" width="150px" alt="150px" />
        <img id="img_voit" src="css/images_2/vv.png" width="150px" alt="150px" />
        <h1>Cousin Huber</h1>
        <h2>Profil</h2>
        <center>
            <img id="img_scoot" src="css/images_2/scooter.png" width="150px" alt="150px" />
        </center>
        <marquee scrollamount="15">
		<figure>
                    <img id="img_ovni" src="css/images_2/ovni.png" width="150px" alt="150px" />	
                </figure>
        </marquee>
        <blockquote class="slogan">"Libérez vos pieds...Libérez vos idées...Laissez nous vous guider...Nous vous offrons la liberté..."</blockquote>
        <div class="menu">
                <a href="home">Home Page</a>
                <a class="lienMap" href="map">Map</a>
                <c:choose>
                    <c:when test="${utilConnecteP.loginPassager!=null}">
                        <a class="right" href="deconnexionPassager">Déconnexion</a>
                        <strong>${utilConnecteP.loginPassager}</strong>
                    </c:when>
                    <c:when test="${utilConnecteC.loginConducteur!=null}">
                    <a class="modifier_profil_conducteur" href="modifier_profil_conducteur">Profil</a>
                    <strong>${utilConnecteC.loginConducteur}</strong>
                    <a class="right" href="deconnexionPassager">Déconnexion</a>
                    </c:when>
                        <c:otherwise>
                            <a href="#"></a>
                        </c:otherwise>
                    </c:choose>  
                <div class="clear"></div>
        </div>
        <div id='historique'>
            <h4>Historique des trajets</h4>
                    <table>
                        <tr>
                            <th>DEPART</th>
                            <th>ARRIVEE</th>
                            <th>PRIX</th>
                            <th>MODE DE PAIEMENT</th>
                            <th>NOMBRE DE PASSAGER</th>
                            <th>CONDUCTEUR</th>
                        </tr>
                        <c:forEach items="${historique}" var="h">
                        <tr>
                            <td>${h.depart}</td>
                            <td>${h.arrivee}</td>
                            <td>${h.prix}$</td>
                            <td>${h.modePaiement}</td>
                            <td>${h.nbPassager}</td>
                            <td>${h.conducteur.loginConducteur}</td>  
                        </tr>
                        </c:forEach>
                    </table>
                        
        </div>
        <div id='profil'>
            <h4>Modifier votre profil</h4>
            <form method="POST">
                Identifiant : <input type="text" value="${utilConnecteP.loginPassager}" name="login"/><br/>
                Mot de Passe : <input type="password" value="${utilConnecteP.mdpPassager}" name="mdp"/><br/>
                Email : <input type="text" value="${utilConnecteP.mailPassager}" name="email"/><br/>
                Tel : <input type="text" value="${utilConnecteP.telPassager}" name="tel"/></br>
                <input class="button_connexion" type="submit" value="Enregistrer"/>
                <input class="button_reset" type="reset" value="annuler"/>   
            </form>
        </div>
        <center id="image">         
            <img id="img" src="css/images_2/tracteur.png" width="150px" alt="150px" />
            <img id="img" src="css/images_2/caddie.png" width="150px" alt="150px" />
            <img id="img" src="css/images_2/fusee.png" width="150px" alt="150px" />
        </center>
    </body>
</html>
