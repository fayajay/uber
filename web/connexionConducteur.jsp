
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Faster+One|Annie+Use+Your+Telescope' rel='stylesheet' type='text/css'>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Connexion Conducteur</title>
    </head>
    <body>
        <h1>Cousin Huber</h1>
        <h2>Connexion Conducteur</h2>
        <blockquote class="slogan">"Libérez vos pieds...Libérez vos idées...Laissez nous vous guider...Nous vous offrons la liberté..."</blockquote>
        <div class="menu">
        <div class="lien1">
            <a href="home">Home Page</a>
            <a class="inscription" href="inscription_conducteur">Inscription</a>
            <div class="clear"></div>
        </div>
        </div>
            <form method="POST">
                Identifiant : <input type="text" name="loginConducteur"/>
                Mot de Passe : <input type="password" name="mdpConducteur"/><br/>

                <input class="button_connexion" type="submit" value="connexion"/>
                <input class="button_reset" type="reset" value="annuler"/>
            </form>    
    </body>
</html>
