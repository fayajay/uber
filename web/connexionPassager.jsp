
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Faster+One|Annie+Use+Your+Telescope' rel='stylesheet' type='text/css'>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Connexion Passager</title>
    </head>
    <body>
        <h1>Cousin Huber</h1>
        <h2>Connexion Passager</h2>
        <div class="lien1">
            <a href="homePage.jsp">Home Page</a>
            <a class="inscription" href="inscription_passager">Inscription</a>
            <div class="clear"></div>
        </div>
            <form method="POST">
                Identifiant : <input type="text" name="loginPassager"/>
                Mot de Passe : <input type="password" name="mdpPassager"/><br/>

                <input class="button_connexion" type="submit" value="connexion"/>
                <input class="button_reset" type="reset" value="annuler"/>
            </form>
    </body>
</html>
