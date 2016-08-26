<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='https://fonts.googleapis.com/css?family=Faster+One|Annie+Use+Your+Telescope' rel='stylesheet' type='text/css'>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <title>Inscription Passager</title>
    </head>
    <body>
        <h1>Cousin Huber</h1>
        <h2>Inscription Passager</h2>
        <blockquote class="slogan">"Libérez vos pieds...Libérez vos idées...Laissez nous vous guider...Nous vous offrons la liberté..."</blockquote>
        <div class="menu">
            <a class="lien1" href="home">Home Page</a>
        </div> 
        
            <form class="form" method="POST">
                Identifiant : <input type="text" name="loginPassager"/><br/>
                Mot de Passe : <input type="password" name="mdpPassager"/><br/>
                Email : <input type="text" name="emailPassager"/><br/>
                Tel : <input type="text" name="telPassager"/></br>
                <input class="button_connexion" type="submit" value="inscription"/>
                <input class="button_reset" type="reset" value="annuler"/>
            </form>
    </body>
</html>
